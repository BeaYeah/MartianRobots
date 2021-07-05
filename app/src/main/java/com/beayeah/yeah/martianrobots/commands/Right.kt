package com.beayeah.yeah.martianrobots.commands

import com.beayeah.yeah.martianrobots.model.Orientation
import com.beayeah.yeah.martianrobots.model.SpaceShip

class Right : BaseCommand() {
    override fun execute(spaceShip: SpaceShip) {
        when (spaceShip.orientation) {
            Orientation.East -> spaceShip.orientation = Orientation.South
            Orientation.North -> spaceShip.orientation = Orientation.East
            Orientation.South -> spaceShip.orientation = Orientation.West
            Orientation.West -> spaceShip.orientation = Orientation.North
        }
    }

    companion object {
        const val CommandCode = 'R'
    }
}