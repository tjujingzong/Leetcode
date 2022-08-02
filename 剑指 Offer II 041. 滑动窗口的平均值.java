import java.util.ArrayList;

class MovingAverage {
  ArrayList<Integer> list;
  int n;
  int sum;

  /** Initialize your data structure here. */
  public MovingAverage(int size) {
    n = size;
    list = new ArrayList<>(size);
  }

  public double next(int val) {
    if (list.size() == n) {
      sum -= list.get(0);
      list.remove(0);
    }
    list.add(val);
    sum += val;
    return (double) sum / list.size();
  }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */