package com.c2v4.sudokusolver

import com.c2v4.sudokusolver.Grid.Companion.fromString
import cucumber.api.java8.En
import org.assertj.core.api.Assertions.assertThat

class GridCreation(private val world: World) : En {

    private var exception: Exception? = null

    private fun createGrid(input: String) {
        world.grid = fromString(input)
    }

    init {

        When("I create a Grid with structure") { input: String -> createGrid(input) }

        When("I safely create a Grid with structure") { input: String ->
            try {
                createGrid(input)
            } catch (e: Exception) {
                exception = e
            }
        }

        Then("The Grid should be created") {
            assertThat(world.grid).isNotNull()
        }

        Then("The Grid should should have {int} in row {int}, column {int}") { value: Int, row: Int, column: Int ->
            assertThat(world.grid[row][column]).isEqualTo(value)
        }

        Then("It should fail due to {string}") { string: String ->
            assertThat(exception).`as`("Exception was not thrown").isNotNull()
            assertThat(exception).hasMessage(string)
        }

        Then("The Grid should should be empty in row {int}, column {int}") { row: Int, column: Int ->
            assertThat(world.grid[row][column]).isEqualTo(-1)
        }
    }
}
