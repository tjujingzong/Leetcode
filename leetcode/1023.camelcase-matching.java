import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=1023 lang=java
 *
 * [1023] Camelcase Matching
 */

// @lc code=start
class Solution {
  ArrayList<String> list;

  public List<Boolean> camelMatch(String[] queries, String pattern) {
    List<Boolean> res = new ArrayList<>();
    this.list = split(pattern);
    System.out.println(list.toString());
    for (String query : queries) {
      res.add(match(query, pattern));
    }
    return res;
  }

  private ArrayList<String> split(String pattern) {
    ArrayList<String> list = new ArrayList<>();
    int i = 0;
    while (i < pattern.length() && Character.isLowerCase(pattern.charAt(i))) {
      i++;
    }
    while (i < pattern.length()) {
      int j = i + 1;
      while (j < pattern.length() && Character.isLowerCase(pattern.charAt(j))) {
        j++;
      }
      list.add(pattern.substring(i, j));
      i = j;
    }
    return list;
  }

  private boolean match(String query, String pattern) {
    ArrayList<String> list2 = split(query);
    System.out.println(list2.toString());
    if (list.size() != list2.size())
      return false;
    for (int i = 0; i < list.size(); i++) {
      String s1 = list.get(i);
      String s2 = list2.get(i);
      int j = 0, k = 0;
      while (j < s1.length() && k < s2.length()) {
        if (s1.charAt(j) == s2.charAt(k))
          j++;
        k++;
      }
      if (j != s1.length())
        return false;
    }
    return true;
  }
}
// @lc code=end
