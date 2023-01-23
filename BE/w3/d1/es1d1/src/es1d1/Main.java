package es1d1;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		
		DB db = new DB();
		db.connect();
		
		boolean insertStudent = false;
		if(insertStudent) {
		Student nuovoStudente = new Student("Paolo", "Russo", "m", "1981-03-03", 3, 2, 4);
		db.insertStudent(nuovoStudente);
		}
		
		boolean updateStudent = false;
		if(updateStudent) {
		HashMap<String, Object> updateValues = new HashMap<>();
	    updateValues.put("name", "Gino");
	    updateValues.put("lastname", "Biricchino");
	    db.updateStudent(2, updateValues);
		}
		
		
	    boolean deleteStudent = false;
	    if(deleteStudent) {
	    db.deleteStudent(15);
	    }
	    
	    boolean getBest = false;
	    if(getBest) {
	    db.getBest();
	    }
	    
	    boolean getVoteRange = true;
	    if(getVoteRange) {
	    db.getVoteRange(2, 6);
	    }
	    
	    
		db.disconnect();
	}

}
