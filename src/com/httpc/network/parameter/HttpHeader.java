package com.httpc.network.parameter;

import java.util.HashMap;

public class HttpHeader {
    private HashMap<String, String> headers = new HashMap<>();
    private boolean isValid = true;

    public void parseLine(String header) {
        String[] entries = header.split(":");

        if (entries.length == 2) {
            this.headers.put(entries[0], entries[1]);
        } else {
            //Header is invalid
            this.isValid = false;
        }
    }

    public boolean isValid() {
        return isValid;
    }

    public boolean contains(String value) {
        return this.headers.containsKey(value);
    }

    public HashMap<String, String> GetHeaders() {
        return headers;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        headers.forEach((key, value) -> stringBuilder.append(key).append(": ").append(value).append("\r\n"));

        return stringBuilder.toString();
    }


}
