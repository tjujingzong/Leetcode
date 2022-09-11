import java.util.Arrays;

class Solution {
  public int longestNiceSubarray(int[] nums) {
    int ans = 0;
    for (int left = 0, right = 0, or = 0; right < nums.length; right++) {
      while ((or & nums[right]) > 0)
        or ^= nums[left++];
      or |= nums[right];
      ans = Math.max(ans, right - left + 1);
    }
    return ans;

  }
}