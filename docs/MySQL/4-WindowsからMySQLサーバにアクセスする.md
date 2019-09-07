# 4-WindowsからMySQLサーバにアクセスする

1. Windowsにmysqlコマンドをインストールする

以下を参考にMySQL5.7をインストールする
 * [MySQL Server 5.7 を Windows にインストールする手順](https://weblabo.oscasierra.net/installing-mysql57-windows/)
 
途中でSetUp Typeを選択する画面があるが、そこでは"Client Only"を選択する。

2. インストールが完了するとMySQL WorkBenchが起動するので下記でMySQLサーバに接続する
 * Connection Name : 自由に
 * HostName : 127.0.0.1
 * Port : 3306
 * Username:root

3. 接続すると起動時に作成したDataBaseとTableが作成されているはず
