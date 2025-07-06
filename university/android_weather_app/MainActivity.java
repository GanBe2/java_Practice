package com.example.project;

import static android.content.ContentValues.TAG;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity implements WeatherCallback{
    private TextView textWeatherInfo;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

                textWeatherInfo = findViewById(R.id.tv_weather_detail);

                WeatherApi.getWeatherInfo(58, 125, this); // 예시 좌표 (서울시 금천구 가산동)
            }


            public void onWeatherInfoReceived(String date, String time, String weather) {
                String weatherInfo = "날짜 : " + date + "\n"
                        + "시간 : " + time + "\n"
                        + "날씨 : " + weather + "\n";
                textWeatherInfo.setText(weatherInfo);
                Log.d(TAG, "Log- Date: " + date + ", Time: " + time + ", Weather: " + weather);
            }


            public void onTemperatureReceived(String temperature) {
                String currentText = textWeatherInfo.getText().toString();
                textWeatherInfo.setText(currentText + "기온 : " + temperature + "℃\n");
            }

            public void onHumidityReceived(String humidity) {
                String currentText = textWeatherInfo.getText().toString();
                textWeatherInfo.setText(currentText + "습도 : " + humidity + "%\n");
            }

            @Override
            public void onError(String message) {
                textWeatherInfo.setText("메인액티비티에러 발생: " + message);
            }
        }