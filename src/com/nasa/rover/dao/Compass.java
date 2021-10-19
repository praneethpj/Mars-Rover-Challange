/**
 * @author Praneethpj
 */
package com.nasa.rover.dao;

import com.nasa.rover.model.Arrow;

public interface Compass {
     char getNextOrientation(Arrow arrow);
}
