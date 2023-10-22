/*
 * @lc app=leetcode.cn id=2034 lang=cpp
 *
 * [2034] Stock Price Fluctuation
 */

// @lc code=start
class StockPrice {
  map<int, int> m;
  map<int, unordered_set<int>> s;

 public:
  StockPrice() {}

  void update(int timestamp, int price) {
    if (m.count(timestamp)) {
      s[m[timestamp]].erase(timestamp);
      if (s[m[timestamp]].empty())
        s.erase(m[timestamp]);
    }
    m[timestamp] = price;
    s[price].insert(timestamp);
  }

  int current() { return m.rbegin()->second; }

  int maximum() { return s.rbegin()->first; }

  int minimum() { return s.begin()->first; };
};

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice* obj = new StockPrice();
 * obj->update(timestamp,price);
 * int param_2 = obj->current();
 * int param_3 = obj->maximum();
 * int param_4 = obj->minimum();
 */
// @lc code=end
