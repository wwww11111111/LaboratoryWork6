package commands;

import smyts.lab6.common.util.Response;

import java.util.ArrayList;

/**
 * class printing all of the commands
 */

public class HelpCommand extends Command {

    ArrayList<Command> commands;

    public HelpCommand(String name, ArrayList<Command> commands) {
        super(name);
        this.commands = commands;
    }

    /**
     *
     *  method to execute the command
     */

    @Override
    public Response execute() {
        Response response = new Response();

        commands.forEach(command -> response.addStringToSend(command.getDescription()));

        return response;
    }

    @Override
    public String getDescription() {
        return ("Команда help выводит справку по доступным командам.");
    }
}
