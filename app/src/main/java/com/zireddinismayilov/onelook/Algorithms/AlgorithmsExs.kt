package com.zireddinismayilov.onelook.Algorithms

import kotlin.ArithmeticException

//2)How do you handle exceptions in kotlin ? Provide an example of a try-catch block for handling a potential exception in your code.
fun divide(num1: Int, num2: Int): Float {
    try {
        return num1 / num2.toFloat()
    } catch (e: ArithmeticException) {
        throw ArithmeticException()
    }
}

// 4)Prepare algorithm to find and eliminate duplicate elements in array
fun removeDuplicates(array: IntArray): IntArray {
    var arr = array
    for (i in 0 until arr.size - 1) {
        val d = arr[i]
        for (j in i + 1 until arr.size) {
            if (arr[j] == d) {
                arr[j] = 0
            }
        }
    }
    return arr
}

fun printArr(array: IntArray) {
    for (i in array) {
        print(i)
    }
    print(" ")
}

//13) Find maximum product of two integers in an array
fun maxProduct(array: IntArray): Int {
    var max: Int = 0
    for (i in 0 until array.size - 1) {
        for (j in i + 1 until array.size) {
            if (max < array[i] * array[j]) {
                max = array[i] * array[j]
            }
        }
    }
    return max
}

fun main() {
    val arr = intArrayOf(1, 2, 7, 4, 2, 6, 4, 5, 4, 2, 1)
    removeDuplicates(arr)
    printArr(removeDuplicates(arr))

    println(maxProduct(arr))
}


