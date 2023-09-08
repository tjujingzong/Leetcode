/*
 * @lc app=leetcode.cn id=854 lang=java
 *
 * [854] K-Similar Strings
 */

// @lc code=start
class Solution {
  int n;
  String t;// 目标函数

  int f(String s) {// 用来衡量和目标函数的相似度
    int ans = 0;
    for (int i = 0; i < n; i++)
      ans += s.charAt(i) != t.charAt(i) ? 1 : 0;
    return ans + 1 >> 1;
  }

  public int kSimilarity(String s1, String s2) {
    if (s1.equals(s2))
      return 0;
    t = s2;
    n = s1.length();
    Map<String, Integer> map = new HashMap<>();// 用来记录当前字符串交换的次数
    PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {//感觉是正常的宽搜基础上加上了优先级
      int v1 = f(a), v2 = f(b), d1 = map.get(a), d2 = map.get(b);
      return (v1 + d1) - (v2 + d2);
    });
    map.put(s1, 0);
    pq.add(s1);
    while (!pq.isEmpty()) {
      String poll = pq.poll();
      int step = map.get(poll);
      char[] cs = poll.toCharArray();
      int idx = 0;
      while (idx < n && cs[idx] == t.charAt(idx))
        idx++;
      for (int i = idx + 1; i < n; i++) {
        if (cs[i] == t.charAt(idx) && cs[i] != t.charAt(i)) {
          swap(cs, idx, i);
          String nstr = String.valueOf(cs);
          if (map.containsKey(nstr) && map.get(nstr) <= step + 1)
            continue;
          if (nstr.equals(t))
            return step + 1;
          map.put(nstr, step + 1);
          pq.add(nstr);
          swap(cs, idx, i);
        }
      }
    }
    return -1; // never
  }

  void swap(char[] cs, int i, int j) {
    char c = cs[i];
    cs[i] = cs[j];
    cs[j] = c;
  }
}
// @lc code=end
