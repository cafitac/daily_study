-- https://leetcode.com/problems/nth-highest-salary/?lang=pythondata

CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  SET N = N - 1;
RETURN (
      select distinct salary from Employee order by Employee.salary DESC limit N, 1
    );
END