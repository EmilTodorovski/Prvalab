package com.example.prvalab;

public class Chatline {
	
	String od;
	String tekst;
	
	public String getOd() {
		return od;
	}
	public void setOd(String od) {
		this.od = od;
	}
	public String getTekst() {
		return tekst;
	}
	public void setTekst(String tekst) {
		this.tekst = tekst;
	}
	
	public Chatline(String od, String tekst) {
		super();
		this.od = od+":    ";
		this.tekst = tekst;
	}
	
	public Chatline() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
