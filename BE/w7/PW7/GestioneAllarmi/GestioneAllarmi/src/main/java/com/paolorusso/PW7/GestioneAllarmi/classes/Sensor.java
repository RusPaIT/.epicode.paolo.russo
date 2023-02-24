package com.paolorusso.PW7.GestioneAllarmi.classes;

import java.util.ArrayList;
import java.util.List;

import com.paolorusso.PW7.GestioneAllarmi.interfaces.Subject;

import lombok.Getter;
import lombok.Setter;

import com.paolorusso.PW7.GestioneAllarmi.interfaces.Observer;

@Getter
@Setter
public class Sensor implements Subject {
	
	int id;
	double latitude;
	double longitude;
	int smokeLevel;
	private List<Observer> observers;
	
	public Sensor(int id, double latitude, double longitude) {
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.observers = new ArrayList<>();
	}
	
	public void setSmokeLevel(int smokeLevel) {
	    this.smokeLevel = smokeLevel;
	    notifyObservers();
	  }


	@Override
	public void addObserver(Observer o) {
		observers.add(o);
	}
	
	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
		
	}


	@Override
	public void notifyObservers() {
		 for (Observer o : observers) {
		      o.update(id, latitude, longitude, smokeLevel);
		    }
		
	}

}
