import java.util.HashSet;

class Solution {
  public boolean equalFrequency(String word) {
    int[] a = new int[26];
    for (int i = 0; i < word.length(); i++) {
      int p = word.charAt(i) - 'a';
      a[p]++;
    }
    for (int i = 0; i < word.length(); i++) {
      int p = word.charAt(i) - 'a';
      a[p]--;
      if (check(a))
        return true;
      a[p]++;
    }
    return false;
  }

  private boolean check(int[] a) {
    HashSet<Integer> set = new HashSet<Integer>();
    for (int i = 0; i < 26; i++) {
      if (a[i] == 0)
        continue;
      set.add(a[i]);
    }
    if (set.size() == 1)
      return true;
    return false;
  }
}