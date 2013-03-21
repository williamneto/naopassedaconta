package com.naopassedaconta;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AddDespesaActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_despesa);
		
		((Button) findViewById(R.id.btn_add_despesa))
			.setOnClickListener(clickAddDespesa);
	}
	
	private OnClickListener clickAddDespesa = new OnClickListener() {
		public void onClick(View v) {
			
		}
	};

}
