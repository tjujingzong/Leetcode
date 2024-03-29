--
-- @lc app=leetcode.cn id=197 lang=mysql
--
-- [197] Rising Temperature
--
-- @lc code=start
# Write your MySQL query statement below
SELECT w2.Id
FROM Weather w1,
  Weather w2
WHERE DATEDIFF(w2.RecordDate, w1.RecordDate) = 1
  AND w1.Temperature < w2.Temperature 
  
  -- @lc code=end