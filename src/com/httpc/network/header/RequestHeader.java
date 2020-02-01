package com.httpc.network.header;

public class RequestHeader {

    private String contentLength;
    private String contentEncoding;
    private String contentType;
    private String authorization;

    public RequestHeader() {
    }

    public RequestHeader(String contentLength, String contentEncoding, String contentType, String authorization) {
       this.authorization = authorization;
       this.contentLength = contentLength;
       this.contentEncoding = contentEncoding;
       this.contentType = contentType;
    }

    public String getContentLength() {
        return contentLength;
    }

    public void setContentLength(String contentLength) {
        this.contentLength = contentLength;
    }

    public String getContentEncoding() {
        return contentEncoding;
    }

    public void setContentEncoding(String contentEncoding) {
        this.contentEncoding = contentEncoding;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }
}
