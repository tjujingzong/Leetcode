import java.util.HashSet;
import java.util.Set;

class Solution {
  int res = 6;
  int lenhand;
  Set<String> vis = new HashSet<>();
  public int findMinStep(String board, String hand) {
      lenhand = hand.length();
      dfs(board, hand);
      return res == 6 ? -1 : res;
  }

  private void dfs(String board, String hand) {
      if (board.length() == 0){
          res = Math.min(lenhand - hand.length(), res);
          return;
      }
      if (hand.length() == 0) return;
      for (int i = 0; i < board.length(); i++) {
          for (int j = 0; j < hand.length(); j++) {
              String s = board.substring(0,i) + hand.charAt(j) + board.substring(i);
              if (vis.add(s)){
                  dfs(eliminate(s) , hand.substring(0,j) + hand.substring(j + 1));
              }
          }
      }
  }

  private String eliminate(String board) {
      for (int left = 0, right = 0; right <= board.length(); right++) {
          if (right < board.length() && board.charAt(right) == board.charAt(left)) continue;
          if (right - left >= 3) {
              board = board.substring(0, left) + board.substring(right);
              right = 0;
          }
          left = right;
      }
      return board;
  }
}
