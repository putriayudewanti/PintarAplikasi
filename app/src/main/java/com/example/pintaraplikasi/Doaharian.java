package com.example.pintaraplikasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Doaharian extends AppCompatActivity {
    ListView listView;
    String[] listItems = {"Doa Bangun Tidur", "Doa Sebelum Tidur", " Doa Masuk Kamar Mandi",
            "Doa Keluar Kamar Mandi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doaharian);

        ListView listView = findViewById(R.id.textview);
        List<String> list = new ArrayList<>();
        list.add("Doa Sebelum Tidur");
        list.add("Doa Bangun Tidur");
        list.add("Doa Masuk Kamar Mandi");
        list.add("Doa Keluar Kamar Mandi");
        list.add("Doa Masuk Rumah");
        list.add("Doa Keluar Rumah");
        list.add("Doa Ketika Bercermin");


        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    //clicked apple

                    startActivity(new Intent(Doaharian.this,TidurSebelum.class));

                }else if(position==1){
                    //clicked orange
                    startActivity(new Intent(Doaharian.this,Banguntidur.class));

                }else if(position==2){
                    //clicked orange
                    startActivity(new Intent(Doaharian.this,Masukwc.class));

                }
                else if(position==3){
                    //clicked orange
                    startActivity(new Intent(Doaharian.this,Keluarwc.class));

                }
                else if(position==4){
                    //clicked orange
                    startActivity(new Intent(Doaharian.this,Masukrumah.class));

                }
                else if(position==5){
                    //clicked orange
                    startActivity(new Intent(Doaharian.this,Keluarrumah.class));

                }
                else if(position==6){
                    //clicked orange
                    startActivity(new Intent(Doaharian.this,Bercermin.class));

                }
            }
        });


    }}