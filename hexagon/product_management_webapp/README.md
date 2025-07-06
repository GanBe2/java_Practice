# 製品管理Webアプリ（JSP + Java + Oracle）

このアプリは、JSPとJava Servletを使って、製品情報（商品名・価格・数量）をOracleデータベースに登録するシンプルなWebアプリです。

## アプリの特徴

- ユーザーがフォームに入力した製品情報をデータベースに登録します。
- ServletとDAOを使って、データの受け取りと登録を分離しています。
- 登録後は完了画面にリダイレクトされます。

## 使用技術

- Java（Servlet）
- JSP（フォーム入力・出力）
- Oracle Database（JDBC接続）
- JDBC（ドライバ接続）
- Apache Tomcat（Webアプリケーションサーバ）

## 主なファイル

- `Product.java`  
  製品情報（名前・価格・数量）を保持するDTOクラスです。

- `ProductDAO.java`  
  データベースに接続し、製品情報を登録します。

- `Product_controller.java`  
  フォームの入力値を受け取り、DAOに渡します。

- `product_input.jsp`  
  製品情報を入力するフォームです。

- `product_output.jsp`  
  登録成功後に表示される簡単な完了画面です。

- `schema.sql`  
  Oracleデータベースに作成する製品テーブルのDDLです。