-- INNER JOINS

-- Who made payment 16666
SELECT * 
FROM payment
WHERE payment_id =  16666;



-- How would we get the customer's name and not the customer id
select *, first_name, last_name from payment
JOIN customer ON payment.customer_id = customer.customer_id
where payment_id = 16666;


-- Since * brings everything from both tables, let's just narrow it to
-- everything from paynent and first, last name of customer
select payment.*, customer.first_name, customer.last_name from payment
JOIN customer ON payment.customer_id = customer.customer_id
where payment_id = 16666;


-- When did they return it? How could we get that data from the rental table
select payment.*, customer.first_name, customer.last_name, rental.return_date from payment
JOIN customer ON payment.customer_id = customer.customer_id
JOIN rental ON rental.rental_id = payment.rental_id
where payment_id = 16666;


-- What did they rent? Can we use the rental inventory id to get the film id?
select payment.*, customer.first_name, customer.last_name, rental.return_date, film.title from payment
JOIN customer ON payment.customer_id = customer.customer_id
JOIN rental ON rental.rental_id = payment.rental_id
JOIN inventory ON inventory.inventory_id = rental.inventory_id
JOIN film ON film.film_id = inventory.film_id
where payment_id = 16666;



-- Lets bring back film id 948
select * from film where film_id=948;


-- But who acted in it? We can get a list of actors from a many to many:
select film.title, (actor.first_name + ' ' + actor.last_name) AS actor from film
JOIN film_actor ON film_actor.film_id = film.film_id
JOIN actor ON actor.actor_id = film_actor.actor_id
where film.film_id=948;

--What about the films and what stores they are in?
select f.title, c.city from store s
join inventory I on s.store_id = I.store_id
join film f on I.film_id = f.film_id
join address a on s.address_id = a.address_id
join city c on a.city_id = c.city_id;

-- More complex, who acted in what together?
select f.title, a1.first_name + ' ' + a1.last_name, a2.first_name + ' ' + a2.last_name from film f 
join film_actor fa1 on f.film_id = fa1.film_id 
join film_actor fa2 on f.film_id = fa2.film_id AND fa1.actor_id != fa2.actor_id
join actor a1 on fa1.actor_id = a1.actor_id 
join actor a2 on fa2.actor_id = a2.actor_id;






-- LEFT OUTER JOINS FOR WORLD
-- Show all countries and their capitals
select c.name, ci.name
from country c
join city ci ON c.capital = ci.id;

-- we are missing some entries though, only 232 when there are in fact 239

select c.name, ci.name
from country c
LEFT JOIN city ci ON c.capital = ci.id




-- UNIONS
-- Gathers a list of all first names used by actors and customers
-- By default removes duplicates
select first_name from actor
union
select first_name from customer order by first_name;


-- Gather the list, but this time note the source table with 'A' for actor and 'C' for customer
select first_name, 'A' as source from actor
union
select first_name, 'C' as source from customer order by first_name;

-- Just for fun, count how many distict first names there are for actors, and how many for customers
select first_name, 'A' as source from actor
union
select first_name, 'C' as source from customer order by first_name;
