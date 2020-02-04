package com.httpc.network.parameter;

public class HttpBody {

    String body;
    int contentLength;

    public HttpBody(String body) {
        this.body = body;
        this.contentLength = body.length();
    }

    public String toString() {
        return body;
    }

    public String getContentLength() {
        return "Content-Length: " + contentLength + "\r\n";
    }

    public boolean isValid() {
        return contentLength > 0;
    }
}
