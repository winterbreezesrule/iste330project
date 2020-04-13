public class MainTest {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        MySQLDatabase test = new MySQLDatabase("student", "student");
        try {
            test.connect();
            System.out.println("connected.");
            test.close();
            System.out.println("connection closed.");
        } catch (Exception e) {

        }
    }
}
