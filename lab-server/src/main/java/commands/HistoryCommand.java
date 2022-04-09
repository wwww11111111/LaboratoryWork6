package commands;

import smyts.lab6.common.util.Response;
import tools.RouteList;

/**
 *
 * class printing last 6 commands
 */

public class HistoryCommand extends Command{

    private RouteList rl;

    public HistoryCommand(String name, RouteList rl) {
        super(name);
        this.rl = rl;
    }

    /**
     *
     *  method to execute the command
     */

    @Override
    public Response execute() {
        Response response = new Response();
        rl.getCommandsHistory().forEach(response::addStringToSend);
        return response;
    }

    @Override
    public String getDescription() {
        return ("Команда history выводит последние 6 команд");
    }
}
