package com.example.myweather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

public class CityActivity extends Activity {


    public final static String CITY = "ru.anastasiadrogunova.myweather.CITY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_city);


        //возвращаем информацию о городе в MainActivity
        final Intent answerIntent = new Intent();
        final EditText editText =  findViewById(R.id.editText);
        editText.setOnKeyListener(new View.OnKeyListener()
                                  {
                                      public boolean onKey(View v, int keyCode, KeyEvent event)
                                      {
                                          if(event.getAction() == KeyEvent.ACTION_DOWN &&
                                                  (keyCode == KeyEvent.KEYCODE_ENTER))
                                          {
                                              //сохраняем текст, введенный до нажатия Enter в переменную
                                              String myCityStr = editText.getText().toString();
                                              answerIntent.putExtra(CITY, myCityStr);
                                              setResult(RESULT_OK, answerIntent);
                                              finish();
                                              return true;
                                          }
                                          return false;
                                      }
                                  }
        );





    }




}
