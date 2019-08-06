package com.c2v4.sudokusolver

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class GridTest {

    @Test
    fun emptyGridTest() {
        Assertions.assertThatThrownBy { Grid(arrayOf()) }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun notASquareTest() {
        Assertions.assertThatThrownBy { Grid(arrayOf(intArrayOf(1, 2))) }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun solveTest() {
        val grid = Grid(arrayOf(
                intArrayOf(0, 6, 0, 0, 0, 0, 4, 2, 0),
                intArrayOf(3, 0, 0, 0, 0, 8, 9, 0, 0),
                intArrayOf(0, 0, 7, 2, 4, 5, 6, 0, 0),
                intArrayOf(9, 0, 6, 3, 0, 4, 0, 0, 0),
                intArrayOf(0, 7, 3, 0, 1, 0, 2, 0, 0),
                intArrayOf(8, 5, 0, 0, 6, 2, 3, 4, 9),
                intArrayOf(0, 0, 4, 1, 2, 0, 0, 9, 8),
                intArrayOf(0, 0, 9, 0, 0, 3, 0, 6, 0),
                intArrayOf(6, 0, 0, 4, 0, 0, 1, 3, 0)
        ))
        assertThat(grid.solved()).isTrue()
        println(grid.pretty())
    }

    @Test
    fun solve2Test() {
        val grid = Grid(arrayOf(
                intArrayOf(2, 0, 0, 6, 0, 7, 5, 0, 0),
                intArrayOf(0, 0, 0, 0, 0, 0, 0, 9, 6),
                intArrayOf(6, 0, 7, 0, 0, 1, 3, 0, 0),
                intArrayOf(0, 5, 0, 7, 3, 2, 0, 0, 0),
                intArrayOf(0, 7, 0, 0, 0, 0, 0, 2, 0),
                intArrayOf(0, 0, 0, 1, 8, 9, 0, 7, 0),
                intArrayOf(0, 0, 3, 5, 0, 0, 6, 0, 4),
                intArrayOf(8, 4, 0, 0, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 5, 2, 0, 6, 0, 0, 8)
        ))
        assertThat(grid.solved()).isTrue()
    }


}