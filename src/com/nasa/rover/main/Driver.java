/**
 * @author Praneethpj
 */
package com.nasa.rover.main;

import com.nasa.rover.controller.UserInputReader;

public class Driver {


    public static void main(String[] args) {
        ////Number of Rovers count is 2
        final int numberOfRovers=2;

        UserInputReader userInputReader=new UserInputReader();

        userInputReader.Commit(numberOfRovers);


    }
}
