class Solution {
  public long findTheArrayConcVal(int[] nums) {
    long ans = 0;
    for (int i = 0; i < (nums.length + 1) / 2; i++) {
      String s1 = String.valueOf(nums[i]);
      if (i == nums.length - i - 1) {
        ans += Long.parseLong(s1);
        break;
      }
      String s2 = String.valueOf(nums[nums.length - i - 1]);
      ans += Long.parseLong(s1 + s2);
    }
    return ans;
  }
}