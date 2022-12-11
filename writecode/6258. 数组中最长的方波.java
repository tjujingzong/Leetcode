import java.util.Arrays;

class Solution {
  public int longestSquareStreak(int[] nums) {
    // 对nums进行排序
    Arrays.sort(nums);
    int n = nums.length;
    int[] dp = new int[n];
    Arrays.fill(dp, 1);
    boolean[] flag = new boolean[n];
    int max = 0;
    for (int i = 0; i < n; i++) {
      if (flag[i]) {
        continue;
      }
      // nums[i]的max次方
      if (Math.pow(nums[i], max) > nums[n - 1]) {
        break;
      }

      int temp = nums[i];
      int t = i;
      for (int j = i + 1; j < n; j++) {
        if (temp * temp < nums[j] || temp * temp > nums[n - 1]) {
          break;
        }
        if (temp * temp == nums[j]) {
          dp[j] = Math.max(dp[j], dp[t] + 1);
          flag[j] = true;
          temp = nums[j];
          t = j;
        }
      }
    }
    for (int i = 0; i < n; i++) {
      max = Math.max(max, dp[i]);
    }
    return max > 1 ? max : -1;
  }
}