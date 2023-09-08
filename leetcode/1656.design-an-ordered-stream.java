import java.util.List;

/*
 * @lc app=leetcode.cn id=1656 lang=java
 *
 * [1656] Design an Ordered Stream
 */

// @lc code=start
class OrderedStream {
  String[] s;
  int ptr = 0;
  int n;

  public OrderedStream(int n) {
    s = new String[n];
    this.n = n;
  }

  public List<String> insert(int idKey, String value) {
    int p = idKey - 1;
    s[p] = value;
    List<String> ret = new ArrayList<String>();
    while (ptr < n && s[ptr] != null) {
      ret.add(s[ptr]);
      ptr++;
    }
    return ret;
  }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */
// @lc code=end
