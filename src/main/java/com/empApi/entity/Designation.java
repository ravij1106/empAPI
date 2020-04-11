package com.empApi.entity;

public enum Designation {
	CEO("CEO"), 
	Admin("Admin"), 
	Project_Manager("Project Manager"), 
	Accountant("Accountant"), 
	Developer("Developer"), 
	Team_Leader("Team Leader");
	
	private String displayName;
	
	Designation(String displayName){
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

	 @Override public String toString() { return displayName; }
}
