import java.util.Arrays;

class Solution {
  public int minimizeMax(int[] nums, int p) {
    Arrays.sort(nums);
    int left = 0;
    int right = nums[nums.length - 1] - nums[0];
    int ans = -1;

    while (left <= right) {
      int mid = (left + right) / 2;
      if (canFindPairs(nums, mid, p)) {
        ans = mid;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return ans;
  }

  private boolean canFindPairs(int[] nums, int mid, int p) {
    int i = 1;
    int cnt = 0;
    while (i < nums.length) {
      if (nums[i] - nums[i - 1] <= mid) {
        cnt++;
        if (cnt == p) {
          break;
        }
        i++;
      }
      i++;
    }

    return cnt >= p;
  }
}
