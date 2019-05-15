package com.maggie.implicitintentandsharecontet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        //用getIntent()取得putExtra的資料
        Intent in=getIntent();
        String str=in.getStringExtra("msg");
        TextView text=findViewById(R.id.textResult);
        text.setText(str);
    }
}
