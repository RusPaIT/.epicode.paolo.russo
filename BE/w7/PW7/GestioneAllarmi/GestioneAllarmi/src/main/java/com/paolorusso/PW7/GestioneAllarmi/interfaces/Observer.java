package com.paolorusso.PW7.GestioneAllarmi.interfaces;

public interface Observer {
	
	void update(int id, double latitude, double longitude,int smokeLevel);

}
