import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=1684 lang=java
 *
 * [1684] Count the Number of Consistent Strings
 */

// @lc code=start
class Solution {
  public int countConsistentStrings(String allowed, String[] words) {
    HashSet<Character> set = new HashSet<Character>();
    for (Character c : allowed.toCharArray())
      set.add(c);
    int ans = 0;
    for (String word : words) {
      boolean flag = true;
      for (Character c : word.toCharArray())
        if (!set.contains(c)) {
          flag = false;
          break;
        }
      if (flag)
        ans++;
    }
    return ans;
  }
}
// @lc code=end
