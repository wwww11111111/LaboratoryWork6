package smyts.lab6.common.util;

import smyts.lab6.common.entities.Route;

import java.io.Serializable;
import java.util.ArrayList;

public class Response implements Serializable {

    String message;
    boolean isObjectNeeded;
    ArrayList<Route> routes = new ArrayList<>();
    ArrayList<String> strings = new ArrayList<>();


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isObjectNeeded() {
        return isObjectNeeded;
    }

    public void setObjectNeeded(boolean objectNeeded) {
        isObjectNeeded = objectNeeded;
    }

    public void addRouteToSend(Route route) {
        this.routes.add(route);
    }

    public void addStringToSend(String string) {
        this.strings.add(string);
    }

    public ArrayList<Route> getRoutes() {
        return routes;
    }

    public ArrayList<String> getStrings() {
        return strings;
    }

    public void setRoutes(ArrayList<Route> routes) {
        this.routes = routes;
    }
}
