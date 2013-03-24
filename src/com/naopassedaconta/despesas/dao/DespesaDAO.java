package com.naopassedaconta.despesas.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.naopassedaconta.core.db.BaseDAO;
import com.naopassedaconta.despesas.models.Despesa;

public class DespesaDAO extends BaseDAO {
	public static String TABLE_NAME = "despesa";
	public static DespesaDAO _instance;
	
	public static interface Columns {
		String ID = "id";
		String DESCRICAO = "descricao";
		String VALOR = "valor";
	}
	
	public DespesaDAO() {
		super();
	}
	
	public static synchronized DespesaDAO getInstance() {
		if (_instance == null)
			_instance = new DespesaDAO();
		
		return _instance;
	}

	@Override
	public void createTable(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE " + TABLE_NAME + " ("
				+ Columns.ID + " INTEGER PRIMARY KEY,"
				+ Columns.DESCRICAO + " TEXT NOT NULL, "
				+ Columns.VALOR + " INTEGER NOT NULL)");
		
	}

	@Override
	public void dropTable(SQLiteDatabase db) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		
	}
	
	public void insert(Despesa d){
		SQLiteDatabase db = getWritableDatabase();
		ContentValues vals = new ContentValues();
		
		vals.put(Columns.ID, d.id);
		vals.put(Columns.DESCRICAO, d.descricao);
		vals.put(Columns.VALOR, d.valor);
		
		db.insert(TABLE_NAME, null, vals);
	}
	
	public List<Despesa> getDespesas(){
		Cursor c = getReadableDatabase().query(
				TABLE_NAME, null, null, null, null, null, null);
		
		return fillList(c);
		
	}
	
	private static ArrayList<Despesa> fillList(Cursor c){
		ArrayList<Despesa> despesas = new ArrayList<Despesa>();
		
		c.moveToFirst();
		while (!c.isAfterLast()){
			Despesa d = new Despesa();
			d.id = c.getString(c.getColumnIndex(Columns.ID));
			d.descricao = c.getString(c.getColumnIndex(Columns.DESCRICAO));
			d.valor = c.getString(c.getColumnIndex(Columns.VALOR));
			
			despesas.add(d);
			c.moveToNext();
		}
		c.close();
		return despesas;
	}

}
