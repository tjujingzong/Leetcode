import java.util.List;

class Solution {
  public List<String> restoreIpAddresses(String s) {
    ArrayList<String> ans = new ArrayList<String>();
    for (int i = 1; i <= 3; i++) {
      if (i > s.length() - 3)
        continue;
      String s1 = s.substring(0, i);
      if (s1.startsWith("0") && !s1.equals("0"))
        continue;
      for (int j = i + 1; j <= i + 3; j++) {
        if (j > s.length() - 2)
          continue;
        String s2 = s.substring(i, j);
        if (s2.startsWith("0") && !s2.equals("0"))
          continue;
        for (int k = j + 1; k <= j + 3; k++) {
          if (k > s.length() - 1) {
            continue;
          }
          if (s.length() - k > 3)
            continue;
          String s3 = s.substring(j, k);
          String s4 = s.substring(k, s.length());
          if (s3.startsWith("0") && !s3.equals("0"))
            continue;
          if (s4.startsWith("0") && !s4.equals("0"))
            continue;
          int n1 = Integer.parseInt(s1);
          int n2 = Integer.parseInt(s2);
          int n3 = Integer.parseInt(s3);
          int n4 = Integer.parseInt(s4);
          if (n1 < 256 && n2 < 256 && n3 < 256 && n4 < 256)
            ans.add(s1 + "." + s2 + "." + s3 + "." + s4);
        }
      }
    }
    return ans;
  }
}