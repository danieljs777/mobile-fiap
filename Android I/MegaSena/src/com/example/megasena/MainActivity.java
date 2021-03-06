package com.example.megasena ;

import java.util.ArrayList ;
import java.util.List ;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.example.megasena.model.SorteioVO;

import android.app.Activity ;
import android.content.DialogInterface;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.os.AsyncTask ;
import android.os.Bundle ;
import android.util.Log;
import android.view.Menu ;
import android.view.View;
import android.widget.Button;
import android.widget.TextView ;

public class MainActivity extends Activity
{

	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState ) ;
		setContentView( R.layout.activity_main ) ;
		
        Button btnViewAction = (Button)findViewById(R.id.button);
        btnViewAction.setOnClickListener
        (
    		new OnClickListener() {
    			@Override
    			public void onClick(View v) {
    				Intent viewIntent = new Intent(getBaseContext( ), ViewAction.class);
    				startActivity(viewIntent);    				
    			}
    		}
        );		
        
        Button btnNewGame = (Button)findViewById(R.id.button2);
        btnNewGame.setOnClickListener
        (
    		new OnClickListener() {
    			@Override
    			public void onClick(View v) {
    				Intent viewIntent = new Intent(getBaseContext( ), NewGame.class);
    				startActivity(viewIntent);    				
    			}
    		}
        );		     
        
        Button btnCheckGame = (Button)findViewById(R.id.button3);
        btnNewGame.setOnClickListener
        (
    		new OnClickListener() {
    			@Override
    			public void onClick(View v) {
    				Intent viewIntent = new Intent(getBaseContext( ), NewGame.class);
    				startActivity(viewIntent);    				
    			}
    		}
        );		          
	}


	@Override
	public boolean onCreateOptionsMenu( Menu menu )
	{
		getMenuInflater( ).inflate( R.menu.main, menu ) ;
		return true ;
	}

   
    




}
