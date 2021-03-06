package book.pieslynj.recursion;

class BSException extends Exception {

	public BSException(String s) {
		super(s);
	}

}

/*
 * A binary search is O(log(n)) because half of the search space is eliminated
 * (in a sense, searched) on each iteration. This is more efficient than a
 * simple search through all the elements, which would be O(n). However, to
 * perform a binary search, the array must be sorted, an operation that is
 * usually O(n log(n)).
 */
public class BinarySearch {

	int binarySearch(int[] array, int target) throws BSException {
		return binarySearch(array, target, 0, array.length - 1);
	}

	int binarySearch(int[] array, int target, int lower, int upper) throws BSException {
		int center, range;

		range = upper - lower;
		if (range < 0) {
			throw new BSException("Limits reversed");
		} else if (range == 0 && array[lower] != target) {
			throw new BSException("Element not in array");
		}
		if (array[lower] > array[upper]) {
			throw new BSException("Array not sorted");
		}
		center = ((range) / 2) + lower;
		if (target == array[center]) {
			return center;
		} else if (target < array[center]) {
			return binarySearch(array, target, lower, center - 1);
		} else {
			return binarySearch(array, target, center + 1, upper);
		}
	}

	int iterBinarySearch(int[] array, int target) throws BSException {
		int lower = 0, upper = array.length - 1;
		int center, range;

		if (lower > upper) {
			throw new BSException("Limits reversed");
		}
		while (true) {
			range = upper - lower;
			if (range == 0 && array[lower] != target) {
				throw new BSException("Element not in array");
			}
			if (array[lower] > array[upper]) {
				throw new BSException("Array not sorted");
			}
			center = ((range) / 2) + lower;
			if (target == array[center]) {
				return center;
			} else if (target < array[center]) {
				upper = center - 1;
			} else {
				lower = center + 1;
			}
		}
	}
}
