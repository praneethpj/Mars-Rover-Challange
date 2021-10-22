/**
 * @author Praneethpj
 */
package com.nasa.rover.controller.compasser;

import com.nasa.rover.controller.compasser.enums.OrientationLeftEnum;
import com.nasa.rover.dao.Compass;
import com.nasa.rover.model.Arrow;

public class OrientationLeft implements Compass {




    @Override
    public String getNextOrientation(Arrow arrow) {

        return  OrientationLeftEnum.valueOf(arrow.getHead()).getDirection();

    }
}
