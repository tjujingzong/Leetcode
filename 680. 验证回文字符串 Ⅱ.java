class Solution {//需要单个判断
  
  public boolean validPalindrome(String s) {
    StringBuffer s2 = new StringBuffer(s);
    StringBuffer s3 = new StringBuffer(s);
    s2.reverse();
    if (s2.equals(s3))
      return true;
    for (int i = 0; i < s2.length(); i++) {
      StringBuffer s6=new StringBuffer(s);
      StringBuffer s4 = s6.deleteCharAt(i);
      StringBuffer s5 = s6.deleteCharAt(i);
      if (s4.reverse().equals(s5))
        return true;
    }
    return false; 
  }
}