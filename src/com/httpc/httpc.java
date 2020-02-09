package com.httpc;

import com.httpc.network.exception.InvalidRequestException;
import com.httpc.network.request.RequestHandler;
import com.httpc.network.request.GetRequest;
import com.httpc.network.request.PostRequest;
import com.httpc.network.request.Request;
import com.httpc.network.response.Response;

public class httpc {

    public static void main(String[] args) {
        RequestHandler requestHandler = new RequestHandler();
        Request request = null;

        try {
            if (args[0].equals("POST")) {
                request = new PostRequest(args);
            } else if (args[0].equals("GET")) {
                request = new GetRequest(args);
            }

            if (request != null) {
                Response response = requestHandler.send(request);

                response.display();
            }
        } catch (InvalidRequestException e) {
            System.out.println(e.toString());

            System.out.println("http help");
        } catch (Exception e2) {
            System.out.println("http help");
        }


    }
}
