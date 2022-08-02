--
-- @lc app=leetcode.cn id=177 lang=mysql
--
-- [177] 第N高的薪水
--
-- @lc code=start
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT BEGIN
DECLARE m INT;
SET m = N - 1;
RETURN (
  # Write your MySQL query statement below.
  SELECT ifnull(
      (
        SELECT DISTINCT salary
        FROM Employee
        ORDER BY salary DESC
        LIMIT m, 1
      ), NULL
    )
);
END 
-- @lc code=end