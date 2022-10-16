class Solution {
  public int countTime(String time) {
    String[] times = time.split(":");
    int ans = 1;
    if (times[0].charAt(0) == '?' && times[0].charAt(1) == '?')
      ans *= 24;
    else if (times[0].charAt(0) == '?') {
      if (times[0].charAt(1) <= '3' && times[0].charAt(1) >= '0')
        ans *= 3;
      else
        ans *= 2;
    } else if (times[0].charAt(1) == '?') {
      if (times[0].charAt(0) == '2')
        ans *= 4;
      else
        ans *= 10;
    }
    if (times[1].charAt(0) == '?')
      ans *= 6;
    if (times[1].charAt(1) == '?')
      ans *= 10;
    return ans == 1 ? 0 : ans;
  }
}