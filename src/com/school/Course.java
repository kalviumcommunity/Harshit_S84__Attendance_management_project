package com.school;

public class Course {
	int courseId;
	String name;

	public void setDetails(int id, String courseName) {
		this.courseId = id;
		this.name = courseName;
	}

	public void displayDetails() {
		System.out.println("Course ID: " + this.courseId + ", Name: " + this.name);
	}

}
