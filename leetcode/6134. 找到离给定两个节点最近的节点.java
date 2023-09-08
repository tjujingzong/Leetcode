import java.util.HashMap;

class Solution {
  public int closestMeetingNode(int[] edges, int node1, int node2) {
    if (node1 == node2)
      return node1;
    HashMap<Integer, Integer> nodes1 = new HashMap<Integer, Integer>();
    int next = edges[node1];
    nodes1.put(node1, 0);
    int len = 1;
    while (true) {
      if (next == -1 || nodes1.keySet().contains(next))
        break;
      nodes1.put(next, len);
      next = edges[next];
      len++;
    }
    HashMap<Integer, Integer> nodes2 = new HashMap<Integer, Integer>();
    next = edges[node2];
    nodes2.put(node2, 0);
    len = 1;
    while (true) {
      if (next == -1 || nodes2.keySet().contains(next))
        break;
      nodes2.put(next, len);
      next = edges[next];
      len++;
    }
    int ans = -1;
    int biggerlen = 100000;
    for (int nod : nodes1.keySet()) {
      if (nodes2.keySet().contains(nod)) {
        if (Math.max(nodes1.get(nod), nodes2.get(nod)) < biggerlen) {
          biggerlen = Math.max(nodes1.get(nod), nodes2.get(nod));
          ans = nod;
        } else if (Math.max(nodes1.get(nod), nodes2.get(nod)) == biggerlen) {
          if (nod < ans)
            ans = nod;
        }
      }
    }
    return ans;
  }
}