package Homework_1;

import java.util.Arrays;
import java.util.Random;

public class Task_3 {
	public static void main(String[] args) {
		int[] array1 = generateRandomArray();
		int[] array2 = generateRandomArray();

		System.out.println("\nМассив 1: " + Arrays.toString(array1));
		System.out.println("Массив 2: " + Arrays.toString(array2));

		try {
			int[] result = differencesOfArrayElements(array1, array2);

			System.out.println("\nМассив разности элементов двух массивов: " + Arrays.toString(result));
		} catch (RuntimeException e) {
			System.out.println("\nПоймано исключение RuntimeException: " + e.getMessage());
		}
	}

	// Генерация случайного массива
	public static int[] generateRandomArray() {
		Random random = new Random();

		int length = random.nextInt(2) + 1;
		int[] array = new int[length];

		for (int i = 0; i < length; i++) {
			array[i] = random.nextInt(6);
		}
		return array;
	}

	// Вычисление разности элементов двух массивов
	public static int[] differencesOfArrayElements(int[] array1, int[] array2) {
		if (array1.length != array2.length) {
			throw new RuntimeException("Длины массивов не равны");
		}

		int[] result = new int[array1.length];
		for (int i = 0; i < array1.length; i++) {
			if (array2[i] == 0) {
				throw new RuntimeException("Деление на ноль");
			}
			result[i] = array1[i] / array2[i];
		}

		return result;
	}

}
