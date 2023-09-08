import java.util.Arrays;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;

class Solution {
  public int smallestDistancePair(int[] nums, int k) {
    int n = nums.length;
    Arrays.sort(nums);
    int left = 0, right = nums[n - 1] - nums[0];
    while (left <= right) {
      int mid = (left + right) / 2;
      int cnt = 0;
      for (int i = 0, j = 0; j < n; j++) {
        while (nums[j] - nums[i] > mid)
          i++;
        cnt += j - i;
      }
      if (cnt >= k) {
        right = mid - 1;
      } else
        left = mid + 1;
    }
    return left;
  }
}