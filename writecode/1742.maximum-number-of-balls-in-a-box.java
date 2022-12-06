/*
 * @lc app=leetcode.cn id=1742 lang=java
 *
 * [1742] Maximum Number of Balls in a Box
 */

// @lc code=start
class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int[] count = new int[46];
        for (int i = lowLimit; i <= highLimit; i++) {
            int sum = 0;
            int num = i;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            count[sum]++;
        }
        int max = 0;
        for (int i = 0; i < 46; i++) {
            max = Math.max(max, count[i]);
        }
        return max;
    }
}
// @lc code=end

