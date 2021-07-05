package com.beayeah.yeah.martianrobots.commands

import com.beayeah.yeah.martianrobots.model.Orientation
import com.beayeah.yeah.martianrobots.model.SpaceShip

class Left : BaseCommand() {
    override fun execute(spaceShip: SpaceShip) {
        when (spaceShip.orientation) {
            Orientation.East -> spaceShip.orientation = Orientation.North
            Orientation.North -> spaceShip.orientation = Orientation.West
            Orientation.South -> spaceShip.orientation = Orientation.East
            Orientation.West -> spaceShip.orientation = Orientation.South
        }
    }

    companion object {
        const val CommandCode = 'L'
    }
}