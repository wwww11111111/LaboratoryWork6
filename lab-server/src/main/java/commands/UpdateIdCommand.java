package commands;


import tools.ConnectionWorker;
import smyts.lab6.common.entities.Route;
import smyts.lab6.common.util.Request;
import smyts.lab6.common.util.Response;
import tools.*;

import java.io.IOException;

/**
 *
 *  class updating the element by id
 */


public class UpdateIdCommand extends Command {

    private RouteList rl;
    private CommonFieldsGetter fieldsGetter;
    private DataReader reader;

    public UpdateIdCommand(String name, RouteList rl) {
        super(name);
        this.rl = rl;
    }

    /**
     *
     *  method to execute the command
     */
    @Override
    public Response execute() {
        try {
            Response response = new Response();
            if (this.arguments.split(" ").length == 1) {
                response.setMessage("Команда update_id должна содержать id в качестве аргумента.");
                return response;
            }
            int id = Integer.parseInt(this.arguments.split(" ")[1]);
            Route route = rl.getRouteById(id);
            if (route == null) {
                response.setMessage("Route с таким id не существует");
                return response;
            }
            rl.getRll().remove(route);
            Request request = ConnectionWorker.askForAnObjectResponse(socket);
            request.getRoute().setId(id);
            rl.getRll().add(request.getRoute());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        Response response = new Response();
        response.setMessage("Значение элемента было успешно обновлено.");
        return response;
    }

    @Override
    public String getDescription() {
        return ("Команда update_id обновляет значение элемента id которого равен заданному");
    }
}
