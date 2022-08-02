class Solution {
  public int minFlips(String s) {
    int ans1 = 0;// 以1开头
    int ans0 = 0;// 以0开头
    for (int i = 0; i < s.length(); i++) {
      if (i % 2 == 0) {
        if (s.charAt(i) == '1')
          ans0++;
        else
          ans1++;
      } else {
        if (s.charAt(i) == '0')
          ans0++;
        else
          ans1++;
      }
    }
    int res = Math.min(ans0, ans1);
    if (s.length() % 2 == 0)
      return res;
    int size=s.length();
    int i = 0;
    while (i < size - 1) {// 想象把前i个放入最后， i从1~size-1
      ans0 = ans1 + (s.charAt(i) == '0' ? -1 : 1);// 旧的start1 计算新的start0，只改变了一位
      ans1 = size - ans0;
      res = min(res, ans0);
      res = min(res, ans1);
      i++;
    }
    return res;
  }
}