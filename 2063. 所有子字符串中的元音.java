class Solution {
  public long countVowels(String word) {
    int n = word.length();
    long ans = 0;
    for (int i = 0; i < n; i++) {
      if ("aeiou".contains(String.valueOf(word.charAt(i)))) {
        ans += (long) (i + 1) * (n - i);
      }
    }
    return ans;
  }
}