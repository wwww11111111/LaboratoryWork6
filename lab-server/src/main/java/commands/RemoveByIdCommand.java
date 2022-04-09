package commands;


import smyts.lab6.common.entities.Route;
import smyts.lab6.common.util.Response;
import tools.RouteList;

import java.util.LinkedList;

/**
 * class removing objects of the collection by id
 */

public class RemoveByIdCommand extends Command {

    private LinkedList<Route> ll;

    public RemoveByIdCommand(String name, RouteList rl) {
        super(name);
        this.ll = rl.getRll();
    }

    /**
     *
     *  method to execute the command
     */

    @Override
    public Response execute() {
        try {
            System.out.println(ll.toString());
            Response response = new Response();
            int id = Integer.parseInt(this.arguments.split(" ")[1]);
            boolean isDeleted = false;
            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).getId() == id) {
                    ll.remove(ll.get(i));
                    isDeleted = true;
                }
            }
            if (!isDeleted) {
                response.setMessage("Route с таким id не существует");
            } else {
                response.setMessage("Удалено.");
            }
            return response;
        } catch ( NumberFormatException e) {
            Response response = new Response();
            response.setMessage("команда должна содержать в качестве аргумента id");
            return response;
        }

    }

    @Override
    public String getDescription() {
        return ("Команда remove_by_id удаляет из коллекции элемент id которого равен заданному");
    }
}
