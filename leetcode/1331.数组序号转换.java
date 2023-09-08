import java.util.Arrays;
import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=1331 lang=java
 *
 * [1331] 数组序号转换
 */

// @lc code=start
class Solution {
  public int[] arrayRankTransform(int[] arr) {
    int n = arr.length;
    int[] temp = new int [n];
    temp=arr.clone();
    Arrays.sort(temp);
    int[] ans = new int[n];
    int p = 1;
    TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
    for (int i = 0; i < n; i++) {
      if (map.containsKey(temp[i]))
        continue;
      else {
        map.put(temp[i], p++);
      }
    }
    for (int i = 0; i < n; i++) {
      ans[i] = map.get(arr[i]);
    }
    return ans;
  }
}
// @lc code=end
