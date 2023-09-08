import java.util.ArrayList;
import java.util.List;

class Fancy {
  ArrayList<Long> list;

  public Fancy() {
    list = new ArrayList<>();
  }

  public void append(int val) {
    list.add((long) val);
  }

  public void addAll(int inc) {
    for (int i = 0; i < list.size(); i++) {
      list.set(i, list.get(i) + inc);
    }
  }

  public void multAll(int m) {
    for (int i = 0; i < list.size(); i++) {
      list.set(i, list.get(i) * m);
    }
  }

  public int getIndex(int idx) {
    if(idx>=list.size()) return -1;
    long ans=list.get(idx) % (1000000000 + 7);
    return (int)ans;
  }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */