package com.beayeah.yeah.martianrobots.model

enum class Orientation {
    North,
    East,
    South,
    West;

    override fun toString() : String =
        super.toString().take(1)
}