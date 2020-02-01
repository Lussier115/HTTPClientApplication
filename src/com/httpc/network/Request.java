package com.httpc.network;

import com.httpc.network.header.RequestHeader;

public class Request {

    private String version = "HTTP/1.0";

    private String url;
    private int port;
    private RequestHeader header;
    private RequestType requestType;

    public enum RequestType {POST, GET}

    public Request(String url, int port) {
        this.url = url;
        this.port = port;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public RequestHeader getHeader() {
        return header;
    }

    public void setHeader(RequestHeader header) {
        this.header = header;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }


}
