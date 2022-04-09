package smyts.lab6.utils;

import smyts.lab6.common.entities.Coordinates;
import smyts.lab6.common.entities.Location;
import smyts.lab6.exceptions.EndOfFileException;

public interface FieldsGetterInterface {
    Coordinates getCoordinates() throws EndOfFileException;
    Location getLocation() throws EndOfFileException;
    float getDistance() throws EndOfFileException;
    String getName() throws EndOfFileException;
}
