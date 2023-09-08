class Solution {
 public:
  long long minimumPossibleSum(int n, int target) {
    vector<int> v;
    int index = 1;
    bool istarget[200000];
    memset(istarget, 0, sizeof(istarget));
    while (v.size() < n) {
      if (!istarget[index]) {
        v.push_back(index);
        if (target - index >= 0)
          istarget[target - index] = true;
      }
      index++;
    }
    long long sum = 0;
    for (int i = 0; i < n; i++) {
      sum += v[i];
    }
    return sum;
  }
};