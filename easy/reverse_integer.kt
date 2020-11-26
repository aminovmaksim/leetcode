
/* https://leetcode.com/problems/reverse-integer/ */

import kotlin.math.abs

fun main() {
    test(100, 1)
    test(123, 321)
    test(-123, -321)
    test(32456, 65423)
    test(120, 21)
    test(0, 0)
    test(2147483417, 0)
    test(-2147483648, 0)
    test(-2147483412, -2143847412)
}

fun reverse(x: Int): Int {
    var flag = false;
    var num = x
    try {
        if (x < 0) {
            num = abs(x);
            flag = true;
        }
        var str = num.toString().reversed()
        if (flag) {
            str = "-" + str
        }
        return str.toInt()
    } catch (e: Exception) {
        return 0
    }
}

fun reverse2(x: Int): Int {
    try {
        val res = if (x < 0) StringBuilder((-x).toString()).append("-").reverse().toString()
            else StringBuilder(x.toString()).reverse().toString()
        return res.toInt()
    } catch(e: Exception) {
        return 0;
    }
}

fun reverse3(x: Int): Int {
    val nFlag = x < 0;
    var num = x.takeIf { !nFlag } ?: -x
    var prevRevNum = 0
    var revNum = 0
    while (num != 0) {
        val pop = num % 10
        revNum = revNum * 10 + pop
        if ((revNum - pop)/10 != prevRevNum) {
            return 0
        }
        prevRevNum = revNum
        num /= 10
    }
    return revNum.takeIf { !nFlag } ?: -revNum
}

fun test(x: Int, answer: Int? = null) {
    val result = reverse3(x)
    print("$x : $result")
    if (answer != null)
        println(" - " + (answer == result))
    else
        println()
}