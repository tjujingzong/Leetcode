class Solution {

  public int fieldOfGreatestBlessing(int[][] mat) {
    int ans = 1;
    TreeMap<Double, List<Integer>> ymap = new TreeMap<>();
    Map<Integer, double[]> map1 = new HashMap<>();
    for (int i = 0; i < mat.length; i++) {
      double cur = mat[i][2] / 2.0;
      double y1 = mat[i][1] - cur;
      double y2 = mat[i][1] + cur;
      double x1 = mat[i][0] - cur;
      double x2 = mat[i][0] + cur;
      ymap.putIfAbsent(y1, new ArrayList<>());
      ymap.putIfAbsent(y2, new ArrayList<>());
      ymap.get(y1).add(i);
      ymap.get(y2).add(i);
      map1.put(i, new double[] { x1, x2 });
    }
    Set<Integer> set = new HashSet<>();
    for (Double key : ymap.keySet()) {
      List<Integer> needRemove = new ArrayList<>();
      for (int index : ymap.get(key)) {
        if (!set.contains(index)) {
          set.add(index);
        } else {
          needRemove.add(index);
        }
      }
      List<double[]> list = new ArrayList<>();
      for (int x : set) {
        list.add(map1.get(x));
      }
      ans = Math.max(ans, maxOverlap(list));
      for (int x : needRemove) {
        set.remove(x);
      }
    }
    return ans;
  }

  public int maxOverlap(List<double[]> intervals) {
    List<double[]> events = new ArrayList<>();
    for (double[] interval : intervals) {
      events.add(new double[] { interval[0], 1 });
      events.add(new double[] { interval[1], -1 });
    }

    events.sort((o1, o2) -> {
      if (o1[0] != o2[0]) {
        return Double.compare(o1[0], o2[0]);
      }
      return Double.compare(o2[1], o1[1]);
    });

    int count = 0;
    int maxCount = 0;
    for (double[] event : events) {
      count += event[1];
      maxCount = Math.max(maxCount, count);
    }

    return maxCount;
  }
}