package com.example.project;

public interface WeatherCallback {
    void onWeatherInfoReceived(String date, String time, String weather);
    void onTemperatureReceived(String temperature);
    void onHumidityReceived(String humidity);
    void onError(String message);
}
