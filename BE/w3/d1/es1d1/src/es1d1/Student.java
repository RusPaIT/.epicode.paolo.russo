package es1d1;

import java.sql.Date;

public class Student {
private int id;
private String name;
private String lastname;
private String gender;
private String birthdate;
private double avg;
private int min_vote;
private int max_vote;

public Student(String name, String lastname, String gender, String birthdate, double avg, int min_vote, int max_vote) {
this.name = name;
this.lastname = lastname;
this.gender = gender;
this.birthdate = birthdate;
this.avg = avg;
this.min_vote = min_vote;
this.max_vote = max_vote;
}


public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getLastname() {
return lastname;
}

public void setLastname(String lastname) {
this.lastname = lastname;
}

public String getGender() {
return gender;
}

public void setGender(String gender) {
this.gender = gender;
}

public String getBirthdate() {
return birthdate;
}

public void setBirthdate(String birthdate) {
this.birthdate = birthdate;
}

public double getAvg() {
return avg;
}

public void setAvg(double avg) {
this.avg = avg;
}

public int getMinVote() {
return min_vote;
}

public void setMinVote(int min_vote) {
this.min_vote = min_vote;
}

public int getMaxVote() {
return max_vote;
}

public void setMaxVote(int max_vote) {
this.max_vote = max_vote;
}
}
