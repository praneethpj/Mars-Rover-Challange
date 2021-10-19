/**
 * @author Praneethpj
 */
package com.nasa.rover.exeptions;

public class WrongPosition extends RuntimeException{
    public WrongPosition(String wrong_position) {
        super(wrong_position);
    }
    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
