package com.example.pintaraplikasi;

import java.util.Calendar;
import android.text.method.ScrollingMovementMethod;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class Alarm extends Activity  {



    TimePicker picker;
    Button buttonStart;
    Button buttonCancel;
    TextView textPrompt;

    TimePickerDialog timePickerYeah;

    final static int req = 1;
    private ImageView ImageViewStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal);

        textPrompt=(TextView) findViewById(R.id.promptID);
        ImageViewStart=(ImageView) findViewById(R.id.btSett );

        ImageViewStart.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                textPrompt.setText("");
                openTimePicker(false);
            }});

        buttonCancel=(Button) findViewById(R.id.btCancel);
        buttonCancel.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                cancelAlarm();
            }});
    }

    private void openTimePicker(boolean is24jam)
    {
        Calendar kalender=Calendar.getInstance();
        timePickerYeah = new TimePickerDialog(
                Alarm.this,
                timeSetListener,
                kalender.get(Calendar.HOUR_OF_DAY),
                kalender.get(Calendar.MINUTE),
                true);

        timePickerYeah.setTitle("Set Alarm Anda");
        timePickerYeah.show();
    }

    OnTimeSetListener timeSetListener=new OnTimeSetListener()
    {

        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

            Calendar calNow = Calendar.getInstance();
            Calendar calSet = (Calendar) calNow.clone();

            calSet.set(Calendar.HOUR_OF_DAY, hourOfDay);
            calSet.set(Calendar.MINUTE, minute);
            calSet.set(Calendar.SECOND, 0);
            calSet.set(Calendar.MILLISECOND, 0);

            if(calSet.compareTo(calNow) <= 0){
                //jika ternyata waktu lewat maka alarm akan di atur untuk besok
                calSet.add(Calendar.DATE, 1);
            }

            setAlarm(calSet);
        }};

    private void setAlarm(Calendar targetCal){

        textPrompt.setText("\n\n"+ "Alarm Telah Diatur Pada: "+targetCal.getTime());

        Intent intent = new Intent(getBaseContext(), ReceiverYeah.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), req, intent, 0);
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(), pendingIntent);

    }
    private void cancelAlarm(){

        textPrompt.setText("\n\n"+"Alarm Telah Dibatalkan!");

        Intent intent = new Intent(getBaseContext(), ReceiverYeah.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), req, intent, 0);
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(pendingIntent);
    }
}





