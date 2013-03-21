package com.naopassedaconta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.naopassedaconta.core.db.DatabaseHelper;

public class MainActivity extends Activity {

	DatabaseHelper dbHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		dbHelper = DatabaseHelper.initInstance(this);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		((Button) findViewById(R.id.btn_add_despesa))
			.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v){
					Intent i = new Intent(MainActivity.this, AddDespesaActivity.class);
					startActivityForResult(i, 27);
				}
			});
		
		return true;
	}

}
