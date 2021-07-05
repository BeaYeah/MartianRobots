package com.beayeah.yeah.martianrobots.model

import com.beayeah.yeah.martianrobots.helpers.CoordinateValidator


data class Coordinate(
    var x : Int = 0,
    var y : Int = 0) {

    override fun toString(): String =
        "$x $y"

    init {
        CoordinateValidator.throwOutOfRangeExcept(x)
        CoordinateValidator.throwOutOfRangeExcept(y)
    }
}