/**
 * @author Praneethpj
 */
package com.nasa.rover.controller.compasser;

import com.nasa.rover.dao.Compass;
import com.nasa.rover.model.Arrow;
import com.nasa.rover.constant.OrientationType;

public class OrientationRight implements Compass {

    @Override
    public char getNextOrientation(Arrow arrow) {
        switch (arrow.getHead()) {
            case OrientationType.N:
                return OrientationType.E;
            case OrientationType.W:
                return  OrientationType.N;
            case OrientationType.S:
                return OrientationType.W;
            case OrientationType.E:
                return OrientationType.S;


        }
        return '0';
    }
}
