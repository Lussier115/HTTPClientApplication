package com.httpc.httpfs;

import java.io. *;
import java.net.ServerSocket;
import java.net.Socket;

public class httpfs {

    private static String MAINPATH = System.getProperty("user.dir") + "/src/com/httpc/httpfs";

    private ServerSocket client;
    private String path;

    private final String CODE_OK = "HTTP/1.0 200 OK \r\n";
    private final String CODE_NOT_FOUND = "HTTP/1.0 404 Not Found \r\n";
    private final String CODE_CREATED = "HTTP/1.0 201 Created \r\n";
    private final String CODE_BAD_REQUEST = "HTTP/1.0 400 Bad Request \r\n";
    private final String CODE_FORBIDDEN = "HTTP/1.0 403 Forbidden \r\n";

    public static void main(String[] args) throws IOException{
        httpfs server = new httpfs(8080, MAINPATH);
        server.start();
    }

    private httpfs(int port, String directory) {
        try {
            client = new ServerSocket(port);
            System.out.println("Server started at port: " + port);
        } catch(IOException e) {
            System.out.print(e.getMessage());
        }
        path = directory;
    }

    private void start() {
        while (true) {
            try {
                Socket socket = client.accept();
                InputStream is = socket.getInputStream();
                OutputStream os = socket.getOutputStream();
                Writer writer = new BufferedWriter(new OutputStreamWriter(os));
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));

                String line = reader.readLine();
                String path = line.substring(line.indexOf(' ')+1, line.indexOf(' ', line.indexOf(' ') + 1));

                if (line.contains("GET")) {
                    if ( (path.contentEquals("")) || (path.contentEquals("/")) ) {
                        /**
                         * PART 2: QUESTION 1
                         */
                        readAllFiles(writer);
                    } else {
                        /**
                         PART 2: QUESTION 2
                         */
                        readFile(path, writer);
                    }
                } else if (line.contains("POST")) {
                        /**
                         PART 2: QUESTION 3
                         */
                    postFile(path, writer, reader);
                }

                socket.close();
            } catch(IOException e) {
                System.out.print(e.getMessage());
            }
        }
    }

    private void readAllFiles(Writer writer) {
        try {
            File directory = new File(path);
            File[] fileNames = directory.listFiles();

            String content = "";
            writer.write(CODE_OK + "\r\n");
            writer.write(CODE_OK);

            for (int i=0; i<fileNames.length; i++){
                content += fileNames[i].getName() + "\r\n";
            }

            writer.write(content);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFile(String file, Writer writer) {
        try {
            if (file.contains("//")) {
                writer.write(CODE_BAD_REQUEST + "\r\n");
                writer.write(CODE_BAD_REQUEST);
                writer.flush();
            } else {
                try {
                    File fileName = new File(path + file);
                    FileReader fileReader = new FileReader(fileName);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);

                    int length = readContentLength(fileName);
                    char[] fileRead = new char[length];
                    String content = readContentType(file);

                    bufferedReader.read(fileRead);

                    writer.write(CODE_OK);
                    writer.write("\r\n");

                    writer.write(CODE_OK);
//                    How to get user-agent in the headers?
//                    writer.write("User-Agent: " + useragent + "\n");
                    writer.write("Content-Length: " + length + "\n");
                    writer.write("Content-Type: " + content + "\n"+ "\n");
                    writer.write(fileRead);

                    writer.flush();
                    fileReader.close();
                    bufferedReader.close();
                } catch (FileNotFoundException e) {
                    writer.write(CODE_NOT_FOUND + "\r\n");
                    writer.write(CODE_NOT_FOUND);
                    writer.flush();
                }
            }
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }

    private void postFile(String file, Writer writer, BufferedReader reader) {
        try {
            File fileName = new File(path + file);
            int length = readContentLength(fileName);
            FileWriter newFile = new FileWriter(path + file);

            String line = reader.readLine();
            while (!line.isEmpty())
            {
                line = reader.readLine();
                char[] fileToWrite = new char[length];
                newFile.write(fileToWrite);
            }

            writer.write(CODE_CREATED + "\r\n");
            writer.write(CODE_CREATED);

            writer.flush();
            reader.close();
            newFile.close();
        } catch(IOException e) {
            System.out.print(e.getMessage());
        }
    }

    private int readContentLength(File file) {
        int length = (int) file.length();
        return length;
    }

    private String readContentType(String file) {
        if (file.endsWith(".html"))
            return "text/html";
        else if (file.endsWith(".xml"))
            return "text/xml";
        else if (file.endsWith(".json"))
            return "application/json";
        else if (file.endsWith(".plain"))
            return "text/plain";
        return "";
    }
}