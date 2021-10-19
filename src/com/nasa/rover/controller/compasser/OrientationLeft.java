/**
 * @author Praneethpj
 */
package com.nasa.rover.controller.compasser;

import com.nasa.rover.dao.Compass;
import com.nasa.rover.model.Arrow;
import com.nasa.rover.constant.OrientationType;

public class OrientationLeft implements Compass {
    @Override
    public char getNextOrientation(Arrow arrow) {
        switch (arrow.getHead()) {
            case OrientationType.N:
                return OrientationType.W;
            case OrientationType.W:
                return OrientationType.S;
            case OrientationType.S:
                return OrientationType.E;
            case OrientationType.E:
                return OrientationType.N;

        }
        return '0';
    }
}
