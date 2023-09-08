class Solution {
  public int maxPalindromes(String s, int k) {
    int i = 0;
    int ans = 0;
    while (i < s.length()) {
      if (i + k <= s.length()) {
        String sub1 = s.substring(i, i + k);
        if (isPalindrome(sub1)) {
          ans++;
          i += k;
          continue;
        }
      }
      if (i + k + 1 <= s.length()) {
        String sub2 = s.substring(i, i + k + 1);
        if (isPalindrome(sub2)) {
          ans++;
          i += k + 1;
          continue;
        }
      }
      i++;
    }
    return ans;
  }

  private boolean isPalindrome(String sub1) {
    int i = 0;
    int j = sub1.length() - 1;
    while (i < j) {
      if (sub1.charAt(i) != sub1.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }
}