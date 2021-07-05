package com.beayeah.yeah.martianrobots.commands

import com.beayeah.yeah.martianrobots.model.Orientation
import com.beayeah.yeah.martianrobots.model.SpaceShip

class Forward : BaseCommand() {
    override fun execute(spaceShip: SpaceShip) {
        when (spaceShip.orientation) {
            Orientation.East -> spaceShip.positionX++
            Orientation.North -> spaceShip.positionY++
            Orientation.South -> spaceShip.positionY--
            Orientation.West -> spaceShip.positionX--
        }
    }

    companion object {
        const val CommandCode = 'F'
    }
}