package com.beayeah.yeah.martianrobots.providers

import com.beayeah.yeah.martianrobots.model.Coordinate
import com.beayeah.yeah.martianrobots.model.Mars

object MarsProvider {
    fun setupMars(line: String): Mars {
        val xy = line.split(" ")

        val topX = xy[0].toInt()
        val topY = xy[1].toInt()

        return Mars(Coordinate(0, 0), Coordinate(topX, topY))
    }
}