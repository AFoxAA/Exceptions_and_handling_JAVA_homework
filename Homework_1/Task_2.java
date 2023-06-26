package Homework_1;

import java.util.Arrays;
import java.util.Random;

public class Task_2 {
    public static void main(String[] args) {
        int[] array1 = generateRandomArray();
        int[] array2 = generateRandomArray();

        System.out.println("\nМассив 1: " + Arrays.toString(array1));
        System.out.println("Массив 2: " + Arrays.toString(array2));

        try {
            int[] result = subtractingArrayElements(array1, array2);

            System.out.println("\nМассив разности элементов двух массивов: " + Arrays.toString(result));
        } catch (IllegalArgumentException e) {
            System.out.println("\nПоймано исключение IllegalArgumentException: " + e.getMessage());
        }
    }

    // Генерация случайного массива
    public static int[] generateRandomArray() {
        Random random = new Random();

        int length = random.nextInt(5) + 1;
        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(51); 
        }
        return array;
    }

    // Вычисление разности элементов двух массивов
    public static int[] subtractingArrayElements(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            throw new IllegalArgumentException("Длины массивов не равны");
        }

        int[] result = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            result[i] = array1[i] - array2[i];
        }

        return result;
    }
}

