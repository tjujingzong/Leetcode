import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class Solution {
  public int extractMantra(String[] matrix, String mantra) {
    int rows = matrix.length;
    int cols = matrix[0].length();
    char[][] grid = new char[rows][cols];
    for (int i = 0; i < rows; i++) {
      grid[i] = matrix[i].toCharArray();
    }

    HashSet<Character> set = new HashSet<>();
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        set.add(grid[i][j]);
      }
    }
    for (int i = 0; i < mantra.length(); i++) {
      if (!set.contains(mantra.charAt(i))) {
        return -1;
      }
    }

    int[][] pos = new int[26][];
    int[] count = new int[26];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        count[grid[i][j] - 'a']++;
      }
    }

    for (int i = 0; i < 26; i++) {
      pos[i] = new int[count[i]];
    }

    Arrays.fill(count, 0);
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        int idx = grid[i][j] - 'a';
        pos[idx][count[idx]++] = i * cols + j;
      }
    }

    int n = mantra.length();
    int[][][] dp = new int[n + 1][rows * cols][n];
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j < rows * cols; j++) {
        Arrays.fill(dp[i][j], -1);
      }
    }

    return dfs(grid, 0, 0, 0, mantra, pos, dp);
  }

  private int dfs(char[][] m, int x, int y, int index, String mantra, int[][] pos, int[][][] dp) {
    if (index == mantra.length()) {
      return 0;
    }

    if (dp[index][x * m[0].length + y][mantra.charAt(index) - 'a'] != -1) {
      return dp[index][x * m[0].length + y][mantra.charAt(index) - 'a'];
    }

    int target = mantra.charAt(index) - 'a';
    int minDist = Integer.MAX_VALUE;
    for (int i = 0; i < pos[target].length; i++) {
      int nx = pos[target][i] / m[0].length;
      int ny = pos[target][i] % m[0].length;
      int dist = Math.abs(nx - x) + Math.abs(ny - y);
      int nextDist = dfs(m, nx, ny, index + 1, mantra, pos, dp);
      if (nextDist != -1) {
        minDist = Math.min(minDist, dist + nextDist + 1);
      }
    }

    dp[index][x * m[0].length + y][target] = minDist == Integer.MAX_VALUE ? -1 : minDist;
    return dp[index][x * m[0].length + y][target];
  }
}
//["hydfpyqaoir","ixpjveolliy","hidhpqciygm","icnefohovue","qcwopbcbxbn","dvahetjbfqg","uiwjsukwofm","spzjegbovxo","aflruwmvkdp"]
// "nrahvcpkmqgsyrcpmgfpmaxvydbp"
// ["aaabaaabbbabaabaababaababbaabbbabbabbabaaabbbbaaabaababababaaaababbbbbaaaaabaabaa","aaaaabbaaabbbabbaabbaaabbbabbabbbbaaabbbbaabbbabbbabbbaabbbbabaabbbbabababaabaaab","abaaababaaaaaaababbbbbbaaaabbbbbabbbabaaaaaabbbbaababbaaaabbbbbabababbbbaaaaabaab","babbababaabaabbbabbababababbabaabaabbabbbababbabbbbbbbaababaabbabbabababbaabaabbb","babbabbbaabaababbabaaaaaababababbabaabababbbbaaabbbbabbbbbbabbabbbbbaaabaabaaaabb","baabbababbbbaaaaabaaaabbbaabbbaabbabbabaaaabbaaaaaabbbaaababbaaaababbbaaabbbababa","aabbbabaaaabbbaabbbbaaaaaaabbababbabaaabbaaabbaababaabbbababbbbabaaababbbaaaaaaba","bbbbbabbbbabaaabbbbbbbbababbabbabababaaaaaabaabbaababbaaaabaabbbaaaabbbbbabaaabab","bbaaabaabaaabababaababbaaababbbbaaabbbaababababaaaabbbabbbbbaaabbaabbaaabbbbbaaaa","aabaabbaabbabbbbbbabbbbbbaabbbabbaaabbbaaabaaaaabaabaaabaabaabbababbbbbabbaabaaab","baaabaabaababbabbbbbaabbaaababaaababaababaaaaaabbbbaaabbbabbbabaaaaaaaaaaaaaaaaaa","bbaabaabaaaabaabaabaaaaaababababababbbaaabaabbbbaababbabbabbbababaabbbaabaababbba","ababaaababaabababbaabaabaaabaabaabbaababbabbbbababaaabbaabbbbbabbbaabbaaaabaaabbb","bbaabbababaabaabaaabaababaabbbaabbbbaaaaabbaaaaaabaabbabbaaaababbbaaababaababaaaa","abbababaaaaaaaababaabaabbbbaabaaabbaabaaabaabbaaaaaabaabbabbaabbbaaaaababbabbaabb","bbabbabaabbbaaaabaababababbaaabaaaabbabbabbabbaabbaaaaaabbbbbabbaaaaaaabbbaabbbba","bbbaabbabbbaabbaaaaaaabbbabbbbaabbbaabbabaabaabbabbbababbbabbbabbbbabbababaaaabaa","aabbaabbbaaaabababaababbaabbaaabbbbaabaababbaaabbbbababbbaababaaabbbabbaabaaabaaa","aabbaabaabaaaaabaabbbbaaabbabbbbaabbbabbaabbabaaabaaabbbbaaabbbbbabaaabababbaabab","babbaababbabbbbbbabbbabaaabbaaabaabababbaaaabbbabaaaabaabaabbababaabbabaaabaabaaa","bababaaaaababaabbaaaabbaaaabaabbbbabbababbaaababbbaababbbbbbbabaabbbabbbaabababba","aaababaababaabbbabbaaabbbabbbbabbbbbbaaaaababbaaabaaababbbaababababaabbaabbbbaaba","bababbaabababbbaaabaaaabbbabbbbbabaaababaaabbbababbaabaaababbaabbbbbbabababbabbba","abbabbbaabbabbbbbbabababaaaabaaababbaabbbbaaabbbabbbabbaaaaababbbaaabbabbbabbaaaa","babaaaaaaaaaaabaaabaaaabababababaaaaabbbbbbabbaababbbaabbaabbbababaaababbabbbbaab","bbabbbabbbaabaaabbbabbaababbbbababbbaabbababbabaaabbbabbabbbbbaabbabbaaaabbaabaaa","babaaabaaaababababbaabaabbbaabaaabbbbabaaabbababbaaaaabaabbbbbbbbabbbababbaababab","babbbbbaabbbbbbabbababbabbbbaabbabaababababbabbbbaaaaaabaabbababbbabbbbbaabaabbaa","bbabbbbabaaaaababbabaabbabbbaabbababbabaabababababbaababbabaaabbaaabaababbbbabbab","bbabababbabaaaabbabaabbbabbbaabbbaabbbaabbbbbbabaaabbbaabaabaaaaabababababaaaaaaa","abbbabababbabababbaaabbbbbaabbaaabbbbbaabbaaaaabbbbababbababaabaaaabbaababaaaaaaa","baabbaaabbbbaaabaabaabbaabbbbaaaaaababbbbabbaabaabbbaabbabbaaababbbbbbaabbbabbaba","baaabbbbbababaabababaaabbbbaaabaababbbbbbbbbabbbbbaaababaaaabbbbaabbaabaababbbbbb","bbaababbbabbbbaababaabbbaaabababbabaaaabbaabbbbbbaaabbbabbbbabbaabababbbbabbbbbba","bababaaaabaaaaabbbbbabababbbaabababaaaabbbbabbbbbbabaaabbaaaabbabbabaaaaababaaaab","bbbaaababbabbbbbabaaabbaaaabbbbbbbabaaaaabaaaabbbbbbaabbbaababbbaababaabaaaababaa","abbabaabbbabbbaaabbbbbbababbabaabbaabababababaabbaabbabaaaaaabaaaabbaaaababaabbba","aababaaabbbbbbbbbbbaaabaabaaabbbaaaabaaabaabaabbbaabbbaababaababababaabbababaabaa","abbabbaaaabbaabbbababbbbbbaaabbbaaaaaaaababbaabbaabbababbbaabbbbbbbabaabbbaaababb","aababaaaababbaaaaaaababaabbabbaaaaababaabbabbaaaaabbbaabbaabbaabbbbbbaaaabbbbabab","bbbaaababaaabbbaaabbbbabaaabbabbaabbbbbaabababbbaababbbbaaaabbbabbbbbaaabbababbba","babbbaabbbaabbbbbaaababbbaababbbababaabaaababbaaaababaaabbbaaaaaabbabaaabaabaaaab","abbbbababaababbbbbbbbababababbaaaaabbaabbababaabaaabaaaabbbabbbaabbaaababaabaaaba","aabbbaaaaababbbaaaaaabaaababbbabaabbabbaababbbabaaaaaaaaabbabbbabaabbbabbbbbbabbb","baaaabababbaabbbaabbbababaaabababbbaabaabbaabbaabbbbababbababbbaaaaababbbbbaaabaa","babbaabababaaabbbaaaaaabbbabbabbbbaaaabbaaaaabbbbababaaabbbabbaababababbaaaababaa","bbaaaabbabbbaabbbaaabaaabaababbbbbbabbbbaaaabbbbbabaaaaabbabbababbbabbabbaabbaaab","aabbbaabbabbabababbbabbbbbabbaabbbbababbbabaaaaababababaaaabbbbaabaaaababbababbbb","bbabbbabbaaabaaaabababbaabaabaaaabbbbaaaaabbaabaabbbbaaaaaabbbbbaaaabbbaabaabbabb","bbbaaaabbbbbbabbbbbbaaabaaaaabbabaababbabbbbabaabbabaabaaababbbabababbbaaaababaaa","bbaabbaababbaaabbbbaabbbaabaababbabbbaaababbbababaaaabbaababaababbbababbababaaaab","abaaaaaaababaaabbbaaababaabbbbbbbabbbbbaababbbbabbbbaabaaaaabaaaabbaaababbbabbaba","baaaaababbbbbbabbbbaaababaaabbababaaabbbbbbbbabbbabbbbaaaaaaaabbbbbaabbabaaaabbbb","abaaaabbbbabababbaabaababbabbababbbabababbabbbabbbbbaaaaaababbabbabaabbababaababb","aabbabbabbbabaabbbaabbbaaaabbabaababbbaaabaababbaababbaaabaabaaabbbaaabbbaabbabba","bbaabbaababbababababaabbabbbbbbabaaababbaababaabbaaabababbbbabaaaaabaabbabbaaaabb","bbbababbaaaaabbaabbbaaaaaaaabaaababaaaaaaabaaabaabaabbaabaabbbbbabbbababbabbaabbb","abaaaabaaabaabababbababbbbbaabbbaaabbbababbbaabaabbababbaaabbbbaaaaabbababbbababb","aaababababaababbbaaaaaaababbabaaaaabbabbabababababaabbbbabbbbaaababaabaababbababb","abbabbbabababaabaabbbbaaaaababaababbabbbbabbbbbababaababbaaaabaabbababaaaabbaaabb","aaaaababbaaaaabaaabbabaaabbbabbaaaabaabbabbababbbaaaabbaaababbbabbabbabaabbbaaaba","aaaaaaabbbaabbbabbbabbbaaabbabbbabaabbbaaabababbbaaaabaababbabbaabbbbaaabbbbbbbba","abaaabaabbbaabbbaabbaababbaabbaaabaababbbaababbabaabaabbabaabbbbbbabbaaaabbbbbbab","aaababaabababbaabbbaababbaabaabbaabababbabbbaabbababaaabaaababbaabbaaaababababaab","abbbbbaaababababbaabababbbbbbaabaabbbabbbbaaaaaaaaaababbbabaaaaababbaaababbbbbaba","babbbbabaabaabbaabababbbababbabbbabaabababbbbaabaabbbababbbbabbbbbabbbbabbbbaaaba","ababbabbbabaaabaabababbbaabaabababbbbbaabbbaaabbaabaaaabbbababbbbabbbbbabaaabbbab","babaaaababbaabbabbaaabbbaababbbabbbbaababbbabaabaaabbaabaabababbbababaababbbaaaab","bbbbabbaaababaaababbabaababbabaaaaaabaabbbabbaaabbbbbbabbbaabbababaaababaabababaa","babbaabbbbbaababbabbbabbbaaaabaababaaaaabababaabbbbaaaaaaaaabbbaaabaabbbabbababba","aaaabbaabaaabbbaabbbabaaabaaaabaababbaabbabaaabbabbaabbababbababbbbbbaaabaabababb","abbbababbaaabbaaabaaabaabbbbbbaabbbaabbabbbabbbbaaaabbbabbbbaaabbabbbaaabababaabb","bbbbbbaaaaababbabbababbbaabbbbbbaaabaaaababaababbbaaaabbabbbabbbbbbbbbbaaaaababab","baaabbbabaabaababbabaabababbaabaaabaaaaaaaabbbaabbaabbbaaaabbaaaaaabababbbaabaaab","bbabbbaaaaaaaabbaabababaaaabbbbbbbaaabbbaabbaabbabbbaaabbbbababbaabbbaaaaaaaabbba","ababbaaaaaaaaaaabaabbaabaaababaaaaababbbabbbbaaaaababbabbbaabaabbbbbaababaabbbbaa","bbaabababaaabbababbbaaabaaabbbaaaaababbbbababaaabaaaabbabbbaabbbbbabaaabaabaaabaa","ababbabbbabbabaabaabbabababbabbbabbabaaaaaababbabbbaababbabaaabaaaabaabbbababbbaa","bbbbbabbabaaaabbaaabbbabababbaaabbababaaaabaaabaabbababaaabbbbabbbabbbbabbbbaabaa","bbbbbbabaabbbaaaaabaaaaababbabbabababaaaabaaabbbbbbaababbaabbbbabaabbbbbaaabbbabb","bbbaaaabbbbabbaaaaaaabbbbabaaabbabaaaaabbbaabbbbaaabaabbbbbbababbabbbaaabbaabaabb","abaaababaaaabbbbabbabababaabbbaabbbabaabbbaabbbaabaabaaaabbabaaabaabaababababaaba","bbbabbbbabaababaaabaabbbaaababaaabaababaaaaaabbbaaabaaaababbbababaabbbbabbabbabaa","aabaababbaaabaaabaaaabbabbbbbbbbbbbbabaabaaaaaaabbababaabbbabbaaaaabaaabbaaabbabb","baabbbaaababaaaaabababababbaaabaaaaabbbabaababaaabbabbabbaaaaaabaabbabbbbabbbaaab","bbabbbaaabbbbaaabaabbaabbabaabbbbbaaabbabbabbaabbbaaaaaabbaabababbbbbaaabbbbaabaa","ababbbbbabbaaaaabbaabbbaabababaabbaaabaabaabaabbaaabbababbbabbbbbbbbaaaababaabaab","aaababaababbbaaaabbabbbabbaaabaaabaaabaaaababaabaaaaaaaaabaabaabaaabbababaaaaabba","abbbabbabbabbabaabababbababaabaabbbabbaabbbbabaaabaaaaaabbaabbbbaabaababbabbbaaaa","aabbaaaaaabaababbabaaaaaaaaabbababbbabaaaaabaabaabaababaabaaabaabababbabaaaaabbaa","bbbbabbbabbaaabbaaaabbabababaabaabbaaababbaabaabbbabababaaabaababbabbaaabaaaaaaaa","abbbaabbaaaabaaaabaaaaaaaaababaaaabbabbbaabaabababbaabaaaaaaababbaabbabbbaaabbabb","bbbbaabbbaaaaaabaaabaababababbabbaabababaabbbbbbabaabbbbabaabaababbbaaababbbabbaa","abbabbbabbaabbaabbbbaaabbaaabbaabbbbbbbbaabbaabbbaaabbaabbbabbabaaababababababaab","bababbabbbaaaaaaaaabaaababababababbbbaaaaaaabaabaaabbbaaaaabbbaabbababaaabaabbaab","bbbbaabbbbbabbaabaaaabbbaabbabaaaabababbababbbbabbbbbbabaabbaabaaaabbabbaabbbaaba","ababaaabbabababbabbbbbabbaabaaababbbbaaabbabbbbabbaababbbbbaaaabbabbbbaaaabaabbba","aaaaababaabbabbaababbbaaababaabaaabbbbbaabaaababaabababbbbbbaabbaaabbaabababaabaa"]
// "aababbbabaabbabaabaaaabaabbbaabbbaababaabbaabaabbbabababbbbbaaabbaabbbbaaabbaaabba"