# labFinalSda


---

# Smart Home System with IoT and Mobile App Control

## Overview

This project simulates a smart home system where a user can control a light through a mobile app. The system follows a **client-server architecture** where:

- The **MobileApp** (client) sends commands to the **Server**.
- The **Server** receives these commands and communicates with the **LightController** to perform actions (turning the light on or off).

The project uses **GRASP principles** (General Responsibility Assignment Software Patterns) to ensure that responsibilities are assigned to the right classes in an efficient manner.


### Key Classes:

- **MobileApp.java**: Represents the mobile application that sends commands to the server.
- **Server.java**: The server that listens for incoming requests and controls the light based on user commands.
- **LightController.java**: Controls the light's state (ON/OFF) based on commands from the server.
- **Main.java**: The main entry point to start the server and simulate the mobile app interaction.

## GRASP Principles Used

### 1. **Information Expert** (LightController)

- **Responsibility**: The `LightController` class is responsible for controlling the light, as it has the necessary information about the light's state (ON/OFF) and its unique identifier (device ID).
- **Why**: This principle ensures that the class with the most information about the light is the one making decisions about its state.

### 2. **Controller** (Server)

- **Responsibility**: The `Server` class acts as a controller, receiving commands from the mobile app and forwarding them to the appropriate controller (i.e., `LightController`).
- **Why**: By making the server the central controller of the application, it decouples the responsibility of managing user inputs from the actual logic of turning the light on or off.

### 3. **Low Coupling** (MobileApp, Server, LightController)

- **Responsibility**: Each class (MobileApp, Server, and LightController) is loosely coupled, meaning they interact through clearly defined interfaces (method calls). The server doesn't need to know the details of the mobile app or light controller, and vice versa.
- **Why**: This promotes modularity, making the system easier to maintain and extend.

### 4. **High Cohesion** (MobileApp, Server, LightController)

- **Responsibility**: Each class has a well-defined role:
    - `MobileApp`: Sends commands.
    - `Server`: Receives and processes commands.
    - `LightController`: Controls the light's state.
- **Why**: High cohesion ensures that related functions are grouped together, making each class focused and easier to understand.

### 5. **Polymorphism** (LightController methods)

- **Responsibility**: Methods like `turnOn()` and `turnOff()` in `LightController` exhibit polymorphism. They are simple actions that can be called on any light object regardless of its state.
- **Why**: This allows us to treat different types of lights in the same way, improving flexibility and extensibility.

---

## How to Run the Code

### Steps to Run the Project:

1. **Clone the Repository**:

   ```bash
   git clone <your-repository-url>
   cd smart-home-system
   ```

4. **Run the Project**:

   To start the system, run the `Main` class:

   This will:
   - Start the **Server** in a background thread.
   - Simulate the **MobileApp** sending light control commands (turning a light on and off).

### Expected Output:

- The server will print the received command and the action it performs (turning the light on or off).
- The **MobileApp** will print the server's response confirming the action.

---

## Explanation of the Flow:

1. **MobileApp** sends the user's ID and a command (ON/OFF) to the **Server**.
2. The **Server** receives this data and forwards the command to the **LightController**.
3. The **LightController** changes the state of the light (ON or OFF) and logs the action.
4. The **Server** sends a response back to the **MobileApp**, confirming the action.

---

## Conclusion

This project is a simple implementation of a **Smart Home System** that follows **GRASP principles** to ensure maintainability, scalability, and clarity in the code structure. The **client-server architecture** allows easy communication between the mobile app and the server, and the **LightController** effectively manages the light's state.
