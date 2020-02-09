package com.httpc.network.response;

import java.util.ArrayList;
import java.util.Scanner;

public class Response {

    private ArrayList<String> headers = new ArrayList<>();
    private ArrayList<String> body = new ArrayList<>();

    private boolean verbose;

    public Response(Scanner in, boolean verbose) {

        boolean isHeaderContent = true;

        while (in.hasNextLine()) {
            String content = in.nextLine();
            if (content.length() < 1) {
                isHeaderContent = false;
            }

            if (isHeaderContent) {
                this.headers.add(content);
            }
            if (!isHeaderContent) {
                if (content.length() > 1) {
                    this.body.add(content);
                }
            }
        }

        this.verbose = verbose;
    }

    public void display() {
        System.out.print("\r\n");

        if (this.verbose) {
            for (String content : headers) {
                System.out.println(content);
            }
            System.out.print("\r\n\r\n");
        }

        for (String content : body) {
            System.out.println(content);
        }

    }
}
