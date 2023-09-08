--
-- @lc app=leetcode.cn id=178 lang=mysql
--
-- [178] 分数排名
--
-- @lc code=start
# Write your MySQL query statement below
select score,
  dense_rank() over (
    order by score desc
  ) as 'rank'
from scores;
from scores -- @lc code=end