class Solution {
  public String largestPalindromic(String num) {
    StringBuilder sb = new StringBuilder();
    int[] c = new int[10];
    for (int i = 0; i < num.length(); i++) {
      int p = num.charAt(i) - '0';
      c[p]++;
    }
    for (int i = 9; i >= 0; i--) {
      if (i == 0 && sb.length() == 0)
        continue;
      if (c[i] == 0)
        continue;
      if (c[i] >= 2) {
        for (int j = 0; j < c[i] / 2; j++) {
          sb.append((char) ('0' + i));
        }
        c[i] = c[i] % 2;
      }
    }
    String odd = "";
    for (int i = 9; i >= 0; i--) {
      if (c[i] == 0)
        continue;
      else {
        odd += (char) ('0' + i);
        break;
      }
    }
    return sb.toString() + odd + sb.reverse().toString();
  }
}