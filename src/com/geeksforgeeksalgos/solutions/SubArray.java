package com.geeksforgeeksalgos.solutions;

class SubArray {

	// function return the minimum length
	// of sub_array
	static int minimumSubArray(int A[], int n, int B[], int m) {
		int result = Integer.MAX_VALUE;

		// Pick starting point
		for (int i = 0; i < n; i++) {

			// Pick ending point
			for (int j = i; j < n; j++) {

				// k is index in first array
				// and 'index' is index in
				// second array.
				int k, index = 0;
				for (k = i; k <= j; k++) {
					if (A[k] == B[index])
						index++;
					if (index == m)
						break;
				}

				// update minimum length sub_array
				if (index == m && result > k - i + 1)
					result = (k == n) ? k - i : k - i + 1;
			}
		}

		// return minimum length subarray
		return result;
	}

	// driver program to test above function
	public static void main(String[] args) {
		int A[] = { 5, 6, 5, 2, 7, 5, 6, 7, 5, 5, 7 };
		int B[] = { 5, 5, 7 };
		int n = A.length;
		int m = B.length;
		System.out.println(minimumSubArray(A, n, B, m));
	}
}
