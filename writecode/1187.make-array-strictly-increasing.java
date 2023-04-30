import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1187 lang=java
 *
 * [1187] Make Array Strictly Increasing
 */

// @lc code=start
class Solution {
  static final int INF = 0x3f3f3f3f;

  public int makeArrayIncreasing(int[] arr1, int[] arr2) {
    Arrays.sort(arr2);
    List<Integer> list = new ArrayList<Integer>();
    int prev = -1;
    for (int num : arr2) {
      if (num != prev) {// 去重
        list.add(num);
        prev = num;
      }
    }
    int n = arr1.length;
    int m = list.size();
    int[][] dp = new int[n + 1][Math.min(m, n) + 1];
    for (int i = 0; i <= n; i++) {
      Arrays.fill(dp[i], INF);
    }
    dp[0][0] = -1;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= Math.min(i, m); j++) {
        /* 如果当前元素大于序列的最后一个元素 */
        if (arr1[i - 1] > dp[i - 1][j]) {
          dp[i][j] = arr1[i - 1];
        }
        if (j > 0 && dp[i - 1][j - 1] != INF) {
          /* 查找严格大于 dp[i - 1][j - 1] 的最小元素 */
          int idx = binarySearch(list, j - 1, dp[i - 1][j - 1]);
          if (idx != list.size()) {
            dp[i][j] = Math.min(dp[i][j], list.get(idx));
          }
        }
        if (i == n && dp[i][j] != INF) {
          return j;
        }
      }
    }
    return -1;
  }

  public int binarySearch(List<Integer> list, int low, int target) {
    int high = list.size();
    while (low < high) {
      int mid = low + (high - low) / 2;
      if (list.get(mid) > target) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }
}

// @lc code=end
