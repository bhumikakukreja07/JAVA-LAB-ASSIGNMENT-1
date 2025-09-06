import java.util.Scanner;

// Task 1: Student Class
class Student {
    String rollNo;
    String name;
    String course;
    double marks;
    String grade;
    Scanner sc = new Scanner(System.in);

    public void inputStudent() {
        System.out.print("Enter Roll Number: ");
        rollNo = sc.nextLine();

        System.out.print("Enter Name: ");
        name = sc.nextLine();

        System.out.print("Enter Course: ");
        course = sc.nextLine();

        System.out.print("Enter Marks: ");
        marks = sc.nextDouble();
        sc.nextLine();  

        calculateGrade();
    }

    public void calculateGrade() {
        if (marks >= 90) grade = "A+";
        else if (marks >= 80) grade = "A";
        else if (marks >= 70) grade = "B";
        else if (marks >= 60) grade = "C";
        else if (marks >= 50) grade = "D";
        else grade = "F";
    }

    public void displayStudent() {
        System.out.println("\n--- Student Details ---");
        System.out.println("Roll Number : " + rollNo);
        System.out.println("Name        : " + name);
        System.out.println("Course      : " + course);
        System.out.println("Marks       : " + marks);
        System.out.println("Grade       : " + grade);
        System.out.println("------------------------");
    }
}

// Task 2: Student Management System Class
class StudentManagementSystem {
    Student[] students;
    int studentCount;
    Scanner sc = new Scanner(System.in);

    public void initializeSystem(int size) {
        students = new Student[size];
        studentCount = 0;
    }
    public void addStudent() {
        if (studentCount >= students.length) {
            System.out.println("Cannot add more students. Storage is full.");
            return;
        }

        Student s = new Student();
        s.inputStudent();
        students[studentCount] = s;
        studentCount++;

        System.out.println("Student added successfully!");
    }
    public void displayAllStudents() {
        if (studentCount == 0) {
            System.out.println("No student records found.");
            return;
        }
        System.out.println("\n====== All Student Records ======");
        for (int i = 0; i < studentCount; i++) {
            students[i].displayStudent();
        }
    }
}

// Task 3: Main Program Class
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        System.out.print("Enter maximum number of students to manage: ");
        int maxStudents = sc.nextInt();
        sc.nextLine(); 

        sms.initializeSystem(maxStudents);

        int choice;

        do {
            System.out.println("\n== Student Record Management System ==");
            System.out.println("1. Add New Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    sms.addStudent();
                    break;
                case 2:
                    sms.displayAllStudents();
                    break;
                case 3:
                    System.out.println("Thank you for using the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
        sc.close();
    }
}