package com.c2v4.sudokusolver

class Grid private constructor(private val values: Array<IntArray>) {
    companion object {
        fun fromString(input: String): Grid {
            val rows = input.split('\n')
            val numberOfRows = rows.size
            if (!numberOfRows.isSquareNumber()) throw IllegalArgumentException("Number of rows is not a square number")
            return Grid(rows.map {
                val column = it.split(' ')
                if (column.size != numberOfRows) throw IllegalArgumentException("Input is not a full square")
                column.map {
                    if (it == ".") -1 else {
                        val intValue = it.toInt()
                        if (intValue < 1 || intValue > numberOfRows) throw IllegalArgumentException("Input has numbers out of range")
                        else intValue
                    }
                }.toIntArray()
            }.toTypedArray())
        }
    }

    operator fun get(row: Int): IntArray = values[row]
}

