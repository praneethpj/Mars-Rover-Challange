/**
 * @author Praneethpj
 */
package com.nasa.rover.controller.compasser;

import com.nasa.rover.controller.compasser.enums.OrientationRightEnum;
import com.nasa.rover.dao.Compass;
import com.nasa.rover.model.Arrow;

public class OrientationRight implements Compass {

    @Override
    public String getNextOrientation(Arrow arrow) {
        return  OrientationRightEnum.valueOf(arrow.getHead()).getDirection();

    }
}
