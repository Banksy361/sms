package com.example.smsct;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edittextnum;
    private EditText edittextmsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.SEND_SMS,Manifest.permission.READ_SMS}, PackageManager.PERMISSION_GRANTED);
        edittextmsg = findViewById(R.id.editText);
        edittextnum = findViewById(R.id.editText2);
    }

    public void smsend(View view){

        String message =edittextmsg.getText().toString();
        String number =edittextnum.getText().toString();
        SmsManager smsmngr =SmsManager.getDefault();
        smsmngr.sendTextMessage(number,null,message,null,null);

    }
}
