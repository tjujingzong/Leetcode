class Solution {
  public int vowelStrings(String[] words, int left, int right) {
    int ans = 0;
    String yuan = "aeiou";
    for (int i = left; i <= right; i++) {
      char first = words[i].charAt(0);
      char last = words[i].charAt(words[i].length() - 1);
      if (yuan.contains(first + "") && yuan.contains(last + "")) {
        ans++;
      }
    }
    return ans;
  }
}
