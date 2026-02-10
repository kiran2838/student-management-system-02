import dao.StudentDAO;
import dao.StudentDAOImpl;
import model.Student;
import java.util.*;

public class MainApp {
    public static void main(String[] args) {

        StudentDAO dao = new StudentDAOImpl();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt(); sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Age: ");
                    int age = sc.nextInt(); sc.nextLine();

                    System.out.print("Course: ");
                    String course = sc.nextLine();

                    dao.addStudent(new Student(id, name, age, course));
                    break;

                case 2:
                    dao.getAllStudents().forEach(s ->
                        System.out.println(
                            s.getId() + " " +
                            s.getName() + " " +
                            s.getAge() + " " +
                            s.getCourse()
                        )
                    );
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt(); sc.nextLine();

                    System.out.print("New Name: ");
                    String uname = sc.nextLine();

                    System.out.print("New Age: ");
                    int uage = sc.nextInt(); sc.nextLine();

                    System.out.print("New Course: ");
                    String ucourse = sc.nextLine();

                    dao.updateStudent(new Student(uid, uname, uage, ucourse));
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt();
                    dao.deleteStudent(did);
                    break;

                case 5:
                    System.out.println("Exiting application...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
