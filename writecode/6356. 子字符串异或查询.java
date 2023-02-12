import java.util.HashMap;

class Solution {
  public int[][] substringXorQueries(String s, int[][] queries) {
    int[][] ans = new int[queries.length][2];
    HashMap<Integer, Integer> map = new HashMap<>();// map存储每个数对应字符串出现的位置
    for (int i = 0; i < s.length(); i++) {
      int x = s.charAt(i) - '0';
      if (x == 0) {
        if (!map.containsKey(x)) {// 去除开头的0
          map.put(x, i);
        }
        continue;
      }
      for (int j = 1; j < 31; j++) {// 考虑int的范围
        if (!map.containsKey(x)) {
          map.put(x, i);
        }
        // System.out.printf("%d %d \r\n", x, i);
        x <<= 1;
        if (i + j < s.length())
          x |= (s.charAt(i + j) - '0');
        else
          break;
      }
    }
    // System.out.println(map);
    for (int i = 0; i < queries.length; i++) {
      int l = queries[i][0], r = queries[i][1];
      l ^= r;
      // System.out.println(l);
      if (map.containsKey(l)) {
        ans[i][0] = map.get(l);
        ans[i][1] = map.get(l) + Integer.toBinaryString(l).length() - 1;
      } else {
        ans[i][0] = -1;
        ans[i][1] = -1;
      }
    }
    return ans;
  }
}
