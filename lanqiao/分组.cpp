#include <algorithm>
#include <climits>
#include <iostream>
#include <vector>

using namespace std;

// Helper function to check if it's possible to divide nums into k groups
bool canDivide(const vector<int>& nums, int mid, int k) {
  int count = 1;              // Number of groups formed so far
  int minGroupMax = nums[0];  // Minimum group maximum

  for (int i = 1; i < nums.size(); i++) {
    if (nums[i] - minGroupMax > mid) {
      // Start a new group
      count++;
      minGroupMax = nums[i];
      if (count > k) {
        return false;
      }
    }
  }

  return true;
}

int main() {
  int n, k;
  cin >> n >> k;
  vector<int> nums(n);

  // Input n numbers
  for (int i = 0; i < n; i++) {
    cin >> nums[i];
  }
  sort(nums.begin(), nums.end());
  // Binary search the minimum possible difference
  int low = 0;
  int high = INT_MAX;
  int result = -1;

  while (low <= high) {
    int mid = low + (high - low) / 2;

    if (canDivide(nums, mid, k)) {
      result = mid;
      high = mid - 1;  // Try to minimize the difference further
    } else {
      low = mid + 1;  // Increase the difference
    }
  }

  cout << result << endl;

  return 0;
}
