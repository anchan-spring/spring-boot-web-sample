# 3-MySQLコンテナを起動する

1. rootユーザにスイッチ
```
$ sudo su -
```

2. docker-compose.ymlを配置するフォルダを作成する
例：
```
$ pwd
/home/vagrant/docker/mysql
```

3. docker-compose.ymlを作成する
```
$cat docker-compose.yml
version: '3'
services:
    db:
        image: mysql:5.7
        container_name: mysql-server
        ports:
            - "3306:3306"
        volumes:
            - ./db/mysql_init:/docker-entrypoint-initdb.d
            - ./db/mysql_data:/var/lib/mysql
        environment:
            MYSQL_ROOT_PASSWORD: root
            MYSQL_USER: test
            MYSQL_PASSWORD: test
```

4. 起動時に作成するDatabaseとTableのDDLを./db/mysql_init/create.sqlに作成する
例:DataBaseを作成する場合
```
create database sample;
use sample;
```

5. docker-compose.ymlが置いているディレクトリで下記コマンドを実行しMySQLコンテナを起動する
```
$ docker-compose up -d
```

6. 起動したことを確認する
```
$ docker-compose ps
    Name                 Command             State                 Ports
--------------------------------------------------------------------------------------
mysql-server   docker-entrypoint.sh mysqld   Up      0.0.0.0:3306->3306/tcp, 33060/tcp
```

7. mysqlコマンドをインストールする
```
$ apt-get update && apt-get -y install mysql-client
$ mysql --version
mysql  Ver 14.14 Distrib 5.7.27, for Linux (x86_64) using  EditLine wrapper
```

8. MySQLに接続する
```
$ mysql -h 127.0.0.1 -u root -p
> mysql
```

localhostでは接続できないので注意
 * https://hacknote.jp/archives/30781/

9. 起動時に作成したDababaseが存在することを確認する
```
mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| sample             |
| sys                |
+--------------------+
```

## 参考

* [docker-compose＋MySQL5.7(8.0も)+初期化+永続化](https://qiita.com/juhn/items/274e44ee80354a39d872)


