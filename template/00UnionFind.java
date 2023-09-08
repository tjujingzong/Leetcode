class UnionFind{
  private int[] parent;
  private int[] rank; // 实际代码中，按秩求并和按大小求并选择其中一种即可
  private int[] size; // 实际代码中，按秩求并和按大小求并选择其中一种即可
  
  public UnionFind(int[] parent) {
      this.parent = parent;
      this.rank = new int[parent.length];
      this.size = new int[parent.length];
      for (int i = 0; i < parent.length; i++) {
          this.rank[i] = 1;
          this.size[i] = 1;
      }
  }
  
  // 直接求并
  public void unionDirect(int x, int y) {
      if(find(x) != find(y)){
          parent[find(y)] = find(x);
      }
  }
  
  // 按大小求并
  public void unionBySize(int x, int y){
      int xRoot = find(x), yRoot = find(y);
      
      if(xRoot != yRoot) { // 根节点不同才求并
          if(size[yRoot] <= size[xRoot]){
              parent[yRoot] = xRoot;
              size[xRoot] += size[yRoot];
          } else {
              parent[xRoot] = yRoot;
              size[yRoot] += size[xRoot];
          }
      }
  }

  // 按秩求并
  public void union(int x, int y){
  int xRoot = find(x), yRoot = find(y);
  if( xRoot != yRoot){
          if(rank[yRoot] <= rank[xRoot]) parent[yRoot] = xRoot;
          else parent[xRoot] = yRoot;
          if(rank[xRoot] == rank[yRoot]) rank[xRoot]++; 
      }
  }
  
  // 直接查找
  public int findDirect(int x) {
      if(parent[x] == x) return x;
      return findDirect(parent[x]);  
  }
  
  // 带路径压缩的查找
  public int find(int x) {
      if(parent[x] == x) return x;
      return parent[x] = find(parent[x]); 
  }
}
