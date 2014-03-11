package com.perfectidea.exam;

import java.io.IOException;
import java.util.ArrayList;

import com.perfectidea.exam.R;
import com.perfectidea.exam.share_functions.DatabaseAccess;
import com.perfectidea.exam.share_functions.LogUtil;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ExamSimulationActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exam_simulation);
		
		ArrayList<String> licenses;
		try {
			licenses = DatabaseAccess.getInstance().GetLicenseGroups();
			for (String str : licenses) {
				LogUtil.e("license : " + str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LogUtil.e(e.getMessage());
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.exam_simulation, menu);
		return true;
	}

}
