package com.example.megasena.util;

import java.io.File;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

public class DataSource extends SQLiteOpenHelper {

	protected Context context;
	protected SQLiteDatabase database;

	public static String DATABASE_COMPLETE = "";
	public static final String DATABASE_NAME = "app_megasena.db";
	public static final int DATABASE_VERSION = 4;

	public static final String ORDER_ASC = " ASC";
	public static final String ORDER_DESC = " DESC";

	static
	{

		DATABASE_COMPLETE = Environment.getExternalStorageDirectory().getPath()	+ File.separator + DATABASE_NAME;
	}

	public boolean createAllTables()
	{
		return true;
	}

	public boolean cleanUp()
	{
		return true;
	}

	public DataSource(Context context)
	{
		super(context, DATABASE_COMPLETE, null, DATABASE_VERSION);
		this.context = context;
		this.database = context.openOrCreateDatabase( DATABASE_COMPLETE, Context.MODE_PRIVATE, null );
		this.database = getWritableDatabase();
	}

	public void onCreate(SQLiteDatabase db)
	{
		db.execSQL("CREATE TABLE sorteios (id INTEGER PRIMARY KEY AUTOINCREMENT, concurso varchar(20), dezenas varchar(20), data DATETIME)");
	}

	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		db.execSQL("DROP TABLE IF EXISTS sorteios");
		onCreate(db);
	}

	public void close()
	{
		this.database.close();
	}

}