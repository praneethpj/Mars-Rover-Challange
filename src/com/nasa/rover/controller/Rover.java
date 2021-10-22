/**
 * @author Praneethpj
 */
package com.nasa.rover.controller;

import com.nasa.rover.controller.compasser.OrientationLeft;
import com.nasa.rover.controller.compasser.OrientationRight;
import com.nasa.rover.dao.Compass;
import com.nasa.rover.dao.RoverDao;
import com.nasa.rover.constant.ActionType;
import com.nasa.rover.model.Arrow;
import com.nasa.rover.model.Coordinate;

import java.util.stream.Stream;

public class Rover implements RoverDao {

    private Coordinate coordinate;
    private Arrow arrow;
    private Compass compasserOrientationLeft;
    private Compass compasserOrientationRight;

    private Movement movement;
    private String nextOrientation;

        public Rover(Coordinate coordinate,String orientation){

        this.coordinate=coordinate;
        this.arrow=new Arrow(this.coordinate,orientation);
        movement=new Movement();
        nextOrientation=this.arrow.getHead();
        compasserOrientationLeft=new OrientationLeft();
        compasserOrientationRight=new OrientationRight();
    }

    public void makeMove(String path){

        for (int i=0;i<path.length();i++){

            if (path.charAt(i) == ActionType.LEFT) {
                nextOrientation = compasserOrientationLeft.getNextOrientation(arrow);
                arrow.setHead(nextOrientation);
            }else if (path.charAt(i) == ActionType.RIGHT) {
                nextOrientation=compasserOrientationRight.getNextOrientation(arrow);
                arrow.setHead(nextOrientation);
            }else if (path.charAt(i) == ActionType.MOVE){
                movement.makeMovement(coordinate,nextOrientation);

            }


        }
        System.out.println(coordinate.getX()+" "+coordinate.getY()+" "+arrow.getHead());
    }
}
