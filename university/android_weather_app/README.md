# 天気情報アプリ（Android）

このアプリは、韓国の公共データポータルが提供する「超短期気象予報API」を使って、  
天気と気温を取得・表示するAndroidアプリです。

## アプリの特徴

- 座標（X, Y）を指定すると、その地域の最新の天気と気温を取得します。
- APIからXML形式のデータを受け取り、天気コードと気温を取り出します。
- 天気の状態は、「晴れ・曇り・雨」など、わかりやすい日本語で表示します。

## 使用技術

- Java（Android Studio）
- HttpURLConnection（API通信）
- DOMパーサー（XMLデータの解析）
- コールバックインターフェース（非同期処理）

## 主なファイル

- `MainActivity.java`  
  画面の表示と、API呼び出しの開始を行います。

- `WeatherApiClient.java`  
  APIにアクセスし、XMLを解析して必要なデータを取り出します。

- `WeatherApiCallback.java`  
  データの取得が終わったとき、画面に伝えるための仕組みです。

- `activity_main.xml`  
  シンプルな画面レイアウトです。