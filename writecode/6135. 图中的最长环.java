import java.util.HashMap;

class Solution {
  public int longestCycle(int[] edges) {
    int ans = -1;
    for (int i = 0; i < edges.length; i++) {
      if (edges[i] == -1)
        continue;
      HashMap<Integer, Integer> edgesMap = new HashMap<Integer, Integer>();
      int next = edges[i], size = 1;
      while (!edgesMap.containsKey(next) && next != -1) {
        int temp = edges[next];// 记录下一个跳转的位置
        edges[next] = -1;// 赋为-1，标记为查找过
        edgesMap.put(next, size);
        ++size;
        next = temp;// 改变next为下一跳
      }
      if (next != -1)// 如果确实是因为找到了环结束的，更新ans
        ans = Math.max(ans, size - edgesMap.get(next));
    }
    return ans;
  }
}