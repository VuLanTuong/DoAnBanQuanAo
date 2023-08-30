package com.example.doanbanquanao.model;

public enum Gender {
	M("Male"),
	F("Female");
	private String gender;

	private Gender() {
		// TODO Auto-generated constructor stub
	}

	private Gender(String gender) {
		this.gender = gender;
	}
	public String getGender() {
		return gender;
	}
	 @Override
	  public String toString() {
	    return String.valueOf(gender);
	  }
}
