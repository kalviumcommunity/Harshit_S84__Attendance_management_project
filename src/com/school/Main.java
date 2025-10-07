package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
	// Add a helper method to demonstrate polymorphism across Person types
	public static void displaySchoolDirectory(List<Person> people) {
		System.out.println("\n--- School Directory ---");
		if (people == null || people.isEmpty()) {
			System.out.println("No people in the directory.");
			return;
		}
		for (Person person : people) {
			person.displayDetails(); // Polymorphic dispatch
		}
	}

	public static void main(String[] args) {
		System.out.println("--- School Administration & Attendance System (Polymorphism Demo) ---");

		// --- Data Setup: create specific Person types ---
		Student student1 = new Student("Alice Wonderland", "Grade 10");
		Student student2 = new Student("Bob The Builder", "Grade 9");
		Teacher teacher1 = new Teacher("Dr. Emily Carter", "Physics");
		Staff staff1 = new Staff("Mr. John Davis", "Librarian");

		// Directory demonstrating polymorphism
		List<Person> schoolPeople = new ArrayList<>();
		schoolPeople.add(student1);
		schoolPeople.add(student2);
		schoolPeople.add(teacher1);
		schoolPeople.add(staff1);

		displaySchoolDirectory(schoolPeople);

		// --- Course Setup ---
		List<Course> courses = new ArrayList<>();
		Course course1 = new Course("Intro to Quantum Physics");
		Course course2 = new Course("Advanced Algorithms");
		courses.add(course1);
		courses.add(course2);

		System.out.println("\n\n--- Available Courses ---");
		for (Course c : courses)
			c.displayDetails();

		// --- Setup services for Part 8: AttendanceService & FileStorageService ---
		FileStorageService storageService = new FileStorageService();
		AttendanceService attendanceService = new AttendanceService(storageService);

		// Build master lists to support ID-based lookups in overloaded methods
		List<Student> allStudents = new ArrayList<>();
		allStudents.add(student1);
		allStudents.add(student2);
		// If you have more students add them here

		List<Course> allCourses = new ArrayList<>();
		allCourses.add(course1);
		allCourses.add(course2);

		System.out.println("\n\n--- Marking Attendance (Using overloaded methods) ---");
		// 1) Object-based marking
		attendanceService.markAttendance(student1, course1, "Present");
		attendanceService.markAttendance(student2, course1, "Absent");

		// 2) ID-based marking (uses lookup helper inside AttendanceService)
		attendanceService.markAttendance(student1.getId(), course2.getCourseId(), "Present", allStudents, allCourses);
		attendanceService.markAttendance(student2.getId(), course1.getCourseId(), "Daydreaming", allStudents, allCourses); // Invalid status -> handled by AttendanceRecord

		System.out.println("\n\n--- Querying Attendance (Overloaded display methods) ---");
		attendanceService.displayAttendanceLog(); // all records
		attendanceService.displayAttendanceLog(student1); // filter by student
		attendanceService.displayAttendanceLog(course1); // filter by course

		System.out.println("\n\n--- Saving Data to Files ---");
		// Save only students from the schoolPeople list (filter using instanceof)
		List<Student> studentsToSave = new ArrayList<>();
		for (Person p : schoolPeople) {
			if (p instanceof Student) {
				studentsToSave.add((Student) p);
			}
		}
		if (!studentsToSave.isEmpty()) {
			storageService.saveData(studentsToSave, "students.txt");
		} else {
			System.out.println("No student data to save from school directory.");
		}

		// Save courses
		storageService.saveData(courses, "courses.txt");
		// Save attendance log via the service
		attendanceService.saveAttendanceData();

		System.out.println("\nSession 8: Overloaded Commands Demonstrated Complete.");
	}
}
