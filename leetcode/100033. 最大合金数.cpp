class Solution {
 public:
  int maxNumberOfAlloys(int n,
                        int K,
                        int budget,
                        vector<vector<int>>& composition,
                        vector<int>& stock,
                        vector<int>& cost) {
    // 枚举每台机器，看是否有机器能在预算内造出 X 份合金
    auto check = [&](long long X) {
      for (int i = 0; i < K; i++) {
        long long money = 0;
        for (int j = 0; j < n; j++) {
          long long need = max(0LL, X * composition[i][j] - stock[j]);
          // X 最大值 2e8，composition 最大值 1e8，因此 need 最大值 2e16
          // cost 最大值 100，n 最大值 100
          // 如果我们不做这个检查，就直接把乘积加给 money
          // 则 money 可能会变成 2e20，超出 long long 的范围
          if (need * cost[j] > budget) {
            money = budget + 1;
            break;
          }
          money += need * cost[j];
        }
        if (money <= budget)
          return true;
      }
      return false;
    };

    // 二分最后制造的合金数
    long long head = 0, tail = 2e8;
    while (head < tail) {
      long long mid = (head + tail + 1) >> 1;
      if (check(mid))
        head = mid;
      else
        tail = mid - 1;
    }
    return head;
  }
};
