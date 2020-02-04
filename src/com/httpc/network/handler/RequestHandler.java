package com.httpc.network.handler;

import com.httpc.network.request.Request;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

import java.net.InetAddress;

public class RequestHandler {

    private final int PORT = 80;

    public RequestHandler() {
    }

    public void send(Request request) throws Exception, IOException {
        if (!request.isValid())
            throw new Exception();

        // Open Socket
        InetAddress addressIp = InetAddress.getByName(request.getUrl());
        Socket socket = new Socket(addressIp, PORT);

        PrintWriter out = new PrintWriter(socket.getOutputStream());
        InputStream in = socket.getInputStream();

        // Send request
        out.write(request.toString());
        out.flush();

        // Read entire answer
        StringBuilder res = new StringBuilder();
        int data = in.read();
        while(data != -1) {
            res.append((char) data);
            data = in.read();
        }

        out.close();
        in.close();
        socket.close();

        System.out.println(res.toString());
    }
}