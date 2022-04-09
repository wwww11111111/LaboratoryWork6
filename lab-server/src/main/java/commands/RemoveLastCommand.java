package commands;

import smyts.lab6.common.util.Response;
import tools.RouteList;

import java.util.LinkedList;

/**
 *
 *  class removing the last element of the collection
 */

public class RemoveLastCommand extends Command {

    private LinkedList ll;

    public RemoveLastCommand(String name, RouteList rl) {
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
        if (this.ll.size() == 0) {
            response.setMessage("коллекция уже пустая!");
            return response;
        } else {
            ll.remove(ll.size() - 1);
            response.setMessage("удалено.");
            return response;
        }
    }

    @Override
    public String getDescription() {
        return ("Команда remove_last удаляет последний элемент из коллекции");
    }
}
