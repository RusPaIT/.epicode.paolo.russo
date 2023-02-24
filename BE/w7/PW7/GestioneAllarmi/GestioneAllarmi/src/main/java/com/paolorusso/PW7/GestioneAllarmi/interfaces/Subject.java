package com.paolorusso.PW7.GestioneAllarmi.interfaces;

public interface Subject {
	
	 void addObserver(Observer o);
	 void removeObserver(Observer o);
	 void notifyObservers();

}
