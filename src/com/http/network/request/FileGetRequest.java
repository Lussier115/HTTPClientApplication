package com.http.network.request;

import com.http.network.exception.InvalidRequestException;

public class FileGetRequest extends PostRequest {
    public FileGetRequest(String[] args, RequestType requestType) throws InvalidRequestException {
        super(args, requestType);



    }
}
