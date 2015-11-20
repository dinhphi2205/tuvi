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

import com.phi.tuvionline.R;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

public class FramentBirthday2 extends Fragment {

	private static final String ARG_POSITION = "position";

	private int position;
	EditText et_day1;
	EditText et_day2;
	ImageView btn_submit;
    boolean iset1Click = true;

	public static FramentBirthday2 newInstance(int position) {
		FramentBirthday2 f = new FramentBirthday2();
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

		View  v = inflater.inflate(R.layout.fragment_follow_2birthday,container,false);
        et_day1 = (EditText) v.findViewById(R.id.bd2_et_birthday1);
        et_day2 = (EditText) v.findViewById(R.id.bd2_et_birthday2);
        btn_submit = (ImageView) v.findViewById(R.id.bd2_btn_submit);
        btn_submit.setVisibility(View.GONE);
        et_day1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iset1Click = true;
                showDateDialog();
            }
        });
        et_day2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iset1Click = false;
                showDateDialog();
            }
        });
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
		return v;
	}

	@Override
	public void onResume() {
		super.onResume();

	}

	public void processIt(String name)
	{}

	private void showDateDialog() {
		Calendar now = Calendar.getInstance();
		DatePickerDialog dpd = DatePickerDialog.newInstance(new DatePickerDialog.OnDateSetListener() {
				 @Override
				 public void onDateSet(DatePickerDialog datePickerDialog, int i, int i1, int i2) {
                    if (iset1Click)
                    {
                        et_day1.setText(i+"-"+i1+"-"+i2);
                    }
                    else
                    {
                        et_day2.setText(i+"-"+i1+"-"+i2);
                    }
                    if (et_day1.getText().toString() != null && !et_day1.getText().toString().equals("")
                            && et_day1.getText().toString() != null && !et_day1.getText().toString().equals(""))
                    {
                        btn_submit.setVisibility(View.VISIBLE);
                    }
				 }
			 }, now.get(Calendar.YEAR),
				now.get(Calendar.MONTH),
				now.get(Calendar.DAY_OF_MONTH));

		dpd.show(getActivity().getFragmentManager(),"Datepickerdialog");
	}
}