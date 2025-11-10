package com.school;

import java.util.List;

public class Main {

    // displaySchoolDirectory is now better placed in RegistrationService or a ReportService
    // For now, let's make it use RegistrationService data
    public static void displaySchoolDirectory(RegistrationService regService) {
        System.out.println("\n--- School Directory ---");
        List<Person> people = regService.getAllPeople();
        if (people.isEmpty()) {
            System.out.println("No people registered.");
            return;
        }
        for (Person person : people) {
            person.displayDetails();
        }
    }

    public static void main(String[] args) {
        System.out.println("--- School System (SRP Demo) ---");

        // --- Setup Services ---
        FileStorageService storageService = new FileStorageService();
        RegistrationService registrationService = new RegistrationService(storageService);
        // AttendanceService now depends on RegistrationService
        AttendanceService attendanceService = new AttendanceService(storageService, registrationService);

        // --- Registering Entities via RegistrationService ---
        System.out.println("\n--- Registering People and Courses ---");
        Student student1 = registrationService.registerStudent("Alice Wonderland", "Grade 10");
        Student student2 = registrationService.registerStudent("Bob The Builder", "Grade 9");
        registrationService.registerTeacher("Dr. Emily Carter", "Physics");
        registrationService.registerStaff("Mr. John Davis", "Librarian");

        Course course1 = registrationService.createCourse("Intro to Programming");
        Course course2 = registrationService.createCourse("Data Structures");

        // Display directory using data from RegistrationService
        displaySchoolDirectory(registrationService);

        System.out.println("\n\n--- Marking Attendance ---");
        // Mark attendance using Student and Course objects
        attendanceService.markAttendance(student1, course1, "Present");
        // Mark attendance using studentId and courseId (lookup via RegistrationService)
        attendanceService.markAttendance(student2.getId(), course1.getCourseId(), "Absent");
        attendanceService.markAttendance(student1.getId(), course2.getCourseId(), "Tardy"); // Invalid

        System.out.println("\n\n--- Querying Attendance ---");
        attendanceService.displayAttendanceLog(student1); // Log for Alice
        attendanceService.displayAttendanceLog();         // Full log

        // --- Saving Data via Services ---
        System.out.println("\n\n--- Saving All Data ---");
        registrationService.saveAllRegistrations();
        attendanceService.saveAttendanceData();

        System.out.println("\nSession 9: SRP with Registration & Attendance Services Complete.");
    }
}