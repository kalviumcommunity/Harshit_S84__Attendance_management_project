package com.school;

import java.util.ArrayList;
import java.util.List;

public class RegistrationService {
    private List<Student> students;
    private List<Teacher> teachers;
    private List<Staff> staffMembers;
    private List<Course> courses; // Managing courses here for now
    private FileStorageService storageService;

    private final String STUDENTS_FILE = "students.txt";
    private final String TEACHERS_FILE = "teachers.txt";
    private final String STAFF_FILE = "staff.txt";
    private final String COURSES_FILE = "courses.txt";


    public RegistrationService(FileStorageService storageService) {
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.staffMembers = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.storageService = storageService;
        // In a real app, load data here
    }

    public Student registerStudent(String name, String gradeLevel) {
        Student student = new Student(name, gradeLevel);
        this.students.add(student);
        System.out.println("Student registered: " + name + " (ID: " + student.getId() + ")");
        return student;
    }

    public Teacher registerTeacher(String name, String subject) {
        Teacher teacher = new Teacher(name, subject);
        this.teachers.add(teacher);
        System.out.println("Teacher registered: " + name + " (ID: " + teacher.getId() + ")");
        return teacher;
    }

    public Staff registerStaff(String name, String role) {
        Staff staff = new Staff(name, role);
        this.staffMembers.add(staff);
        System.out.println("Staff registered: " + name + " (ID: " + staff.getId() + ")");
        return staff;
    }

    public Course createCourse(String courseName) {
        Course course = new Course(courseName);
        this.courses.add(course);
        System.out.println("Course created: " + courseName + " (ID: C" + course.getCourseId() + ")");
        return course;
    }

    public List<Student> getStudents() { return students; }
    public List<Teacher> getTeachers() { return teachers; }
    public List<Staff> getStaffMembers() { return staffMembers; }
    public List<Course> getCourses() { return courses; }

    public Student findStudentById(int studentId) {
        for (Student s : students) {
            if (s.getId() == studentId) return s;
        }
        return null;
    }

    public Course findCourseById(int courseId) {
        for (Course c : courses) {
            if (c.getCourseId() == courseId) return c;
        }
        return null;
    }

    public List<Person> getAllPeople() {
        List<Person> allPeople = new ArrayList<>();
        allPeople.addAll(students);
        allPeople.addAll(teachers);
        allPeople.addAll(staffMembers);
        return allPeople;
    }

    public void saveAllRegistrations() {
        storageService.saveData(students, STUDENTS_FILE);
        storageService.saveData(teachers, TEACHERS_FILE);
        storageService.saveData(staffMembers, STAFF_FILE);
        storageService.saveData(courses, COURSES_FILE);
        System.out.println("All registration data saved.");
    }
}