class Solution {
  public List<Integer> findSubstring(String s, String[] words) {
      List<Integer> res = new ArrayList<Integer>();
      int m = words.length, n = words[0].length(), ls = s.length();
      for (int i = 0; i < n; i++) {
          if (i + m * n > ls) {
              break;
          }
          Map<String, Integer> differ = new HashMap<String, Integer>();
          for (int j = 0; j < m; j++) {
              String word = s.substring(i + j * n, i + (j + 1) * n);
              differ.put(word, differ.getOrDefault(word, 0) + 1);
          }
          for (String word : words) {
              differ.put(word, differ.getOrDefault(word, 0) - 1);
              if (differ.get(word) == 0) {
                  differ.remove(word);
              }
          }
          for (int start = i; start < ls - m * n + 1; start += n) {
              if (start != i) {
                  String word = s.substring(start + (m - 1) * n, start + m * n);
                  differ.put(word, differ.getOrDefault(word, 0) + 1);
                  if (differ.get(word) == 0) {
                      differ.remove(word);
                  }
                  word = s.substring(start - n, start);
                  differ.put(word, differ.getOrDefault(word, 0) - 1);
                  if (differ.get(word) == 0) {
                      differ.remove(word);
                  }
                  word = s.substring(start - n, start);
              }
              if (differ.isEmpty()) {
                  res.add(start);
              }
          }
      }
      return res;
  }
}

// 作者：LeetCode-Solution
// 链接：https://leetcode.cn/problems/substring-with-concatenation-of-all-words/solution/chuan-lian-suo-you-dan-ci-de-zi-chuan-by-244a/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。