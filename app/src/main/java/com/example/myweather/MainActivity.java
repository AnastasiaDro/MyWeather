package com.example.myweather;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    static final private int CHOOSE_CITY = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //тренируемся в воспроизведении жизенных циклов активити
        String instanceState;
        if (savedInstanceState == null){
            instanceState = getString(R.string.first_start);
        }
        else {
            instanceState = "Повторый запуск";
        }
        Toast.makeText(getApplicationContext(), instanceState, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "onStop", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Toast.makeText(getApplicationContext(), "onSaveInstanceState", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResume", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        Toast.makeText(getApplicationContext(), "onRestoreInstanceState", Toast.LENGTH_SHORT).show();

    }

    //обработчик нажатия на кнопку change - поменять город
    //переходим на второй экран с activity_city и ожидаем ввода города
    public void onChangeClick(View view) {
        Intent intent = new Intent(MainActivity.this, CityActivity.class);
        startActivityForResult(intent, CHOOSE_CITY);
    }

    //Ждём название города из CityActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        TextView textViewCity = findViewById(R.id.textViewCity);

        if (requestCode == CHOOSE_CITY) {
            if (resultCode == RESULT_OK) {
                String cityName = data.getStringExtra(CityActivity.CITY);
                textViewCity.setText(cityName);
            } else {
                textViewCity.setText(R.string.defaultCity);//ставим значение по умолчанию
            }
        }

    }


}
