/**
 * @author Praneethpj
 */
package com.nasa.rover.model;


public class Position extends Coordinate {

    public String getInitOrientationType() {
        return initOrientationType;
    }



    private String initOrientationType;
    public   String orientationType(String orientationType){
       this.initOrientationType=orientationType;
        return orientationType;
    }

}
