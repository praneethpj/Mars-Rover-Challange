package com.nasa.rover.controller.compasser.enums;

import com.nasa.rover.constant.OrientationTypeEnum;

/**
 * @author Praneethpj
 */
public enum OrientationLeftEnum {
    N {

        public String getDirection() {
            return OrientationTypeEnum.W.toString();
        }
    },
    S {

        public String getDirection() {
            return OrientationTypeEnum.E.toString();
        }
    },
    E {

        public String getDirection() {
            return OrientationTypeEnum.N.toString();
        }
    },
    W {

        public String getDirection() {
            return OrientationTypeEnum.S.toString();
        }
    };
    public abstract String getDirection();
}
