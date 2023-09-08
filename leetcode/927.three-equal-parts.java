import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=927 lang=java
 *
 * [927] Three Equal Parts
 */

// @lc code=start
class Solution {
  int[] ans = { -1, -1 };
  ArrayList<Integer> indexOfOne = new ArrayList<>();

  public int[] threeEqualParts(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 1)
        indexOfOne.add(i);
    }
    if (indexOfOne.size() % 3 != 0)
      return ans;
    if (indexOfOne.size() == 0) {
      ans[0] = 0;
      ans[1] = 2;
      return ans;
    }
    int gap = indexOfOne.size() / 3;
    int laststart = indexOfOne.get(2 * gap);
    int len = arr.length - laststart;
    int firststart = indexOfOne.get(0);
    for (int i = 0; i < len; i++) {
      if (arr[firststart + i] != arr[laststart + i])
        return ans;
    }
    int midstart = indexOfOne.get(gap);
    for (int i = 0; i < len; i++) {
      if (arr[midstart + i] != arr[laststart + i])
        return ans;
    }
    ans[0] = firststart + len - 1;
    ans[1] = midstart + len - 1;
    return ans;
  }

}
// @lc code=end
