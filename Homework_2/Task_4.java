package Homework_2;

import java.util.Scanner;

public class Task_4 {
    public static void main(String[] args) {
        float number = inputOfFloatNumber();
        System.out.println("Вы ввели число: " + number);
    }

    public static float inputOfFloatNumber() {
        Scanner scanner = new Scanner(System.in);
        float number = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("\nВведите дробное число(разделитель ','): ");

            if (scanner.hasNextFloat()) {
                number = scanner.nextFloat();
                validInput = true;
            } else {
                System.out.println("Некорректный ввод числа, попробуйте еще раз!");
                scanner.nextLine(); 
            }
        }

        return number;
    }
}


