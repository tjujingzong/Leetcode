import java.util.TreeMap;

class Solution {
  public int deleteAndEarn(int[] nums) {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        map.put(nums[i], map.get(nums[i]) + nums[i]);
      } else {
        map.put(nums[i], nums[i]);
      }
    }
    int n = map.size();
    int[] dp = new int[n];
    int i = 0;
    int lastnum = 0;
    for (Integer e : map.keySet()) {
      int val = map.get(e);
      if (i == 0) {
        dp[i] = val;
      } else if (i == 1) {
        if (e - lastnum > 1)
          dp[i] = dp[0] + val;
        else
          dp[i] = Math.max(val, dp[0]);
      } else if (e - lastnum > 1)
        dp[i] = Math.max(dp[i - 2] + val, dp[i - 1] + val);
      else
        dp[i] = Math.max(dp[i - 2] + val, dp[i - 1]);
      i++;
      lastnum = e;
    }
    return dp[n - 1];
  }
}