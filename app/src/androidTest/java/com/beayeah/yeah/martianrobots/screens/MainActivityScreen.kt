package com.beayeah.yeah.martianrobots.screens

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import com.beayeah.yeah.martianrobots.R
import com.beayeah.yeah.martianrobots.extensions.checkHasText
import com.beayeah.yeah.martianrobots.extensions.clearText
import com.beayeah.yeah.martianrobots.extensions.click
import com.beayeah.yeah.martianrobots.extensions.typeText


class MainActivityScreen {
    val commandText = R.id.commandsText
    val commandButton = R.id.commandButton
    val resultText = R.id.resultText

    fun checkResultTextHasValue(text: String) {
        resultText.checkHasText(text)
    }

    fun clearCommands() {
        commandText.clearText()
    }

    fun enterCommand(command: String) {
        commandText.typeText(command)
    }

    fun clickCommandButton() {
        commandButton.click()
    }

    fun closeKeyboard() {
        Espresso.onView(ViewMatchers.withId(R.id.commandsText))
            .perform(ViewActions.closeSoftKeyboard())
    }
}