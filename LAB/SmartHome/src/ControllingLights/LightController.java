package ControllingLights;

public class LightController {

    private String deviceId;
    private String status;

    public LightController(String deviceId) {
        this.deviceId = deviceId;
        this.status = "OFF";  
    }

    public void turnOn() {
        this.status = "ON";
        System.out.println("Light " + deviceId + " is turned ON");
    }

    public void turnOff() {
        this.status = "OFF";
        System.out.println("Light " + deviceId + " is turned OFF");
    }
}
