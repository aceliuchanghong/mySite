```shell
docker ps -a
docker images

docker pull mysql:latest
docker run -p 3306:3306 --name lchMysql -e MYSQL_ROOT_PASSWORD=321654 -d mysql
docker exec -it lchMysql /bin/sh

docker pull mongo:latest
docker run -itd --name lchmongo -p 27017:27017 mongo --auth
# docker exec -it lchmongo mongo admin
docker exec -it lchmongo mongosh admin
```

```xml

<mirrors>
    <mirror>
        <id>aliyun-public</id>
        <mirrorOf>*</mirrorOf>
        <name>aliyun public</name>
        <url>https://maven.aliyun.com/repository/public</url>
    </mirror>
</mirrors>
```

```mysql
create schema schema_liu;

CREATE TABLE user
(
    id   VARCHAR(20),
    name VARCHAR(50)
);

select *
from user;
insert into user
values ('1', 'liuchanghong');
insert into user
values ('2', 'Lawrence');
insert into user
values ('3', 'Gukeyan');


CREATE TABLE student
(
    sno   CHAR(90) NOT NULL PRIMARY KEY COMMENT '学生ID',
    sname CHAR(40) NOT NULL COMMENT '姓名',
    ssex  CHAR(20) COMMENT '性别',
    sage  SMALLINT COMMENT '年龄',
    sdept CHAR(200) COMMENT '所在系'
);
CREATE TABLE course
(
    cno     CHAR(40)  NOT NULL PRIMARY KEY COMMENT '课程ID',
    cname   CHAR(40) NOT NULL COMMENT '课程名',
    cpno    CHAR(40) COMMENT '先行课（参照自身，Cno）',
    ccredit SMALLINT COMMENT '学分'
);
CREATE TABLE sc
(
    sno   CHAR(90) NOT NULL COMMENT '学生ID（参照student，Cno）',
    cno   CHAR(40) NOT NULL COMMENT '课程ID（参照course，Cno）',
    grade SMALLINT COMMENT '成绩'
);
CREATE TABLE orders
(
    id  CHAR(20) NOT NULL COMMENT '订单id',
    ordername  CHAR(20) NOT NULL COMMENT '货物名称',
    uid  CHAR(20) NOT NULL COMMENT '客户'
);

insert into student
values ('1', 'Lawrence', 'M', 25, 'Math');

insert into orders
values ('1', '水', '1');
insert into orders
values ('2', '糖', '3');

```

```vue
1.安装vue插件
2.安装 Node.js 和 npm (https://www.liaoxuefeng.com/wiki/1022910821149312/1023025597810528)
3.npm install element-ui -S
4.创建项目 (https://www.jb51.net/article/242011.htm)
```

```url
springboot:https://www.bezkoder.com/spring-boot-vue-js-mysql/#Spring_Boot_Back-end
```

```sql
-- mongo
-- 创建一个名为 admin，密码为 123456 的用户。
db
.
createUser
({ user:'admin',pwd:'123456',roles:[ { role:'userAdminAnyDatabase', db: 'admin'},"readWriteAnyDatabase"]});
db.auth
('admin', '123456')

use mongoTest
db
show dbs
db.mongoTest.insertOne({"lch":"lchTest"})
```
### https://open.yesapi.cn/list79.html
## 表结构设计
### 涉及用户参与
- 用户信息表

### 仅网站owner参与
- 数据相关

- 操作相关

















