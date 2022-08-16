package kvbdev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientExample {

    public static void main(String[] args) {

        String host = "127.0.0.1";
        int port = 8080;

        try (
                Socket socket = new Socket(host, port);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            out.println("CLIENT");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
