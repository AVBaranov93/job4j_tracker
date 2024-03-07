select p.name, c.name from person p join company c on p.company_id = c.id
where p.id in (select id from person where company_id <> 5);