/**
 * @author Praneethpj
 */
package com.nasa.rover.model;

public class Arrow {

    public Arrow(){ }
    public Arrow(Coordinate coordinate,String head){
        this.head=head;
        this.coordinate=coordinate;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    private String head;

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    private Coordinate coordinate;

}
