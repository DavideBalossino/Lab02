package it.polito.alien.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Model {
	Map<String,String> mparole=new HashMap<String,String>();
	
	
	public void aggiungiTraduzione(String originale, String tradotta) {
		mparole.put(originale, tradotta);
		
	}
	
	public boolean verificaParole(String originale,String tradotta) {
		if(originale.toLowerCase().matches("[a-zA-Z]*") && tradotta.matches("[a-zA-Z]*"))
				return true;
		return false;
	}
	
	public boolean verificaParola(String originale) {
		if(originale.toLowerCase().matches("[a-zA-Z]*"))
			return true;
	return false;
	}
	
	public String traduci(String originale) {
		return mparole.get(originale);
	}
	
	public void ripulisci() {
		mparole.clear();
	}
	

}
