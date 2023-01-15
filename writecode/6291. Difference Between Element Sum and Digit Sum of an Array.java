class Solution {
  public int differenceOfSum(int[] nums) {
    int sum1 = 0;
    int sum2 = 0;
    for (int i = 0; i < nums.length; i++) {
      sum1 += nums[i];
    }
    // sum2为每个数每一位的数字和
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      while (num != 0) {
        sum2 += num % 10;
        num /= 10;
      }
    }
    return Math.abs(sum1 - sum2);
  }
}
