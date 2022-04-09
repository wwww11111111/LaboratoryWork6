package commands;


import smyts.lab6.common.entities.Route;
import smyts.lab6.common.util.Response;
import tools.RouteList;

import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 *
 *  class finding the unique distance
 */

public class PrintUniqueDistanceCommand extends Command {

    private RouteList routeList;

    public PrintUniqueDistanceCommand(String name, RouteList routeList) {
        super(name);
        this.routeList = routeList;
    }

    /**
     *
     *  method to execute the command
     */

    @Override
    public Response execute() {
        Response response = new Response();
        HashSet<Float> hs = new HashSet<>();

        routeList.getRll().stream().map(Route::getDistance).filter(aFloat ->
                Collections.frequency(routeList.getRll().stream()
                        .map(Route::getDistance)
                        .collect(Collectors.toList()), aFloat) == 1)
                .forEach(aFloat -> response.addStringToSend(Float.toString(aFloat)));

        return response;
    }

    @Override
    public String getDescription() {
        return ("Команда print_unique_distance выводит уникальные значения поля distance среди всех элементов");
    }
}
