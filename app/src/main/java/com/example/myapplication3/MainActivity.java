package com.example.myapplication3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication3.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText name =findViewById(R.id.name);
        EditText family =findViewById(R.id.family);
        EditText jab =findViewById(R.id.job);
        RadioButton mard = findViewById(R.id.male);
        RadioButton zan = findViewById(R.id.female);
        Intent intent =new Intent(MainActivity.this, com.example.myapplication3.MainActivity2.class);
        Button sabt =findViewById(R.id.sabt);
        sabt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("tex1",name.getText().toString());
                intent.putExtra("tex2",family.getText().toString());
                intent.putExtra("tex3",jab.getText().toString());
                String a = null;
                if (mard.isChecked())
                {
                    a ="mard";
                }
                else
                {
                    a = "zan";
                }
                intent.putExtra("tex4", a);
                startActivity(intent);
            }
        });
        Intent getshaer =getIntent();
        SharedPreferences save = getSharedPreferences("data_name", Context.MODE_PRIVATE);
        String m1 = save.getString("tex1", "");
        String m2 = save.getString("tex2", "");
        String m3 = save.getString("tex3", "");
        name.setText(m1);
        family.setText(m2);
        jab.setText(m3);
    }
}