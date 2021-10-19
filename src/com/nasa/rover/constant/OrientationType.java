/**
 * @author Praneethpj
 */
package com.nasa.rover.constant;

import com.sun.org.apache.xpath.internal.functions.WrongNumberArgsException;

public class OrientationType {
    public final static char N='N';
    public final static char S='S';
    public final static char W='W';
    public final static char E='E';

    public static char getOrientationType(char orientation) throws WrongNumberArgsException {
        if(orientation==N || orientation==S||orientation==W||orientation==E){
            return orientation;
        }else{
            throw new WrongNumberArgsException("You have entered wrong Orientation type");
        }

    }
}
