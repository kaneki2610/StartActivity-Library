package com.example.startactivitylibrary;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class NewDesign extends Fragment {
	private static final String ARG_PARAM1 = "param1";
	private static final String ARG_PARAM2 = "param2";

	private String mParam1;
	private String mParam2;

	TextView txtDeviceInfoHome;
	Button btnGetDeviceInfo;
	String deviceInfo = "empty";
	String type = "";

	OnHeadlineSelectedListener callback;

	public void setOnHeadlineSelectedListener(OnHeadlineSelectedListener callback) {
		this.callback = callback;
	}

	public interface OnHeadlineSelectedListener {
		public void onGetDeviceInfo(String deviceInfo);
	}


	public NewDesign() {
	}

	public static NewDesign newInstance(String param1, String param2) {
		NewDesign fragment = new NewDesign();
		Bundle args = new Bundle();
		args.putString(ARG_PARAM1, param1);
		args.putString(ARG_PARAM2, param2);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
			mParam1 = getArguments().getString(ARG_PARAM1);
			mParam2 = getArguments().getString(ARG_PARAM2);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_new_design, container, false);
		findById(view);
		onHandleClick();
		return view;
	}
	
	public void setModel(String model) {
		type = model;
		Toast.makeText(getActivity(), "Model: " + type, Toast.LENGTH_SHORT).show();
	}

	private void findById(View view) {
		txtDeviceInfoHome = view.findViewById(R.id.txtDeviceInfoHome);
		btnGetDeviceInfo = view.findViewById(R.id.btnGetDeviceIno);
	}

	private void onHandleClick() {
		btnGetDeviceInfo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				deviceInfo = getDeviceInfoString(type);
				txtDeviceInfoHome.setText(deviceInfo);
				callback.onGetDeviceInfo(deviceInfo);
			}
		});
	}

	String getDeviceInfoString(String type) {
		if (type.equals("MODEL")) {
			return Build.MODEL;
		}
		return "";
	}

}