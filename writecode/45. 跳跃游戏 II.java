import java.util.Arrays;

class Solution {
  public int jump(int[] nums) {
    int n = nums.length;
    int[] jumptimes = new int[n];
    Arrays.fill(jumptimes, n);
    jumptimes[0] = 0;
    boolean[] flag = new boolean[n];
    flag[0] = true;
    for (int i = 0; i < n; i++) {
      if (flag[i]) {
        for (int j = 1; j <= nums[i]; j++) {
          if (i + j >= n)
            break;
          flag[i + j] = true;
          if (jumptimes[i + j] < jumptimes[i] + 1)
            jumptimes[i + j] = jumptimes[i] + 1;
        }
      }
    }
    return jumptimes[n - 1];
  }
}