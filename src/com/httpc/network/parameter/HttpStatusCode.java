package com.httpc.network.parameter;

public class HttpStatusCode {

    public static final int OK = 200;
    public static final int NotFound = 404;
    public static final int Created = 201;
    public static final int BadRequest = 400;
    public static final int Forbidden = 403;

    public static String getStatusMessage(int statusCode) {
        switch (statusCode) {
            case 200:
                return "OK\nServer successfully found the resource and has sent it back to the client.";
            case 404:
                return "Not Found\nServer has not found anything matching the requested URI.";
            case 201:
                return "Created\nServer has successfully created a resource from a POST ONLY request.";
            case 400:
                return "Bad Request\nServer doesn't understand the request.";
            case 403:
                return "Forbidden\nServer understood the request, but refuses to 'service' it.";
        }

        return "Invalid Status Code";
    }
}
