# 2-Docker環境を構築する


下記コマンドを実行しUbuntuに無償版のDocker(Docker Community Edition 通称Docker CE）をインストールする。

1. aptのパッケージリストを更新する。
```
$sudo apt-get update -y
```

2. 依存するコンポーネントをインストールする。
Docker CEは下記コンポーネントに依存しているため先にこちらをインストールする。
```
$ sudo apt install -y apt-transport-https ca-certificates curl software-properties-common
```
  * apt-transpot-https
  * ca-certificates
  * curl
  * software-properties-common

3. Dockerのパッケージリポジトリをaptに登録する。
```
$curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
```

4. aptリポジトリに安定板のDockerパッケージリポジトリを設定する。
```
$ sudo add-apt-repository \
   "deb [arch=amd64] https://download.docker.com/linux/ubuntu \
   $(lsb_release -cs) \
   stable"
```

5. 再度パッケージリストを更新する。
```
$sudo apt update -y
```

6. 最新版のDocker CEをインストールする。
```
$sudo apt install -y docker-ce
```

7. インストールしたDocker CEのバージョンを確認する。
```
$ sudo docker version
Client:
Version:           18.06.1-ce
 API version:       1.38
 Go version:        go1.10.3
 Git commit:        e68fc7a
 Built:             Tue Aug 21 17:24:58 2018
 OS/Arch:           linux/amd64
 Experimental:      false
Server:
 Engine:
  Version:          18.06.1-ce
  API version:      1.38 (minimum version 1.12)
  Go version:       go1.10.3
  Git commit:       e68fc7a
  Built:            Tue Aug 21 17:23:24 2018
  OS/Arch:          linux/amd64
  Experimental:     false
```
