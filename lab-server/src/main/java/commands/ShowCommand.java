package commands;

import smyts.lab6.common.entities.Route;
import smyts.lab6.common.util.Response;
import tools.RouteList;

import java.util.LinkedList;

/**
 *
 *  class printing the collection
 */

public class ShowCommand extends Command {

    String name;
    LinkedList ll;

    public ShowCommand(String name, RouteList rl) {
        super(name);
        this.ll = rl.getRll();
    }

    /**
     *
     *  method to execute the command
     */

    @Override
    public Response execute() {
        Response response = new Response();
        if (ll.size() == 0) {
            response.setMessage("Коллекция пуста!");
            return response;
        }

        for (int i = 0; i < ll.size(); i++) {
            response.addStringToSend("Route " + (i + 1));
            response.addStringToSend(ll.get(i).toString());

        }
        return response;

    }

    @Override
    public String getDescription() {
        return ("Команда show выводит в стандартный поток вывода все элементы коллекции в строковом представлении");
    }
}
