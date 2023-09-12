class Solution {
 public:
  int scheduleCourse(vector<vector<int>>& courses) {
    sort(courses.begin(), courses.end(),
         [](const auto& c0, const auto& c1) { return c0[1] < c1[1]; });

    priority_queue<int> q;
    // 优先队列中所有课程的总时间
    int total = 0;

    for (const auto& course : courses) {
      int ti = course[0], di = course[1];
      total += ti;
      q.push(ti);
      if (total > di) {
        total -= q.top();
        q.pop();
      }
    }

    return q.size();
  }
};
