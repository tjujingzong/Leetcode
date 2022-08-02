import java.util.HashSet;

class Solution {
  public int canBeTypedWords(String text, String brokenLetters) {
    HashSet<Character> set = new HashSet<>();
    for (int i = 0; i < brokenLetters.length(); i++)
      set.add(brokenLetters.charAt(i));
    int ans = 0;
    String[] words = text.split(" ");
    for (int i = 0; i < words.length; i++) {
      boolean flag = true;
      for (int j = 0; j < words[i].length(); j++) {
        if (set.contains(words[i].charAt(j))) {
          flag = false;
          break;
        }
      }
      if (flag)
        ans++;
    }
    return ans;
  }
}