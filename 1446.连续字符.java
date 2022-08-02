class Solution {
  public int maxPower(String s) {
    int ans = 1;
    for (int i = 0; i < s.length(); i++) {
      int tans = 1;
      int t = i + 1;
      while (t < s.length()) {
        if (s.charAt(i) != s.charAt(t))
          break;
        t++;
        tans++;
      }
      if (tans > ans)
        ans = tans;
    }
    return ans;
  }
}