package commands;

import java.net.Socket;

/**
 *
 * abstract class for the commands
 */

public abstract class Command implements CommandInterface {

    private final String name;
    String arguments;
    private boolean interactiveStatus = true;
    Socket socket;

    public Command(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setArguments(String arguments) {
        this.arguments = arguments;
    }

    public boolean isInteractiveStatus() {
        return interactiveStatus;
    }

    public void setInteractiveStatus(boolean interactiveStatus) {
        this.interactiveStatus = interactiveStatus;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
