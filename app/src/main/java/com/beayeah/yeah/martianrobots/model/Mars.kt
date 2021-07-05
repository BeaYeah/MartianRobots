package com.beayeah.yeah.martianrobots.model

class Mars(
    var bottomBound: Coordinate,
    var topBound: Coordinate,
    var spaceShips: MutableList<SpaceShip> = mutableListOf(),
    var scentedPoints: MutableList<Coordinate> = mutableListOf()
) {
    fun robotStatus(): String {
        var output: StringBuilder = StringBuilder()

        spaceShips.forEach {
            output.append("$it\n")
        }

        return output.toString()
    }

    fun isPositionScented(position: Coordinate): Boolean {
        return scentedPoints.contains(position)
    }
}