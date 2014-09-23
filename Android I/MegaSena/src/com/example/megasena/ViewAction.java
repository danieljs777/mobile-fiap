package com.example.megasena;

import java.text.SimpleDateFormat;

import com.example.megasena.model.SorteioVO;
import com.example.megasena.util.DialogUtils;
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
import android.widget.EditText;

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
			
			try
			{
				SorteioVO sorteio = this.toObject(result);
				
				java.util.Date date = new java.util.Date(Long.parseLong(sorteio.getData().toString()));
				
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy");
				date = formatter.parse(date.toString());
						
				( ( TextView ) ViewAction.this.findViewById( R.id.fld_game_id ) ).setText( sorteio.getConcurso().toString() ) ;
				( ( TextView ) ViewAction.this.findViewById( R.id.fld_game_data ) ).setText( (date.toString()) ) ;
				( ( TextView ) ViewAction.this.findViewById( R.id.fld_game_numbers ) ).setText( sorteio.getDezenas().toString().replaceAll("|", ",") ) ;				
			}
			catch(Exception e)
			{
				DialogUtils.showMessageDialog(ViewAction.this.findViewById( R.id.fld_game_id ).getContext(), "Erro", e.getMessage());
			}


		}

		@Override
		protected String doInBackground(String... params) {
			MegaSenaClient client = new MegaSenaClient( ) ;
			
			String gameId = ( ( TextView ) ViewAction.this.findViewById( R.id.txt_game_id ) ).getText().toString();
			
			String result = client.getResult( gameId ) ;
			
			return result;
			
		}
		
		public SorteioVO toObject( String Json )
		{
			Json = Json.replaceAll("[()]", "").replaceAll("[/]", "").replaceAll("\\\\", "").replaceAll("Date", "");
			
			Gson gson = new Gson();  
			SorteioVO sorteio = gson.fromJson(Json, SorteioVO.class);
			return sorteio;
			
		}

	}
	
    @Override
    public void onClick(View v)
    {
    	TextView btnGameId = ( ( TextView ) ViewAction.this.findViewById( R.id.txt_game_id ) ) ; 
    	String gameId = btnGameId.getText().toString();
    	
    	if(gameId.trim().length() > 0 )
    	{
    		GetDataTask task = new GetDataTask( ) ;
    		task.execute(  ) ;
    		
    	}
    	else
    	{
    		DialogUtils.showMessageDialog(btnGameId.getContext(), "Erro!", "Informe o codigo do Concurso");
    	}
    }	
}
