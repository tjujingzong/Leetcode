import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1626 lang=java
 *
 * [1626] Best Team With No Conflicts
 */

// @lc code=start
class Solution {
  public class Player {
    int age;
    int score;

    public Player(int age, int score) {
      this.age = age;
      this.score = score;
    }
  }

  public int bestTeamScore(int[] scores, int[] ages) {
    int n = scores.length;
    Player[] players = new Player[n];
    for (int i = 0; i < n; i++) {
      players[i] = new Player(ages[i], scores[i]);
    }
    Arrays.sort(players, ((o1, o2) -> {
      if (o1.age == o2.age) {
        return o1.score - o2.score;
      }
      return o1.age - o2.age;
    }));
    int[] dp = new int[n];
    dp[0] = players[0].score;
    int max = dp[0];
    for (int i = 0; i < n; i++) {
      dp[i] = players[i].score;
      for (int j = i - 1; j >= 0; j--) {
        if (players[j].score <= players[i].score) {
          dp[i] = Math.max(dp[i], dp[j] + players[i].score);
        }
      }
      max = Math.max(max, dp[i]);
    }
    return max;
  }
}
// @lc code=end
