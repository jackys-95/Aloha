package com.example.hospitalsystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class IndividualData extends Activity implements OnClickListener {

	Button update;
	Button viewPrevRecord;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_individual_data);
		update = (Button) findViewById(R.id.UpdateRecord);
		update.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				clickUpdate();
			}
		});
		viewPrevRecord = (Button) findViewById(R.id.ViewPrevRecord);
		viewPrevRecord.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				clickPrevRecord();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.individual_data, menu);
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

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	
	public void clickUpdate() {
		Intent updateIntent = new Intent(this, VitalSignsUpdate.class);
		startActivity(updateIntent);
	}
	
	public void clickPrevRecord(){
		Intent updateIntent = new Intent(this, PreviousRecord.class);
		startActivity(updateIntent);
	}
	
}
