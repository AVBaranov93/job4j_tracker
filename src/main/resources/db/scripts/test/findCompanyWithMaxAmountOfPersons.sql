select c.name, count(p.*) from company c join person p on p.company_id = c.id
group by c.name
having count(p.name) =
(select count(id) from person
group by company_id
order by count(id) desc
limit 1)