public class Search {
	public static int find_first_true(boolean[] A, int begin, int end) {
		int index = end;
		for (int i = begin; i != end; ++i) {
			if (A[i] == true) {
				index = i;
				break;
			}
		}
		return index;
	}
	public static int find_first_equal(int[] A, int x) {
		int index = A.length;
		boolean[] B = new boolean[A.length];
		for (int i = 0; i != A.length; ++i) {
			 B[i] = (A[i] == x);
		}
		if (find_first_true(B, 0, A.length) != (A.length)) {
			index = find_first_true(B, 0, A.length);
		}
		return index;
	}
	public static int find_first_true_sorted(boolean[] A, int begin, int end) {
		while (begin < end) {
			int middle = begin + (end - begin) / 2;
			if (A[middle]) {
				end = middle;
			}
			else {
				begin = middle + 1;
			}
		}
		return begin;		
	}
}
