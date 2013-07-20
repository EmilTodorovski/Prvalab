package com.example.prvalab;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.util.Log;

public class Items {
	List<Item> vesti = new ArrayList<Item>();

	public List<Item> getVesti() {
		return vesti;
	}

	public void setVesti(List<Item> vesti) {
		this.vesti = vesti;
	}

	public Items(NodeList nl){
		for (int i = 0; i < nl.getLength(); i++) {
			vesti.add(new Item(nl.item(i)));
		}
	}
	public Items(Elements elements) {
		super();
		for (Element element : elements) {
			Elements naslovi = element.getElementsByTag("title");
			Elements dati = element.getElementsByTag("published");
			Elements linkovi=element.getElementsByTag("link");
			String link = "www.google.com";
			List<String> datiString= new ArrayList<String>();
			for (Element data : dati) {
				String dataString = Jsoup.parse(data.html()).text();
//					.replace("{", "")).text();
//			dataString = dataString.replace("}", "");
				datiString.add(dataString);
			}
			vesti.clear();
			for (int i = 0; i < dati.size() && i<15; i++) {
				Item item = new Item(naslovi.get(i).text(), "0", link);
				vesti.add(item);
				Log.d("data", ""+i+ " " +naslovi.get(i).text());
				Log.d("Izlez", ""+i);
			}
			// TODO Auto-generated constructor stub
		}
	}
}