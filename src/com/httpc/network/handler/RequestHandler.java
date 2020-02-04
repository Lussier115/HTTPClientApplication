package com.httpc.network.handler;

import com.httpc.network.request.Request;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

import java.net.InetAddress;
import java.util.Scanner;

public class RequestHandler {

    private final int PORT = 80;

    public RequestHandler() {
    }

    public void send(Request request) throws Exception, IOException {
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

        // Read entire answer
        while(in.hasNextLine()) {
            System.out.println(in.nextLine());
        }

        out.close();
        in.close();
        socket.close();
    }
}