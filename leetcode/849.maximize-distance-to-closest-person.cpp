/*
 * @lc app=leetcode.cn id=849 lang=cpp
 *
 * [849] Maximize Distance to Closest Person
 */

// @lc code=start
class Solution {
 public:
  int maxDistToClosest(vector<int>& seats) {
    int n = seats.size();
    int maxsize = 0;
    int last = -1;
    for (int i = 0; i < n; i++) {
      if (seats[i] == 1) {
        if (last == -1) {
          maxsize = i;
        } else {
          if ((i - last) / 2 > maxsize) {
            maxsize = max(maxsize, (i - last) / 2);
          }
        }
        last = i;
      }
    }
    if (n - 1 - last > maxsize) {
      maxsize = n - 1 - last;
    }
    return maxsize;
  }
};
// @lc code=end
