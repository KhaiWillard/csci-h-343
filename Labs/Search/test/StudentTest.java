import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;

public class StudentTest {
	@Test
	public void test() {
		test_find_first_true();
		test_find_first_true_sorted();
		test_find_first_equal();
	}
	
	@Test
	public void test_find_first_true() {
		Random r = new Random();
		for (int trial = 0; trial < 200; ++trial) {
			int n = r.nextInt(50) + 1;
			boolean[] arr = new boolean[n];

			int firstTrue = r.nextInt(n + 1);

			for (int i = 0; i < n; ++i) {
				arr[i] = (i >= firstTrue);
			}
			int begin = r.nextInt(n + 1);
			int end = r.nextInt(n + 1 - begin) + begin;

			int expected = end;
			for (int i = begin; i < end; ++i) {
				if(arr[i]) {
					expected = i;
					break;
				}
			}

			int result = Search.find_first_true(arr, begin, end);

			assertEquals(expected, result);
		}	

	}

        @Test
        public void test_find_first_true_sorted() {
                Random r = new Random();

                for (int trial = 0; trial < 200; ++trial) {
                    int n = r.nextInt(50) + 1; 
                    boolean[] arr = new boolean[n];
                    int firstTrue = r.nextInt(n + 1);

                    for (int i = 0; i < n; ++i) {
                        arr[i] = (i >= firstTrue);
                    }

                    int begin = r.nextInt(n + 1);
                    int end = r.nextInt(n + 1 - begin) + begin; 
                    int expected = end;
                    for (int i = begin; i < end; ++i) {
                        if (arr[i]) {
                            expected = i;
                            break;
                        }
                    }

                    int result = Search.find_first_true_sorted(arr, begin, end);

                    assertEquals(expected, result);
                }
        }
	
	@Test
	public void test_find_first_equal() {
		Random r = new Random();

		for (int trial = 0; trial < 200; ++trial) {
			int n = r.nextInt(50) + 1;
			int[] arr = new int[n];

			int val = r.nextInt(5);
			for (int i = 0; i < n; ++i) {
				arr[i] = val;
				if (r.nextBoolean()) {
					val += r.nextInt(3);
				}
			}
			int x = r.nextInt(val + 3);

			int expected = n;
			for (int i = 0; i < n; ++i) {
				if (arr[i] == x) {
					expected = i;
					break;
				}
			}

			int result = Search.find_first_equal(arr, x);

			assertEquals(expected, result);
		}
	}	
}

