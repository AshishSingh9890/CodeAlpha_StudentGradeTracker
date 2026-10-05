
import java.util.Scanner;

class Student {

    String name;
    int rollNo;
    double marks;

    Student(String name, int rollNo, double marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    String getGrade() {

        if (marks >= 90) {
            return "A";
        } else if (marks >= 80) {
            return "B";
        } else if (marks >= 70) {
            return "C";
        } else if (marks >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    String getResult() {

        if (marks >= 40) {
            return "PASS";
        } else {
            return "FAIL";
        }
    }
}

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("      STUDENT GRADE TRACKER");
        System.out.println("=================================");

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        if (n <= 0) {
            System.out.println("Number of students must be greater than 0.");
            return;
        }

        Student[] students = new Student[n];

        // Taking student details
        for (int i = 0; i < n; i++) {

            System.out.println("\n--- Student " + (i + 1) + " ---");

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter roll number: ");
            int rollNo = sc.nextInt();

            System.out.print("Enter marks (0-100): ");
            double marks = sc.nextDouble();
            sc.nextLine();

            while (marks < 0 || marks > 100) {

                System.out.println("Invalid marks! Enter marks between 0 and 100.");

                System.out.print("Enter marks: ");
                marks = sc.nextDouble();
                sc.nextLine();
            }

            students[i] = new Student(name, rollNo, marks);
        }

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println("             MENU");
            System.out.println("=================================");
            System.out.println("1. Display All Students");
            System.out.println("2. Calculate Average Marks");
            System.out.println("3. Find Highest Marks");
            System.out.println("4. Find Lowest Marks");
            System.out.println("5. Search Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    displayStudents(students);
                    break;

                case 2:
                    calculateAverage(students);
                    break;

                case 3:
                    findHighest(students);
                    break;

                case 4:
                    findLowest(students);
                    break;

                case 5:
                    searchStudent(students);
                    break;

                case 6:
                    System.out.println("\nThank you for using Student Grade Tracker!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 6);

        sc.close();
    }

    // Display all students
    static void displayStudents(Student[] students) {

        System.out.println("\n========== ALL STUDENTS ==========");

        for (int i = 0; i < students.length; i++) {

            System.out.println("\nStudent " + (i + 1));
            System.out.println("Name: " + students[i].name);
            System.out.println("Roll No: " + students[i].rollNo);
            System.out.println("Marks: " + students[i].marks);
            System.out.println("Grade: " + students[i].getGrade());
            System.out.println("Result: " + students[i].getResult());
        }
    }

    // Calculate average
    static void calculateAverage(Student[] students) {

        double totalMarks = 0;

        for (int i = 0; i < students.length; i++) {
            totalMarks = totalMarks + students[i].marks;
        }

        double average = totalMarks / students.length;

        System.out.println("\nAverage Marks: " + average);
    }

    // Find highest marks
    static void findHighest(Student[] students) {

        Student highest = students[0];

        for (int i = 1; i < students.length; i++) {

            if (students[i].marks > highest.marks) {
                highest = students[i];
            }
        }

        System.out.println("\n===== HIGHEST MARKS =====");
        System.out.println("Name: " + highest.name);
        System.out.println("Roll No: " + highest.rollNo);
        System.out.println("Marks: " + highest.marks);
    }

    // Find lowest marks
    static void findLowest(Student[] students) {

        Student lowest = students[0];

        for (int i = 1; i < students.length; i++) {

            if (students[i].marks < lowest.marks) {
                lowest = students[i];
            }
        }

        System.out.println("\n===== LOWEST MARKS =====");
        System.out.println("Name: " + lowest.name);
        System.out.println("Roll No: " + lowest.rollNo);
        System.out.println("Marks: " + lowest.marks);
    }

    // Search student
    static void searchStudent(Student[] students) {

        System.out.print("\nEnter roll number to search: ");
        int rollNo = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < students.length; i++) {

            if (students[i].rollNo == rollNo) {

                System.out.println("\n===== STUDENT FOUND =====");
                System.out.println("Name: " + students[i].name);
                System.out.println("Roll No: " + students[i].rollNo);
                System.out.println("Marks: " + students[i].marks);
                System.out.println("Grade: " + students[i].getGrade());
                System.out.println("Result: " + students[i].getResult());

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student with roll number "
                    + rollNo + " was not found.");
        }
    }
}
