School Attendance System
This is a 10-part code-along project to build a console-based school attendance system in Java.

## Session 1: Introduction and Orientation
- Verified Java and Git setup.
- Initialized Git repository for the project.
- Created basic project structure with `Main.java`.
- Compiled and ran the initial "Welcome" program.
- Pushed initial setup to a `part-01` branch on GitHub and created a PR.

### How to Run
1. Navigate to the project root directory (`AttendanceSystem`).
2. Compile: `javac src/com/school/Main.java`
3. Run: `java -cp src com.school.Main`

adding this line for pull request

## Part 3: Constructor Initialization & Auto-ID Generation
- Implemented parameterized constructors in `Student` and `Course` classes for object initialization.
- Utilized `private static` member variables for automatic and unique ID generation.
- Demonstrated the use of the `this` keyword to distinguish instance variables from constructor parameters.
- Changed `Course`'s `courseId` to `int` for simpler auto-generation and updated its display.
- Updated `Main.java` to use constructors and show ID progression.

### How to Run (ensure this is up-to-date)
1. Navigate to the project root directory.
2. Compile: `javac src/com/school/Student.java src/com/school/Course.java src/com/school/Main.java` (or `javac src/com/school/*.java`)
3. Run: `java -cp src com.school.Main`

## Part 7: Polymorphic Behaviour in Attendance and Displaying Reports
- Modified `AttendanceRecord` to hold `Student` and `Course` objects instead of just their IDs, enhancing its object-oriented nature and how records are displayed. The `toDataString()` method still uses IDs for simpler file storage.
- Created a `displaySchoolDirectory(List<Person> people)` method in `Main.java` to demonstrate polymorphism. This method iterates through a list of `Person` objects (containing `Student`, `Teacher`, `Staff` instances) and calls `person.displayDetails()`. The correct overridden method for each specific object type is executed at runtime.
- Populated a `List<Person>` in `main` and used it with `displaySchoolDirectory`.
- Updated `Main.java` to use `instanceof` and casting when preparing the list of students for saving, as `Person` itself does not implement `Storable`.
- Demonstrated richer `AttendanceLog` display that uses data from `Student` and `Course` objects.

### How to Run
1. Navigate to the project root directory.
2. Compile: `javac src/com/school/*.java`
3. Run: `java -cp src com.school.Main`

### Notes / Submission
- The program prints a "School Directory" section (showing polymorphic `displayDetails()` output) and an "Attendance Log" with richer messages.
- Files `students.txt`, `courses.txt`, and `attendance_log.txt` are written to the project root when `FileStorageService.saveData` is called.

## Part 8: Overloaded Commands: Multiple Ways to Mark and Query Attendance
- Added `AttendanceService.java` to encapsulate attendance logic and manage `AttendanceRecord` objects.
- Implemented overloaded `markAttendance` methods:
  - `markAttendance(Student student, Course course, String status)` — object-based.
  - `markAttendance(int studentId, int courseId, String status, List<Student> allStudents, List<Course> allCourses)` — ID-based, uses helper lookups.
- Implemented overloaded `displayAttendanceLog` methods:
  - `displayAttendanceLog()` — shows all records.
  - `displayAttendanceLog(Student student)` — filters records for a student.
  - `displayAttendanceLog(Course course)` — filters records for a course.
- `AttendanceService` uses `FileStorageService` to save the attendance log to `attendance_log.txt`.
- Demonstrated overloaded methods in `Main.java` with example calls.

### How to Run (Part 8)
1. Navigate to the project root directory.
2. Compile all sources: `javac src/com/school/*.java`
3. Run: `java -cp src com.school.Main`
4. Verify `attendance_log.txt` contains the saved attendance entries.

### Notes
- The project uses simple console output to demonstrate polymorphism and method overloading.
- When saving, storable objects write compact ID-based strings for easy re-loading or manual inspection.
