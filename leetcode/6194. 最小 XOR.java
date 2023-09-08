class Solution {
  public int minimizeXor(int num1, int num2) {
    int n1 = num1;
    int cnt2 = 0;
    while (num2 > 0) {
      if (num2 % 2 == 1)
        cnt2++;
      num2 /= 2;
    }
    int cnt1 = 0;
    int[] bits = new int[32];
    int len = 0;
    while (num1 > 0) {
      bits[len] = num1 % 2;
      if (num1 % 2 == 1)
        cnt1++;
      num1 /= 2;
      len++;
    }
    int[] bits2 = new int[32];
    if (cnt1 == cnt2)
      return n1;
    if (cnt2 > cnt1) {
      int dif = cnt2 - cnt1;
      for (int i = 0; i < 32; i++) {
        if (dif == 0)
          break;
        if (bits[i] == 0) {
          bits2[i] = 1;
          dif--;
        }
      }
      int ans = 0;
      int w = 1;
      for (int i = 0; i < 32; i++) {
        ans += bits2[i] * w;
        w *= 2;
      }
      return n1 + ans;
    }
    if (cnt1 > cnt2) {
      int dif = cnt2;
      for (int i = 31; i >= 0; i--) {
        if (dif == 0)
          break;
        if (bits[i] == 1) {
          bits2[i] = 1;
          dif--;
        }
      }
    }
    int ans = 0;
    int w = 1;
    for (int i = 0; i < 32; i++) {
      ans += bits2[i] * w;
      w *= 2;
    }
    return ans;
  }
}