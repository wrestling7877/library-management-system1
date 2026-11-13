# 📚 Library Management System

Java Servlet / JSP / JDBC を使用して開発した、図書館向けの書籍管理Webアプリケーションです。

書籍情報の登録・一覧表示・更新・削除を中心に、著者やカテゴリーとの関連付け、書籍画像のアップロードなどの機能を実装しています。

本プロジェクトは、Java Webアプリケーションの基本的な構成や、Servletによるリクエスト処理、JSPによる画面表示、JDBCを利用したデータベース操作を学ぶために個人で開発しました。

---

## 📋 1. プロジェクト概要

| 項目 | 内容 |
|---|---|
| プロジェクト名 | Library Management System |
| 開発形態 | 個人開発 |
| アプリケーション形式 | Java Web Application |
| パッケージ形式 | WAR |
| データベース | PostgreSQL |
| 実行環境 | Apache Tomcat |

## ✨ 2. 主な機能

### 📖 書籍管理（Book Management）

- 書籍情報の登録
- 書籍一覧の表示
- 書籍情報の更新
- 書籍情報の削除
- 書籍画像のアップロードおよび表示
- 書籍一覧のページネーション

### 👤 著者・カテゴリー管理（Author / Category）

- 著者一覧の取得
- 著者情報の表示
- カテゴリー一覧の取得
- 書籍登録・更新時の著者およびカテゴリーの関連付け

### 📝 書籍情報（Book Information）

コード上で扱っている主な書籍情報は以下のとおりです。

- タイトル
- 説明
- 著者
- カテゴリー
- ISBN
- 出版年
- 所蔵数量
- 画像ファイル名

※著者・カテゴリーについては、ソースコードで確認できた一覧取得・参照および書籍との関連付けを記載しています。独立した追加・更新・削除機能は本READMEでは機能として記載していません。

---

## 🛠️ 3. 使用技術（Technology Stack）

| 分類 | 技術 |
|---|---|
| Programming Language | Java（Java 8 source/target設定） |
| Web Technology | Jakarta Servlet API 5.0、JSP、JSTL |
| Database Access | JDBC |
| Database | PostgreSQL |
| Build Tool | Maven |
| Frontend | HTML、CSS、Bootstrap 5.1.3 |
| JavaScript Library | jQuery 3.6.0 |
| Other Libraries | Gson 2.9.1、Lombok 1.18.24 |
| Application Server | Apache Tomcat |

---

## 🏗️ 4. システム構成（System Architecture）

本アプリケーションは、Java Servlet、JSP、DAO、Modelを使用した基本的なJava Webアプリケーションの構成です。

| コンポーネント | 役割 |
|---|---|
| Servlet | HTTPリクエストを受け取り、書籍・著者・カテゴリー関連の処理を実行 |
| JSP / JSTL | 書籍一覧、登録・更新フォームなどの画面を表示 |
| DAO | JDBCを使用してPostgreSQLへのSQL実行とデータ取得を行う |
| Model | Book、Author、Categoryなどのデータを管理 |
| PostgreSQL | 書籍、著者、カテゴリーおよび関連情報を保存 |

---

## 📁 5. ディレクトリ構成（Project Structure）

```text
src/
└── main/
    ├── java/
    │   └── uz/pdp/librarymanagementsystem/
    │       ├── attachments/   # 画像・ファイル取得用Servlet
    │       ├── authors/       # 著者Model、DAO、Servlet
    │       ├── books/         # 書籍Model、DAO、各種Servlet
    │       ├── category/      # カテゴリーModel、DAO
    │       ├── db/            # DB接続処理
    │       └── utils/         # 共通ユーティリティ
    │
    └── webapp/
        ├── WEB-INF/
        ├── includes/
        ├── *.jsp
        └── styles.css
```

---

## 🚀 6. 実行環境・起動方法（Setup & Installation）

### 前提条件

以下の環境が必要です。

- JDK 8 以降
- Apache Maven
- PostgreSQL
- Jakarta Servlet 5.0 に対応した Apache Tomcat 10.0 以降

### Step 1. リポジトリを取得

```bash
git clone <リポジトリURL>
cd library-management-system
```

### Step 2. PostgreSQLを準備

PostgreSQLにデータベースを作成し、アプリケーションが使用するテーブルを用意してください。

ソースコードから確認できる主なテーブル名は以下のとおりです。

- `book`
- `author`
- `category`
- `book_authors`

※このリポジトリには、データベース作成用のDDL／初期データSQLファイルは含まれていません。実行前に、ソースコード内のSQLに合わせてテーブルおよび関連制約を準備する必要があります。

### Step 3. データベース接続設定

以下のクラスでPostgreSQLへの接続設定を行います。

```text
src/main/java/uz/pdp/librarymanagementsystem/db/DbConnection.java
```

接続先URL、ユーザー名、パスワードは、ご自身のローカル環境に合わせて設定してください。

> **注意：** データベースの認証情報をソースコードやGitリポジトリに直接保存しないでください。公開リポジトリでは、環境変数や外部設定ファイルなどを利用してください。

### Step 4. WARファイルをビルド

プロジェクトのルートディレクトリで以下のコマンドを実行します。

```bash
mvn clean package
```

ビルドが成功すると、以下のWARファイルが生成されます。

```text
target/library-management-system-1.0-SNAPSHOT.war
```

### Step 5. Apache Tomcatへデプロイ

生成されたWARファイルをTomcatの`webapps`ディレクトリに配置し、Tomcatを起動してください。

デプロイ後、以下のURLからアクセスできます（コンテキストパスはWARファイル名に依存します）。

```text
http://localhost:8080/library-management-system-1.0-SNAPSHOT/
```

---

## ⚙️ 7. 補足・実行時の設定

- 書籍画像の保存先は、`src/main/java/uz/pdp/librarymanagementsystem/utils/Util.java`で定義されています。実行環境に合わせて、書き込み可能なディレクトリに変更してください。
- Servlet API 5.0（`jakarta.servlet`）を使用しているため、Jakarta EE 9以降に対応したTomcatが必要です。
- データベースのDDLや初期データはリポジトリに含まれていないため、別途準備が必要です。

---

## 📚 8. 開発を通じて学んだこと（What I Learned）

本プロジェクトの開発を通じて、以下の技術や知識を学びました。

- Java Servletを使ったHTTPリクエスト／レスポンス処理
- JSPとJSTLを使ったWeb画面の実装
- JDBCおよびPreparedStatementを使ったPostgreSQL操作
- DAOとModelを分けた基本的なコード構成
- 書籍情報のCRUD処理
- ファイルアップロードとファイル取得処理
- MavenによるWARパッケージの作成
- Apache TomcatへのWebアプリケーションのデプロイ

---

## 🔧 9. 今後の改善課題（Future Improvements）

今後、以下の点を改善していきたいと考えています。

- DB接続情報を環境変数等で管理する
- 画像保存先を環境に依存しない設定に変更する
- データベースDDLおよび初期データを管理するSQLファイルを追加する
- 入力値検証、例外処理、トランザクション管理を強化する
- テストコードを追加する

---

**本プロジェクトは、Java Web開発の基礎技術を実践的に学ぶことを目的とした個人開発プロジェクトです。**
