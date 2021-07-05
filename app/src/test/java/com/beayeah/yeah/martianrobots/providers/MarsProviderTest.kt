package com.beayeah.yeah.martianrobots.providers

import com.beayeah.yeah.martianrobots.model.Mars
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MarsProviderTest {
    lateinit var mars: Mars

    @Before
    fun setup() {
        mars = MarsProvider.setupMars("5 3")
    }

    @Test
    fun getWorldTopBoundsSetCorrectly() {
        assertEquals(5, mars?.topBound?.x)
        assertEquals(3, mars?.topBound?.y)
    }

    @Test
    fun bottomBoundsZero() {
        assertEquals(0, mars?.bottomBound?.x)
        assertEquals(0, mars?.bottomBound?.y)
    }

    @Test
    fun robotsListInitiallyZero() {
        assertEquals(0, mars?.spaceShips?.count())
    }
}