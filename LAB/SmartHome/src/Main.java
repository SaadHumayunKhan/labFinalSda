

import Server.*;

public class Main {

    public static void main(String[] args) {
       
        Thread serverThread = new Thread(() -> {
            Server server = new Server();
            server.start();
        });
        serverThread.start();

        
        try {
            Thread.sleep(1000);  
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

     
        ClientMobileApp.MobileApp mobileApp = new ClientMobileApp.MobileApp("U001", "ON");  // Turn ON the light
        mobileApp.sendLightCommand();

        ClientMobileApp.MobileApp mobileApp2 = new ClientMobileApp.MobileApp("U001", "OFF");  // Turn OFF the light
        mobileApp2.sendLightCommand();
    }
}
