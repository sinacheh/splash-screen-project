package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication3.R;

public class MainActivity2 extends AppCompatActivity {

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        Intent intent =getIntent();
        TextView a1 =findViewById(R.id.tex1);
        TextView a2 =findViewById(R.id.tex2);
        TextView a3 =findViewById(R.id.tex3);
        TextView a4 =findViewById(R.id.tex4);
        String note1 =intent.getStringExtra("tex1");
        String note2 =intent.getStringExtra("tex2");
        String note3 =intent.getStringExtra("tex3");
        String note4 =intent.getStringExtra("tex4");
        a1.setText(note1);
        a2.setText(note2);
        a3.setText(note3);
        a4.setText(note4);
        SharedPreferences save = getSharedPreferences("data_name", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =save.edit();
        Button ok =findViewById(R.id.button);
        CheckBox yes =findViewById(R.id.taiied);
        yes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked==true){
                    ok.setEnabled(true);
                }
                else {
                    ok.setEnabled(false);
                }
            }

        });
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value1 ="defult1";
                String value2 ="defult2";
                String value3 ="defult3";
                String value4 ="defult4";
                editor.putString("matn1","defult1");
                editor.putString("matn2","defult2");
                editor.putString("matn3","defult3");
                editor.putString("matn4","defult4");
                Toast.makeText(MainActivity2.this, "اطلاعات با موفقیت ذخیره شد!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}