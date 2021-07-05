package com.beayeah.yeah.martianrobots.model

import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Test

class MarsTest {
    @Test
    fun isScentedReturnsCorrectly() {
        var world = Mars(Coordinate(0, 0), Coordinate(5, 3))

        world.scentedPoints = mutableListOf(Coordinate(5, 3), Coordinate(4, 3))

        assertTrue(world.isPositionScented(Coordinate(4, 3)))
        assertTrue(world.isPositionScented(Coordinate(5, 3)))
        assertFalse(world.isPositionScented(Coordinate(1, 3)))
    }
}