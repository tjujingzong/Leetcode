class Solution {
 public:
  int maxSum(vector<int>& nums) {
    vector<vector<int>> v(10);
    for (int& i : nums) {
      string s = to_string(i);
      int maxx = 0;
      for (char c : s) {
        maxx = max(maxx, c - '0');
      }
      v[maxx].push_back(i);
    }
    int ans = -1;
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < v[i].size(); j++) {
        for (int k = j + 1; k < v[i].size(); k++) {
          ans = max(v[i][j] + v[i][k], ans);
        }
      }
    }
    return ans;
  }
};