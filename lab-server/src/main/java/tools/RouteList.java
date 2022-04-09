package tools;



import smyts.lab6.common.entities.Route;

import java.time.ZonedDateTime;
import java.util.LinkedList;

public class RouteList {
    private final LinkedList<Route> rll;
    private final ZonedDateTime creationDatetime;
    private final LinkedList<String> commandsHistory;

    public RouteList() {
        rll = new LinkedList<>();
        creationDatetime = ZonedDateTime.now();
        this.commandsHistory = new LinkedList<>();
    }

    public LinkedList<Route> getRll() {
        return rll;
    }

    public Route getRouteById (int id) {
        if (id < 0) return null;

        for (Route cur : rll) {
            if (cur.getId() == id) return cur;
        }

        return null;
    }

    public void addCommandName(String commandName) {
        if (commandsHistory.size() == 5) {
            commandsHistory.removeFirst();
        }
        commandsHistory.add(commandName);
    }

    public ZonedDateTime getCreationDatetime() {
        return creationDatetime;
    }

    public LinkedList<String> getCommandsHistory() {
        return commandsHistory;
    }
}
