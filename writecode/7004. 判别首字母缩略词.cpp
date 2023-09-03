class Solution {
 public:
  bool isAcronym(vector<string>& words, string s) {
    string s1 = "";
    for (int i = 0; i < words.size(); i++) {
      s1 += words[i][0];
    }
    return s1 == s;
  }
};