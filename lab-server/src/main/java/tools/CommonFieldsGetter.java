package tools;


import smyts.lab6.common.entities.Route;
import tools.exceptions.EndOfFileException;
import tools.interfaces.FieldsGetterInterface;

import java.time.ZonedDateTime;

/**
 * class for the getting the fields
 */

public class CommonFieldsGetter {

    /**
     * terminal input
     */
    private FieldsGetterInterface scanner;

    /**
     * file input
     */
    private FieldsGetterInterface reader;

    public CommonFieldsGetter(FieldsGetterInterface scanner, FieldsGetterInterface reader) {
        this.scanner = scanner;
        this.reader = reader;
    }

    public Route start(boolean isInteractive) throws EndOfFileException {
        if (isInteractive) {
            Route route = new Route();
            route.setId();
            route.setCoordinates(scanner.getCoordinates());
            System.out.println("Введите координаты x (Float) y (long) z (Double) и имя начала ");
            route.setFrom(scanner.getLocation());
            System.out.println("Введите координаты x (Float) y (long) z (Double) и имя начала ");
            route.setTo(scanner.getLocation());
            route.setDistance(scanner.getDistance());
            route.setCreationDate(ZonedDateTime.now().toString());
            return route;
        } else {
            Route route = new Route();
            route.setId();
            route.setCoordinates(reader.getCoordinates());
            route.setFrom(reader.getLocation());
            route.setTo(reader.getLocation());
            route.setCreationDate(ZonedDateTime.now().toString());
            route.setDistance(reader.getDistance());
            return route;
        }


    }

    public FieldsGetterInterface getScanner() {
        return scanner;
    }
    public FieldsGetterInterface getReader() {return reader;}

}
