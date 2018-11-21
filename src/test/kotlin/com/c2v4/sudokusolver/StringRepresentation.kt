package com.c2v4.sudokusolver

import cucumber.api.java8.En
import org.assertj.core.api.Assertions.assertThat

class StringRepresentation(private val world: World) : En {

    init {
        Then("The String representation should look like") { string: String ->
            assertThat(world.grid.toString()).isEqualTo(string.trim())
        }
    }
}