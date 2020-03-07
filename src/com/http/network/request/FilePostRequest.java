package com.http.network.request;

import com.http.network.exception.InvalidRequestException;

public class FilePostRequest extends GetRequest {

    public FilePostRequest(String[] args, RequestType requestType) throws InvalidRequestException {
        super(args, requestType);


    }
}
