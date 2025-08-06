package com.school;

public class Course {
    private static int nextCourseIdCounter = 101;
	int courseId;
	String name;

    public Course(String name) {
        this.courseId = nextCourseIdCounter++;
        this.name = name;
    }
	public void displayDetails() {
		System.out.println("Course ID: " + this.courseId + ", Name: " + this.name);
	}

}
