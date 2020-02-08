package com.httpc.network.parameter;

public class HttpBody {

    String body;
    int contentLength;
    BodyType type;

    public enum BodyType {INLINE, FILE}

    public HttpBody(String body, BodyType type) {
        this.body = body;
        this.type = type;
        this.contentLength = body.length();
    }

    public String toString() {
        return this.getContentLength() + "\r\n" + this.getBody();
    }

    public String getContentLength() {
        return "Content-Length: " + contentLength + "\r\n";
    }

    public String getBody() {

        if (type == BodyType.INLINE) {
            return "{" + body + " }";
        }

        return body;
    }

    public boolean isValid() {
        return contentLength > 0;
    }
}
