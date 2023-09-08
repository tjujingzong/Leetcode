import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  public int[][] spiralMatrix(int m, int n, ListNode head) {
    int[][] matrix = new int[m][n];
    int upper_bound = 0, lower_bound = m - 1;
    int left_bound = 0, right_bound = n - 1;
    int count = 0;
    ArrayList <Integer> l=new ArrayList<>();
    while(head!=null){
      l.add(head.val);
      head=head.next;
    }
    for(int i=0;i<m;i++)
    Arrays.fill(matrix[i], -1);
    while (count < l.size()) {
        // 从左到右
        // 「上边界」要在「下边界」上面
        if (upper_bound <= lower_bound) {
            // 从「左边界」开始，到「右边界」截止
            for (int j = left_bound; j <= right_bound; j++) {
                if (count>=l.size()) break;
                matrix[upper_bound][j] = l.get(count);
                count++;
            }
            // 「上边界」下移
            upper_bound++;
        }

        // 从上到下
        // 「右边界」要在「左边界」右边
        if (right_bound >= left_bound) {
            // 从「上边界」开始，到「下边界」截止
            for (int i = upper_bound; i <= lower_bound; i++) {
              if (count>=l.size()) break;
                matrix[i][right_bound] = l.get(count);
                count++;
            }
            // 「右边界」左移
            right_bound--;
        }

        // 从右到左
        // 「下边界」要在「上边界」下面
        if (lower_bound >= upper_bound) {
            // 从「右边界」开始，到「左边界」截止
            for (int j = right_bound; j >= left_bound; j--) {
              if (count>=l.size()) break;
                matrix[lower_bound][j] = l.get(count);
                count++;
            }
            // 「下边界」上移
            lower_bound--;
        }

        // 从下到上
        // 「左边界」要在「右边界」左边
        if (left_bound <= right_bound) {
            // 从「下边界」开始，到「上边界」截止
            for (int i = lower_bound; i >= upper_bound; i--) {
              if (count>=l.size()) break;
                matrix[i][left_bound] = l.get(count);
                count++;
            }
            // 「左边界」右移
            left_bound++;
        }
    }
    return matrix;
  }
}