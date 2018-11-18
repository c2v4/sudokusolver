package com.c2v4.sudokusolver

class Grid private constructor(private val values: Array<Array<Int>>) {
    private val possibleValues:Array<Array<Array<Int>>>
    init {

        possibleValues= arrayOf()
    }

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
                        if (intValue !in 1..numberOfRows) throw IllegalArgumentException("Input has numbers out of range")
                        else intValue
                    }
                }.toTypedArray()
            }.toTypedArray())
        }
    }

    operator fun get(row: Int): Array<Int> = values[row]
}

