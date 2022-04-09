package entities;

public class Location {
    private Float x; //Поле не может быть null
    private long y;
    private Double z; //Поле не может быть null
    private String name; //Поле не может быть null

    public Location(Float x, long y, Double z, String name) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    public Location() {

    }

    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }

    public Double getZ() {
        return z;
    }

    public void setZ(Double z) {
        this.z = z;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.equals("") || name == null) {
            throw new IllegalArgumentException();
        } else {
            this.name = name;
        }
    }

    @Override
    public String toString() {
        return  "x = " + x +
                ", y = " + y +
                ", z = " + z +
                ", name = '" + name + '\'';
    }
}
