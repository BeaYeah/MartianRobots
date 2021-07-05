package com.beayeah.yeah.martianrobots.helper

import com.beayeah.yeah.martianrobots.helpers.CoordinateValidator
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Test

class CoordinateValidatorTest {
    @Test
    fun testValid() {
        assertTrue(CoordinateValidator.isCoordinateCorrect(50))
        assertTrue(CoordinateValidator.isCoordinateCorrect(0))
    }

    @Test
    fun testInvalid() {
        assertFalse(CoordinateValidator.isCoordinateCorrect(51))
        assertFalse(CoordinateValidator.isCoordinateCorrect(1300))
        assertFalse(CoordinateValidator.isCoordinateCorrect(-5))
    }
}