class Solution {
  public int passThePillow(int n, int time) {
    int i = 0;
    int ans = 1;
    while (time-- > 0) {
      if (i % 2 == 0)
        ans++;
      else
        ans--;
      if (ans == n || ans == 1)
        i++;
    }
    return ans;
  }
}