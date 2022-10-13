class LUPrefix {
  int[] a = new int[100005];
  int p = 1;
  int maxn;

  public LUPrefix(int n) {
    maxn = n;
  }

  public void upload(int video) {
    a[video]++;
  }

  public int longest() {
    for (int i = p; i <= maxn; i++) {
      if (a[i] == 0)
        break;
      p++;
    }
    return p - 1;
  }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */