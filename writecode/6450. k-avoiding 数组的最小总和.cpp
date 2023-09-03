class Solution {
 public:
  int minimumSum(int n, int k) {
    bool ispair[55];
    for (int i = 0; i < 55; i++) {
      ispair[i] = false;
    }
    vector<int> a;
    int i = 1;
    while (a.size() < n) {
      if (i <= k && !ispair[i]) {
        a.push_back(i);
        ispair[k - i] = true;
      }
      if (i > k) {
        a.push_back(i);
      }
      i++;
    }
    int sum = 0;
    for (int i = 0; i < a.size(); i++) {
      sum += a[i];
    }
    return sum;
  }
};