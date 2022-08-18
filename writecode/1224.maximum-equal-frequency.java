
/*
 * @lc app=leetcode.cn id=1224 lang=java
 *
 * [1224] Maximum Equal Frequency
 */

// @lc code=start
class Solution {
    public int maxEqualFreq(int[] nums) {
      Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
      Map<Integer, Integer> count = new HashMap<Integer, Integer>();
      int res = 0, maxFreq = 0;
      for (int i = 0; i < nums.length; i++) {
          if (count.getOrDefault(nums[i], 0) > 0) {
              freq.put(count.get(nums[i]), freq.get(count.get(nums[i])) - 1);
          }
          count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
          maxFreq = Math.max(maxFreq, count.get(nums[i]));
          freq.put(count.get(nums[i]), freq.getOrDefault(count.get(nums[i]), 0) + 1);
          boolean ok = maxFreq == 1 ||
                  freq.get(maxFreq) * maxFreq + freq.get(maxFreq - 1) * (maxFreq - 1) == i + 1 && freq.get(maxFreq) == 1 ||
                  freq.get(maxFreq) * maxFreq + 1 == i + 1 && freq.get(1) == 1;
          if (ok) {
              res = Math.max(res, i + 1);
          }
      }
      return res;
    }
}
// @lc code=end

