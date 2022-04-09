package commands;

import smyts.lab6.common.util.Response;
import tools.RouteList;

import java.util.LinkedList;

/**
 *
 * class to clear the collection
 */

public class ClearCommand extends Command {

    private LinkedList ll;

    public ClearCommand(String name, RouteList rl) {
        super(name);
        this.ll = rl.getRll();
    }

    /**
     *
     *  method to execute the command
     */

    @Override
    public Response execute() {
        ll.clear();
        Response response = new Response();
        response.setMessage("Коллекция была успешно очищена!");
        return response;
    }

    @Override
    public String getDescription() {
        return ("Команда clear очищает коллекцию.");
    }


}
