package kvbdev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {

    public static void main(String[] args) {
        int port = 8080;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            try (
                    Socket clientSocket = serverSocket.accept();
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
            ) {
                System.out.printf("server: New connection accepted from %s:%d%n",
                        clientSocket.getRemoteSocketAddress(), clientSocket.getPort());

                final String clientMessage = in.readLine();
                String resultMessage = "The server got a message: '" + clientMessage + "'";

                System.out.println("server: " + resultMessage);
                out.println(resultMessage);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.flush();
    }

}
