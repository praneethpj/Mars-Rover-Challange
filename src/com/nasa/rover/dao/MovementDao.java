/**
 * @author Praneethpj
 */
package com.nasa.rover.dao;

import com.nasa.rover.model.Arrow;
import com.nasa.rover.model.Coordinate;

public interface MovementDao {

     Coordinate makeMovement(Coordinate coordinate, String nextPosition);
     Coordinate createMovement(Coordinate coordinate,String nextPosition);
}
