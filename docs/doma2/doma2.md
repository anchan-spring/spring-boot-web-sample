# doma2

## 依存ライブラリ

```
    <dependency>
        <groupId>org.seasar.doma.boot</groupId>
        <artifactId>doma-spring-boot-starter</artifactId>
        <version>1.1.1</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-jdbc</artifactId>
    </dependency>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
    </dependency>
```

## MySQLへの接続設定

* application.property
```
spring.datasource.url=jdbc:mysql://localhost:3306/sampledb
spring.datasource.username=testuser
spring.datasource.password=testuser
spring.datasource.driverClassName=com.mysql.jdbc.Driver
spring.jpa.database=MYSQL
spring.jpa.hibernate.ddl-auto=update
```

## 実装の流れ

1. 対象テーブルのEntityクラスを作成

2. Respositoryクラスを作成

3. 作成したRespositoryクラスを@AutowiseControllerクラスを作成

## Entityクラスの作成

### アノテーション

 * @Entity
  * エンティティを定義
 * @Table
  * エンティティに対応するテーブル情報を指定
 * @Id
  * 主キーを指定

## Repositoryクラスを作成

### アノテーション

 * @ConfigAutowireable
    * @Repositoryと@Autowiredを付与するアノテーション
  * @Repository
   * @Repository
    * Spirngのコンポーネントとして認識され、ApplicationContextに登録されることで、DI対象のクラス
    * DBとやりとりするクラス、つまりDAOクラスに付与するアノテーション

## 参考URL

 * [公式ドキュメント](https://doma.readthedocs.io/en/2.19.2/)
 * [doma2でデータベース連携(Spring boot)](https://qiita.com/sukezane/items/35f17aa9a20ba7a4a471)
 * [SpringBoot×DOMA2 チュートリアル 環境構築から実行まで](https://qiita.com/k0001/items/55737a53b6e17edec707)