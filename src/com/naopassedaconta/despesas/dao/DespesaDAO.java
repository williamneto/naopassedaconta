package com.naopassedaconta.despesas.dao;

import android.database.sqlite.SQLiteDatabase;

import com.naopassedaconta.core.db.BaseDAO;

public class DespesaDAO extends BaseDAO {
	public static String TABLE_NAME = "despesa";
	public static DespesaDAO _instance;
	
	public static interface Columns {
		String ID = "id";
		String VALOR = "valor";
		String DATA = "data";
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dropTable(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
	}

}
