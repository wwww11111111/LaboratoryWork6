package tools;

import commands.*;
import smyts.lab6.common.util.Response;

import java.net.Socket;
import java.util.ArrayList;

/**
 * invoker class
 */

public class CommandExecutor {

    ArrayList<Command> commands;
    private boolean isInteractiveStatus = true;
    private RouteList routeList;
    private String path;

    public CommandExecutor(ArrayList<Command> commands, RouteList routeList, String path) {
        this.commands = commands;
        this.routeList = routeList;
        this.path = path;
        initCommands();
    }

    /**
     * @param commandNameAndArguments name of the command
     */

    public Response execute(String commandNameAndArguments, Socket socket) {
        String commandName;
        Response response = new Response();
        if (commandNameAndArguments.split(" ").length == 0 || commandNameAndArguments.equals("")) {
            return response;
        }
        commandName = commandNameAndArguments.split(" ")[0];

        boolean noSuchCommand = true;

        for (Command command : commands) {

            if (command.getName().equals(commandName)) {
                if (isInteractiveStatus) {
                    command.setInteractiveStatus(true);
                } else command.setInteractiveStatus(false);

                command.setArguments(commandNameAndArguments);
                command.setSocket(socket);
                response = command.execute();
                routeList.addCommandName(command.getName());

                noSuchCommand = false;
            }

        }
        if (noSuchCommand) {
            response.setMessage("no such command");
            return response;
        }
        return response;
    }

    /**
     * @param interactiveStatus
     */

    public void setInteractiveStatus(boolean interactiveStatus) {
        isInteractiveStatus = interactiveStatus;
    }

    private void initCommands() {
        commands.add(new ClearCommand("clear", routeList));
        commands.add(new SaveCommand("save", routeList, path));
        commands.add(new HelpCommand("help", commands));
        commands.add(new InfoCommand("info", routeList));
        commands.add(new ShowCommand("show", routeList));
        commands.add(new AddCommand("add", routeList));
        commands.add(new UpdateIdCommand("update_id", routeList));
        commands.add(new RemoveByIdCommand("remove_by_id", routeList));
        commands.add(new RemoveLastCommand("remove_last", routeList));
        commands.add(new RemoveGreaterCommand("remove_greater", routeList));
        commands.add(new HistoryCommand("history", routeList));
        commands.add(new AverageOfDistanceCommand("average_of_distance", routeList));
        commands.add(new FilterLessThanDistanceCommand("filter_less_than_distance", routeList));
        commands.add(new PrintUniqueDistanceCommand("print_unique_distance", routeList));
    }

}
