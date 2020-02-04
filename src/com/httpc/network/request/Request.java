package com.httpc.network.request;


import com.httpc.network.exception.InvalidRequestException;
import com.httpc.network.parameter.HttpBody;
import com.httpc.network.parameter.HttpHeader;

import java.net.MalformedURLException;
import java.net.URL;

public class Request {

    protected String version = "HTTP/1.0";
    protected String url;
    protected String host;
    protected RequestType requestType;
    protected HttpBody body;
    protected HttpHeader headers;

    private boolean verbos;

    public enum RequestType {POST, GET}

    public Request() {
    }

    public Request(RequestType requestType, HttpHeader headers, HttpBody body, String url) {
        this.url = url;
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
        String request = requestType.toString() + url + version + "\r\n";
        return request;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public boolean isVerbos() {
        return verbos;
    }

    public void setVerbos(boolean verbos) {
        this.verbos = verbos;
    }

    protected void parseRequest(String[] args) throws InvalidRequestException {
        this.headers = new HttpHeader();

        for (int i = 1; i < args.length; i++) {

            if (requestType == RequestType.GET) {
                if (args[i].equals("-d") || args[i].equals("-f")) {
                    throw new InvalidRequestException("Cannot contain -d or -f");
                }
            }


            if (args[i].equals("-h")) {
                String content = args[i + 1];
                this.headers.parseLine(content);

            } else if (args[i].equals("-v")) {
                this.setVerbos(true);
            } else if (i == (args.length - 1)) {
                try {
                    URL url = new URL(args[i]);
                    this.host = url.getHost();
                    this.url = args[i];

                } catch (MalformedURLException e) {
                    // it wasn't a URL
                }

            }
        }
    }

    public String getHost() {
        return this.host;
    }
}
