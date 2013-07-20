package com.example.prvalab;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.util.Log;



public class Item {
	private String title ;
	private String date ;
	private String content;
	private String link ;


	public String getTitle() {
		return title;
	}
	public Item(Node item) {
		try {
			NodeList nodes = item.getChildNodes();
			// Log.d("A",item.getNodeValue());
			for (int i = 0; i < nodes.getLength(); i++) {
				Node node = nodes.item(i);
				node.normalize();
				Log.d("Izlez", node.getNodeName());
				if (node.getNodeName().equalsIgnoreCase("link") && link==null) {
					link = node.getAttributes().getNamedItem("href").getNodeValue();
				}
				if (node.getNodeName().equalsIgnoreCase("title")) {
					title = node.getFirstChild().getNodeValue();
					title = title.replaceAll("&.{1,5}?;", "");
				}
				if (node.getNodeName().equalsIgnoreCase("pubDate")) {
					date = node.getFirstChild().getNodeValue();
				}
				if (node.getNodeName().equalsIgnoreCase("description")) {
					content = node.getFirstChild().getNodeValue();
				}
			}
			if (date.length() > 0) {
				if (date.contains("+")) {
					date = date.substring(0, date.lastIndexOf(" "));
				}
				if (date.contains(","))
					;
				date = date.substring(date.indexOf(",") + 1);
				date = date.trim();
				date = date.substring(0, date.lastIndexOf(":"));
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	public Item(String title, String date, String link) {
		super();
		this.title = title;
		this.date = date;
		this.link = link;
	}

	public String getDate() {
		return date;
	}

	public String getContent() {
		return content;
	}

	public String getLink() {
		return link;
	}

	@Override
	public String toString() {
		return title + " " + date + " " + content + " " + link;
	}
}
