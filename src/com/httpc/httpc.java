package com.httpc;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class httpc {

    public static void main(String[] args) {
        int server_port = 8080; // Defines at which port the server will be listening at
        try( ServerSocket server = new ServerSocket(server_port) ){
            System.out.println("Server has been instantiated at port " + server_port);

            // Server is a process that runs continously and awaits for requests from clients
            while(true){
                // Is this a blocking or non-blocking call?
                // What would you need to do to service multiple clients at the same time?
                try ( Socket client_connection = server.accept() )
                {
                    PrintWriter outbount_client = new PrintWriter(client_connection.getOutputStream(), true);
                    outbount_client.println("Well hello to you too.");
                    client_connection.close();

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
