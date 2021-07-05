package com.beayeah.yeah.martianrobots

import com.beayeah.yeah.martianrobots.model.SpaceShip
import com.beayeah.yeah.martianrobots.model.Mars
import com.beayeah.yeah.martianrobots.providers.CommandProvider
import com.beayeah.yeah.martianrobots.providers.RobotProvider
import com.beayeah.yeah.martianrobots.providers.MarsProvider

class CommandParser {
    private val maxCommandLength = 100

    lateinit var mars: Mars
    private lateinit var robotProvider: RobotProvider
    private var currentSpaceShip: SpaceShip? = null

    fun execute(input: String): String {
        val commandLines = input.split('\n')

        commandLines.forEachIndexed { index, line ->
            try {
                if (line.isEmpty() || line.isBlank()) {
                    // continue
                } else if (line.length > maxCommandLength) {
                    throw Exception("Command length more than 100 characters at line ${index + 1}")
                } else if (!::mars.isInitialized) {
                    val newWorld = MarsProvider.setupMars(line)
                    this.robotProvider = RobotProvider(newWorld)
                    mars = newWorld
                } else if (currentSpaceShip != null) {
                    val commands = CommandProvider.getCommandList(line)
                    currentSpaceShip?.executeCommands(commands)
                    currentSpaceShip = null
                } else { // create robot
                    val robot = robotProvider.createRobot(line)
                    this.mars.spaceShips.add(robot)
                    currentSpaceShip = robot
                }
            } catch (e: Exception) {
                throw Exception("Failed at line ${index + 1} - ${e?.message}")
            }
        }

        return mars.robotStatus()
    }
}
