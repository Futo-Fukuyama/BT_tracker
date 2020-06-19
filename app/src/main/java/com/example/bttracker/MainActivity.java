package com.example.bttracker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNotificationChannel();

        TextView mainButton1 = findViewById(R.id.Mainbutton1);
        mainButton1.setOnClickListener(this);

        TextView mainButton2 = findViewById(R.id.Mainbutton2);
        mainButton2.setOnClickListener(this);

        TextView mainButton3 = findViewById(R.id.Mainbutton3);
        mainButton3.setOnClickListener(this);

        TextView mainButton4 = findViewById(R.id.Mainbutton4);
        mainButton4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)  {
         switch (view.getId()) {
             case R.id.Mainbutton1:
                    // If Mainbutton1 is clicked, do something
                    Intent toLog = new Intent(this, LogActivity.class);
                    startActivity(toLog);
                    break;
                case R.id.Mainbutton2:
                    Intent toNormal = new Intent(this, NormalActivity.class);
                    startActivity(toNormal);
                    break;
                case R.id.Mainbutton3:
                    Intent toMechanism = new Intent(this, MechanismActivity.class);
                    startActivity(toMechanism);
                    break;
                case R.id.Mainbutton4:
                    Intent openFeverLink = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.healthline.com/health/how-to-break-a-fever"));
                    if (openFeverLink.resolveActivity(getPackageManager()) != null) {
                        startActivity(openFeverLink);
                    }
                    break;
            }
        }

    public void setReminder(View view) {
        Toast.makeText(this, "Reminder set!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ReminderBroadcastReceiver.class);
        PendingIntent pd = PendingIntent.getBroadcast(this, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        long interval = 1000*6;
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), interval, pd);
    }

    private void createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            String channelID = "BT_Tracker_Channel";
            String channelName = "BTTrackerReminderChannel";
            String channelDescription = "Channel for BT Tracker Reminder";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(channelID, channelName, importance);
            channel.setDescription(channelDescription);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }



    }
}