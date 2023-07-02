/*
 * @lc app=leetcode.cn id=2490 lang=cpp
 *
 * [2490] Circular Sentence
 */

// @lc code=start
class Solution {
 public:
  bool isCircularSentence(string sentence) {
    for (int i = 0; i < sentence.size(); i++) {
      if (sentence[i] == ' ') {
        if (sentence[i + 1] != sentence[i - 1]) {
          return false;
        }
      }
    }
    if (sentence[0] != sentence[sentence.size() - 1])
      return false;
    return true;
  }
};
// @lc code=end
