package com.example.android28;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Notification notification;
    private NotificationManager manager;
    private Button btnNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNotification = (Button)findViewById(R.id.btnNotification);
        manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        btnNotification.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                manager.notify(0,notification_method("Notification","訊息來了"));
            }
        });
    }

    private Notification notification_method(String title,String text) {
        return notification = new Notification.Builder(this)
                .setContentTitle(title)
                .setContentText(text)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.ic_launcher_background)
                .build();
    }
}