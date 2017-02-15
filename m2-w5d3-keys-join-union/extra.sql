-- Display all the films and their language
select f.title, l.name from film f inner join language l on f.language_id=l.language_id;

-- Display all the films and in English
select f.title, l.name from film f inner join language l on f.language_id=l.language_id where l.name='English';

-- Display all the films with their category
select f.title, c.name 
from film f 
inner join film_category fc on f.film_id=fc.film_id
inner join category c on fc.category_id=c.category_id;

-- Display all the films with a category of Horror
select f.title, c.name 
from film f 
inner join film_category fc on f.film_id=fc.film_id
inner join category c on fc.category_id=c.category_id
where c.name='Horror';

-- Display all the films with a category of Horror and title that begins with the letter F
select f.title, c.name 
from film f 
inner join film_category fc on f.film_id=fc.film_id
inner join category c on fc.category_id=c.category_id
where c.name='Horror' and f.title like 'F%';

-- Display the number of rentals made by each customer ordered from highest to lowest
/* SQL
select c.last_name + ', ' + c.first_name, count(r.rental_id) rentals from rental r
inner join customer c on c.customer_id=r.customer_id
group by c.last_name, c.first_name
order by rentals desc;
*/

/* Postgres
select c.last_name || ', ' || c.first_name, count(r.rental_id) rentals from rental r
inner join customer c on c.customer_id=r.customer_id
group by c.last_name, c.first_name
order by rentals desc;
*/