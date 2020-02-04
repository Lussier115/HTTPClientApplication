package com.httpc.network.request;

public class GetRequest extends Request {

    public GetRequest(String[] args) {
        this.setRequestType(RequestType.GET);
        this.parseRequest(args);
    }

    @Override
    public String toString() {
        String request = requestType.toString() + " "+ url+  " "+ version + "\r\n" + this.headers.toString()+ "\r\n";

        return request;
    }
}
