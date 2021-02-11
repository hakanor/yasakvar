package com.hakanor.yasakvar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {
    private EditText yas;
    private Button buton1;
    private Button buton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        yas = findViewById(R.id.yas);
        buton1 = findViewById(R.id.buton1);
        buton2 = findViewById(R.id.buton2);

        yas.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String text = s.toString();
                if (!text.isEmpty()){
                    buton1.setEnabled(true);
                    buton1.setAlpha(1.0f);
                }
                else{
                    buton1.setEnabled(false);
                    buton1.setAlpha(0.5f);
                }
            }
        });

        buton1.setOnClickListener(new View.OnClickListener() {
            private String key;

            @Override
            public void onClick(View v) {
                    Calendar c = Calendar.getInstance();
                    float yas_float = Float.valueOf(yas.getText().toString());
                    int saat= c.get(Calendar.HOUR_OF_DAY);
                    int gün = c.get(Calendar.DAY_OF_WEEK);
                    System.out.println("Hell"+ saat);
                    System.out.println("Hell" + gün);

                    if((gün==1 || gün==7) ){
                        buton2.setText("Dışarı Çıkamazsınız(Hafta Sonu Sebeiyle)");
                        buton2.setAlpha(1.0f);
                        buton2.setBackgroundColor(Color.parseColor("#FF0040"));
                    }
                    if((saat<5 || saat>20) ){
                        buton2.setText("Dışarı Çıkamazsınız");
                        buton2.setAlpha(1.0f);
                        buton2.setBackgroundColor(Color.parseColor("#FF0040"));
                    }
                    if((saat<5 || saat>20) && (yas_float<20 || yas_float>65)){
                        buton2.setText("Dışarı Çıkamazsınız");
                        buton2.setAlpha(1.0f);
                        buton2.setBackgroundColor(Color.parseColor("#FF0040"));
                    }
                    else{
                        buton2.setText("Dışarı Çıkabilirsiniz");
                        buton2.setAlpha(1.0f);
                        buton2.setBackgroundColor(Color.parseColor("#BBDE42"));
                    }

                //Intent intent = new Intent(MainActivity.this, MainActivity2.class);
               // startActivity(intent);
            }
        });

    }
}