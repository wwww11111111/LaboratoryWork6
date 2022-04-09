package tools;


import smyts.lab6.common.entities.Coordinates;
import smyts.lab6.common.entities.Location;
import smyts.lab6.common.entities.Route;
import tools.exceptions.NotCorrectArgumentException;
import tools.interfaces.ObjectMaker;

import java.time.DateTimeException;
import java.util.HashSet;

/**
 * class for making the routes from the file
 */

public class RouteMaker implements ObjectMaker<Route> {

    private HashSet<Integer> usedIds = new HashSet<>();

    @Override
    public Route makeObject(String[] splittedString) throws NotCorrectArgumentException {

        Route route = new Route();

        int i = 0;
        try {
            int id = Integer.parseInt(splittedString[i++]);

            if (!usedIds.add(id)) {
             throw new NotCorrectArgumentException(i);
            }

            route.setId(id);
            route.setName(splittedString[i++]);

            Coordinates coordinates = new Coordinates();
            coordinates.setX(Double.parseDouble(splittedString[i++]));
            coordinates.setY(Long.parseLong(splittedString[i++]));
            route.setCoordinates(coordinates);


            route.setCreationDate(splittedString[i++]);

            for (int j = 0; j < 2; j++) {
                Location location = new Location();
                location.setX(Float.parseFloat(splittedString[i++]));
                location.setY(Long.parseLong(splittedString[i++]));
                location.setZ(Double.parseDouble(splittedString[i++]));
                location.setName(splittedString[i++]);
                if (j == 0) route.setFrom(location);
                else route.setTo(location);
            }

            route.setDistance(Float.parseFloat(splittedString[i++]));
        } catch (IllegalArgumentException | DateTimeException e) {
            throw new NotCorrectArgumentException(++i);
        }

        return route;
    }
}
