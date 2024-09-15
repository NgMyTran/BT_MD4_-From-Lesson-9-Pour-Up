import ra.Calculator;
import ra.DataInput;
import ra.QuadraticEquation;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.divide(4,2));

        QuadraticEquation equation = new QuadraticEquation(2, 3, 1);
        System.out.println(equation.calculateRoots());

        DataInput input = new DataInput();

        int age = input.readInt("Nhập tuổi của bạn: ");
        double salary = input.readDouble("Nhập lương của bạn: ");
        String name = input.readStringLine("Nhập tên của bạn: ");

        System.out.println("Tuổi của bạn: " + age);
        System.out.println("Lương của bạn: " + salary);
        System.out.println("Tên của bạn: " + name);

        input.close();
    }
}