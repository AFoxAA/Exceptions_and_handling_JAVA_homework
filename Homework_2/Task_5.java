package Homework_2;

public class Task_5 {
	public static void main(String[] args) {
		int[] intArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		try {
			int d = 0;
			double catchedRes1 = intArray[8] / d;
			System.out.println("catchedRes1 = " + catchedRes1);
		} catch (ArithmeticException e) {
			System.out.println("\nПоймано исключение ArithmeticException: Деление на ноль!");
		}
	}
}
