import java.util.Arrays;

class Solution {
  public int miceAndCheese(int[] reward1, int[] reward2, int k) {
    int ans = 0;
    int n = reward1.length;
    int count = 0;
    int[] diffreward = new int[n];
    for (int i = 0; i < n; i++) {
      diffreward[i] = reward1[i] - reward2[i];
      ans += reward2[i];
    }
    Arrays.sort(diffreward);
    for (int i = n - 1; i >= 0; i--) {
      if (count < k) {
        ans += diffreward[i];
        count++;
      } else {
        break;
      }
    }
    return ans;
  }
}