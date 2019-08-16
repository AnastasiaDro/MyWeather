package com.example.myweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //обработчик нажатия на кнопку change - поменять город
    //переходим на второй экран с activity_city
    public void onChangeClick(View view) {
        Intent intent = new Intent(MainActivity.this, CityActivity.class);
        startActivity(intent);
    }
}
