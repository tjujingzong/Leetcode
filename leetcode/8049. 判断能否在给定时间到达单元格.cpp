class Solution {
 public:
  bool isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
    int h = abs(fx - sx);
    int v = abs(fy - sy);
    int maxt = h + v;
    int mint = maxt - min(h, v);
    if (t == 1 && maxt == 0) {
      return false;
    }
    if (t >= mint) {
      return true;
    }
    return false;
  }
};