package com.httpc.network.request;

import com.httpc.network.parameter.HttpBody;
import com.httpc.network.parameter.HttpHeader;

public class GetRequest extends Request{

    public GetRequest() {
        super();
    }

    public GetRequest(String version, String url, int port, HttpHeader headers, RequestType requestType, HttpBody body) {
        super(version, url, port, headers, requestType, body);
    }
}
