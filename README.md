# Spring MVC サンプルプロジェクト

## クラス図

http://192.168.11.20:18080/uml/AqXCpavCJrL8hKZCBSX9rKlApozHgERYKaZEIImkLWWkAChCItS22eQd9WM3bJWM5EHa9YUMPERd0HKgA6Whv2Pcvca4bu1KHiTgMfNbPwPmATHoAUJbbwGgvAIcbLWfF6vQzBXv-kFcLO-RDZvktlEuQVlZvkMFcpS_RfhqTDty5mjxW3OMG9sId9zNKfIVavDQ13OVuX2Fr9oSV6TK6Q3L6I1X3T_ybDGSJIi5Y1k0ChLmVPvvAQaLcFeoGS9e-XGW6c4EByali4fCIKii1cAkMW00

クラス図を更新する度に上記URLを更新すること

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