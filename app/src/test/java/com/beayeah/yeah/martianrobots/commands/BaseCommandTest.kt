package com.beayeah.yeah.martianrobots.commands

import com.beayeah.yeah.martianrobots.model.Coordinate
import com.beayeah.yeah.martianrobots.model.Orientation
import com.beayeah.yeah.martianrobots.model.SpaceShip
import com.beayeah.yeah.martianrobots.model.Mars


open class BaseCommandTest {
    private var mars: Mars = Mars(Coordinate(0, 0), Coordinate(5, 3))

    fun setupRobot(position: Coordinate, orientation: Orientation): SpaceShip =
        SpaceShip(position, orientation, false, mars)
}