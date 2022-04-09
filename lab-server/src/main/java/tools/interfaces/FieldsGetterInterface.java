package tools.interfaces;



import smyts.lab6.common.entities.Coordinates;
import smyts.lab6.common.entities.Location;
import tools.exceptions.EndOfFileException;

public interface FieldsGetterInterface {
    Coordinates getCoordinates() throws EndOfFileException;
    Location getLocation() throws EndOfFileException;
    float getDistance() throws EndOfFileException;
    String getName() throws EndOfFileException;
}
