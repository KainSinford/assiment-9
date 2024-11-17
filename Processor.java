
package assiment.pkg9;
import java.util.Scanner;
public class Processor {
    private StudentList studentList;

    public processor() {
        studentList = new StudentList();
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Enter student info ");
            System.out.println("2. Show info all student ");
            System.out.println("3. Search student by id");
            System.out.println("4. Delete student by id");
            System.out.println("5. Change student by id");
            System.out.println("6. Exit");
            System.out.print(" Choose one:  ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    inputStudents(scanner);
                    break;
                case 2:
                    studentList.displayAllStudents();
                    break;
                case 3:
                    searchStudent(scanner);
                    break;
                case 4:
                    deleteStudent(scanner);
                    break;
                case 5:
                    editStudent(scanner);
                    break;
                case 6:
                    System.out.println("Exit program...");
                    break;
                default:
                    System.out.println("Incorrect!");
                    break;
            }
        } while (choice != 6);
    }

    private void inputStudents(Scanner scanner) {
        System.out.print("Enter quantity student: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter student infomation no " + (i + 1));
            Student student = new Student("", "", 0);
            student.input();
            studentList.addStudent(student);
        }
    }
    private void searchStudent(Scanner scanner) {
        scanner.nextLine(); 
        System.out.print("Enter id to search: ");
        String id = scanner.nextLine();
        Student student = studentList.searchById(id);
        if (student != null) {
            student.display();
        } else {
            System.out.println("Student does not exist");
        }
    }

    private void deleteStudent(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Enter id student to delete: ");
        String id = scanner.nextLine();
        if (studentList.deleteById(id)) {
            System.out.println("Delete success.");
        } else {
            System.out.println("Studen does not exist.");
        }
    }
    private void editStudent(Scanner scanner) {
        scanner.nextLine(); 
        System.out.print("Enter the student ID to edit: ");
        String id = scanner.nextLine();
        System.out.print("Enter new name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new age: ");
        int newAge = scanner.nextInt();

        if (studentList.editById(id, newName, newAge)) {
            System.out.println("Change student info success.");
        } else {
            System.out.println("Student does not exist.");
        }
    }

    public static void main(String[] args) {
        processor processor = new processor();
        processor.showMenu();
    }
}

