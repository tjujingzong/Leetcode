import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;

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

    // 使用优先队列替换Queue，并提供一个比较器来比较步数
    PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    queue.add(new int[] { 0, 0, 0 });
    int ans = Integer.MAX_VALUE;

    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      int x = cur[0] / cols;
      int y = cur[0] % cols;
      int step = cur[1];
      int i = cur[2];
      int idx = mantra.charAt(i) - 'a';
      for (int j = 0; j < pos[idx].length; j++) {
        int nx = pos[idx][j] / cols;
        int ny = pos[idx][j] % cols;
        int nstep = step + Math.abs(nx - x) + Math.abs(ny - y) + 1;
        if (i == mantra.length() - 1) {
          ans = Math.min(ans, nstep);
        } else {
          queue.add(new int[] { pos[idx][j], nstep, i + 1 });
        }
      }
    }
    return ans;
  }

}
// ["hydfpyqaoir","ixpjveolliy","hidhpqciygm","icnefohovue","qcwopbcbxbn","dvahetjbfqg","uiwjsukwofm","spzjegbovxo","aflruwmvkdp"]
// "nrahvcpkmqgsyrcpmgfpmaxvydbp"
// ["aaabaaabbbabaabaababaababbaabbbabbabbabaaabbbbaaabaababababaaaababbbbbaaaaabaabaa","aaaaabbaaabbbabbaabbaaabbbabbabbbbaaabbbbaabbbabbbabbbaabbbbabaabbbbabababaabaaab","abaaababaaaaaaababbbbbbaaaabbbbbabbbabaaaaaabbbbaababbaaaabbbbbabababbbbaaaaabaab","babbababaabaabbbabbababababbabaabaabbabbbababbabbbbbbbaababaabbabbabababbaabaabbb","babbabbbaabaababbabaaaaaababababbabaabababbbbaaabbbbabbbbbbabbabbbbbaaabaabaaaabb","baabbababbbbaaaaabaaaabbbaabbbaabbabbabaaaabbaaaaaabbbaaababbaaaababbbaaabbbababa","aabbbabaaaabbbaabbbbaaaaaaabbababbabaaabbaaabbaababaabbbababbbbabaaababbbaaaaaaba","bbbbbabbbbabaaabbbbbbbbababbabbabababaaaaaabaabbaababbaaaabaabbbaaaabbbbbabaaabab","bbaaabaabaaabababaababbaaababbbbaaabbbaababababaaaabbbabbbbbaaabbaabbaaabbbbbaaaa","aabaabbaabbabbbbbbabbbbbbaabbbabbaaabbbaaabaaaaabaabaaabaabaabbababbbbbabbaabaaab","baaabaabaababbabbbbbaabbaaababaaababaababaaaaaabbbbaaabbbabbbabaaaaaaaaaaaaaaaaaa","bbaabaabaaaabaabaabaaaaaababababababbbaaabaabbbbaababbabbabbbababaabbbaabaababbba","ababaaababaabababbaabaabaaabaabaabbaababbabbbbababaaabbaabbbbbabbbaabbaaaabaaabbb","bbaabbababaabaabaaabaababaabbbaabbbbaaaaabbaaaaaabaabbabbaaaababbbaaababaababaaaa","abbababaaaaaaaababaabaabbbbaabaaabbaabaaabaabbaaaaaabaabbabbaabbbaaaaababbabbaabb","bbabbabaabbbaaaabaababababbaaabaaaabbabbabbabbaabbaaaaaabbbbbabbaaaaaaabbbaabbbba","bbbaabbabbbaabbaaaaaaabbbabbbbaabbbaabbabaabaabbabbbababbbabbbabbbbabbababaaaabaa","aabbaabbbaaaabababaababbaabbaaabbbbaabaababbaaabbbbababbbaababaaabbbabbaabaaabaaa","aabbaabaabaaaaabaabbbbaaabbabbbbaabbbabbaabbabaaabaaabbbbaaabbbbbabaaabababbaabab","babbaababbabbbbbbabbbabaaabbaaabaabababbaaaabbbabaaaabaabaabbababaabbabaaabaabaaa","bababaaaaababaabbaaaabbaaaabaabbbbabbababbaaababbbaababbbbbbbabaabbbabbbaabababba","aaababaababaabbbabbaaabbbabbbbabbbbbbaaaaababbaaabaaababbbaababababaabbaabbbbaaba","bababbaabababbbaaabaaaabbbabbbbbabaaababaaabbbababbaabaaababbaabbbbbbabababbabbba","abbabbbaabbabbbbbbabababaaaabaaababbaabbbbaaabbbabbbabbaaaaababbbaaabbabbbabbaaaa","babaaaaaaaaaaabaaabaaaabababababaaaaabbbbbbabbaababbbaabbaabbbababaaababbabbbbaab","bbabbbabbbaabaaabbbabbaababbbbababbbaabbababbabaaabbbabbabbbbbaabbabbaaaabbaabaaa","babaaabaaaababababbaabaabbbaabaaabbbbabaaabbababbaaaaabaabbbbbbbbabbbababbaababab","babbbbbaabbbbbbabbababbabbbbaabbabaababababbabbbbaaaaaabaabbababbbabbbbbaabaabbaa","bbabbbbabaaaaababbabaabbabbbaabbababbabaabababababbaababbabaaabbaaabaababbbbabbab","bbabababbabaaaabbabaabbbabbbaabbbaabbbaabbbbbbabaaabbbaabaabaaaaabababababaaaaaaa","abbbabababbabababbaaabbbbbaabbaaabbbbbaabbaaaaabbbbababbababaabaaaabbaababaaaaaaa","baabbaaabbbbaaabaabaabbaabbbbaaaaaababbbbabbaabaabbbaabbabbaaababbbbbbaabbbabbaba","baaabbbbbababaabababaaabbbbaaabaababbbbbbbbbabbbbbaaababaaaabbbbaabbaabaababbbbbb","bbaababbbabbbbaababaabbbaaabababbabaaaabbaabbbbbbaaabbbabbbbabbaabababbbbabbbbbba","bababaaaabaaaaabbbbbabababbbaabababaaaabbbbabbbbbbabaaabbaaaabbabbabaaaaababaaaab","bbbaaababbabbbbbabaaabbaaaabbbbbbbabaaaaabaaaabbbbbbaabbbaababbbaababaabaaaababaa","abbabaabbbabbbaaabbbbbbababbabaabbaabababababaabbaabbabaaaaaabaaaabbaaaababaabbba","aababaaabbbbbbbbbbbaaabaabaaabbbaaaabaaabaabaabbbaabbbaababaababababaabbababaabaa","abbabbaaaabbaabbbababbbbbbaaabbbaaaaaaaababbaabbaabbababbbaabbbbbbbabaabbbaaababb","aababaaaababbaaaaaaababaabbabbaaaaababaabbabbaaaaabbbaabbaabbaabbbbbbaaaabbbbabab","bbbaaababaaabbbaaabbbbabaaabbabbaabbbbbaabababbbaababbbbaaaabbbabbbbbaaabbababbba","babbbaabbbaabbbbbaaababbbaababbbababaabaaababbaaaababaaabbbaaaaaabbabaaabaabaaaab","abbbbababaababbbbbbbbababababbaaaaabbaabbababaabaaabaaaabbbabbbaabbaaababaabaaaba","aabbbaaaaababbbaaaaaabaaababbbabaabbabbaababbbabaaaaaaaaabbabbbabaabbbabbbbbbabbb","baaaabababbaabbbaabbbababaaabababbbaabaabbaabbaabbbbababbababbbaaaaababbbbbaaabaa","babbaabababaaabbbaaaaaabbbabbabbbbaaaabbaaaaabbbbababaaabbbabbaababababbaaaababaa","bbaaaabbabbbaabbbaaabaaabaababbbbbbabbbbaaaabbbbbabaaaaabbabbababbbabbabbaabbaaab","aabbbaabbabbabababbbabbbbbabbaabbbbababbbabaaaaababababaaaabbbbaabaaaababbababbbb","bbabbbabbaaabaaaabababbaabaabaaaabbbbaaaaabbaabaabbbbaaaaaabbbbbaaaabbbaabaabbabb","bbbaaaabbbbbbabbbbbbaaabaaaaabbabaababbabbbbabaabbabaabaaababbbabababbbaaaababaaa","bbaabbaababbaaabbbbaabbbaabaababbabbbaaababbbababaaaabbaababaababbbababbababaaaab","abaaaaaaababaaabbbaaababaabbbbbbbabbbbbaababbbbabbbbaabaaaaabaaaabbaaababbbabbaba","baaaaababbbbbbabbbbaaababaaabbababaaabbbbbbbbabbbabbbbaaaaaaaabbbbbaabbabaaaabbbb","abaaaabbbbabababbaabaababbabbababbbabababbabbbabbbbbaaaaaababbabbabaabbababaababb","aabbabbabbbabaabbbaabbbaaaabbabaababbbaaabaababbaababbaaabaabaaabbbaaabbbaabbabba","bbaabbaababbababababaabbabbbbbbabaaababbaababaabbaaabababbbbabaaaaabaabbabbaaaabb","bbbababbaaaaabbaabbbaaaaaaaabaaababaaaaaaabaaabaabaabbaabaabbbbbabbbababbabbaabbb","abaaaabaaabaabababbababbbbbaabbbaaabbbababbbaabaabbababbaaabbbbaaaaabbababbbababb","aaababababaababbbaaaaaaababbabaaaaabbabbabababababaabbbbabbbbaaababaabaababbababb","abbabbbabababaabaabbbbaaaaababaababbabbbbabbbbbababaababbaaaabaabbababaaaabbaaabb","aaaaababbaaaaabaaabbabaaabbbabbaaaabaabbabbababbbaaaabbaaababbbabbabbabaabbbaaaba","aaaaaaabbbaabbbabbbabbbaaabbabbbabaabbbaaabababbbaaaabaababbabbaabbbbaaabbbbbbbba","abaaabaabbbaabbbaabbaababbaabbaaabaababbbaababbabaabaabbabaabbbbbbabbaaaabbbbbbab","aaababaabababbaabbbaababbaabaabbaabababbabbbaabbababaaabaaababbaabbaaaababababaab","abbbbbaaababababbaabababbbbbbaabaabbbabbbbaaaaaaaaaababbbabaaaaababbaaababbbbbaba","babbbbabaabaabbaabababbbababbabbbabaabababbbbaabaabbbababbbbabbbbbabbbbabbbbaaaba","ababbabbbabaaabaabababbbaabaabababbbbbaabbbaaabbaabaaaabbbababbbbabbbbbabaaabbbab","babaaaababbaabbabbaaabbbaababbbabbbbaababbbabaabaaabbaabaabababbbababaababbbaaaab","bbbbabbaaababaaababbabaababbabaaaaaabaabbbabbaaabbbbbbabbbaabbababaaababaabababaa","babbaabbbbbaababbabbbabbbaaaabaababaaaaabababaabbbbaaaaaaaaabbbaaabaabbbabbababba","aaaabbaabaaabbbaabbbabaaabaaaabaababbaabbabaaabbabbaabbababbababbbbbbaaabaabababb","abbbababbaaabbaaabaaabaabbbbbbaabbbaabbabbbabbbbaaaabbbabbbbaaabbabbbaaabababaabb","bbbbbbaaaaababbabbababbbaabbbbbbaaabaaaababaababbbaaaabbabbbabbbbbbbbbbaaaaababab","baaabbbabaabaababbabaabababbaabaaabaaaaaaaabbbaabbaabbbaaaabbaaaaaabababbbaabaaab","bbabbbaaaaaaaabbaabababaaaabbbbbbbaaabbbaabbaabbabbbaaabbbbababbaabbbaaaaaaaabbba","ababbaaaaaaaaaaabaabbaabaaababaaaaababbbabbbbaaaaababbabbbaabaabbbbbaababaabbbbaa","bbaabababaaabbababbbaaabaaabbbaaaaababbbbababaaabaaaabbabbbaabbbbbabaaabaabaaabaa","ababbabbbabbabaabaabbabababbabbbabbabaaaaaababbabbbaababbabaaabaaaabaabbbababbbaa","bbbbbabbabaaaabbaaabbbabababbaaabbababaaaabaaabaabbababaaabbbbabbbabbbbabbbbaabaa","bbbbbbabaabbbaaaaabaaaaababbabbabababaaaabaaabbbbbbaababbaabbbbabaabbbbbaaabbbabb","bbbaaaabbbbabbaaaaaaabbbbabaaabbabaaaaabbbaabbbbaaabaabbbbbbababbabbbaaabbaabaabb","abaaababaaaabbbbabbabababaabbbaabbbabaabbbaabbbaabaabaaaabbabaaabaabaababababaaba","bbbabbbbabaababaaabaabbbaaababaaabaababaaaaaabbbaaabaaaababbbababaabbbbabbabbabaa","aabaababbaaabaaabaaaabbabbbbbbbbbbbbabaabaaaaaaabbababaabbbabbaaaaabaaabbaaabbabb","baabbbaaababaaaaabababababbaaabaaaaabbbabaababaaabbabbabbaaaaaabaabbabbbbabbbaaab","bbabbbaaabbbbaaabaabbaabbabaabbbbbaaabbabbabbaabbbaaaaaabbaabababbbbbaaabbbbaabaa","ababbbbbabbaaaaabbaabbbaabababaabbaaabaabaabaabbaaabbababbbabbbbbbbbaaaababaabaab","aaababaababbbaaaabbabbbabbaaabaaabaaabaaaababaabaaaaaaaaabaabaabaaabbababaaaaabba","abbbabbabbabbabaabababbababaabaabbbabbaabbbbabaaabaaaaaabbaabbbbaabaababbabbbaaaa","aabbaaaaaabaababbabaaaaaaaaabbababbbabaaaaabaabaabaababaabaaabaabababbabaaaaabbaa","bbbbabbbabbaaabbaaaabbabababaabaabbaaababbaabaabbbabababaaabaababbabbaaabaaaaaaaa","abbbaabbaaaabaaaabaaaaaaaaababaaaabbabbbaabaabababbaabaaaaaaababbaabbabbbaaabbabb","bbbbaabbbaaaaaabaaabaababababbabbaabababaabbbbbbabaabbbbabaabaababbbaaababbbabbaa","abbabbbabbaabbaabbbbaaabbaaabbaabbbbbbbbaabbaabbbaaabbaabbbabbabaaababababababaab","bababbabbbaaaaaaaaabaaababababababbbbaaaaaaabaabaaabbbaaaaabbbaabbababaaabaabbaab","bbbbaabbbbbabbaabaaaabbbaabbabaaaabababbababbbbabbbbbbabaabbaabaaaabbabbaabbbaaba","ababaaabbabababbabbbbbabbaabaaababbbbaaabbabbbbabbaababbbbbaaaabbabbbbaaaabaabbba","aaaaababaabbabbaababbbaaababaabaaabbbbbaabaaababaabababbbbbbaabbaaabbaabababaabaa"]
// "aababbbabaabbabaabaaaabaabbbaabbbaababaabbaabaabbbabababbbbbaaabbaabbbbaaabbaaabba"