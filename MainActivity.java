package com.example.internshipproject;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button add,remove,save;
    DynamicViews dnv;
    Context context;
    private LinearLayout mlayout;
    ViewGroup container;
    CheckBox cb;
    List<CheckBox> cblist=new ArrayList<>();
    EditText et,et2,et3,et4;
    private Adapter mAdapter;
    String st,st1,st2,spin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        mlayout = (LinearLayout)findViewById(R.id.ll2);
        add = (Button)findViewById(R.id.btnadd);
        remove=(Button) findViewById(R.id.btnremove);
        save=(Button)findViewById(R.id.btnsave);

        et=findViewById(R.id.et4);
        et2=findViewById(R.id.et);
        et3=findViewById(R.id.et2);
        et4=findViewById(R.id.et3);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Saved.class);
                st=et2.getText().toString();
                st1=et3.getText().toString();
                st2=et4.getText().toString();

                i.putExtra("k",st);
                i.putExtra("k1",st1);
                i.putExtra("k2",st2);
                i.putExtra("k3",spin);
                startActivity(i);
                finish();
            }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=Integer.parseInt(et.getText().toString());
                removeView(position);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dnv = new DynamicViews(context);
                mlayout.addView(dnv.descriptionCheckbox(getApplicationContext()));

            }
        });


        Spinner spinner=findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.ddl,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        spin=String.valueOf(spinner.getSelectedItem());
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text=parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {


    }

    public void removeView(int position){
        cblist.remove(position);
        mAdapter.notify();
    }




}
