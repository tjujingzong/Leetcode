import java.util.ArrayList;

class Solution {
  public int[] asteroidCollision(int[] asteroids) {
    ArrayList<Integer> aList = new ArrayList<>();
    for (int i = 0; i < asteroids.length; i++)
      aList.add(asteroids[i]);
    int i = aList.size() - 1;// 从右往左撞
    while (i >= 1) {
      i = Math.min(aList.size() - 1, i);// 防止越界
      if (i < 1)
        break;
      if (aList.get(i) < 0 && aList.get(i - 1) > 0) {
        if (aList.get(i) + aList.get(i - 1) < 0)// 正的被撞没
          aList.remove((int) i - 1);
        else if (aList.get(i) + aList.get(i - 1) > 0)
          aList.remove((int) i);// 负的撞没
        else {
          aList.remove((int) i);// 全没
          aList.remove((int) i - 1);
        }
        continue;
      }
      i--;
    }
    int[] res = new int[aList.size()];
    for (i = 0; i < aList.size(); i++)
      res[i] = aList.get(i);
    return res;
  }
}