package smyts.lab6.common.entities;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;

public class Route implements Comparable<Route>, Serializable {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Location from; //Поле может быть null
    private Location to; //Поле может быть null
    private float distance; //Значение поля должно быть больше 1
    private static int idGenerator = 0;

    @Override
    public int compareTo(Route o) {
        return (int) (distance - o.distance);
    }

    public Route() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException();
        }
        this.id = id;
    }

    public void setId() {
        this.id = ++idGenerator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) throws DateTimeParseException {
        this.creationDate = ZonedDateTime.parse(creationDate);
    }

    public Location getFrom() {
        return from;
    }

    public void setFrom(Location from) {
        this.from = from;
    }

    public Location getTo() {
        return to;
    }

    public void setTo(Location to) {
        this.to = to;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        if (distance <= 1) {
            throw new IllegalArgumentException();
        } else {
            this.distance = distance;
        }
    }

    public static void setIdGenerator (int i) {
        idGenerator = i;
    }

    @Override
    public String toString() {
        return "id = " + id + "\n" +
                "name = " + name +  "\n" +
                "coordinates = { " + coordinates.toString() + "}"  + "\n" +
                "creationDate = " + creationDate +  "\n" +
                "location from = { " + from.toString() + "}" +  "\n" +
                "location to = { " + to.toString() + "}" +  "\n" +
                "distance = " + distance +  "\n";
    }
}
