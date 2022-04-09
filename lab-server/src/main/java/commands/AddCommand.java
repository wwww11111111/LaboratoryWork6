package commands;


import tools.ConnectionWorker;
import smyts.lab6.common.util.Request;
import smyts.lab6.common.util.Response;
import tools.*;

import java.io.IOException;
import java.util.LinkedList;

/**
 * command for adding element to the collection
 */

public class AddCommand extends Command {


    private LinkedList ll;
    private CommonFieldsGetter fieldsGetter;

    /**
     * @param name name of the command
     * @param rl   wrapper of the list
     */
    public AddCommand(String name, RouteList rl) {

        super(name);
        this.ll = rl.getRll();
    }

    /**
     * method to execute the command
     */

    @Override
    public Response execute() {
        try {
            Request request = ConnectionWorker.askForAnObjectResponse(socket);
            ll.add(request.getRoute());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        Response response = new Response();
        response.setMessage("Объект был успешно добавлен в коллекцию.");
        return response;
    }

    @Override
    public String getDescription() {
        return "Команда add *name* активирует форму для добавления в коллекцию нового элемента.";
    }
}
