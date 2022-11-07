import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=901 lang=java
 *
 * [901] Online Stock Span
 */

// @lc code=start
class StockSpanner {
  ArrayList<Integer> arr;
  ArrayList<Integer> ans;

  public StockSpanner() {
    arr = new ArrayList<Integer>();
    ans = new ArrayList<Integer>();
  }

  public int next(int price) {
    arr.add(price);
    int t = 1;
    int i = arr.size() - 2;
    while (i >= 0) {
      if (arr.get(i) <= price) {
        t += ans.get(i);
        i -= ans.get(i);
      } else
        break;
    }
    ans.add(t);
    return t;
  }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
// @lc code=end
