package com.c2v4.sudokusolver

import cucumber.api.java8.En
import org.assertj.core.api.Assertions.assertThat

class GridCreation(private val world: World) : En {

    init {

        When("I create a Grid with structure") { input: String ->

            world.grid = createGridFromString(input)
        }

        Then("The Grid should be created") {
            assertThat(world.grid).isNotNull()
        }
    }
}
