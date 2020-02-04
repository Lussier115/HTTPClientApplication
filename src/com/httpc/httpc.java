package com.httpc;

import com.httpc.network.handler.RequestHandler;
import com.httpc.network.request.GetRequest;
import com.httpc.network.request.PostRequest;
import com.httpc.network.request.Request;

public class httpc {

    public static void main(String[] args) throws Exception {
        RequestHandler requestHandler = new RequestHandler();
        Request request = null;

        if(args[0].equals("POST")){
            request = new PostRequest();

        } else if(args[0].equals("GET")) {
            request = new GetRequest();
        }

        if(request != null){
            requestHandler.send(request);
        }

    }
}
