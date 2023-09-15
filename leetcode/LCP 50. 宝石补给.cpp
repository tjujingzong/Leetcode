class Solution {
 public:
  int giveGem(vector<int>& gem, vector<vector<int>>& operations) {
    for (vector<int>& op : operations) {
      int x = op[0];
      int y = op[1];
      int h = gem[x] / 2;
      gem[x] -= h;
      gem[y] += h;
    }
    int mi = 0x3f3f3f3f;
    int ma = -1;
    for (int& i : gem) {
      mi = min(mi, i);
      ma = max(ma, i);
    }
    return ma - mi;
  }
};