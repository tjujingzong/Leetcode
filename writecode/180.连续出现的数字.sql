--
-- @lc app=leetcode.cn id=180 lang=mysql
--
-- [180] 连续出现的数字
--
-- @lc code=start
# Write your MySQL query statement below
select DISTINCT aa.num as ConsecutiveNums
from (
    select a.id,
      a.num,
      row_number() over(
        order by id
      ) id_new,
      row_number() over(
        partition by num
        order by id
      ) num_new
    from logs a
  ) aa
group by aa.num,
(aa.id_new - aa.num_new)
HAVING count(*) >= 3;
-- @lc code=end