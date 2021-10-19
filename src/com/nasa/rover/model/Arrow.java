/**
 * @author Praneethpj
 */
package com.nasa.rover.model;

public class Arrow {

    public Arrow(){ }
    public Arrow(Coordinate coordinate,char head){
        this.head=head;
        this.coordinate=coordinate;
    }

    public char getHead() {
        return head;
    }

    public void setHead(char head) {
        this.head = head;
    }

    private char head;

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    private Coordinate coordinate;

}
