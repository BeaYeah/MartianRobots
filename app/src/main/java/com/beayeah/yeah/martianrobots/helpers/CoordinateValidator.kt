package com.beayeah.yeah.martianrobots.helpers

object CoordinateValidator {
    private const val maxCoordinate = 50
    private const val minCoordinate = 0

    fun throwOutOfRangeExcept(value: Int) {
        if (!isCoordinateCorrect(value)) {
            throw Exception("The maximum value for any coordinate is 50 and the lower is 0")
        }
    }

    fun isCoordinateCorrect(value: Int): Boolean =
        value in minCoordinate - 1..maxCoordinate
}
