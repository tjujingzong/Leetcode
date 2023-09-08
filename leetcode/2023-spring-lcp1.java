import java.util.ArrayList;

class Solution {
  public int[] supplyWagon(int[] supplies) {
    int n = supplies.length;
    int[] res = new int[n / 2];
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list.add(supplies[i]);
    }

    while (list.size() > res.length) {
      int min = Integer.MAX_VALUE;
      int index1 = 0;
      int index2 = 0;

      for (int i = 0; i < list.size() - 1; i++) {
        if (list.get(i) + list.get(i + 1) < min) {
          min = list.get(i) + list.get(i + 1);
          index1 = i;
          index2 = i + 1;
        }
      }
      ArrayList<Integer> temp = new ArrayList<>();
      for (int i = 0; i < list.size(); i++) {
        if (i == index1) {
          temp.add(list.get(i) + list.get(i + 1));
        } else if (i != index1 && i != index2) {
          temp.add(list.get(i));
        }
      }
      list = temp;
    }
    for (int i = 0; i < res.length; i++) {
      res[i] = list.get(i);
    }
    return res;
  }
}