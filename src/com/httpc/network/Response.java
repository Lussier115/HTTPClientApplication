package com.httpc.network;

import com.httpc.network.header.RequestHeader;

public class Response {

    private String version;
    private int statusCode;
    private int phrase;
    private RequestHeader header;

    public Response() {
    }

    public Response(String version, int statusCode, int phrase, RequestHeader header) {
        this.version = version;
        this.statusCode = statusCode;
        this.phrase = phrase;
        this.header = header;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getPhrase() {
        return phrase;
    }

    public void setPhrase(int phrase) {
        this.phrase = phrase;
    }

    public RequestHeader getHeader() {
        return header;
    }

    public void setHeader(RequestHeader header) {
        this.header = header;
    }
}
