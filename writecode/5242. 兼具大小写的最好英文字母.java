import java.util.HashSet;
import java.util.TreeSet;

class Solution {
  public String greatestLetter(String s) {
    TreeSet<String> bigset = new TreeSet<>();
    TreeSet<String> smallset = new TreeSet<>();
    String ans = "";
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
        bigset.add(s.substring(i, i + 1));
      else
        smallset.add(s.substring(i, i + 1));
    }
    for (String big : bigset) {
      for (String small : smallset) {
        if (big.equals(small.toUpperCase()))
          ans = big;
      }
    }
    return ans;
  }
}