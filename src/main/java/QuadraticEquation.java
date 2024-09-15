public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private double calculateDelta() {
        return b * b - 4 * a * c;
    }

    public String calculateRoots() {
        double delta = calculateDelta();
        if (a == 0) {
            return "Hệ số a không được bằng 0.";
        } else if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            return "Phương trình có hai nghiệm phân biệt:\n" +
                    "Nghiệm thứ nhất x1 = " + x1 + "\n" +
                    "Nghiệm thứ hai x2 = " + x2;
        } else if (delta == 0) {
            double x = -b / (2 * a);
            return "Phương trình có nghiệm kép:\n" +
                    "Nghiệm x = " + x;
        } else {
            return "Phương trình vô nghiệm.";
        }
    }
}

