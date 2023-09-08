/*
 * @lc app=leetcode.cn id=143 lang=cpp
 *
 * [143] Reorder List
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
  void reorderList(ListNode* head) {
    vector<ListNode*> v;
    while (head != nullptr) {
      v.push_back(head);
      head = head->next;
    }
    int i = 0, j = v.size() - 1;
    while (i < j) {
      v[i]->next = v[j];
      i++;
      if (i == j) {
        break;
      }
      v[j]->next = v[i];
      j--;
    }
    v[i]->next = nullptr;
    return;
  }
};
// @lc code=end
