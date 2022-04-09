package tools;

import commands.*;
import smyts.lab6.common.entities.Route;
import smyts.lab6.common.util.Response;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Application {

    public static void start(String[] args) throws IOException, ClassNotFoundException {

        String path = "C:\\Users\\smyts\\Desktop\\jokes.txt";
        if (args.length == 1) {
            path = args[0];
        }

        RouteList routeList = new RouteList();
        DataReader reader = new DataReader(path);
        FIleManager fIleManager = new FIleManager(reader, routeList.getRll(), new RouteMaker());
        fIleManager.start();
        Route.setIdGenerator(fIleManager.getMaxId());

        ServerSocket server = new ServerSocket(1234);
        Socket socket = server.accept();

        ArrayList<Command> commands = new ArrayList<>();
        CommandExecutor commandExecutor = new CommandExecutor(commands, routeList, path);

        while (true) {
            System.out.println("готов принимать");
            String commandNameAndArguments = ConnectionWorker.receiveCommandNameAndArguments(socket).getCommandNameAndArguments();
            System.out.println("принял команду" + commandNameAndArguments);
            Response response = commandExecutor.execute(commandNameAndArguments, socket);
            System.out.println("выполнил");

            ConnectionWorker.sendResponse(socket, response);
            System.out.println("отправил ответ");
        }

    }
}
