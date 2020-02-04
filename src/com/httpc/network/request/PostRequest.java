package com.httpc.network.request;


import com.httpc.network.parameter.HttpBody;
import com.httpc.network.parameter.HttpHeader;

public class PostRequest extends Request {

    public PostRequest(String[] args) {
    }

    public PostRequest(RequestType requestType, HttpHeader headers, HttpBody body, String url) {
        super(requestType, headers, body, url);
    }
}
