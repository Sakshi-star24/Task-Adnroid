package com.example.internshipproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Saved extends AppCompatActivity {

    TextView tv,tv1,tv2,tv3;
    String s,s1,s2,spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);

        tv=findViewById(R.id.tv);
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        tv3=findViewById(R.id.tv3);

        s=getIntent().getExtras().getString("k");
        tv.setText(s);
        s1=getIntent().getExtras().getString("k1");
        tv1.setText(s1);
        s2=getIntent().getExtras().getString("k2");
        tv2.setText(s2);
        spin=getIntent().getExtras().getString("k3");
        tv3.setText(spin);

    }
}
