```shell
docker ps -a
docker pull mysql:latest
docker run -p 3306:3306 --name lchMysql -e MYSQL_ROOT_PASSWORD=321654 -d mysql
docker exec -it lchMysql /bin/sh
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

insert into user values('1', 'liuchanghong');

```