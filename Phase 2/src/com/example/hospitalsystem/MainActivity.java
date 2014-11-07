package com.example.hospitalsystem;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button searchButton;
	private Button createNew;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		searchButton = (Button) findViewById(R.id.LookUpPatient);
		searchButton.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				clickSearch();
			}
		});
		createNew = (Button) findViewById(R.id.CreateANewRecord);
		createNew.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				clickAddPatient();
			}
		});
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub


	}

	
	public void clickSearch() {
		Intent searchIntent = new Intent(this, LookUpPatient.class);
		startActivity(searchIntent);
	}
	
	public void clickAddPatient(){
		Intent createNewRecordIntent = new Intent(this, CreateNewRecord.class);
		startActivity(createNewRecordIntent);
	}
}
