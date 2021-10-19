/**
 * @author Praneethpj
 */
package com.nasa.rover.model;


public class Position extends Coordinate {

    public char getInitOrientationType() {
        return initOrientationType;
    }



    private char initOrientationType;
    public   char orientationType(char orientationType){
       this.initOrientationType=orientationType;
        return orientationType;
    }

}
