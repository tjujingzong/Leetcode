/*
 * @lc app=leetcode.cn id=141 lang=cpp
 *
 * [141] Linked List Cycle
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
 public:
  bool hasCycle(ListNode* head) {
    if (head == nullptr)
      return false;
    int cnt = 0;
    while (head->next != nullptr) {
      head = head->next;
      cnt++;
      if (cnt > 10000) {
        return true;
      }
    }

    return false;
  }
};
// @lc code=end
