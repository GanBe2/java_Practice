package com.example.project;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.xml.parsers.DocumentBuilderFactory;

public class WeatherApi {

    private static final String TAG = "WeatherApi";

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void getWeatherInfo(int x, int y, WeatherCallback callback) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection con = null;
                String s = null; // 에러 메시지

                try {
                    LocalDateTime t = LocalDateTime.now().minusMinutes(30); // 현재 시각 30분전

                    URL url = new URL(
                            "https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtFcst"
                                    + "?ServiceKey=kOi8Lip34pcIqvkXt4tjC%2Fdz3weHgvBIyCgn1CO3NCHIViflC5x3%2B4QsijSS%2BCQ2tBBlew5nChk1k90j7MBvuw%3D%3D" // 서비스키
                                    + "&numOfRows=60" // 한 페이지 결과 수 (10개 카테고리값 * 6시간)
                                    + "&base_date=" + t.format(DateTimeFormatter.ofPattern("yyyyMMdd"))  // 발표 날짜
                                    + "&base_time=" + t.format(DateTimeFormatter.ofPattern("HHmm")) // 발표 시각
                                    + "&nx=" + x // 예보지점의 X 좌표값
                                    + "&ny=" + y // 예보지점의 Y 좌표값
                    );

                    con = (HttpURLConnection) url.openConnection();
                    Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(con.getInputStream());

                    boolean ok = false; // <resultCode>00</resultCode> 획득 여부

                    Element e;
                    NodeList ns = doc.getElementsByTagName("header");
                    if (ns.getLength() > 0) {
                        e = (Element) ns.item(0);
                        if ("00".equals(e.getElementsByTagName("resultCode").item(0).getTextContent()))
                            ok = true; // 성공 여부
                        else // 에러 메시지
                            s = e.getElementsByTagName("resultMsg").item(0).getTextContent();
                    }

                    if (ok) {
                        String fd = null, ft = null; // 가장 빠른 예보 시각
                        String pty = null; // 강수형태
                        String sky = null; // 하늘상태
                        String cat; // category
                        String val; // fcstValue

                        ns = doc.getElementsByTagName("item");
                        for (int i = 0; i < ns.getLength(); i++) {
                            e = (Element) ns.item(i);

                            if (ft == null) { // 가져올 예보 시간 결정
                                fd = e.getElementsByTagName("fcstDate").item(0).getTextContent(); // 예보 날짜
                                ft = e.getElementsByTagName("fcstTime").item(0).getTextContent(); // 예보 시각
                            } else if (!fd.equals(e.getElementsByTagName("fcstDate").item(0).getTextContent()) ||
                                    !ft.equals(e.getElementsByTagName("fcstTime").item(0).getTextContent()))
                                continue; // 결정된 예보 시각과 같은 시각의 것만 취한다.

                            cat = e.getElementsByTagName("category").item(0).getTextContent(); // 자료구분코드
                            val = e.getElementsByTagName("fcstValue").item(0).getTextContent(); // 예보 값

                            if ("PTY".equals(cat)) pty = val; // 강수형태
                            else if ("SKY".equals(cat)) sky = val; // 하늘상태
                            else if ("T1H".equals(cat)) {
                                callback.onTemperatureReceived(val); // 기온
                            }

                        }

                        callback.onWeatherInfoReceived(fd, ft, determineWeatherCondition(pty, sky));
                        Log.d(TAG, "로그남겼다:" + pty);
                    }
                } catch (Exception e) {
                    Log.e(TAG, "Error in doInBackground: " + e.getMessage());
                    s = e.getMessage();
                } finally {
                    if (con != null)
                        con.disconnect();
                }

                if (s != null) {
                    callback.onError(s);
                }
            }
        });

        thread.start();
    }

    private static String determineWeatherCondition(String pty, String sky) {
        if ("0".equals(pty)) {
            if ("1".equals(sky)) return "맑음";
            else if ("3".equals(sky)) return "구름많음";
            else if ("4".equals(sky)) return "흐림";
        } else if ("1".equals(pty)) return "비";
        else if ("2".equals(pty)) return "비/눈";
        else if ("3".equals(pty)) return "눈";
        else if ("5".equals(pty)) return "빗방울";
        else if ("6".equals(pty)) return "빗방울눈날림";
        else if ("7".equals(pty)) return "눈날림";

        return "알 수 없음";
    }
}
