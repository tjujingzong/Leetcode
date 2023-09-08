import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=658 lang=java
 *
 * [658] Find K Closest Elements
 */

// @lc code=start
class Solution {
  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    List<Integer> ans = new ArrayList<Integer>();
    int n = arr.length;
    if (x <= arr[0]) {
      for (int i = 0; i < k; i++)
        ans.add(arr[i]);
      return ans;
    }
    if (x >= arr[n - 1]) {
      for (int i = 0; i < k; i++)
        ans.add(arr[n - k + i]);
      return ans;
    }
    int p = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] >= x) {
        p = i;
        break;
      }
    }
    int l = p - 1;
    int r = p;
    while (ans.size() < k) {
      if (l >= 0 && r < n) {
        if (x - arr[l] <= arr[r] - x) {
          ans.add(arr[l]);
          l--;
        } else {
          ans.add(arr[r]);
          r++;
        }
      } else if (r < n) {
        ans.add(arr[r]);
        r++;
      } else {
        ans.add(arr[l]);
        l--;
      }
    }
    Collections.sort(ans);
    return ans;
  }
}