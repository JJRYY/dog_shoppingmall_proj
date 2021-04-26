-- 계정 권한 부여
drop user 'user_shoppingmall'@'localhost';

grant all 
   on shoppingmall.* 
   to 'user_shoppingmall'@'localhost' identified by 'rootroot';

-- file 권한(backup, load) -- root만 권한 부여 가능
GRANT File 
   ON *.* 
   TO 'user_shoppingmall'@'localhost';