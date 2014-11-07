package com.example.hospitalsystem;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DigitalClock;
import android.widget.TextView;

public class VitalSignsUpdate extends Activity implements OnClickListener {

	private Button save;
	private TextView date;
	Calendar c;
	SimpleDateFormat format;
	BroadcastReceiver timer;
	DigitalClock d;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vital_signs_update);
		timer = new BroadcastReceiver(){
			@Override
			public void onReceive(Context ctx, Intent intent)
			{
				
				date.setText(format.format(c.getTime()));

			}
		};
		this.registerReceiver(timer, new IntentFilter(Intent.ACTION_TIME_TICK));
		save = (Button) findViewById(R.id.save);
		save.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				clickSave();
			}
		});
		c = Calendar.getInstance();
		date = (TextView) findViewById(R.id.CurrentTime);
		format = new SimpleDateFormat("yyyy/MM/dd");
		date.setText(format.format(c.getTime()));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.vital_signs_update, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void clickSave() {
		//back end code goes here
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}
}
