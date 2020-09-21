package com.example.startactivitylibrary;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AndroidLib extends AppCompatActivity {
    TextView txtDeviceInfoHome;
    Button btnGetDeviceInfo, btnGotoSecondActivity;
    ImageView btnBackFlutterView;
    String deviceInfo = "empty";
    String type = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);
        findById();
        receiveType();
        onHandleClick();
    }

    private void findById() {
        txtDeviceInfoHome = findViewById(R.id.txtDeviceInfoHome);
        btnGetDeviceInfo = findViewById(R.id.btnGetDeviceIno);
        btnGotoSecondActivity = findViewById(R.id.btnGotoSecondActivity);
        btnBackFlutterView = findViewById(R.id.btnOnBackFlutterView);
    }

    private void receiveType() {
        final Intent intentType = getIntent();
        type = intentType.getStringExtra("type");
    }

    private void onHandleClick() {
        btnGetDeviceInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deviceInfo = getDeviceInfoString(type);
                txtDeviceInfoHome.setText(deviceInfo);
            }
        });

        btnBackFlutterView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent data = new Intent();
                data.putExtra("deviceInfo", deviceInfo);
                setResult(Activity.RESULT_OK, data);
                finish();
            }
        });

        btnGotoSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AndroidLib.this, "Go to Second activity", Toast.LENGTH_LONG).show();
            }
        });
    }

    String getDeviceInfoString(String type) {
        if (type.equals("MODEL")) {
            return Build.MODEL;
        }
        return "";
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
