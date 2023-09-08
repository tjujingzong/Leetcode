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
  ListNode* doubleIt(ListNode* head) {
    string n = "";
    n += (head->val + '0');
    while (head->next != nullptr) {
      n += (head->next->val + '0');
      head = head->next;
    }
    reverse(n.begin(), n.end());
    string s = "";
    int flag = 0;
    
    for (int i = 0; i < n.size(); i++) {
      int cur = n[i] - '0';
      cur *= 2;
      cur += flag;
      if (cur >= 10) {
        flag = 1;
        s += (cur % 10 + '0');
      } else {
        flag = 0;
        s += (cur + '0');
      }
    }
    if (flag == 1) {
      s += '1';
    }
    reverse(s.begin(), s.end());
    vector<ListNode*> v;
    for (int i = 0; i < s.size(); i++) {
      v.push_back(new ListNode(s[i] - '0'));
    }
    for (int i = 0; i < s.size() - 1; i++) {
      v[i]->next = v[i + 1];
    }
    return v[0];
  }
};