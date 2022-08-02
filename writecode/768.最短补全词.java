import java.util.ArrayList;

class Solution {
  public String shortestCompletingWord(String licensePlate, String[] words) {
    String ans = "";
    String s = licensePlate.toLowerCase();
    ArrayList<Character> chlist = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
        chlist.add(s.charAt(i));
    }
    int minlength = 16;
    for (int i = 0; i < words.length; i++) {
      ArrayList<Character> tchlist = new ArrayList<>();
      tchlist.addAll(chlist);
      for (int j = 0; j < words[i].length(); j++) {
        if (tchlist.contains(words[i].charAt(j))) {
          tchlist.remove((Object)words[i].charAt(j));
        }
      }
      if (tchlist.isEmpty() && words[i].length() < minlength) {
        ans = words[i];
        minlength = words[i].length();
      }
    }
    return ans;
  }
}