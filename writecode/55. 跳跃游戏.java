class Solution {
  public boolean canJump(int[] nums) {
    int n = nums.length;
    boolean[] flag = new boolean[n];
    flag[0] = true;
    for (int i = 0; i < n; i++) {
      if (flag[i]) {
        for (int j = 1; j <= nums[i]; j++) {
          if (i + j >= n)
            break;
          flag[i + j] = true;
        }
      }
    }
    return flag[n - 1];
  }
}