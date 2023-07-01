package Homework_2;

import java.util.Scanner;

public class Task_7 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in, "CP866");

		System.out.print("Введите строку: ");
		String input = scanner.nextLine();

		try {
			if (input.isEmpty()) {
				throw new Exception("Пустые строки вводить нельзя!!!");
			} else {
				System.out.println("Вы ввели: " + input);
			}
		} catch (Exception e) {
			System.out.println("Ошибка ввода: " + e.getMessage());
		}
	}
}
