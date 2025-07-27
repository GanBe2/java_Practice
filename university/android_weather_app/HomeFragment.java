package com.example.project;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.xml.parsers.DocumentBuilderFactory;

public class HomeFragment extends Fragment {
    private EditText etMemo;
    private TextView tvMemos;
    private MemoDatabaseHelper dbHelper;

    private final Executor executor = Executors.newSingleThreadExecutor();
    private final Handler handler = new Handler(Looper.getMainLooper());
    private static final String TAG = "HnpWeather";
    private static int temperature;

    // 좌표 설정: 서울시 노원구 공릉2동
    private int x = 62;  // 대체가능
    private int y = 128; // 대체가능

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        etMemo = view.findViewById(R.id.et_memo);
        tvMemos = view.findViewById(R.id.tv_memo_display);
        Button btnSaveMemo = view.findViewById(R.id.btn_save_memo);
        Button btnClearMemos = view.findViewById(R.id.btn_clear_memo);

        dbHelper = new MemoDatabaseHelper(requireContext());

        btnSaveMemo.setOnClickListener(v -> saveMemo());

        btnClearMemos.setOnClickListener(v -> clearMemos());

        fetchWeatherData();

        displayMemos();

        return view;
    }

    //날씨 데이터 처리
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void fetchWeatherData() {
        executor.execute(() -> {
            String[] weatherInfo = new String[5];
            String result = getWeather(x, y, weatherInfo);

            handler.post(() -> {
                if (result == null) {
                    // 날씨 정보를 화면에 표시
                    TextView dateTextView = requireView().findViewById(R.id.dateTextView);
                    TextView timeTextView = requireView().findViewById(R.id.timeTextView);
                    TextView weatherTextView = requireView().findViewById(R.id.weatherTextView);
                    TextView temperatureTextView = requireView().findViewById(R.id.temperatureTextView);
                    TextView clothTextView = requireView().findViewById(R.id.tv_preparations_detail);

                    dateTextView.setText("날짜 : " + weatherInfo[0]);
                    timeTextView.setText("시간 : " + weatherInfo[1] + " 기준");
                    weatherTextView.setText("날씨 : " + weatherInfo[2]);
                    temperatureTextView.setText("기온 : " + weatherInfo[3] + "℃");
                    temperature = Integer.parseInt(weatherInfo[3]) ;
                    clothTextView.setText(getCloth(temperature)); //뭐입지 텍스트

                } else {
                    //오류 메시지 출력
                    TextView dateTextView = requireView().findViewById(R.id.dateTextView);
                    dateTextView.setText("Error : " + result);
                }
            });
        });
    }

    //Api 접속
    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getWeather(int x, int y, String[] weatherInfo) {
        HttpURLConnection con = null;
        String errorMsg = null;

        try {
            // 현재 시간으로 설정
            LocalDateTime now = LocalDateTime.now().minusMinutes(30);
            String baseDate = now.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            String baseTime = now.format(DateTimeFormatter.ofPattern("HHmm"));

            // 기상청 API 호출 URL
            URL url = new URL(
                    "https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtFcst"
                            + "?ServiceKey=kOi8Lip34pcIqvkXt4tjC%2Fdz3weHgvBIyCgn1CO3NCHIViflC5x3%2B4QsijSS%2BCQ2tBBlew5nChk1k90j7MBvuw%3D%3D"
                            + "&numOfRows=60"
                            + "&base_date=" + baseDate
                            + "&base_time=" + baseTime
                            + "&nx=" + x
                            + "&ny=" + y
            );

            con = (HttpURLConnection) url.openConnection();
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(con.getInputStream());

            boolean success = false;
            Element element;
            NodeList nodeList = doc.getElementsByTagName("header");

            if (nodeList.getLength() > 0) {
                element = (Element) nodeList.item(0);
                String resultCode = element.getElementsByTagName("resultCode").item(0).getTextContent();
                String resultMsg = element.getElementsByTagName("resultMsg").item(0).getTextContent();
                Log.d(TAG, "resultCode: " + resultCode + ", resultMsg: " + resultMsg);

                if ("00".equals(resultCode)) {
                    success = true;
                } else {
                    errorMsg = resultMsg;
                }
            }

            if (success) {
                String forecastDate = null, forecastTime = null;
                String precipitationType = null, skyCondition = null;
                String category, value;

                nodeList = doc.getElementsByTagName("item");
                for (int i = 0; i < nodeList.getLength(); i++) {
                    element = (Element) nodeList.item(i);

                    if (forecastTime == null) {
                        forecastDate = element.getElementsByTagName("fcstDate").item(0).getTextContent();
                        forecastTime = element.getElementsByTagName("fcstTime").item(0).getTextContent();
                    } else if (!forecastDate.equals(element.getElementsByTagName("fcstDate").item(0).getTextContent()) ||
                            !forecastTime.equals(element.getElementsByTagName("fcstTime").item(0).getTextContent())) {
                        continue;
                    }

                    category = element.getElementsByTagName("category").item(0).getTextContent();
                    value = element.getElementsByTagName("fcstValue").item(0).getTextContent();

                    Log.d(TAG, "category: " + category + ", value: " + value);

                    if ("PTY".equals(category)) precipitationType = value;
                    else if ("SKY".equals(category)) skyCondition = value;
                    else if ("T1H".equals(category)) weatherInfo[3] = value;
                    else if ("REH".equals(category)) weatherInfo[4] = value;
                }

                weatherInfo[0] = forecastDate;
                weatherInfo[1] = forecastTime;

                if ("0".equals(precipitationType)) {
                    if ("1".equals(skyCondition)) weatherInfo[2] = "맑음";
                    else if ("3".equals(skyCondition)) weatherInfo[2] = "구름많음";
                    else if ("4".equals(skyCondition)) weatherInfo[2] = "흐림";
                } else if ("1".equals(precipitationType)) weatherInfo[2] = "비";
                else if ("2".equals(precipitationType)) weatherInfo[2] = "비/눈";
                else if ("3".equals(precipitationType)) weatherInfo[2] = "눈";
                else if ("5".equals(precipitationType)) weatherInfo[2] = "빗방울";
                else if ("6".equals(precipitationType)) weatherInfo[2] = "빗방울눈날림";
                else if ("7".equals(precipitationType)) weatherInfo[2] = "눈날림";
            }

        } catch (Exception e) {
            errorMsg = e.getMessage();
            Log.e(TAG, "Exception: " + errorMsg, e);
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }
        return errorMsg;
    }

    //옷 추천
    public String getCloth(int temp) {
        Cloth cloth = new Cloth();
        String recommendation = cloth.getClothingRecommendation(temp);
        return recommendation;
    }

    private void saveMemo() {
        String memo = etMemo.getText().toString();
        if (!memo.isEmpty()) {
            dbHelper.addMemo(memo);
            etMemo.setText(""); // 입력 필드 비우기
            displayMemos();
        }
    }

    private void displayMemos() {
        List<String> memos = dbHelper.getAllMemos();
        StringBuilder memoText = new StringBuilder();
        for (String memo : memos) {
            memoText.append(memo).append("\n");
        }
        tvMemos.setText(memoText.toString().trim());
    }

    private void clearMemos() {
        dbHelper.deleteAllMemos();
        tvMemos.setText(""); // 메모 텍스트뷰 비우기
    }
}
