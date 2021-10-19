/**
 * @author Praneethpj
 */
package com.nasa.rover.controller;

import com.nasa.rover.dao.MovementDao;
import com.nasa.rover.model.Arrow;
import com.nasa.rover.model.Coordinate;
import com.nasa.rover.constant.OrientationType;

public class Movement implements MovementDao {

  public Coordinate makeMovement(Arrow arrow,Coordinate coordinate,char nextPosition){


      switch (nextPosition){
          case OrientationType.N:
              coordinate.setY(coordinate.getY()+1);
              break;
          case OrientationType.W:
              coordinate.setX(coordinate.getX()-1);
              break;
          case OrientationType.E:
              coordinate.setX(coordinate.getX()+1);
              break;
          case OrientationType.S:
              coordinate.setY(coordinate.getY()-1);
              break;
      }

      return coordinate;
  }

}
