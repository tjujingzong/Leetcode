class Solution {
 public:
  int minimumOperations(string num) {
    int num_zero = 0;
    for (int i = 0; i < num.size(); i++) {
      if (num[i] == '0')
        num_zero++;
    }
    int ans = num.size() - num_zero;
    int n = num.size();
    int p1 = -2, p2 = -2;
    for (int i = n - 1; i >= 0; i--) {
      if (num[i] == '0') {
        p1 = i;
        break;
      }
    }
    for (int i = p1 - 1; i >= 0; i--) {
      if (num[i] == '0' || num[i] == '5') {
        p2 = i;
        break;
      }
    }
    ans = min(ans, n - p2 - 2);
    p1 = -2, p2 = -2;
    for (int i = n - 1; i >= 0; i--) {
      if (num[i] == '5') {
        p1 = i;
        break;
      }
    }
    for (int i = p1 - 1; i >= 0; i--) {
      if (num[i] == '2' || num[i] == '7') {
        p2 = i;
        break;
      }
    }
    ans = min(ans, n - p2 - 2);
    return ans;
  }
};