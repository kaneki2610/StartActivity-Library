package com.example.demo_android_library;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.startactivitylibrary.NewDesign;


public class StartActivity extends AppCompatActivity implements NewDesign.OnHeadlineSelectedListener {
	ImageView btnBackFlutterView;
	String deviceInfo = "";
	String model = "";
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_activity);

		Intent intent = getIntent();
		model = intent.getStringExtra("type");

		btnBackFlutterView = findViewById(R.id.btnOnBackFlutterView);
		handleClick();
		FragmentManager fragmentManager = getSupportFragmentManager();
		NewDesign newDesign = (NewDesign) fragmentManager.findFragmentById(R.id.fragment);
		newDesign.setModel(model);
	}

	@Override
	public void onAttachFragment(@NonNull Fragment fragment) {
		super.onAttachFragment(fragment);
		if (fragment instanceof NewDesign) {
			NewDesign headlinesFragment = (NewDesign) fragment;
			headlinesFragment.setOnHeadlineSelectedListener(this);
		}
	}

	public void handleClick() {
		btnBackFlutterView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				final Intent data = new Intent();
				data.putExtra("data", deviceInfo);
				setResult(Activity.RESULT_OK, data);
				finish();
			}
		});
	}

	@Override
	public void onGetDeviceInfo(String s) {
		deviceInfo = s;
	}
}