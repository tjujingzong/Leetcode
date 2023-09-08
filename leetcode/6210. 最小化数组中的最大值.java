class Solution {
  public int minimizeArrayValue(int[] nums) {
    int n = nums.length;
    int ans = nums[0];
    Long sum = (long) nums[0];
    for (int i = 1; i < n; i++) {
      sum += nums[i];
      ans = (int) Math.max(ans, sum % (i + 1) == 0 ? sum / (i + 1) : sum / (i + 1) + 1);
    }
    return ans;
  }
}