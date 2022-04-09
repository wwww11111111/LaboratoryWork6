package smyts.lab6.common.entities;

import java.io.Serializable;

public class Coordinates implements Serializable {
    private double x;
    private long y;

    public Coordinates(double x, long y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates() {
    }


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "x = " + x
                + ", y = " + y;
    }
}

