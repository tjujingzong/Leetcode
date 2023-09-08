import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
  Map<Character, int[]> map = new HashMap<>();
  int n = 7;
  String w = "elohtcd";
  int[][] arr = new int[][] {
      { 0, 4, 7 },
      { 3, 3, 3 },
      { 5, 2, 3 },
      { 7, 1, 1 },
      { 8, 1, 1 },
      { 9, 1, 1 },
      { 10, 1, 1 }
  };
  int len;
  String[] words;

  public int Leetcode(String[] words) {
    for (int i = 0; i < 7; i++) {
      map.put(w.charAt(i), arr[i]);
    }
    this.words = words;
    len = words.length;
    mapArr = new HashMap[len];
    dp = new int[len][1 << 11];
    for (String wor : words) {
      mapArr[index] = new HashMap<Integer, Integer>();
      Arrays.fill(dp[index], Integer.MAX_VALUE);
      dfs(wor, 0, 0);
      index++;
    }
    for (int i = 0; i < (1 << 11); i++) {
      Arrays.fill(mergeArr[i], -2);
    }
    int ans = dfs(0, 0);
    return ans == Integer.MAX_VALUE ? -1 : ans;
  }

  HashMap<Integer, Integer>[] mapArr;
  int index = 0;

  void dfs(String str, int mask, int cost) {
    mapArr[index].put(mask, Math.min(cost, mapArr[index].getOrDefault(mask, Integer.MAX_VALUE)));
    if (str.equals(""))
      return;
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (!map.containsKey(ch))
        continue;
      int[] flag = map.get(ch);
      if (((mask >> flag[0]) & flag[2]) < flag[1]) {
        dfs((i > 0 ? str.substring(0, i) : "") +
            (i < str.length() - 1 ? str.substring(i + 1) : ""),
            mask + (1 << flag[0]),
            cost + i * (str.length() - i - 1));
      }
    }
  }

  int[][] mergeArr = new int[1 << 11][1 << 11];

  int merge(int cur, int add) {
    if (mergeArr[cur][add] != -2)
      return mergeArr[cur][add];
    int res = cur;
    for (int[] a : arr) {
      int num1 = (cur >> a[0]) & a[2];
      int num2 = (add >> a[0]) & a[2];
      if (a[1] < num1 + num2)
        return -1;
      res += (num2 << a[0]);
    }
    mergeArr[cur][add] = res;
    return res;
  }

  int[][] dp;

  int dfs(int pos, int mask) {
    if (pos == len)
      return mask == 2012 ? 0 : Integer.MAX_VALUE;
    if (dp[pos][mask] != Integer.MAX_VALUE)
      return dp[pos][mask];
    int res = Integer.MAX_VALUE;
    for (Map.Entry<Integer, Integer> en : mapArr[pos].entrySet()) {
      if (res <= en.getValue())
        continue;
      int t1 = merge(mask, en.getKey());
      if (t1 == -1)
        continue;
      int t = dfs(pos + 1, t1);
      if (t == Integer.MAX_VALUE)
        continue;
      res = Math.min(res, t + en.getValue());
    }
    dp[pos][mask] = res;
    return res;
  }
}