package com.httpc.network.request;


import com.httpc.network.parameter.HttpBody;
import com.httpc.network.parameter.HttpHeader;

public class Request {

    private String version = "HTTP/1.0";

    private String url;
    private int port;
    private RequestType requestType;
    private HttpBody body;
    private HttpHeader headers;


    public enum RequestType {POST, GET}

    public Request() {
        this.url = url;
        this.port = port;
    }

    public Request(String version, String url, int port, HttpHeader headers, RequestType requestType, HttpBody body) {
        this.version = version;
        this.url = url;
        this.port = port;
        this.requestType = requestType;

        this.headers = headers;
        this.body = body;
    }

    public boolean isValid() {
        if (requestType == null) {
            return false;
        }
        if (requestType.equals(requestType.POST)) {
            return body.isValid();
        }
        if (!headers.isValid()) {
            return false;
        }
        return true;
    }

    public String toString() {
        String request = requestType.toString() + url + version + "\r\n"
                + headers.toString()
                + body.getContentLength()
                + "\r\n"
                + body;

        return request;
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

    public HttpHeader getHeader() {
        return headers;
    }

    public void setHeader(HttpHeader httpHeader) {
        this.headers = httpHeader;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }


}
