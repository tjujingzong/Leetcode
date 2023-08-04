class Solution {
 public:
  bool isSubstring(const std::string& a, const std::string& b) {
    // 使用find函数查找子字符串b在字符串a中的位置
    size_t found = a.find(b);

    // 如果找到了子字符串b，则返回true，否则返回false
    return found != std::string::npos;
  }

  string minimumString(string a, string b, string c) {
    vector<string> strs;
    strs.push_back(contanct(a, b, c));
    strs.push_back(contanct(a, c, b));
    strs.push_back(contanct(b, a, c));
    strs.push_back(contanct(b, c, a));
    strs.push_back(contanct(c, a, b));
    strs.push_back(contanct(c, b, a));
    string ans = strs[0];
    for (int i = 1; i < strs.size(); i++) {
      if (strs[i].size() < ans.size()) {
        ans = strs[i];
      }
      if (strs[i].size() == ans.size() && strs[i] < ans) {
        ans = strs[i];
      }
    }
    return ans;
  }
  string contanct(string a, string b, string c) {
    string ans = a;
    int i;
    if (!isSubstring(a, b)) {
      for (i = min(a.size(), b.size()); i >= 0; i--) {
        string s1 = b.substr(0, i);
        string s2 = a.substr(a.size() - i, a.size());
        if (s1 == s2) {
          break;
        }
      }
      ans += b.substr(i, b.size());
    }
    if (!isSubstring(ans, c)) {
      for (i = min(ans.size(), c.size()); i >= 0; i--) {
        string s1 = c.substr(0, i);
        string s2 = ans.substr(ans.size() - i, ans.size());
        if (s1 == s2) {
          break;
        }
      }
      ans += c.substr(i, c.size());
    }
    return ans;
  }
};