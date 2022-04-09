package commands;

import smyts.lab6.common.util.Response;
import tools.RouteList;

/**
 *
 * class printing the information of the collection
 */

public class InfoCommand extends Command{

    RouteList routeList;
    public InfoCommand(String name, RouteList routeList) {
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
        response.addStringToSend(this.routeList.getRll().getClass().toString());
        response.addStringToSend(this.routeList.getCreationDatetime().toString());
        response.addStringToSend(Integer.toString(this.routeList.getRll().size()));
        return response;
    }

    @Override
    public String getDescription() {
        return ("Команда info выводит в стандартный поток вывода информацию о коллекции");
    }
}
