package com.example.prvalab;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class ChatActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chat);
		
		
		
		
	}

	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	
	String aa = "aaAaa";
	Chatline cl = new Chatline (aa,aa);
	ChatList chatlist = new ChatList ();
	chatlist.add(cl);
	chatlist.add(cl);
	chatlist.add(cl);
		
	ListView list = (ListView) findViewById(R.id.lista);
	list.setAdapter(new ListAdapter(this, chatlist));
	
	
	}
	
//	@Override
/*	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_chat, menu);
		return true;
	}*/

}
