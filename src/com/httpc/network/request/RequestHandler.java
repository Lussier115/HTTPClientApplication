package com.httpc.network.request;

import com.httpc.network.request.Request;
import com.httpc.network.response.Response;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import java.net.InetAddress;
import java.util.Scanner;

public class RequestHandler {

    private final int PORT = 80;

    public RequestHandler() {
    }

    public Response send(Request request) throws Exception {
        if (!request.isValid())
            throw new Exception();

        // Open Socket
        InetAddress addressIp = InetAddress.getByName(request.getHost());
        Socket socket = new Socket(addressIp, PORT);

        PrintWriter out = new PrintWriter(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream());

        // Send request
        out.write(request.toString());
        out.flush();

        Response response = new Response(in, request.isVerbose());

        out.close();
        in.close();
        socket.close();

        return response;
    }
}