import java.util.*;

class Student {
    int rollNo;
    String name;
    int marks;

    Student(int rollNo, String name, int marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    public String getGrade() {
        if (marks >= 90) return "A";
        else if (marks >= 80) return "B";
        else if (marks >= 70) return "C";
        else return "D";
    }

    public String toString() {
        return "Roll No: " + rollNo +
               ", Name: " + name +
               ", Marks: " + marks +
               ", Grade: " + getGrade();
    }
}

public class StudentManagementSystem {
    static ArrayList<Student> studentList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Student Management Menu ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    System.out.println("Exiting... Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void addStudent() {
        System.out.print("Enter roll number: ");
        int roll = sc.nextInt();
        sc.nextLine();  // Clear buffer
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter marks: ");
        int marks = sc.nextInt();

        Student s = new Student(roll, name, marks);
        studentList.add(s);
        System.out.println("✅ Student added successfully!");
    }

    public static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("📋 List of Students:");
        for (Student s : studentList) {
            System.out.println(s);
        }
    }

    public static void deleteStudent() {
        System.out.print("Enter roll number to delete: ");
        int roll = sc.nextInt();
        boolean found = false;

        Iterator<Student> itr = studentList.iterator();
        while (itr.hasNext()) {
            Student s = itr.next();
            if (s.rollNo == roll) {
                itr.remove();
                System.out.println("🗑️ Student removed.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("❌ Student not found.");
        }
    }
}
