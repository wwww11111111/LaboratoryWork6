package commands;


import smyts.lab6.common.entities.Route;
import smyts.lab6.common.util.Response;
import tools.RouteList;

import java.io.*;
import java.util.LinkedList;

/**
 *
 *  class saving the collection to the file
 */

public class SaveCommand extends Command {

    LinkedList ll;
    String path;

    public SaveCommand(String name, RouteList rl, String path) {
        super(name);
        this.ll = rl.getRll();
        this.path = path;
    }

    /**
     *
     *  method to execute the command
     */

    @Override
    public Response execute() {
        Response response = new Response();
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            for (int i = 0; i < ll.size(); i++) {
                Route route = (Route) ll.get(i);
                String line = "";
                line += route.getId() + ",";
                line += route.getName() + ",";
                line += route.getCoordinates().getX() + ",";
                line += route.getCoordinates().getY() + ",";
                line += route.getCreationDate() + ",";
                line += route.getFrom().getX() + ",";
                line += route.getFrom().getY() + ",";
                line += route.getFrom().getZ() + ",";
                line += route.getFrom().getName() + ",";
                line += route.getTo().getX() + ",";
                line += route.getTo().getY() + ",";
                line += route.getTo().getZ() + ",";
                line += route.getTo().getName() + ",";
                line += route.getDistance();
                line += "\n";
                osw.write(line);
            }
            osw.close();
            response.setMessage("успешно.");
            return response;
        } catch (FileNotFoundException e) {

            response.setMessage("файл не найден");
            return response;
        } catch (UnsupportedEncodingException e) {
            response.setMessage("утф ошибка");
            return response;
        } catch (IOException e) {
            response.setMessage("Ошибка доступа к файлу");
            return response;
        }
    }

    @Override
    public String getDescription() {
        return ("Команда save сохранет коллекцию в файл.");
    }
}


