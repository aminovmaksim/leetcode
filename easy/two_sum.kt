
/* https://leetcode.com/problems/two-sum/ */

import java.util.Arrays

fun main() {
    test(intArrayOf(2, 7, 11, 15), 9, intArrayOf(1, 0))
    test(intArrayOf(3, 2, 4), 6, intArrayOf(2, 1))
    test(intArrayOf(3, 3), 6, intArrayOf(1, 0))
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    for (i in 0 until nums.size) {
        for (j in (i+1) until nums.size) {
            if (nums.get(i) + nums.get(j) == target) {
                return intArrayOf(i, j)
            }
        }
    }
    return intArrayOf(0,0)
}

fun twoSum2(nums: IntArray, target: Int): IntArray {
    val map = HashMap<Int, Int>()
    for (i in 0 until nums.size) {
        map.put(nums.get(i), i)
    }
    for (i in 0 until nums.size) {
        val diff = target - nums.get(i)
        val number = map.get(diff)
        if (number != null && number != i) {
            return intArrayOf(i, number)
        }
    }
    return intArrayOf(0,0)
}

fun twoSum3(nums: IntArray, target: Int): IntArray {
    val map = HashMap<Int, Int>()
    for (i in 0 until nums.size) {
        val diff = target - nums.get(i)
        val number = map.get(diff)
        if (number != null && number != i) {
            return intArrayOf(i, number)
        }
        map.put(nums.get(i), i)
    }
    return intArrayOf(0,0)
}

fun test(nums: IntArray, target: Int, answer: IntArray? = null) {
    val result = twoSum3(nums, target)
    print(Arrays.toString(nums))
    print(" : " + target + " - " + Arrays.toString(result))
    if (answer != null)
        println(" - " + result.contentEquals(answer))
    else
        println()
}