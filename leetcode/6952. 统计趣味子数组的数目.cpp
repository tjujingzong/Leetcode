typedef long long LL;

class Solution {
 public:
  long long countInterestingSubarrays(vector<int>& nums, int modulo, int k) {
    int n = nums.size();
    vector<int> arr(n);
    for (int i = 0; i < n; i++) {
      arr[i] = nums[i] % modulo == k ? 1 : 0;
    }
    LL ans = 0;
    unordered_map<int, int> counter;
    counter[0] = 1;
    LL presum = 0;
    for (int i = 0; i < n; i++) {
      presum = (presum + arr[i]) % modulo;
      int t = (presum - k + modulo) % modulo;
      if (counter.count(t)) {
        ans += counter[t];
      }
      counter[presum]++;
    }
    return ans;
  }
};