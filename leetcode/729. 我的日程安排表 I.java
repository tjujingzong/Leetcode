import java.util.Map;
import java.util.TreeMap;

class MyCalendar {
  TreeMap<Integer, Integer> intervals;

  public MyCalendar() {
    intervals = new TreeMap<Integer, Integer>();
  }
  
  public boolean book(int start, int end) {
    Map.Entry<Integer, Integer> entry=intervals.lowerEntry(end);
    if(entry==null) {
      intervals.put(start, end);
      return true;
    }
    if(entry.getValue()<=start){
      intervals.put(start, end);
      return true;
    }
    return false;
  }
}

/**
* Your MyCalendar object will be instantiated and called as such:
* MyCalendar obj = new MyCalendar();
* boolean param_1 = obj.book(start,end);
*/