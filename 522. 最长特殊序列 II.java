class Solution {
  public int findLUSlength(String[] strs) {
    int ans = -1;
    for (int i = 0; i < strs.length; i++) {
      boolean flag=true;
      for (int j = 0; j < strs.length; j++) {
        if (i == j)
          continue;
        if (check(strs[i], strs[j])) {// 检查i是否是j的字串
          flag=false;
          break;
        }
      }
      if(flag) ans=Math.max(ans, strs[i].length())
    }
    return ans;
  }

  public boolean check(String s1, String s2) {
    int pts1 = 0, pts2 = 0;
    while (pts1 < s1.length() && pts2 < s2.length()) {
      if (s1.charAt(pts1) == s2.charAt(pts2)) {
        pts1++;
      }
      pts2++;
    }
    return pts1 == s1.length();
  }
}