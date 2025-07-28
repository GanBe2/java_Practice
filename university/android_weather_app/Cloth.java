package com.example.project;
public class Cloth {

    // 기온별 옷차림 정보를 배열로 저장
    private static final String[] outerwears = {
        "-", 
	"-", 
	"薄手のカーディガン", 
	"カーディガン",
	"ジャケット, モッズコート",
	"トレンチコート, モッズコート",
	"コート, レザージャケット, フリース",
	"ダウンジャケット, 厚手のコート"
    };

    private static final String[] tops = {
        "ノースリーブ, 半袖",
	"半袖, 薄手のシャツ",
	"長袖Tシャツ",
	"薄手のニット, スウェット",
	"ニット",
	"ニット",
	"ヒートテック, ニット",
	"-"
    };

private static final String[] bottoms = {
    "短パン、短いスカート、ワンピース", 
    "短パン、綿パンツ", 
    "綿パンツ", 
    "ジーンズ", 
    "ジーンズ", 
    "ジーンズ、裏起毛パンツ", 
    "レギンス", 
    "裏起毛アイテム"
};

private static final String[] accessories = {
    "-", "-", "-", "-", "ストッキング", "ストッキング", "-", "マフラー"
};


    // 기온에 따른 추천 옷차림을 반환
    public static String getClothingRecommendation(int temperature) {
        int index = getTemperatureIndex(temperature);
        return "上着: " + outerwears[index] + "\n" +
                "トップス: " + tops[index] + "\n" +
                "ボトムス: " + bottoms[index] + "\n" +
                "アクセサリー: " + accessories[index];
    }

    // 입력된 기온에 맞는 배열 인덱스를 반환
    private static int getTemperatureIndex(int temperature) {
        if (temperature >= 28) {
            return 0;
        } else if (temperature >= 23) {
            return 1;
        } else if (temperature >= 20) {
            return 2;
        } else if (temperature >= 17) {
            return 3;
        } else if (temperature >= 12) {
            return 4;
        } else if (temperature >= 9) {
            return 5;
        } else if (temperature >= 5) {
            return 6;
        } else {
            return 7;
        }
    }
}
