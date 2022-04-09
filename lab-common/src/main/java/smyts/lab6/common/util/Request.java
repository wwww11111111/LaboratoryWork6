package smyts.lab6.common.util;

import smyts.lab6.common.entities.Route;

import java.io.Serializable;

public class Request implements Serializable {

    private String commandNameAndArguments;
    private Route route;

    public String getCommandNameAndArguments() {
        return commandNameAndArguments;
    }

    public void setCommandNameAndArguments(String commandNameAndArguments) {
        this.commandNameAndArguments = commandNameAndArguments;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
