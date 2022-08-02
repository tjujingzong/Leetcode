import java.util.Arrays;
import java.util.HashSet;

class Solution {
  public int longestAwesome(String s) {
    int ans = 1;
    for (int i = 0; i < s.length(); i++) {
      HashSet<Integer> set = new HashSet<>();
      for (int j = i; j < s.length(); j++) {
        int nownum = s.charAt(j) - '0';
        if (set.contains(nownum))
          set.remove((Object) nownum);
        else
          set.add(nownum);
        if (set.size() <= 1) {
          ans = Math.max(ans, j - i + 1);
        }
      }
    }
    return ans;
  }
}