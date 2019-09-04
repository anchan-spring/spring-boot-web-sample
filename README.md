# Spring Boot MVC サンプル

## 使用しているSpringBoot

### 開発用

 * spring-boot-starter-web
 * spring-boot-starter-thymeleaf
 * lombok

### テスト用

 *  spring-boot-starter-test

### ビルド用

 * spring-boot-maven-plugin

## 実行方法

1. example.boot.SpringBootWebSampleApplicationを右クリックし実行 -> Spring Bootアプリケーションを選択

2. ブラウザで`http://localhost:8080/hello`にアクセス

## トラブルシューティング

pom.xmlの1行目で不明なエラーが発生する場合は下記を実施する

1. ヘルプ -> 新規ソフトウェアのインストールを選択

2. URLに下記を入力しm2e-wtpプラグインをインストール
    * https://download.eclipse.org/m2e-wtp/releases/1.4/