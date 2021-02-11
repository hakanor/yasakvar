package com.hakanor.yasakvar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {
    public boolean cikis=false;
    private EditText yas;
    private Button buton1;
    private Button buton2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        yas = findViewById(R.id.yas);
        buton1 = findViewById(R.id.buton1);


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
                    if(saat<5 || saat>20){
                        cikis=false;
                    }
                    else{
                        if(yas_float<20 || yas_float>65){
                            cikis=false;
                            buton2.setText("Dışarı Cıkamazsınız");
                        }

                        else{
                            cikis=true;
                            buton2.setText("Dışarı Cıkabilirsiniz");
                        }

                    }

                //Intent intent = new Intent(MainActivity.this, MainActivity2.class);
               // startActivity(intent);
            }
        });



    }
}