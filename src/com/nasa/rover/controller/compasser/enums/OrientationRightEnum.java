package com.nasa.rover.controller.compasser.enums;

import com.nasa.rover.constant.OrientationTypeEnum;

/**
 * @author Praneethpj
 */
public enum OrientationRightEnum {
    N {

        public String getDirection() {
            return OrientationTypeEnum.E.toString();
        }
    },
    S {

        public String getDirection() {
            return OrientationTypeEnum.W.toString();
        }
    },
    E {

        public String getDirection() {
            return OrientationTypeEnum.S.toString();
        }
    },
    W {

        public String getDirection() {
            return OrientationTypeEnum.N.toString();
        }
    };
    public abstract String getDirection();
}
