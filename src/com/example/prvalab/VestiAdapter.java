package com.example.prvalab;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class VestiAdapter extends BaseAdapter {
	private Items items;
	private Context context;


	


	public VestiAdapter(Items items, Context context) {
		super();
		this.items = items;
		this.context = context;
	}


	public int getCount() {
		try
		{
			return items.getVesti().size();			
		}
		catch (Exception e) {
			e.printStackTrace();
			Log.d("Blaa ", "bla drn drn");
		}
		return 0;
	}


	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return (items.getVesti()).get(arg0);
	}


	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {	
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View result =inflater.inflate(R.layout.news_item, null);
		
		TextView title=(TextView)result.findViewById(R.id.title);
		title.setText(items.getVesti().get(position).getTitle());
		
	//	TextView pubdate = (TextView) result.findViewById(R.id.date);
	//	pubdate.setText(items.getVesti().get(position).getDate());
//		int[] gradients= {R.drawable.gradient_purple1,R.drawable.gradient_purple2,R.drawable.gradient_purple3,R.drawable.gradient_purple4,R.drawable.gradient_purple5};
//		pubdate.setBackgroundResource(gradients[position%gradients.length]);
		//pubdate.setBackgroundResource(R.drawable.gradient_yellow1);
		final Item it=items.getVesti().get(position);
		result.setOnClickListener(new OnClickListener() {
		
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(it.getLink()));
			     i.putExtra("linkot", it.getLink());
			     context.startActivity(i);   
			}
		});
		return result;
	}
}
