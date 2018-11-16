package com.c2v4.sudokusolver

class Grid private constructor(private val values: Array<IntArray>) {
    companion object {
        fun createGridFromString(input: String): Grid =
            Grid(input.split('\n').map { it.split(' ').map { it.toInt() }.toIntArray() }.toTypedArray())
    }

    operator fun get(row: Int): IntArray = values[row]
}

