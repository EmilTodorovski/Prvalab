spackage com.example.prvalab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter {

	Context context;
	ChatList lista;

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	@Override
	public Chatline getItem(int position) {

		return lista.getItem(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View result =inflater.inflate(R.layout.listitem, null);
		TextView ime= (TextView)result.findViewById(R.id.name);
		TextView tekst = (TextView) result.findViewById(R.id.chattext);
		ime.setText(getItem(position).getOd());
		tekst.setText(getItem(position).getTekst());
		
		return result;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public ChatList getLista() {
		return lista;
	}

	public void setLista(ChatList lista) {
		this.lista = lista;
	}

	public ListAdapter(Context context, ChatList lista) {
		super();
		this.context = context;
		this.lista = lista;
	}

	public ListAdapter() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
