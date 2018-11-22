package com.c2v4.sudokusolver

import java.util.*

class Grid private constructor(private val values: Array<Array<Array<Int>>>) {

    companion object {
        fun fromString(input: String): Grid {
            val rows = input.trim().split('\n')
            val numberOfRows = rows.size
            if (!numberOfRows.isSquareNumber()) throw IllegalArgumentException("Number of rows is not a square number")
            return Grid(rows.map {
                val column = it.split(' ')
                if (column.size != numberOfRows) throw IllegalArgumentException("Input is not a full square")
                column.map {
                    if (it == ".") Array(numberOfRows) { n -> n + 1 } else {
                        val intValue = it.toInt()
                        if (intValue !in 1..numberOfRows) throw IllegalArgumentException("Input has numbers out of range")
                        else arrayOf(intValue)
                    }
                }.toTypedArray()
            }.toTypedArray())
        }
    }

    fun get(row: Int, column: Int): Int {
        val possibleValues = values[row][column]
        return if (possibleValues.size == 1) possibleValues[0] else -1
    }

    fun simplify(): Grid {
        TODO()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Grid

        if (!Arrays.deepEquals(values, other.values)) return false

        return true
    }

    override fun hashCode(): Int {
        return Arrays.deepHashCode(values)
    }

    override fun toString(): String {
        return values.flatMap {
            it.map { it.firstOrNull() ?: "." }
                .chunked(Math.sqrt(values.size.toDouble()).toInt())
                .map { it.joinToString(" ") }
        }
            .chunked(Math.sqrt(values.size.toDouble()).toInt())
            .map { it.joinToString("|") }
            .chunked(Math.sqrt(values.size.toDouble()).toInt())
            .map { it.joinToString("|\n|","|","|") }
            .joinToString("\n|-------|\n") // TODO: Formula
            .toString()
    }
}

