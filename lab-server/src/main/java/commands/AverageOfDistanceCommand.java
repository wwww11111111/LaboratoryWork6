package commands;


import smyts.lab6.common.entities.Route;
import smyts.lab6.common.util.Response;
import tools.RouteList;

/**
 *
 * class for counting the average distance of the collection
 */

public class AverageOfDistanceCommand extends Command {

    private RouteList routeList;

    public AverageOfDistanceCommand(String name, RouteList routeList) {
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
        double sum = routeList.getRll().stream().mapToDouble(Route::getDistance).sum();
        response.setMessage(sum == 0 ? "в коллекции нет элементов"
                : Double.toString(sum / routeList.getRll().size()));
        return response;
    }

    @Override
    public String getDescription() {
        return "Команда average_of_distance выводит среднее значение поля distance всех элементов коллекции";
    }
}
