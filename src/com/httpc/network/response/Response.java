package com.httpc.network.response;

public class Response {

    private String version;
    private int statusCode;
    private int phrase;
    private String[] headers;

    public Response() {

    }

    public Response(String version, int statusCode, int phrase, String[] header) {
        this.version = version;
        this.statusCode = statusCode;
        this.phrase = phrase;
        this.headers = header;
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

    public String[] getHeader() {
        return headers;
    }

    public void setHeader(String[] header) {
        this.headers = header;
    }
}
