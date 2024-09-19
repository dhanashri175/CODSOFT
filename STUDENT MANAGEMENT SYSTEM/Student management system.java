import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private String rollNumber;
    private String grade;

    public Student(String name, String rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (searchStudent(student.getRollNumber()) == null) {
            students.add(student);
            System.out.println("Student " + student.getName() + " added successfully.");
        } else {
            System.out.println("A student with roll number " + student.getRollNumber() + " already exists.");
        }
    }

    public void removeStudent(String rollNumber) {
        Student studentToRemove = searchStudent(rollNumber);
        if (studentToRemove != null) {
            students.remove(studentToRemove);
            System.out.println("Student " + studentToRemove.getName() + " removed successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public Student searchStudent(String rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber().equals(rollNumber)) {
                return student;
            }
        }
        return null;
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        String choice;
        do {
            System.out.println("\n1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter roll number: ");
                    String rollNumber = scanner.nextLine();
                    System.out.print("Enter grade: ");
                    String grade = scanner.nextLine();
                    sms.addStudent(new Student(name, rollNumber, grade));
                    break;
                case "2":
                    System.out.print("Enter roll number to remove: ");
                    sms.removeStudent(scanner.nextLine());
                    break;
                case "3":
                    System.out.print("Enter roll number to search: ");
                    Student found = sms.searchStudent(scanner.nextLine());
                    if (found != null) {
                        System.out.println("Student found: " + found);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case "4":
                    sms.displayStudents();
                    break;
                case "5":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (!choice.equals("5"));

        scanner.close();
    }
}
