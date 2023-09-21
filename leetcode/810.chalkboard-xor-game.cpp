class Solution {
 public:
  bool xorGame(vector<int>& nums) {
    if (nums.size() % 2 == 0) {
      return true;
    }
    int xorsum = 0;
    for (int num : nums) {
      xorsum ^= num;
    }
    return xorsum == 0;
  }
};
