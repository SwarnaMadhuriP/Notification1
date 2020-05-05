package com.example.notification1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.example.notification1.App.CHANNEL_ID_1;
import static com.example.notification1.App.CHANNEL_ID_2;

public class MainActivity extends AppCompatActivity {
 private NotificationManagerCompat notificationmanager;
 private EditText editTextTitle,editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationmanager=NotificationManagerCompat.from(this);
        editTextTitle=(EditText)findViewById(R.id.editText1);
        editTextMessage=(EditText)findViewById(R.id.editText2);

    }
    public  void sendOnChannel1(View v){
        Notification notification=new NotificationCompat.Builder(this, CHANNEL_ID_1)
                .setSmallIcon(R.drawable.ic_message_black_24dp)
                .setContentTitle(editTextTitle.getText().toString())
                .setContentText(editTextMessage.getText().toString())
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setOnlyAlertOnce(true)
                .build();
        notificationmanager.notify(1,notification);
    }
    public  void sendOnChannel2(View v){
        Notification notification=new NotificationCompat.Builder(this, CHANNEL_ID_2)
                .setSmallIcon(R.drawable.ic_message_black_24dp)
                .setContentTitle(editTextTitle.getText().toString())
                .setContentText(editTextMessage.getText().toString())
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build();
        notificationmanager.notify(2,notification);

    }
}
