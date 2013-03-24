package com.example.prvalab;

import java.util.ArrayList;
import java.util.List;

public class ChatList {
	
	List<Chatline> muabet = new ArrayList<Chatline>();

	public List<Chatline> getMuabet() {
		return muabet;
	}

	public void setMuabet(List<Chatline> muabet) {
		this.muabet = muabet;
	}

	public ChatList(List<Chatline> muabet) {
		super();
		this.muabet = muabet;
	}

	public ChatList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void add(Chatline linija)
	{
		muabet.add(linija);
	}
	

	public int size ()
	{
		return muabet.size();
	}
	
	public Chatline getItem(int position)
	{
		return muabet.get(position);
	}
}
