package Homework_1;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Task_1 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		actionDivision();
		// noIndex();                                     // снять коммит для проверки
		// handleNullPointerExceptionInStringArray();     // снять коммит для проверки
	}

	// Деление на ноль и корректное число
	public static void actionDivision() {

		try {
			System.out.print("Введите первое целое число: ");
			String input1 = scanner.nextLine();
			String[] numbers1 = input1.split(" ");
			if (numbers1.length != 1) {
				throw new NumberFormatException();
			}
			int number1 = Integer.parseInt(numbers1[0]);

			System.out.print("Введите второе целое число: ");
			String input2 = scanner.nextLine();
			String[] numbers2 = input2.split(" ");
			if (numbers2.length != 1) {
				throw new NumberFormatException();
			}
			int number2 = Integer.parseInt(numbers2[0]);

			int result = number1 / number2;
			System.out.println("Результат деления: " + result);
		} catch (ArithmeticException e) {
			System.out.println("\nПоймано исключение ArithmeticException: Деление на ноль!");
		} catch (NumberFormatException e) {
			System.out.println(
					"\nПоймано исключение NumberFormatException: Введено некорректное значение. Пожалуйста, введите целое число!");
		}
	}

	// Обращение к несуществующему индексу
	public static void noIndex() {
		int[] arr = { 10, 20, 30, 40, 50 };

		System.out.print("Введите номер индекса: ");

		try {
			int index = scanner.nextInt();
			int number = arr[index - 1];
			System.out.println("Число под индексом " + index + ": " + number);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Поймано исключение ArrayIndexOutOfBoundsException: Индекс не существует!");
		} catch (InputMismatchException e) {
			System.out.println("Поймано исключение InputMismatchException: Некорректный ввод числа!");
		}
	}

	// Обработка исключения нулевого указателя в строковом массиве
	public static void handleNullPointerExceptionInStringArray() {
		String[] array = new String[5];
		String element = null;

		try {
			element = array[1];
			int length = element.length();
			System.out.println("Длина элемента: " + length);
		} catch (NullPointerException e) {
			System.out.println("Поймано исключение NullPointerException: Элемент равен null");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Поймано исключение ArrayIndexOutOfBoundsException: Индекс не существует!");
		}
	}
}
