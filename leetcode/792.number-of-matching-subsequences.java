import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=792 lang=java
 *
 * [792] Number of Matching Subsequences
 */

// @lc code=start
class Solution {
  public int numMatchingSubseq(String s, String[] words) {
    // 1. build a map of char to list of index
    Map<Character, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      map.putIfAbsent(s.charAt(i), new ArrayList<>());
      map.get(s.charAt(i)).add(i);
    }
    int count = 0;
    for (String word : words) {
      if (!map.containsKey(word.charAt(0))) {
        continue;
      }
      List<Integer> list = map.get(word.charAt(0));
      int index = list.get(0);
      boolean found = true;
      for (int i = 1; i < word.length(); i++) {
        char c = word.charAt(i);
        if (!map.containsKey(c)) {
          found = false;
          break;
        }
        List<Integer> nextList = map.get(c);
        int nextIndex = binarySearch(nextList, index);
        if (nextIndex == -1) {
          found = false;
          break;
        }
        index = nextList.get(nextIndex);
      }
      if (found) {
        count++;
      }
    }
    return count;
  }

  private int binarySearch(List<Integer> nextList, int index) {
    int left = 0;
    int right = nextList.size() - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nextList.get(mid) > index) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return left == nextList.size() ? -1 : left;
  }
}
// @lc code=end
