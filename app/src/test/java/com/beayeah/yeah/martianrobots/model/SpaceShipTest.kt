package com.beayeah.yeah.martianrobots.model

import junit.framework.Assert.*
import org.junit.Before
import org.junit.Test

class SpaceShipTest {
    lateinit var mars: Mars

    @Before
    fun setup() {
        mars = Mars(Coordinate(0, 0), Coordinate(5, 3))
    }

    @Test
    fun getStringReturnsCorrectly() {
        val robot = SpaceShip(Coordinate(4, 3), Orientation.West, false, mars)

        assertEquals("4 3 W", robot.toString())
    }

    @Test
    fun getStringReturnsCorrectlyIfLost() {
        val robot = SpaceShip(Coordinate(1, 2), Orientation.East, true, mars)

        assertEquals("1 2 E LOST", robot.toString())
    }

    @Test
    fun lostIfMovesOutOfBoundsX() {
        val robot = SpaceShip(Coordinate(5, 3), Orientation.East, false, mars)

        assertFalse(robot.isLost)

        robot.positionX++

        assertTrue(robot.isLost)
    }

    @Test
    fun lostIfMovesOutOfBoundsY() {
        val robot = SpaceShip(Coordinate(1, 3), Orientation.North, false, mars)

        assertFalse(robot.isLost)

        robot.positionY++

        assertTrue(robot.isLost)
    }

    @Test
    fun lostIfMovesOutOfBoundsLowerX() {
        val robot = SpaceShip(Coordinate(0, 3), Orientation.West, false, mars)

        assertFalse(robot.isLost)

        robot.positionX--

        assertTrue(robot.isLost)
    }

    @Test
    fun lostIfMovesOutOfBoundsLowerY() {
        val robot = SpaceShip(Coordinate(1, 0), Orientation.South, false, mars)

        assertFalse(robot.isLost)

        robot.positionY--

        assertTrue(robot.isLost)
    }

    @Test
    fun leavesScentWhenMovesOutOfBoundsY() {
        val initialCoordinate = Coordinate(1, 3)
        val robot = SpaceShip(initialCoordinate, Orientation.North, false, mars)

        assertFalse(robot.isLost)

        robot.positionY++

        assertTrue(mars.isPositionScented(initialCoordinate))
    }

    @Test
    fun leavesScentWhenMovesOutOfBoundsX() {
        val initialCoordinate = Coordinate(5, 3)
        val robot = SpaceShip(initialCoordinate, Orientation.East, false, mars)

        assertFalse(robot.isLost)

        robot.positionX++

        assertTrue(mars.isPositionScented(initialCoordinate))
    }

    @Test
    fun doesNotMoveOutOfBoundsIfScent() {
        val initialCoordinate = Coordinate(5, 3)
        val robot = SpaceShip(initialCoordinate, Orientation.East, false, mars)

        assertFalse(robot.isLost)
        robot.positionX++

        assertTrue(robot.isLost)
        assertTrue(mars.isPositionScented(initialCoordinate))

        val robot2 = SpaceShip(initialCoordinate, Orientation.East, false, mars)

        assertFalse(robot2.isLost)
        robot.positionX++
        assertFalse(robot2.isLost)
    }
}