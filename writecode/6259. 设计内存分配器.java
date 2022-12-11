class Allocator {
  int[] memory;

  public Allocator(int n) {
    memory = new int[n];
  }

  public int allocate(int size, int mID) {
    int n = memory.length;
    int count = 0;
    for (int i = 0; i < n; i++) {
      if (memory[i] == 0) {
        count++;
      } else {
        count = 0;
      }
      if (count == size) {
        for (int j = i - size + 1; j <= i; j++) {
          memory[j] = mID;
        }
        return i - size + 1;
      }
    }
    return -1;
  }

  public int free(int mID) {
    int n = memory.length;
    int count = 0;
    for (int i = 0; i < n; i++) {
      if (memory[i] == mID) {
        memory[i] = 0;
        count++;
      }
    }
    return count;

  }
}

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.free(mID);
 */