/**
 * @author Praneethpj
 */
package com.nasa.rover.controller;


import com.nasa.rover.constant.OrientationType;
import com.nasa.rover.controller.Rover;
import com.nasa.rover.exeptions.WrongPosition;
import com.nasa.rover.model.Coordinate;
import com.nasa.rover.model.Position;
import com.nasa.rover.model.Surface;
import com.nasa.rover.valiation.InputValidation;
import com.sun.org.apache.xpath.internal.functions.WrongNumberArgsException;
import javafx.geometry.Pos;

import java.util.Scanner;

public class UserInputReader {

    private Scanner scanner;
    private InputValidation inputValidation;

    public UserInputReader(){
        scanner=new java.util.Scanner(System.in);
        inputValidation=new InputValidation();
    }

    private Surface getSurface(){
        String tmpSurface[]=scanner.nextLine().split(" ");


        if(tmpSurface.length<2 || tmpSurface.length>2){
            throw new RuntimeException("Wrong Surface pattern ");
        }
        if(!inputValidation.validNumber(String.valueOf(tmpSurface[0].charAt(0))) || !inputValidation.validNumber(String.valueOf(tmpSurface[1].charAt(0)))){
            throw new NumberFormatException("The numbers in Surface is not correct");
        }

        Surface surface=new Surface(Integer.valueOf(tmpSurface[0]),Integer.valueOf(tmpSurface[1]));
        return surface;

    }

    private Position getPosition(){

        String tmpPostion[]=scanner.nextLine().split(" ");

        if(tmpPostion.length<3 || tmpPostion.length>3){
            throw new WrongPosition("Wrong Position");
        }
        int tmpX=0;
        int tmpY=0;

        try{
            tmpX=Integer.parseInt(String.valueOf(tmpPostion[0].charAt(0)));
            tmpY=Integer.parseInt(String.valueOf(tmpPostion[1].charAt(0)));
        }catch (NumberFormatException ex){
            throw new NumberFormatException("The numbers in Position is not correct");
        }


       if(!inputValidation.validNumber(String.valueOf(tmpX)) || !inputValidation.validNumber(String.valueOf(tmpY))){
           throw new NumberFormatException("The numbers in Position is not correct");
        }
        Position position= new Position();

        position.setX(tmpX);
        position.setY(tmpY);
        try {
            position.orientationType(OrientationType.getOrientationType(tmpPostion[2].charAt(0)));
        } catch (WrongNumberArgsException e) {
            e.printStackTrace();
        }



        return position;

    }

    private String getInstructions(){
        String tmpInstructor=scanner.nextLine();

       if( inputValidation.getInstructions(tmpInstructor)){
           return tmpInstructor;
       }else{
           throw new RuntimeException("The instruction pattern is wrong (Ex: LLRRMM)");
       }

    }

    public void Commit(int numberofRovers){
        Surface surface=getSurface();
        Coordinate coordinate[]=new Coordinate[numberofRovers];
        String instructions[]=new String[numberofRovers];
        for(int i=0;i<numberofRovers;i++) {
             coordinate[i] = getPosition();
             instructions[i] = getInstructions();
        }
        for(int i=0;i<numberofRovers;i++) {
            if (inputValidation.surfaceValidate(surface, coordinate[i])) {
                Position position= (Position) coordinate[i];
                Rover rover = new Rover(coordinate[i], position.getInitOrientationType());
                rover.makeMove(instructions[i]);
            }
        }
    }


}
