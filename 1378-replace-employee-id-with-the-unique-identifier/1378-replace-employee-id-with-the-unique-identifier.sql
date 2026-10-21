/* Write your PL/SQL query statement below */
select eu.unique_id, e.name
from Employees e
left join employeeuni eu
on e.id=eu.id