package com.beayeah.yeah.martianrobots.commands

import com.beayeah.yeah.martianrobots.model.SpaceShip

abstract class BaseCommand {
    abstract fun execute(spaceShip: SpaceShip)
}