/**
 * @author Praneethpj
 */
package com.nasa.rover.valiation;

import com.nasa.rover.constant.SurfaceType;
import com.nasa.rover.model.Coordinate;
import com.nasa.rover.model.Surface;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidation {

    Pattern p;
    Matcher m;

    public boolean surfaceValidate(Surface surface, Coordinate coordinate){

        if(coordinate.getX()>surface.getUpperX() || surface.getUpperY()<coordinate.getY()){

            return false;
        }else if(coordinate.getX()<SurfaceType.lowerX || SurfaceType.lowerY>coordinate.getX()){

            return false;
        }
        return true;

    }


    public boolean getInstructions(String directions){
         p = Pattern.compile("[LRM]+(?![\\w,])");//. represents single character
         m = p.matcher(directions.toUpperCase());

        if(m.matches()){
            return true;

        }else {
            return false;
        }

    }

    public boolean validNumber(String num){
         p = Pattern.compile("-?\\d+(\\.\\d+)?");//. represents single character
         m = p.matcher(num);

        if(m.matches()){
            return true;

        }else {
            return false;
        }
    }
}
