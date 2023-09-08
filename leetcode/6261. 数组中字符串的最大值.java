class Solution {
  public int maximumValue(String[] strs) {
    int ans = 0;
    for (String s : strs) {
      // 如果s包含字母
      if (s.matches(".*[a-zA-Z]+.*"))
        ans = Math.max(ans, s.length());
      else
        // 值为该字符串在 10 进制下的所表示的数字
        ans = Math.max(ans, Integer.valueOf(s));
    }
    return ans;
  }
}