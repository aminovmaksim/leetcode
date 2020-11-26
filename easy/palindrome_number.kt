
/* https://leetcode.com/problems/palindrome-number/ */

fun main() {
    test(101, true)
    test(123, false)
    test(-123, false)
    test(-121, false)
    test(111, true)
    test(0, true)
    test(10, false)
}

fun isPalindrome(x: Int): Boolean {
    if (x < 0 || (x % 10 == 0 && x != 0)) return false
    var revnum = 0
    var num = x
    while (num > revnum) {
        revnum = revnum * 10 + num % 10
        num /= 10
    }
    return num == revnum || num == revnum / 10
}

fun isPalindrome2(x: Int): Boolean {
    if (x < 0) return false
    val str = x.toString()
    return str == str.reversed()
}

fun test(x: Int, answer: Boolean? = null) {
    val result = isPalindrome(x)
    print("$x : $result")
    if (answer != null)
        println(" - " + (answer == result))
    else
        println()
}