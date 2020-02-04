package com.httpc.network.request;

import com.httpc.network.parameter.HttpBody;
import com.httpc.network.parameter.HttpHeader;

public class PostRequest extends Request {

    public PostRequest() {
        super();
    }

    public PostRequest(String version, String url, int port, HttpHeader headers, RequestType requestType, HttpBody body) {
        super(version, url, port, headers, requestType, body);
    }
}
