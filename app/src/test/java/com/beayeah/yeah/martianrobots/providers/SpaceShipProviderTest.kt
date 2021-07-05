package com.beayeah.yeah.martianrobots.providers

import com.beayeah.yeah.martianrobots.model.Coordinate
import com.beayeah.yeah.martianrobots.model.Orientation
import com.beayeah.yeah.martianrobots.model.Mars
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class SpaceShipProviderTest {
    lateinit var robotProvider: RobotProvider
    private var mars: Mars = Mars(Coordinate(0, 0), Coordinate(5, 3))

    @Before
    fun Setup() {
        robotProvider = RobotProvider(mars)
    }

    @Test
    fun getsRobotEast() {
        val robot = robotProvider.createRobot("1 1 E")

        assertEquals(1, robot.positionX)
        assertEquals(1, robot.positionY)
        assertEquals(robot.orientation.toString(), Orientation.East.toString())
    }

    @Test
    fun getsRobotNorth() {
        val robot = robotProvider.createRobot("3 2 N")

        assertEquals(3, robot.positionX)
        assertEquals(2, robot.positionY)
        assertEquals(robot.orientation.toString(), Orientation.North.toString())
    }

    @Test
    fun getsRobotWest() {
        val robot = robotProvider.createRobot("0 3 W")

        assertEquals(0, robot.positionX)
        assertEquals(3, robot.positionY)
        assertEquals(robot.orientation.toString(), Orientation.West.toString())
    }

    @Test
    fun getsRobotSouth() {
        val robot = robotProvider.createRobot("3 2 S")

        assertEquals(3, robot.positionX)
        assertEquals(2, robot.positionY)
        assertEquals(robot.orientation.toString(), Orientation.South.toString())
    }
}