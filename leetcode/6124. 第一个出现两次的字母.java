class Solution {
  public char repeatedCharacter(String s) {
    int[] num = new int[26];
    for (int i = 0; i < s.length(); i++) {
      int p = s.charAt(i) - 'a';
      num[p]++;
      if (num[p] == 2)
        return s.charAt(i);
    }
    return 'a';
  }
}