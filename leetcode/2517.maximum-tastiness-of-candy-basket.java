/*
 * @lc app=leetcode.cn id=2517 lang=java
 *
 * [2517] Maximum Tastiness of Candy Basket
 */

// @lc code=start

class Solution {
  public int maximumTastiness(int[] price, int k) {
    Arrays.sort(price);
    int left = 0, right = price[price.length - 1] - price[0];
    while (left < right) {
      int mid = (left + right + 1) / 2;
      if (check(price, k, mid)) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }

  public boolean check(int[] price, int k, int tastiness) {
    int prev = Integer.MIN_VALUE / 2;
    int cnt = 0;
    for (int p : price) {
      if (p - prev >= tastiness) {
        cnt++;
        prev = p;
      }
    }
    return cnt >= k;
  }
}

// @lc code=end
