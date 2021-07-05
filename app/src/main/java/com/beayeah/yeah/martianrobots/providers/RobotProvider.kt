package com.beayeah.yeah.martianrobots.providers

import com.beayeah.yeah.martianrobots.model.Coordinate
import com.beayeah.yeah.martianrobots.model.Orientation
import com.beayeah.yeah.martianrobots.model.SpaceShip
import com.beayeah.yeah.martianrobots.model.Mars

class RobotProvider(private val mars: Mars) {
    fun createRobot(line: String): SpaceShip {
        val robotCommand = line.split(" ")

        val orientation: Orientation =

            when (robotCommand[2]) {
                Orientation.East.toString() -> Orientation.East
                Orientation.West.toString() -> Orientation.West
                Orientation.North.toString() -> Orientation.North
                Orientation.South.toString() -> Orientation.South
                else -> throw Exception("Invalid orientation")
            }

        return SpaceShip(
            Coordinate(robotCommand[0].toInt(), robotCommand[1].toInt()),
            orientation,
            false,
            mars
        )
    }
}