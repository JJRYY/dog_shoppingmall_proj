select user(), database();

-- selectList
select id, kind, price, image, country, height, weight, content, readcount from dog;

-- select
select id, kind, price, image, country, height, weight, content, readcount from dog where id = 1;

-- update readcount
update dog set readcount = readcount + 1 where id = ?;

-- insert dog
insert into dog(kind, price, image, country, height, weight, content, readcount) values ('삽살개', 5000, 'sap.jpg', '한국', 1, 20, '눈 안 보임', 0);

delete from dog where id = 6;