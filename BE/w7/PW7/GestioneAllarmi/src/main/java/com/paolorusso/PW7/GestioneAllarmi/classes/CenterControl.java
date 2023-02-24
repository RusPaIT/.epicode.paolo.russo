package com.paolorusso.PW7.GestioneAllarmi.classes;

import com.paolorusso.PW7.GestioneAllarmi.interfaces.Observer;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CenterControl implements Observer {
	
	
	public void update(int id, double latitude, double longitude, int smokeLevel) {
	    switch(smokeLevel) {
	        case 0:
	            System.out.println("Total absence of smoke detected from sensor " + id + " located at (" + latitude + ", " + longitude + ") with smoke level " + smokeLevel + "\n");
	            break;
	        case 1,2,3,4:
	            System.out.println("Situation stable, smoke values normal from sensor " + id + " located at (" + latitude + ", " + longitude + ")  with smoke level " + smokeLevel + "\n");
	            break;
	        case 5:
	            System.out.println("\"Critical smoke presence detected!! ATTENTION!!\" from sensor " + id + " located at (" + latitude + ", " + longitude + ") with smoke level " + smokeLevel + "\n");
	            break;
	        default:
	            if(smokeLevel > 5) {
	                System.out.println("Alarm triggered from sensor " + id + " located at (" + latitude + ", " + longitude + ") with smoke level " + smokeLevel + "\n");
	            }
	            else {
	                System.out.println("Invalid smoke level value detected from sensor " + id + " located at (" + latitude + ", " + longitude + ")\n");
	            }
	            break;
	    }
	}
}
