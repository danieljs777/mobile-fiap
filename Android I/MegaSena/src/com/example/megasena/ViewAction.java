package com.example.megasena;

import com.example.megasena.model.Sorteio;
import com.google.gson.Gson;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewAction extends ActionBarActivity implements android.view.View.OnClickListener
{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_action);
		
        Button btnViewAction = (Button)findViewById(R.id.btn_consult);
        btnViewAction.setOnClickListener(this);				

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_action, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private class GetDataTask extends AsyncTask< String, Void, String>
	{

		@Override
		protected void onPostExecute( String result )
		{
			super.onPostExecute( result ) ;

			Sorteio sorteio = this.toObject(result);
						
			( ( TextView ) ViewAction.this.findViewById( R.id.fld_game_id ) ).setText( sorteio.getConcurso().toString() ) ;
			( ( TextView ) ViewAction.this.findViewById( R.id.fld_game_data ) ).setText( sorteio.getData().toString() ) ;
			( ( TextView ) ViewAction.this.findViewById( R.id.fld_game_numbers ) ).setText( sorteio.getDezenas().toString() ) ;
		}

		@Override
		protected String doInBackground(String... params) {
			MegaSenaClient client = new MegaSenaClient( ) ;
			
			String gameId = ( ( TextView ) ViewAction.this.findViewById( R.id.txt_game_id ) ).getText().toString();
			
			String result = client.getResult( gameId ) ;
			
			return result;
			
		}
		
		public Sorteio toObject( String Json )
		{
			Json = Json.replaceAll("[()]", "").replaceAll("[/]", "").replaceAll("\\\\", "").replaceAll("Date", "");
			
			Gson gson = new Gson();  
			Sorteio sorteio = gson.fromJson(Json, Sorteio.class);
			return sorteio;
			
		}			

	}
	
    @Override
    public void onClick(View v)
    {
		GetDataTask task = new GetDataTask( ) ;
		task.execute(  ) ;
    }	
}
