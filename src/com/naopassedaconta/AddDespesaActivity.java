package com.naopassedaconta;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.naopassedaconta.core.db.DatabaseHelper;
import com.naopassedaconta.despesas.models.Despesa;

public class AddDespesaActivity extends Activity {
	DatabaseHelper dbHelper;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		dbHelper = DatabaseHelper.initInstance(this);
		setContentView(R.layout.add_despesa);
		
		((Button) findViewById(R.id.btn_add_despesa))
			.setOnClickListener(clickAddDespesa);
	}
	
	private OnClickListener clickAddDespesa = new OnClickListener() {
		public void onClick(View v) {
			Despesa d = new Despesa();
			
			String descricao = ((EditText) findViewById(R.id.descricao_text)).getText().toString();
			String valor = ((EditText) findViewById(R.id.valor)).getText().toString();
			
			d.id = null;
			d.descricao = descricao;
			d.valor = valor;
			
			d.save();
			
			((EditText) findViewById(R.id.descricao_text)).setText("");
			((EditText) findViewById(R.id.valor)).setText("");
			
			finish();
		}
	};

}
