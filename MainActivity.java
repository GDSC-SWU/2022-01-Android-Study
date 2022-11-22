package com.example.eveytime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HorizontalScrollView scrollView1 = findViewById(R.id.main_middle_first_scroll);
        HorizontalScrollView scrollView2 = findViewById(R.id.main_middle_second_scroll);

        scrollView1.setHorizontalScrollBarEnabled(false); // 스크롤 바 없애기
        scrollView2.setHorizontalScrollBarEnabled(false); // 스크롤 바 없애기

        RelativeLayout layout01 = (RelativeLayout) findViewById(R.id.main_middle_second_content1);
        layout01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("log01","click layout01");
            }
        });
    }
}