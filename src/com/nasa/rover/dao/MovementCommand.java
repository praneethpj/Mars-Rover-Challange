package com.nasa.rover.dao;

import com.nasa.rover.model.Coordinate;

/**
 * @author Praneethpj
 */
public interface MovementCommand {
    Coordinate  create(Coordinate coordinate);
}
