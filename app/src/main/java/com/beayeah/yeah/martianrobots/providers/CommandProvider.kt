package com.beayeah.yeah.martianrobots.providers

import com.beayeah.yeah.martianrobots.commands.BaseCommand
import com.beayeah.yeah.martianrobots.commands.Forward
import com.beayeah.yeah.martianrobots.commands.Left
import com.beayeah.yeah.martianrobots.commands.Right

object CommandProvider {
    fun getCommandList(line: String): List<BaseCommand> {

        val commands: MutableList<BaseCommand> = mutableListOf()

        line.forEach {
            commands.add(getCommand(it))
        }
        return commands
    }

    fun getCommand(commandCode: Char): BaseCommand =
        when (commandCode) {
            Left.CommandCode -> Left()
            Right.CommandCode -> Right()
            Forward.CommandCode -> Forward()
            else -> throw Exception("Invalid command")
        }
}