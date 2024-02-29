package org.example.tasks;

public class Arctg {
    public static void main(String[] args) {
        for (int i = -9; i < 10; i++) {
            System.out.println(( double) i/10);
            System.out.println((Math.atan(i)));
        }
    }
    public static double calculate(double x, int n) {

        double result = x;  // Хранится результат

        double xx = x * x;
        double pow = x;
        double fact = 1;

        int sign = 1;       // Отвечает за знак (чередование '+' -> '-' -> '+' -> ...)

        for (int i = 1; i < n; i += 1) {

            sign *= -1;
            pow *= xx;

            result += sign * pow/(2 * i + 1);


        }

        // Дополнительно округляем, чтобы легче было проверять
        return result;
    }
}
