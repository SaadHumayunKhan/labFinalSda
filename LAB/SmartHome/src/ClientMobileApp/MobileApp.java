package ClientMobileApp;

import java.io.*;
import java.net.*;

public class MobileApp {

    private String userId;
    private String lightCommand;

    public MobileApp(String userId, String lightCommand) {
        this.userId = userId;
        this.lightCommand = lightCommand;
    }

    public void sendLightCommand() {
        try (Socket socket = new Socket("localhost", 8080);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

      
            out.println(userId);
            out.println(lightCommand);

            String response = in.readLine(); 
            System.out.println("Server response: " + response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MobileApp app = new MobileApp("U001", "ON"); 
        app.sendLightCommand();

        MobileApp app2 = new MobileApp("U001", "OFF");  
        app2.sendLightCommand();
    }
}
