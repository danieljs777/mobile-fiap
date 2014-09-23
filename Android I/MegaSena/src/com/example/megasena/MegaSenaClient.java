package com.example.megasena ;

import java.io.BufferedReader ;
import java.io.InputStream ;
import java.io.InputStreamReader ;
import java.util.ArrayList ;
import java.util.List ;

import org.apache.http.HttpResponse ;
import org.apache.http.NameValuePair ;
import org.apache.http.client.entity.UrlEncodedFormEntity ;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient ;
import org.apache.http.message.BasicNameValuePair ;

import android.os.AsyncTask;

public class MegaSenaClient 
{
	private static String URL = "http://servicos.albertino.eti.br/Loteria.asmx/GetMegaSena_PorConcurso_JSON" ;

	public String getResult( String params )
	{

		try
		{
			StringBuffer buffer = new StringBuffer( ) ;

			org.apache.http.client.HttpClient client = new DefaultHttpClient( ) ;
			
			HttpPost post = new HttpPost( URL ) ;
			List<NameValuePair> nvList = new ArrayList<NameValuePair>( ) ;
			BasicNameValuePair bnvp = new BasicNameValuePair( "numero", params.toString() ) ;

			nvList.add( bnvp ) ;
			post.setEntity( new UrlEncodedFormEntity( nvList ) ) ;

			HttpResponse resp = client.execute( post ) ;

			InputStream is = resp.getEntity( ).getContent( ) ;
			BufferedReader reader = new BufferedReader( new InputStreamReader( is ) ) ;
			StringBuilder str = new StringBuilder( ) ;
			String line = null ;
			while (( line = reader.readLine( ) ) != null)
			{
				str.append( line + "\n" ) ;
			}
			is.close( ) ;
			buffer.append( str.toString( ) ) ;

			return buffer.toString( ) ;
		}
		catch (Throwable t)
		{
			t.printStackTrace( ) ;
		}

		return null ;
	}


}
