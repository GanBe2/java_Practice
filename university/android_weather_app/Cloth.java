package com.example.project;
public class Cloth {

    // 기온별 옷차림 정보를 배열로 저장
    private static final String[] outerwears = {
            "-", "-", "얇은 가디건", "가디건", "자켓, 야상", "트렌치코트, 야상", "코트, 가죽자켓, 플리스", "패딩, 두꺼운 코트"
    };

    private static final String[] tops = {
            "민소매, 반팔", "반팔, 얇은 셔츠", "긴팔티", "얇은 니트, 맨투맨", "니트", "니트", "히트텍, 니트", "-"
    };

    private static final String[] bottoms = {
            "반바지, 짧은 치마, 원피스", "반바지, 면바지", "면바지", "청바지", "청바지", "청바지, 기모바지", "레깅스", "기모제품"
    };

    private static final String[] accessories = {
            "-", "-", "-", "-", "스타킹", "스타킹", "-", "목도리"
    };

    // 기온에 따른 추천 옷차림을 반환
    public static String getClothingRecommendation(int temperature) {
        int index = getTemperatureIndex(temperature);
        return "외투: " + outerwears[index] + "\n" +
                "상의: " + tops[index] + "\n" +
                "하의: " + bottoms[index] + "\n" +
                "기타: " + accessories[index];
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
