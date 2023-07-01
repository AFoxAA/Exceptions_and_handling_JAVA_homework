package Homework_3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.util.Scanner;

public class Task_8 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in, "CP866");

		String[] data = getInputData(scanner);
		writeDataToFile(data);

		String lastName = data[0];
		String firstName = data[1];
		String patronymic = data[2];
		String phoneNumber = data[3];

		printData(lastName, firstName, patronymic, phoneNumber);

		scanner.close();
	}

	// Метод для получения входных данных от пользователя
	private static String[] getInputData(Scanner scanner) {
		String[] data = new String[4];
		boolean isValid = false;

		while (!isValid) {
			System.out.println("\nВведите данные (Фамилия Имя Отчество номер_телефона):");
			String input = scanner.nextLine().trim();

			if (input.isEmpty()) {
				System.out.println("Ошибка: данные не введены!!!");
				continue;
			}

			try {
				data = parseInputData(input);
				isValid = true;
			} catch (InvalidDataFormatException e) {
				System.out.println("Ошибка: некорректный формат данных, " + e.getMessage());
			}
		}

		return data;
	}

	// Метод для разбора введенных пользователем данных
	private static String[] parseInputData(String input) throws InvalidDataFormatException {
		String[] data = input.split(" ");

		if (data.length != 4) {
			throw new InvalidDataFormatException("ожидается 4 параметра, получено: " + data.length + " !!!");
		}

		if (isAnyFieldEmpty(data)) {
			throw new InvalidDataFormatException("некоторые поля не заполнены!!!");
		}

		if (!isPhoneNumberValid(data[3])) {
			throw new InvalidDataFormatException("номер телефона должен содержать только цифры!!!");
		}

		return data;
	}

	// Метод, который проверяет, есть ли пустые поля в массиве данных
	private static boolean isAnyFieldEmpty(String[] data) {
		for (String field : data) {
			if (field.trim().isEmpty()) {
				return true;
			}
		}
		return false;
	}

	private static boolean isPhoneNumberValid(String phoneNumber) {
		return phoneNumber.matches("\\d+");
	}

	// Метод для записи данных в файл
	private static void writeDataToFile(String[] data) {
		BufferedWriter bufferedWriter = null;

		try {
			String lastName = data[0];
			String firstName = data[1];
			String patronymic = data[2];
			String phoneNumber = data[3];

			String fileName = lastName + ".txt";
			File file = new File(fileName);
			boolean fileExists = file.exists();

			FileWriter fileWriter = new FileWriter(file, true);
			bufferedWriter = new BufferedWriter(fileWriter);

			if (fileExists) {
				bufferedWriter.newLine();
			}

			bufferedWriter.write(lastName + ' ' + firstName + ' ' + patronymic + ' ' + phoneNumber);
			System.out.println("\nДанные успешно записаны в файл: " + fileName);
		} catch (IOException e) {
			System.out.println("Ошибка при записи данных в файл!!!");
			e.printStackTrace();
		} finally {
			try {
				if (bufferedWriter != null) {
					bufferedWriter.close();
				}
			} catch (IOException e) {
				System.out.println("Ошибка при закрытии файла!!!");
				e.printStackTrace();
			}
		}
	}

	// Метод для вывода введенных данных на консоль
	private static void printData(String lastName, String firstName, String patronymic, String phoneNumber) {
		System.out.println("\nДанные успешно введены:");
		System.out.println("Фамилия: " + lastName);
		System.out.println("Имя: " + firstName);
		System.out.println("Отчество: " + patronymic);
		System.out.println("Номер телефона: " + phoneNumber);
	}

	// Пользовательское исключение, которое используется для обработки некорректных данных
	public static class InvalidDataFormatException extends Exception {
		public InvalidDataFormatException(String message) {
			super(message);
		}
	}
}
