/*
 * Copyright (C) 2013 Andreas Stuetz <andreas.stuetz@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.phi.tuvionline.fragment_main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.phi.tuvionline.R;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

public class FramentBirthday extends Fragment {

	private static final String ARG_POSITION = "position";

	private int position;
	EditText et_day;
	ImageView btn_submit;
	ImageView btn_datepicker;
	public static FramentBirthday newInstance(int position) {
		FramentBirthday f = new FramentBirthday();
		Bundle b = new Bundle();
		b.putInt(ARG_POSITION, position);
		f.setArguments(b);
		return f;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		position = getArguments().getInt(ARG_POSITION);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View  v = inflater.inflate(R.layout.fragment_follow_birthday,container,false);
		et_day = (EditText) v.findViewById(R.id.bd_et_birthday);
		btn_submit = (ImageView) v.findViewById(R.id.bd_btn_submit);
		btn_datepicker = (ImageView) v.findViewById(R.id.bd_btn_pickday);

//		et_name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//			@Override
//			public void onFocusChange(View v, boolean hasFocus) {
//				if (hasFocus) btn_submit.setVisibility(View.VISIBLE);
//				else btn_submit.setVisibility(View.GONE);
//			}
//		});

		btn_submit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String name = et_day.getText().toString();
				Toast.makeText(getActivity(),"pressed",Toast.LENGTH_SHORT).show();
				processIt(name);

			}
		});
		btn_datepicker.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				showDateDialog();
			}
		});
		et_day.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(),"bbbbbbbbbbbbbbb",Toast.LENGTH_SHORT).show();
			}
		});

		return v;
	}

	@Override
	public void onResume() {
		super.onResume();
		if (et_day.getText().toString() == null || et_day.getText().toString().equals(""))
		{
			btn_submit.setVisibility(View.GONE);
		} else
		{
			btn_submit.setVisibility(View.VISIBLE);
		}
	}

	public void processIt(String name)
	{}

	private void showDateDialog() {
		Calendar now = Calendar.getInstance();
		DatePickerDialog dpd = DatePickerDialog.newInstance(new DatePickerDialog.OnDateSetListener() {
				 @Override
				 public void onDateSet(com.wdullaer.materialdatetimepicker.date.DatePickerDialog datePickerDialog, int i, int i1, int i2) {
						et_day.setText(i+"-"+i1+"-"+i2);
						btn_submit.setVisibility(View.VISIBLE);
				 }
			 }, now.get(Calendar.YEAR),
				now.get(Calendar.MONTH),
				now.get(Calendar.DAY_OF_MONTH));

		dpd.show(getActivity().getFragmentManager(),"Datepickerdialog");
	}
}