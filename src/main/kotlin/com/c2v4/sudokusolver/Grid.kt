package com.c2v4.sudokusolver

import com.google.common.base.Preconditions

class Grid(values: Array<IntArray>) {

    private val possibilities: Array<Array<IntArray>> = startingPossibilities()


    init {
        val size = values.size
        Preconditions.checkArgument(size == 9, "Size should be 9")
        Preconditions.checkArgument(values.all { it.size == size }, "Array should be a square")
        values.forEachIndexed { x, ints -> ints.forEachIndexed { y, i -> if (i != 0) insertNumber(x, y, i) } }
    }

    private fun insertNumber(x: Int, y: Int, i: Int) {
        possibilities[x][y] = intArrayOf(i)
        removeFromRow(x, y, i)
        removeFromColumn(x, y, i)
        removeFromSquare(x, y, i)
    }

    private fun removeFromSquare(x: Int, y: Int, i: Int) {
        for (j in 0..2) {
            for (k in 0..2) {
                val posx = (x/3)*3 +j
                val posy = (y/3)*3 +k
                if (posx != x && posy != y) {
                    val oldArray = possibilities[posx][posy]
                    val newArray = oldArray.filter { it!=i }.toIntArray()
                    if (newArray.isEmpty()) throw IllegalStateException()
                    possibilities[posx][posy] = newArray
                    if(oldArray.size==2 && newArray.size ==1){
                        insertNumber(posx,posy,newArray[0])
                    }
                }
            }
        }
    }

    private fun removeFromColumn(x: Int, y: Int, i: Int) {
        for (index in possibilities.indices) {
            if (index != x) {
                val newArray = possibilities[index][y].filter { it != i }.toIntArray()
                if (newArray.isEmpty()) throw IllegalStateException()
                val size = possibilities[index][y].size
                possibilities[index][y] = newArray
                if (size == 2 && newArray.size == 1) {
                    insertNumber(index, y, newArray[0])
                }
            }
        }
    }

    private fun removeFromRow(x: Int, y: Int, i: Int) {
        for (index in possibilities[x].indices) {
            if (index != y) {
                val newArray = possibilities[x][index].filter { it != i }.toIntArray()
                if (newArray.isEmpty()) throw IllegalStateException()
                val size = possibilities[x][index].size
                possibilities[x][index] = newArray
                if (size == 2 && newArray.size == 1) {
                    insertNumber(x, index, newArray[0])
                }
            }
        }
    }

    fun solved() = possibilities.all { it.all { it.size ==1 } }

    override fun toString(): String {
        return "Grid(possibilities=${possibilities.contentDeepToString()})"
    }

    fun pretty(): String {
        return possibilities.joinToString("|\n|","-------------------\n|","|\n-------------------\n"){
            it.joinToString(" "){it[0].toString()}
        }
    }

}

val startingPossibilities: () -> Array<Array<IntArray>> = { Array(9) { Array(9) { IntArray(9) { it + 1 } } } }