package calculator;

import java.util.Scanner;

public class CalculatorController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LoggerSingleton logger = LoggerSingleton.getInstance();

        System.out.println("Введите действительную часть первого числа:");
        double real1 = scanner.nextDouble();
        System.out.println("Введите мнимую часть первого числа:");
        double imaginary1 = scanner.nextDouble();
        ComplexNumber num1 = new ComplexNumber(real1, imaginary1);

        System.out.println("Введите действительную часть второго числа:");
        double real2 = scanner.nextDouble();
        System.out.println("Введите мнимую часть второго числа:");
        double imaginary2 = scanner.nextDouble();
        ComplexNumber num2 = new ComplexNumber(real2, imaginary2);

        System.out.println("Выберите операцию: 1) Сложение 2) Умножение 3) Деление");
        int choice = scanner.nextInt();

        Operation operation;
        switch (choice) {
            case 1:
                operation = new Addition();
                break;
            case 2:
                operation = new Multiplication();
                break;
            case 3:
                operation = new Division();
                break;
            default:
                throw new IllegalArgumentException("Неверный выбор операции");
        }

        ComplexNumber result = operation.execute(num1, num2);
        System.out.println("Результат: " + result);
        logger.log("Выполнена операция: " + operation.getClass().getSimpleName() + " с результатом: " + result);
    }
}
