class Solution {
  public int beautifulPartitions(String s, int k, int minLength) {
    // 定义 f[i][j] 表示把 s 的前 j 个字符分割成 i 段的方案数
    int n = s.length();
    int[][] f = new int[k + 1][n + 1];
    // 每段分割都以‘2’或‘3’或‘5’或‘7’开头，以其他数字结尾，且长度不小于 minLength
    // 求分割方案数

    // 初始化
    f[0][0] = 1;
    for (int i = 1; i <= k; i++) {
      for (int j = 1; j <= n; j++) {
        // 枚举最后一段的长度
        for (int l = minLength; l <= j; l++) {
          // 枚举最后一段的开头
          if (s.charAt(j - l) == '2' || s.charAt(j - l) == '3' || s.charAt(j - l) == '5' || s.charAt(j - l) == '7') {
            f[i][j] += f[i - 1][j - l];
          }
        }
      }
    }
    return f[k][n];
  }
}