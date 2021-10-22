/**
 * @author Praneethpj
 */
package com.nasa.rover.model;

public class Coordinate {
    public int getX() {
        return x;
    }

    public String setX(int x) {
        this.x = x;
        return "";
    }

    public int getY() {
        return y;
    }

    public String setY(int y) {
        this.y = y;
        return "";
    }

    private int  x;
    private int  y;
}
