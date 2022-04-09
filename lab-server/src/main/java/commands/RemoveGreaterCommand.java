package commands;


import smyts.lab6.common.entities.Route;
import smyts.lab6.common.util.Response;
import tools.RouteList;

import java.util.LinkedList;

/**
 * class removing all the elements greater than given
 */

public class RemoveGreaterCommand extends Command {

    private LinkedList<Route> ll;

    public RemoveGreaterCommand(String name, RouteList rl) {
        super(name);
        this.ll = rl.getRll();
    }

    /**
     * method to execute the command
     */

    @Override
    public Response execute() {
        Response response = new Response();
        float distance = Float.parseFloat(this.arguments.split(" ")[1]);
        if (distance <= 1) {
            response.setMessage("Введенное число должно быть больше 1 ");
            return response;
        }
        if (ll.size() == 0) {
            response.setMessage("Коллекция пуста.");
            return response;
        }

        ll.stream().filter(route -> route.getDistance() > distance);
        response.setMessage("Удалено.");
        return response;

    }

    @Override
    public String getDescription() {
        return ("Команда remove_greater удаляет из коллекции элементы значение distance которых превыщает заданное");
    }
}
