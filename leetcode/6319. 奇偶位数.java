class Solution {
  public int[] evenOddBit(int n) {
    String s = Integer.toBinaryString(n);
    int[] res = new int[2];
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '0')
        continue;
      res[(s.length() - 1 - i) % 2]++;
    }
    return res;
  }
}