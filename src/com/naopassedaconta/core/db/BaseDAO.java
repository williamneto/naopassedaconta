package com.naopassedaconta.core.db;

import android.database.sqlite.SQLiteDatabase;

public abstract class BaseDAO {
	private DatabaseHelper helper;
	
	public BaseDAO() {
		this.helper = DatabaseHelper.getInstance();
	}
	
	public DatabaseHelper getHelper(){
		return helper;
	}
	
	public synchronized SQLiteDatabase getWritableDatabase() {
		return this.helper.getWritableDatabase();
	}

	public synchronized SQLiteDatabase getReadableDatabase() {
		return this.helper.getReadableDatabase();
	}
	
	public abstract void createTable(SQLiteDatabase db);
	public abstract void dropTable(SQLiteDatabase db);

}
