package com.naopassedaconta;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.naopassedaconta.core.db.DatabaseHelper;
import com.naopassedaconta.despesas.models.Despesa;

public class MainActivity extends Activity {

	DatabaseHelper dbHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		dbHelper = DatabaseHelper.initInstance(this);
		setContentView(R.layout.activity_main);		
	}
	
	@Override
	protected void onStart(){
		super.onStart();
		List<Despesa> despesas = Despesa.getDespesas();
		int total = 0;
		
		if (despesas.size() != 0){
			TableLayout tabela = ((TableLayout) findViewById(R.id.tableLayout));
			tabela.setStretchAllColumns(true);
			tabela.setShrinkAllColumns(true);
	        
			tabela.removeAllViews();
			
			TableRow rowTitulo = new TableRow(this);			
			TextView descricaoLabel = new TextView(this);
			descricaoLabel.setText("Descrição");
			descricaoLabel.setTextSize(25);
			
			TextView valorLabel = new TextView(this);
			valorLabel.setText("Valor");
			valorLabel.setTextSize(25);
			
			rowTitulo.addView(descricaoLabel);
			rowTitulo.addView(valorLabel);

			tabela.addView(rowTitulo);
			
			for (int i = 0; i < despesas.size(); i++){
				Despesa object = (Despesa) despesas.get(i);
				
				TableRow row = new TableRow(this);			
				TextView descricao = new TextView(this);
				descricao.setText(object.descricao);
				descricao.setTextSize(15);
				
				TextView valor = new TextView(this);
				valor.setText("R$ "+object.valor);
				valor.setTextSize(19);
				
				row.addView(descricao);
				row.addView(valor);
				
				int valorInt = Integer.parseInt(object.valor);
				total += valorInt;
				
				
				tabela.addView(row);
			}
			
			TableRow totalRow = new TableRow(this);
			TextView totalString = new TextView(this);
			totalString.setText("R$ " + Integer.toString(total));
			totalString.setTextSize(23);
			
			TextView blank = new TextView(this);
			blank.setText("");
			blank.setTextSize(29);
			
			totalRow.addView(blank);
			totalRow.addView(totalString);
			tabela.addView(totalRow);
			
		}
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
