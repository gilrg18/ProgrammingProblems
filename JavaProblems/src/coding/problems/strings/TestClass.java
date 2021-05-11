package coding.problems.strings;

public class TestClass {
	// iterative
	public static int[] binarySearch(int[] array, int value) {
		int left = 0;
		int right = array.length - 1;
		int middle;
		while (left <= right) {
			middle = (left + right) / 2;
			if (array[middle] == value) {
				return new int[] { value, middle };
			} else if (value < array[middle]) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}

		return new int[] {value, -1 };
	}

	// recursive
	public static int[] recursiveBS(int[] array, int value) {
		return recursiveBS(array, value, 0, array.length - 1);
	}

	private static int[] recursiveBS(int[] array, int value, int left, int right) {
		if (left > right) {
			return new int[] {value, -1 };
		}
		int middle = (left + right) / 2;
		if (array[middle] == value) {
			return new int[] { value, middle };
		} else if (value < array[middle]) {
			return recursiveBS(array, value, left, middle - 1);
		} else {
			return recursiveBS(array, value, middle + 1, right);
		}

	}

	public static void main(String[] args) {
		System.out.println("Test Class");
		int[] arr = { 1, 2, 5, 10, 34, 42, 43, 55 };
		int[] res = binarySearch(arr, 34);
		for (int i : res) {
			System.out.print(i + " ");
		}

		int[] recursive = recursiveBS(arr, 1);
		for (int i : recursive) {
			System.out.print(i + " ");
		}

	}
}
