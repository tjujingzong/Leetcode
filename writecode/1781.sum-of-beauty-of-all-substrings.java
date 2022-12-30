class Solution {
  public int beautySum(String s) {
    int res = 0;
    for (int i = 0; i < s.length(); i++) {
      int[] cnt = new int[26];
      int maxFreq = 0;
      for (int j = i; j < s.length(); j++) {
        cnt[s.charAt(j) - 'a']++;
        maxFreq = Math.max(maxFreq, cnt[s.charAt(j) - 'a']);
        int minFreq = s.length();
        for (int k = 0; k < 26; k++) {
          if (cnt[k] > 0) {
            minFreq = Math.min(minFreq, cnt[k]);
          }
        }
        res += maxFreq - minFreq;
      }
    }
    return res;
  }
}

// 作者：力扣官方题解
// 链接：https://leetcode.cn/problems/sum-of-beauty-of-all-substrings/solutions/2016548/suo-you-zi-zi-fu-chuan-mei-li-zhi-zhi-he-rq3x/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。