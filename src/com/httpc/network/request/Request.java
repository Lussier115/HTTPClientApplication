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

    private boolean verbose;

    public enum RequestType {POST, GET}

    public Request() {
    }

    public boolean isValid() {
        if (requestType == null) {
            return false;
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

    public boolean isVerbose() {
        return verbose;
    }

    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }

    protected void parseRequest(String[] args) throws InvalidRequestException {
        this.headers = new HttpHeader();

        for (int i = 1; i < args.length; i++) {

            if (args[i].equals("-h")) {
                String content = args[i + 1];
                this.headers.parseLine(content);
            }

            if (args[i].equals("-v")) {
                this.setVerbose(true);
            }

            // Should be the last parameter of the curl
            if (i == (args.length - 1)) {
                try {
                    String tempURL = args[i];

                    if (tempURL.startsWith("www")) {
                        tempURL = "http://".concat(tempURL);
                    }

                    URL url = new URL(tempURL);
                    this.host = url.getHost();
                    this.url = tempURL;

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
