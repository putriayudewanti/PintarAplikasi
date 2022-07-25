package com.example.pintaraplikasi;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * Activity class to handle the ordering of donuts
 * @author Alark Patel, Nicolas Ku
 */

public class Zikir extends AppCompatActivity {
    String[] listItems = {"Doa Bangun Tidur", "Doa Sebelum Tidur", " Doa Masuk Kamar Mandi",
            "Doa Keluar Kamar Mandi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zikir);

        ListView listView = findViewById(R.id.textview);
        List<String> list = new ArrayList<>();
        list.add("DZIKIR SENIN");
        list.add("DZIKIR SELASA");
        list.add("DZIKIR RABU");
        list.add("DZIKIR KAMIS");
        list.add("DZIKIR JUM'AT");
        list.add("DZIKIR SABTU");
        list.add("DZIKIR MINGGU");


        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    //clicked apple

                    startActivity(new Intent(Zikir.this,Senin.class));

                }else if(position==1){
                    //clicked orange
                    startActivity(new Intent(Zikir.this,Selasa.class));

                }else if(position==2){
                    //clicked orange
                    startActivity(new Intent(Zikir.this,Rabu.class));

                }else if(position==3){
                    //clicked orange
                    startActivity(new Intent(Zikir.this,Kamis.class));

                }else if(position==4){
                    //clicked orange
                    startActivity(new Intent(Zikir.this,JUMAT.class));

                }else if(position==5){
                    //clicked orange
                    startActivity(new Intent(Zikir.this,Sabtu.class));

                }else if(position==6){
                    //clicked orange
                    startActivity(new Intent(Zikir.this,Minggu.class));

                }
            }
        });


    }

    private void StartActivity(Intent intent) {
    }
}