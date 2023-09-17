#define MAXX ((int)1e4)
bool inited = false;
bool flag[MAXX + 10];
int P[MAXX + 10];

// 全局预处理
void init() {
  if (inited)
    return;
  inited = true;

  memset(flag, 0, sizeof(flag));
  for (int i = 1; i <= MAXX; i++)
    P[i] = 1;
  // 筛法求质数
  for (int i = 2; i <= MAXX; i++)
    if (!flag[i]) {
      for (int j = i * 2; j <= MAXX; j += i)
        flag[j] = true;
      // 计算质数 i 在它的倍数 j 的质因数分解中出现了几次
      for (int j = i; j <= MAXX; j += i) {
        int tmp = j, cnt = 0;
        while (tmp % i == 0)
          tmp /= i, cnt++;
        if (cnt & 1)
          P[j] *= i;
      }
    }
}

class Solution {
 public:
  long long maximumSum(vector<int>& nums) {
    init();
    int n = nums.size();
    // 用哈希表维护每组的和
    unordered_map<int, long long> mp;
    for (int i = 0; i < n; i++)
      mp[P[i + 1]] += nums[i];
    // 取每组和的最大值
    long long ans = 0;
    for (auto& p : mp)
      ans = max(ans, p.second);
    return ans;
  }
};
