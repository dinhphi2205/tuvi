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
import android.text.Editable;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.phi.tuvionline.R;

public class FramentName extends Fragment {

	private static final String ARG_POSITION = "position";

	private int position;
	EditText et_name;
	ImageView btn_submit;
	public static FramentName newInstance(int position) {
		FramentName f = new FramentName();
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

		View  v = inflater.inflate(R.layout.fragment_follow_name,container,false);

		et_name = (EditText) v.findViewById(R.id.name_et_name);
		btn_submit = (ImageView) v.findViewById(R.id.name_btn_submit);

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
				String name = et_name.getText().toString();
				Toast.makeText(getActivity(),"pressed",Toast.LENGTH_SHORT).show();
				processIt(name);

			}
		});

		return v;
	}

	public void processIt(String name)
	{}
}