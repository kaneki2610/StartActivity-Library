package com.example.demo_android_library;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
	Button button;
	public static final int REQUEST_CODE = 1000;
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button = findViewById(R.id.btnClick);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(MainActivity.this, StartActivity.class);
				intent.putExtra("type", "MODEL");
				startActivityForResult(intent, REQUEST_CODE);
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode == REQUEST_CODE) {
			if(resultCode == RESULT_OK) {
				String deviceInfo = data.getStringExtra("data");
				if(deviceInfo != null) {
					Toast.makeText(MainActivity.this, deviceInfo, Toast.LENGTH_LONG).show();
				} else {
					Toast.makeText(MainActivity.this, "ccccccccc", Toast.LENGTH_LONG).show();
				}
			}
		}
	}
}