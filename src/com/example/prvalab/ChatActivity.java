package com.example.prvalab;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class ChatActivity extends Activity {
	
	ChatList cl;
	ListAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chat);

		cl = new ChatList();
		
		
		Button btn_prati = (Button) findViewById(R.id.kopce_prati);
		btn_prati.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// se dodava noviot tekst
				EditText edittext = (EditText) findViewById(R.id.textpole);
				String nl = edittext.getText().toString();
				edittext.setText("");
				
				Chatline cln = new Chatline("Me", nl);
				cl.add(cln);
				adapter.notifyDataSetChanged();
			}
		});
	}

	@Override
	protected void onResume() {
		
		super.onResume();

		String aa = "aaAaa";
		Chatline cln = new Chatline(aa, aa);
		cl.add(cln);
		cl.add(cln);
		cl.add(cln);

		ListView list = (ListView) findViewById(R.id.lista);
		adapter = new ListAdapter(this, cl);
		list.setAdapter(adapter);

	}

	// @Override
	/*
	 * public boolean onCreateOptionsMenu(Menu menu) { // Inflate the menu; this
	 * adds items to the action bar if it is present.
	 * getMenuInflater().inflate(R.menu.activity_chat, menu); return true; }
	 */

}
