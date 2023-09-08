import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class Solution {
  public int[] numMovesStones(int a, int b, int c) {
    ArrayList<Integer> l=new ArrayList<>();
    l.add(a);
    l.add(b);
    l.add(c);
    Collections.sort(l);
    int min=l.get(0);
    int mid=l.get(1);
    int max=l.get(2);
    int gap1=mid-min;
    int gap2=max-mid;

  }
}