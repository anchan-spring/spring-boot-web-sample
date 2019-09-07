# 3-MySQLコンテナを起動する

1. rootユーザにスイッチする
```
$ sudo su -
```

2. gitコマンドをインストールする
```
$ apt-get install git
$ git --version
git version 2.7.4
```

3. [spring-boo-web-sample-mysql](https://github.com/anchan-spring/spring-boo-web-sample-mysql)リポジトリをcloneする
```
$ cd /home/vagrant/docker
$ git clone https://github.com/anchan-spring/spring-boo-web-sample-mysql.git
```

4. MySQLコンテナを起動する
```
$ docker-compose up -d
```

5. 起動したことを確認する
```
$ docker-compose ps
    Name                 Command             State                 Ports
--------------------------------------------------------------------------------------
mysql-server   docker-entrypoint.sh mysqld   Up      0.0.0.0:3306->3306/tcp, 33060/tcp
```

6. mysqlコマンドをインストールする
```
$ apt-get update && apt-get -y install mysql-client
$ mysql --version
mysql  Ver 14.14 Distrib 5.7.27, for Linux (x86_64) using  EditLine wrapper
```

7. MySQLに接続する
```
$ mysql -h 127.0.0.1 -u root -p
> mysql
```

localhostでは接続できないので注意
 * https://hacknote.jp/archives/30781/

8. 起動時に作成したDababaseが存在することを確認する
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

※起動時には下記フォルダ配下のSQLが実行される
 * https://github.com/anchan-spring/spring-boo-web-sample-mysql/blob/master/db/mysql_init/

## 参考

* [docker-compose＋MySQL5.7(8.0も)+初期化+永続化](https://qiita.com/juhn/items/274e44ee80354a39d872)


