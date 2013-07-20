package com.example.prvalab;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.NodeList;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


public class VestiActivity extends Activity {
	ListView lista;
	TextView error;
	LinearLayout listaLay;
	LinearLayout load;
	String location;
	Item it;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.news);
		
//		TextView txtNews=(TextView) findViewById(R.id.txt_news);
//		TextView txtLoading=(TextView) findViewById(R.id.loading);
		ImageView iv=(ImageView)findViewById(R.id.refresh);
		iv.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(getIntent()); finish();
			}
		});
		load = (LinearLayout) findViewById(R.id.loader);
		lista = (ListView) findViewById(R.id.lista_news);
		listaLay=(LinearLayout)findViewById(R.id.lista_layout);
		error = (TextView) findViewById(R.id.error);
		location = "http://search.twitter.com/search.atom?q=%23android";
		new fillList().execute(null, null, null);

	}


	private class fillList extends AsyncTask<Void, Void, Void> {
		boolean er = false;
		Items itemi;

		@Override
		protected Void doInBackground(Void... params) {
			
			try {
				
				URL url = new URL(location);

//				Document dok = null;
//				try {
//					dok = Jsoup.parse(url, 30000);
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
				org.w3c.dom.Document dok= db.parse(url.openStream());
				NodeList lista = dok.getElementsByTagName("entry");
//				Elements nastani = dok.getElementsByClass("regularitem");
				
				itemi= new Items(lista);
			} 
			catch (Exception e) {
				er=true;
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			load.setVisibility(View.GONE);
			if (er) {
				error.setVisibility(View.GONE);
			} else {
				listaLay.setVisibility(View.VISIBLE);
			}
			lista.setAdapter(new VestiAdapter(itemi,VestiActivity.this));	
			super.onPostExecute(result);
		}

		@Override
		protected void onPreExecute() {
			load.setVisibility(View.VISIBLE);
			super.onPreExecute();
		}
	}
	
	

}
