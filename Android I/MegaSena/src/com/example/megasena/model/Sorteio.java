package com.example.megasena.model ;

import java.util.Date;
import java.util.List ;
import org.json.JSONArray ;
import org.json.JSONException ;
import org.json.JSONObject ;

import com.google.gson.Gson;  

public class Sorteio
{

	private Integer Concurso ;
	private String Data ; 
	private String Dezenas ;
	

	public Integer getConcurso() {
		return Concurso;
	}

	public void setConcurso(Integer Concurso) {
		this.Concurso = Concurso;
	}
	
	
	public String getData() {
		return Data;
	}

	public void setData(String data) {
		Data = data;
	}

	public String getDezenas() {
		return Dezenas;
	}

	public void setDezenas(String dezenas) {
		Dezenas = dezenas;
	}

	public String toJSON( )
	{

		try
		{
			JSONObject jsonObj = new JSONObject( ) ;

			jsonObj.put( "Concurso", this.getConcurso() ) ;
			//jsonObj.put( "Data", this.getData( ) ) ; 
			jsonObj.put( "Dezenas", this.getDezenas( ) ) ;

			return jsonObj.toString( ) ;

		}
		catch (JSONException ex)
		{
			ex.printStackTrace( ) ;
		}

		return null ;

	}
	




}
