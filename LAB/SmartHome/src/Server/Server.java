package Server;

import ControllingLights.*;
import ClientMobileApp.*;

import java.io.*;
import java.net.*;

public class Server {

    private LightController lightController;

    public Server() {
        this.lightController = new LightController("L001"); 
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server started on port 8080...");

            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                    String userId = in.readLine(); 
                    String command = in.readLine(); 

                    System.out.println("Received command from User " + userId + ": " + command);

                   
                    if (command.equalsIgnoreCase("ON")) {
                        lightController.turnOn();
                    } else if (command.equalsIgnoreCase("OFF")) {
                        lightController.turnOff();
                    }

                    out.println("Command executed for User " + userId + ": Light " + command); // Send response to client
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }
}
