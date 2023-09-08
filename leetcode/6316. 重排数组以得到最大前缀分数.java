import java.util.Arrays;

class Solution {
  public int maxScore(int[] nums) {
    int ans = 0;
    long sum = 0;
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      sum += nums[nums.length - 1 - i];
      if (sum > 0)
        ans++;
      else
        break;
    }
    return ans;
  }
}