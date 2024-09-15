import java.util.InputMismatchException;
import java.util.Scanner;

public class DataInput {
    private Scanner scanner;

    public DataInput() {
        this.scanner = new Scanner(System.in);
    }

    // int
    public int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Dữ liệu không hợp lệ. Vui lòng nhập một số nguyên.");
                scanner.next();
            }
        }
    }

    // double
    public double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Dữ liệu không hợp lệ. Vui lòng nhập một số thực.");
                scanner.next();
            }
        }
    }

    // nhiều String
    public String readStringLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    // Đóng Scanner khi không còn sử dụng
    public void close() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
