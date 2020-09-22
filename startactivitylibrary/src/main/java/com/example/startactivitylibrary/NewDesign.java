package com.example.startactivitylibrary;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NewDesign extends Fragment {
	TextView txtDeviceInfoHome;
	Button btnPushData;
	EditText editText;
	OnHeadlineSelectedListener callback;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_new_design, container, false);
		findById(view);
		onHandleClick();
		return view;
	}

	public void setOnHeadlineSelectedListener(OnHeadlineSelectedListener callback) {
		this.callback = callback;
	}

	public interface OnHeadlineSelectedListener {
		public void onGetValue(String value);
	}


	public NewDesign() {
	}

	public void setModel(String value) {
		if (value.isEmpty()) {
			txtDeviceInfoHome.setText("null");
		} else {
			txtDeviceInfoHome.setText(value);
		}
	}

	private void findById(View view) {
		txtDeviceInfoHome = view.findViewById(R.id.txtDeviceInfoHome);
		btnPushData = view.findViewById(R.id.btnGetDeviceIno);
		editText = view.findViewById(R.id.edtEditText);
	}

	private void onHandleClick() {
		btnPushData.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (editText.getText().toString().trim().equalsIgnoreCase("")) {
					editText.setError("Value Can\'t Be Empty");
				} else {
					Toast.makeText(getActivity(), "Push success: " + editText.getText().toString(), Toast.LENGTH_LONG).show();
					callback.onGetValue(editText.getText().toString().trim());
				}
			}
		});
	}
}