
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
            System.out.println("\n== MENU ==");
            System.out.println("1. Nhập thông tin sinh viên ");
            System.out.println("2. Hiển thị thông tin tất cả sinh viên ");
            System.out.println("3. Tìm kiếm sinh viên theo id");
            System.out.println("4. Xóa sinh viên theo id");
            System.out.println("5. Thay đổi sinh viên theo id");
            System.out.println("6. thoát");
            System.out.print(" \Chọn một:  ");
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
                    System.out.println("Thoát chương trình...");
                    break;
                default:
                    System.out.println("Không đúng!");
                    break;
            }
        } while (choice != 6);
    }

    private void inputStudents(Scanner scanner) {
        System.out.print("Nhập số lượng sinh viên: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sinh viên số " + (i + 1));
            Student student = new Student("", "", 0);
            student.input();
            studentList.addStudent(student);
        }
    }
    private void searchStudent(Scanner scanner) {
        scanner.nextLine(); 
        System.out.print("Nhập id để tìm: ");
        String id = scanner.nextLine();
        Student student = studentList.searchById(id);
        if (student != null) {
            student.display();
        } else {
            System.out.println("Sinh viên không tồn tại");
        }
    }

    private void deleteStudent(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Nhập id sinh viên để xía: ");
        String id = scanner.nextLine();
        if (studentList.deleteById(id)) {
            System.out.println("xóa thành công.");
        } else {
            System.out.println("\Sinh viên không tồn tại.");
        }
    }
    private void editStudent(Scanner scanner) {
        scanner.nextLine(); 
        System.out.print("Nhập id sinh viên để thay đổi: ");
        String id = scanner.nextLine();
        System.out.print("Nhập tên mới: ");
        String newName = scanner.nextLine();
        System.out.print("Nhập tuổi mới: ");
        int newAge = scanner.nextInt();

        if (studentList.editById(id, newName, newAge)) {
            System.out.println("Đổi thông tin sinh viên thành công.");
        } else {
            System.out.println("Sinh viên không tồn tại .");
        }
    }

    public static void main(String[] args) {
        processor processor = new processor();
        processor.showMenu();
    }
}

