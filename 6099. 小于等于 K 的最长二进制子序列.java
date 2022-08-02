class Solution {
  public int longestSubsequence(String s, int k) {
    long wight = 1;
    int ans = 0;
    long sum = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      int nownum = Integer.parseInt(s.substring(i, i + 1));
      if(wight>k){
        if(nownum==0) ans++;
        continue;
      }
      if (nownum * wight + sum <= k) {
        ans++;
        sum += nownum * wight;
        wight *= 2;
      }
    }
    return ans;
  }
}