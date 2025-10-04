package com.school;

public class AttendanceRecord implements Storable {
	private Student student; // Changed from studentId to Student object
	private Course course;   // Changed from courseId to Course object
	private String status; // e.g., "Present", "Absent"

	public AttendanceRecord(Student student, Course course, String status) {
		this.student = student;
		this.course = course;
		// Basic validation for status
		if ("Present".equalsIgnoreCase(status) || "Absent".equalsIgnoreCase(status)) {
			this.status = status;
		} else {
			this.status = "Invalid"; // Default for invalid input
			System.out.println("Warning: Invalid attendance status provided ('" + status + "'). Set to 'Invalid'.");
		}
	}

	// Getters
	public Student getStudent() {
		return student;
	}

	public Course getCourse() {
		return course;
	}

	public String getStatus() {
		return status;
	}

	public void displayRecord() {
		// Use object data for a richer display
		System.out.println("Attendance: Student " + student.getName() + " (ID: " + student.getId() + ")" +
						" in Course " + course.getCourseName() + " (ID: C" + course.getCourseId() + ")" +
						" - Status: " + status);
	}

	@Override
	public String toDataString() {
		// Format: studentId,courseId,status - keep IDs for file storage simplicity
		return student.getId() + "," + course.getCourseId() + "," + status;
	}
}
