package com.c2v4.sudokusolver

fun Int.isSquareNumber(): Boolean {
    val x = Math.sqrt(this.toDouble())
    return Math.pow(x,2.0).toInt() == this
}