class Solution {
  public int findTheLongestBalancedSubstring(String s) {
    int max = 0;
    for (int i = 0; i < s.length(); i++) {
      int count = 0;
      for (int j = i; j < s.length(); j++) {
        if(Check(s.substring(i, j + 1))){
          count = j - i + 1;
          max = Math.max(max, count);
        }
      }
    }
    return max;
  }

  private boolean Check(String substring) {
    if(substring.length() % 2 != 0)
    return false;
    for (int i = 0; i < substring.length()/2; i++) {
      if(substring.charAt(i) != '0')
        return false;
    }
    for (int i = substring.length()/2; i < substring.length(); i++) {
      if(substring.charAt(i) != '1')
        return false;
    }
    return true;
  }
}