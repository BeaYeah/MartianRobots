package com.beayeah.yeah.martianrobots.model

import com.beayeah.yeah.martianrobots.commands.BaseCommand

class SpaceShip(
    private var position: Coordinate,
    var orientation: Orientation,
    var isLost: Boolean = false,
    var mars: Mars
) {

    var positionX: Int
        set(newX) {
            if (isLost)
                return

            updatePosition(Coordinate(newX, position.y))
        }
        get() = position.x

    var positionY: Int
        set(newY) {
            if (isLost)
                return

            updatePosition(Coordinate(position.x, newY))
        }
        get() = position.y

    private fun updatePosition(newPosition: Coordinate) {
        if (newPosition.x > mars.topBound.x || newPosition.y > mars.topBound.y
            || newPosition.y < mars.bottomBound.y || newPosition.x < mars.bottomBound.x
        ) {
            robotLost()
            return
        }

        position = newPosition
    }

    private fun robotLost() {
        if (mars.isPositionScented(position)) {
            return
        }

        mars.scentedPoints.add(position)
        isLost = true
    }

    fun executeCommand(command: BaseCommand): SpaceShip {
        command.execute(this)
        return this
    }

    fun executeCommands(commands: List<BaseCommand>): SpaceShip {
        commands.forEach {
            executeCommand(it)
        }
        return this
    }

    override fun toString(): String {
        val lostText = if (isLost) " LOST" else ""

        return "$position $orientation$lostText"
    }
}
