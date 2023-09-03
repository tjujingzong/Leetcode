/*
 * @lc app=leetcode.cn id=23 lang=cpp
 *
 * [23] Merge k Sorted Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
 public:
  ListNode* mergeKLists(vector<ListNode*>& lists) {
    ListNode *ans = NULL, *t;
    int min = INT_MAX;
    int min_index = 0;
    int flag = 0;
    while (flag == 0) {
      flag = 1;
      for (int i = 0; i < lists.size(); i++) {
        if (lists[i] != NULL) {
          flag = 0;
          if (lists[i]->val < min) {
            min = lists[i]->val;
            min_index = i;
          }
        }
      }
      if (flag == 0) {
        if (ans == NULL) {
          ans = new ListNode(min);
          t = ans;
        } else {
          t->next = new ListNode(min);
          t = t->next;
        }
        lists[min_index] = lists[min_index]->next;
        min = INT_MAX;
      }
    }
    return ans;
  }
};
// @lc code=end
