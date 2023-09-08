class Solution {
 public:
  string finalString(string s) {
    string ans = "";
    for (int i = 0; i < s.size(); i++) {
      if (s[i] == 'i') {
        // reverse
        reverse(ans.begin(), ans.end());
      } else
        ans += s[i];
    }
    return ans;
  }
};