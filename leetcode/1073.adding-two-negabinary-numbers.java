/*
 * @lc app=leetcode.cn id=1073 lang=java
 *
 * [1073] Adding Two Negabinary Numbers
 */

// @lc code=start

import java.lang.reflect.Array;

class Solution {
  public int[] addNegabinary(int[] arr1, int[] arr2) {
    int n = arr1.length;
    int m = arr2.length;
    ArrayList<Integer> ans = new ArrayList<>();
    int i = n - 1, j = m - 1;
    int carry = 0;
    while (i >= 0 || j >= 0 || carry != 0) {
      int sum = carry;
      if (i >= 0)
        sum += arr1[i--];
      if (j >= 0)
        sum += arr2[j--];
      ans.add(sum & 1);
      carry = -(sum >> 1);
    }
    while (ans.size() > 1 && ans.get(ans.size() - 1) == 0)// remove leading zeros
      ans.remove(ans.size() - 1);
    Collections.reverse(ans);
    int[] res = new int[ans.size()];
    for (int k = 0; k < ans.size(); k++)
      res[k] = ans.get(k);
    return res;
  }
}
// @lc code=end
