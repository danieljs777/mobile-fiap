package com.example.megasena.model;
import java.util.ArrayList;
import java.util.List;

import com.example.megasena.util.DataSource;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

public class SorteioDAO extends DataSource 
{
	
	private static final String TABLE_NAME 			= "sorteios";	

	private static final String FIELD_ID 			= "id";
	private static final String FIELD_CONCURSO 		= "concurso";
	private static final String FIELD_DEZENAS 		= "dezenas";
	
	private static final String[] ALL_FIELDS 		= new String[] { FIELD_ID, FIELD_CONCURSO, FIELD_DEZENAS};
	
	private static final String INSERT 				= "insert into " + TABLE_NAME + " (" + FIELD_CONCURSO + ", " + FIELD_DEZENAS + ") values (?, ?)";
	
	private SQLiteStatement insertStmt;

	public SorteioDAO(Context context) 
	{
		super(context);
		this.insertStmt = super.database.compileStatement(INSERT);
	}
	
	public long insert(SorteioVO jogo)
	{
		this.insertStmt.bindLong(1, jogo.getConcurso());
		this.insertStmt.bindString(2, jogo.getDezenas());
		return this.insertStmt.executeInsert();
	}
	
	public SorteioVO findById(Integer id)
	{

		String[] args = new String[] { String.valueOf(id) };
		
		Cursor cursor = database.query(TABLE_NAME, ALL_FIELDS, FIELD_ID + "=?", args, null, null, null);
		
		if (cursor.moveToFirst())
		{
			SorteioVO sorteio = new SorteioVO();
			sorteio.setConcurso( cursor.getInt( 0 ) ) ;
			sorteio.setDezenas( cursor.getString( 1 ) ) ;
			sorteio.setData( cursor.getString( 2 ) ) ;
			
			return sorteio;
		}
		else
		{
			return null;
		}
	}	
	
	public List<SorteioVO> selectAll( )
	{
		List<SorteioVO> list = new ArrayList<SorteioVO>( ) ;
		Cursor cursor = this.database.query( TABLE_NAME, ALL_FIELDS, null, null, null, null, "codigo" ) ;
		if (cursor.moveToFirst( ))
		{
			do
			{
				SorteioVO sorteio = new SorteioVO( ) ;
				sorteio.setConcurso( cursor.getInt( 0 ) ) ;
				sorteio.setDezenas( cursor.getString( 1 ) ) ;
				sorteio.setData( cursor.getString( 2 ) ) ;

				list.add( sorteio ) ;
			}
			while (cursor.moveToNext( )) ;
		}
		
		if (cursor != null && !cursor.isClosed( ))
		{
			cursor.close( ) ;
		}
		
		return list ;
	}	
	

	

}
