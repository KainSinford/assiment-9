
package assiment.pkg9;
import java.util.Scanner;

public class ClassStudent {
private String id;
    private String name;
    private int age;
    public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
   
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
  
    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
    }
   
    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter id: ");
        this.id = scanner.nextLine();
        System.out.print("Enter name: ");
        this.name = scanner.nextLine();
        System.out.print("Enter age: ");
        this.age = scanner.nextInt();
    }
}