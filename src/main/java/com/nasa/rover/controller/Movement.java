/**
 * @author Praneethpj
 */
package com.nasa.rover.controller;

import com.nasa.rover.constant.OrientationTypeEnum;
import com.nasa.rover.dao.MovementCommand;
import com.nasa.rover.dao.MovementDao;
import com.nasa.rover.model.Coordinate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
//Used Command Pattern
public class Movement implements MovementDao {
    private static final Map<String, MovementCommand> MOVEMENT;

    static {
        final Map<String, MovementCommand> movementCoordinates = new HashMap<>();
        movementCoordinates.put(OrientationTypeEnum.N.name(), coordinate -> {//new MovementCommand() { replace with lambda
            coordinate.setY(coordinate.getY()+1);
            return  coordinate;
        });

        movementCoordinates.put(OrientationTypeEnum.W.toString(), coordinate -> {
            coordinate.setX(coordinate.getX()-1);
            return  coordinate;
        });
        movementCoordinates.put(OrientationTypeEnum.E.toString(), coordinate -> {
            coordinate.setX(coordinate.getX()+1);
            return  coordinate;
        });
        movementCoordinates.put(OrientationTypeEnum.S.toString(), coordinate -> {
            coordinate.setY(coordinate.getY()-1);
            return  coordinate;
        });
        MOVEMENT = Collections.unmodifiableMap(movementCoordinates);
    }

    public Coordinate createMovement(Coordinate coordinate,String nextPosition) {
        MovementCommand command = MOVEMENT.get(nextPosition);

        if (command == null) {
            throw new IllegalArgumentException("Invalid Position type: "
                    + nextPosition);
        }

        return command.create(coordinate);
    }

  public Coordinate makeMovement(Coordinate coordinate,String nextPosition){
      Movement createCommand = new Movement();
      return createCommand.createMovement(coordinate,String.valueOf(nextPosition));

  }

}
