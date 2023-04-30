import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

class Solution {
  class Path {
    int x1, y1, x2, y2, cost;

    public Path(int x1, int y1, int x2, int y2, int cost) {
      this.x1 = x1;
      this.y1 = y1;
      this.x2 = x2;
      this.y2 = y2;
      this.cost = cost;
    }
  }

  class Key {
    int x, y, targetX, targetY;

    public Key(int x, int y, int targetX, int targetY) {
      this.x = x;
      this.y = y;
      this.targetX = targetX;
      this.targetY = targetY;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o)
        return true;
      if (o == null || getClass() != o.getClass())
        return false;
      Key key = (Key) o;
      return x == key.x && y == key.y && targetX == key.targetX && targetY == key.targetY;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y, targetX, targetY);
    }
  }

  public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
    List<Path> paths = new ArrayList<>();
    for (int[] road : specialRoads) {
      int x1 = road[0], y1 = road[1], x2 = road[2], y2 = road[3], cost = road[4];
      if (Math.abs(x1 - x2) + Math.abs(y1 - y2) <= cost)
        continue;
      paths.add(new Path(x1, y1, x2, y2, cost));
    }

    paths.sort((a, b) -> a.x1 - b.x1);
    Map<Key, Integer> memo = new HashMap<>();
    return dfs(start[0], start[1], target[0], target[1], paths, 0, memo);
  }

  private int dfs(int x, int y, int targetX, int targetY, List<Path> paths, int i, Map<Key, Integer> memo) {
    Key key = new Key(x, y, targetX, targetY);
    if (memo.containsKey(key))
      return memo.get(key);
    int normalCost = Math.abs(targetX - x) + Math.abs(targetY - y);
    int minCost = normalCost;

    for (int j = i; j < paths.size(); j++) {
      Path path = paths.get(j);
      int cost = dfs(x, y, path.x1, path.y1, paths, j + 1, memo) + path.cost
          + dfs(path.x2, path.y2, targetX, targetY, paths, j + 1, memo);
      minCost = Math.min(minCost, cost);
    }

    memo.put(key, minCost);
    return minCost;
  }
}
