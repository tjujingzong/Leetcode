
class Node {
  public boolean val;
  public boolean isLeaf;
  public Node topLeft;
  public Node topRight;
  public Node bottomLeft;
  public Node bottomRight;

  public Node() {
  }

  public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
    val = _val;
    isLeaf = _isLeaf;
    topLeft = _topLeft;
    topRight = _topRight;
    bottomLeft = _bottomLeft;
    bottomRight = _bottomRight;
  }

};

  public Node intersect(Node quadTree1, Node quadTree2) {
    if (quadTree1.isLeaf) {
      if (quadTree1.val) {
        return new Node(true, true);
      }
      return new Node(quadTree2.val, quadTree2.isLeaf, quadTree2.topLeft, quadTree2.topRight, quadTree2.bottomLeft,
          quadTree2.bottomRight);
    }
    if (quadTree2.isLeaf) {
      return intersect(quadTree2, quadTree1);
    }
    Node o1 = intersect(quadTree1.topLeft, quadTree2.topLeft);
    Node o2 = intersect(quadTree1.topRight, quadTree2.topRight);
    Node o3 = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
    Node o4 = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
    if (o1.isLeaf && o2.isLeaf && o3.isLeaf && o4.isLeaf && o1.val == o2.val && o1.val == o3.val && o1.val == o4.val) {
      return new Node(o1.val, true);
    }
    return new Node(false, false, o1, o2, o3, o4);
  }
}

// 作者：LeetCode-Solution
// 链接：https://leetcode.cn/problems/logical-or-of-two-binary-grids-represented-as-quad-trees/solution/si-cha-shu-jiao-ji-by-leetcode-solution-wy1u/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。