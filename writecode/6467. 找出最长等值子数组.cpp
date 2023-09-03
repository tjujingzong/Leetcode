class Solution {
 public:
  int longestEqualSubarray(vector<int>& nums, int k) {
    int maxLength = 0;
    int maxCount = 0;
    unordered_map<int, int> countMap;
    int left = 0;

    for (int right = 0; right < nums.size(); ++right) {
      countMap[nums[right]]++;
      maxCount = max(maxCount, countMap[nums[right]]);

      int currentWindowSize = right - left + 1;
      int elementsToRemove = currentWindowSize - maxCount;

      if (elementsToRemove > k) {
        countMap[nums[left]]--;
        left++;
      }

      maxLength = max(maxLength, currentWindowSize - elementsToRemove);
    }

    return maxLength;
  }
};
