package com.example.yazlab22;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{

    Spinner girisSpinner;
    ArrayAdapter<CharSequence> myAdapter;
    public static String girisSpinnertut;

    Button girisButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        girisSpinner = (Spinner) findViewById(R.id.girisSpinner);
        myAdapter =  ArrayAdapter.createFromResource(this,R.array.girisSpinner,android.R.layout.simple_spinner_item);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        girisSpinner.setAdapter(myAdapter);
        girisSpinner.setOnItemSelectedListener(this);


        girisButton = (Button) findViewById(R.id.girisButton);
        girisButton.setOnClickListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        girisSpinnertut = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {

        if(v.getId() == girisButton.getId()){
            Intent Gecis = new Intent(MainActivity.this,Gecis.class);
            startActivity(Gecis);
        }

    }

}
