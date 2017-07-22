# LoginSys
一个用Servlet写的注册登入系统，图片验证码！

## 建表语句
-------------------
CREATE TABLE IF NOT EXISTS webdb.t_users (
  user_name varchar(20) collate utf8_unicode_ci NOT NULL,
  password_md5 varchar(50) collate utf8_unicode_ci NOT NULL,
  email varchar(30) collate utf8_unicode_ci NOT NULL,
  PRIMARY KEY  (user_name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
