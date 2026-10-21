/* Write your PL/SQL query statement below */
select p.product_name, s.year, s.price
from sales s
inner join product p
on s.product_id=p.Product_id