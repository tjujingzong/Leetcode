class Solution {
  public int similarPairs(String[] words) {
    int ans = 0;
    for (int i = 0; i < words.length; i++) {
      int[] count = new int[26];
      for (int k = 0; k < words[i].length(); k++) {
        count[words[i].charAt(k) - 'a']++;
      }
      for (int j = i + 1; j < words.length; j++) {
        int[] count2 = new int[26];
        for (int k = 0; k < words[j].length(); k++) {
          count2[words[j].charAt(k) - 'a']--;
        }
        boolean flag = true;
        for (int k = 0; k < 26; k++) {
          if (count[k] == 0 && count2[k] != 0) {
            flag = false;
            break;
          }
          if (count[k] != 0 && count2[k] == 0) {
            flag = false;
            break;
          }
        }
        if (flag) {
          ans++;
        }
      }
    }
    return ans;
  }
}