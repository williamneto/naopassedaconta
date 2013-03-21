package com.naopassedaconta.core.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.naopassedaconta.despesas.dao.DespesaDAO;

public class DatabaseHelper extends SQLiteOpenHelper {
	private static final String DATABASE_NAME = "naopassedaconte.db";
	private static final int DATABASE_VERSION = 1;
	private static final String TAG = "dbHelper";
	private static DatabaseHelper _instance;
	private Context context;
	
	public DatabaseHelper(Context context){
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		this.context = context;
	}
	
	@Override
	public void onCreate(SQLiteDatabase db){
		//DespesaDAO.getInstance().createTable(db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	public static synchronized DatabaseHelper initInstance(Context context) {
        _instance = new DatabaseHelper(context);
        return _instance;
	}

	public static synchronized DatabaseHelper getInstance() {
        return _instance;
	}

	public Context getContext() {
		return context;
	}


}
