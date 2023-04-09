import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=1125 lang=java
 *
 * [1125] Smallest Sufficient Team
 */

// @lc code=start
class Solution {
  public int[] smallestSufficientTeam(String[] reqSkills, List<List<String>> people) {
    var sid = new HashMap<String, Integer>();
    int m = reqSkills.length;
    for (int i = 0; i < m; ++i)
      sid.put(reqSkills[i], i); // 字符串映射到下标

    int n = people.size();
    var mask = new int[n];
    for (int i = 0; i < n; ++i)
      for (var s : people.get(i)) // 把 people[i] 压缩成一个二进制数 mask[i]
        mask[i] |= 1 << sid.get(s);

    long all = (1L << n) - 1;
    int u = 1 << m;
    var f = new long[u]; // f[j] 表示并集为 j 至少要选的 people 集合
    Arrays.fill(f, all);
    f[0] = 0;
    for (int j = 0; j < u - 1; ++j) // f[u-1] 无需计算
      if (f[j] < all)
        for (int i = 0; i < n; ++i)
          if (Long.bitCount(f[j]) + 1 < Long.bitCount(f[j | mask[i]]))
            f[j | mask[i]] = f[j] | (1L << i); // 刷表：用 f[j] 去更新其它状态

    long res = f[u - 1];
    var ans = new int[Long.bitCount(res)];
    for (int i = 0, j = 0; i < n; ++i)
      if (((res >> i) & 1) > 0)
        ans[j++] = i; // 所有在 res 中的下标
    return ans;
  }
}
// @lc code=end
