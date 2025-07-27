package com.example.project;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(navItemSelectedListener);

        // 앱 시작 시 첫 번째 프래그먼트 (HomeFragment) 표시
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new HomeFragment())
                    .commit();
        }

    }

    private BottomNavigationView.OnItemSelectedListener navItemSelectedListener =
            item -> {
                Fragment selectedFragment = null;

                // BottomNavigationView의 각 메뉴 아이템
                if (item.getItemId() == R.id.nav_main) {
                    selectedFragment = new HomeFragment();
                } else if (item.getItemId() == R.id.nav_alarm) {
                    selectedFragment = new AlarmFragment();
                }else if (item.getItemId() == R.id.nav_bus) {
                    selectedFragment = new BusFragment();
                }

                // 선택된 프래그먼트를 프래그먼트 컨테이너에 표시
                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, selectedFragment)
                            .commit();
                    return true;
                }

                return false; // 처리 실패
            };



}
