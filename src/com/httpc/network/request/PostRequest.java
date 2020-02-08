package com.httpc.network.request;

import com.httpc.network.exception.InvalidRequestException;
import com.httpc.network.parameter.HttpBody;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class PostRequest extends Request {

    private HttpBody body;

    public PostRequest(String[] args) throws InvalidRequestException {
        this.setRequestType(RequestType.POST);

        for (int i = 1; i < args.length; i++) {

            if (args[i].equals("-f")) {
                //TODO :: handle -f on POST, Throw InvalidRequestException if -d or -f already exists
            }

            if (args[i].equals("-d")) {

                StringBuilder builder = new StringBuilder();
                for (String value : args) {
                    builder.append(value);
                }
                String query = builder.toString().replaceAll("([A-Za-z]\\w+)", "\"$1\"");
                int startIndex = query.indexOf("{");
                int lastIndex = query.lastIndexOf("}");

                String content = query.substring(startIndex + 1, lastIndex);

                body = new HttpBody(content, HttpBody.BodyType.INLINE);
            }
        }

        this.parseRequest(args);
    }

    @Override
    public String toString() {
        String request = requestType.toString() + " " + this.url + " " + this.version +
                "\r\n" + this.headers.toString() + body.toString();

        return request;
    }
}
