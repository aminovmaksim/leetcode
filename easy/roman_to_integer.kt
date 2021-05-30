
/* https://leetcode.com/problems/roman-to-integer/ */

fun romanToInt(s: String): Int {
    var sum = 0
    var prevNum = 0
    val map = hashMapOf('I' to 1, 'V' to 5, 'X' to 10, 'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000)
    for (c in s.toCharArray()) {
        val value = map[c] ?: 0
        sum += if (prevNum < value)
            value - prevNum * 2
        else
            value
        prevNum = value
    }
    return sum
}

fun main() {
    test("I", 1)
    test("II", 2)
    test("IV", 4)
    test("IX", 9)
    test("LVIII", 58)
    test("MMXX", 2020)
    test("MCMXCIV", 1994)
    test("MCMXCIX", 1999)
    test("MMMMCCXXXIV", 4234)
}

fun test(s: String, answer: Int? = null) {
    val result = romanToInt(s)
    print("$s : $result")
    if (answer != null)
        println(" - " + (answer == result))
    else
        println()
}