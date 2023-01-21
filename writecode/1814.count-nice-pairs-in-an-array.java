/*
 * @lc app=leetcode.cn id=1814 lang=java
 *
 * [1814] Count Nice Pairs in an Array
 */

// @lc code=start
class Solution {
  public int countNicePairs(int[] nums) {
    int mod = 1000000007;
    int ans = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      int rev = reverse(num);
      int diff = num - rev;
      int count = map.getOrDefault(diff, 0);
      ans = (ans + count) % mod;
      map.put(diff, count + 1);
    }
    return ans;
  }

  public int reverse(int n) {
    int rev = 0;
    while (n > 0) {
      rev = rev * 10 + n % 10;
      n /= 10;
    }
    return rev;
  }
}
// @lc code=end
