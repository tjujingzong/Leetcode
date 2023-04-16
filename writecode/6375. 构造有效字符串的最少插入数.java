// 给你一个字符串 word ，你可以向其中任何位置插入 "a"、"b" 或 "c" 任意次，返回使 word 有效 需要插入的最少字母数。

// 如果字符串可以由 "abc" 串联多次得到，则认为该字符串 有效 。
class Solution {
  public int addMinimum(String word) {
    var s = word.toCharArray();
    int t = 1;
    for (int i = 1; i < s.length; ++i)
      if (s[i - 1] >= s[i]) // 必须生成一个新的 abc
        ++t;
    return t * 3 - s.length;
  }
}