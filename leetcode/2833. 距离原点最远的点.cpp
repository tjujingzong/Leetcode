class Solution {
 public:
  int furthestDistanceFromOrigin(string moves) {
    int p = 0;
    int cnt = 0;
    for (char& c : moves) {
      if (c == 'L')
        p--;
      else if (c == 'R')
        p++;
      else
        cnt++;
    }
    return max(abs(p + cnt), abs(p - cnt));
  }
};