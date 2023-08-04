class Solution {
  const int MOD = 1e9 + 7;

  int calc(string& s) {
    int m = s.length(), memo[m][10];
    memset(memo, -1, sizeof(memo));  // -1 表示没有计算过
    function<int(int, int, bool, bool)> f = [&](int i, int pre, bool is_limit,
                                                bool is_num) -> int {
      if (i == m)
        return is_num;  // is_num 为 true 表示得到了一个合法数字
      if (!is_limit && is_num && memo[i][pre] != -1)
        return memo[i][pre];
      int res = 0;
      if (!is_num)  // 可以跳过当前数位
        res = f(i + 1, pre, false, false);
      int up = is_limit
                   ? s[i] - '0'
                   : 9;  // 如果前面填的数字都和 s 的一样，那么这一位至多填数字
                         // s[i]（否则就超过 s 啦）
      for (int d = 1 - is_num; d <= up; ++d)  // 枚举要填入的数字 d
        if (!is_num || abs(d - pre) == 1)  // 第一位数字随便填，其余必须相差 1
          res = (res + f(i + 1, d, is_limit && d == up, true)) % MOD;
      if (!is_limit && is_num)
        memo[i][pre] = res;
      return res;
    };
    return f(0, 0, true, false);
  }

  bool valid(string& s) {
    for (int i = 1; i < s.length(); i++)
      if (abs(int(s[i]) - int(s[i - 1])) != 1)
        return false;
    return true;
  }

 public:
  int countSteppingNumbers(string low, string high) {
    return (calc(high) - calc(low) + MOD + valid(low)) %
           MOD;  // +MOD 防止算出负数
  }
};
