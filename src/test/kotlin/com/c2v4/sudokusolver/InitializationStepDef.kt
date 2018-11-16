package com.c2v4.sudokusolver

import cucumber.api.java8.En

class InitializationStepDef(private val world: World): En {

    init {

        Given("I set up game for {int} players") { int1: Int ->
            // Write code here that turns the phrase above into concrete actions
//            throw cucumber.api.PendingException()
        }

        Then("The state exists") {
            println("It Works")
//            assertThat(world.state).isNotNull()
        }
    }
}
