package com.geeksforgeeksalgos.solutions;

public class GenerateSubArray {

	public static void main(String[] args) {

		int[] array = { 1, 2, 3, 4, 5 };
		GenerateSubArrayList(array);
	}

	private static void GenerateSubArrayList(int[] array) {
		
		int length = array.length;
		
		for(int i=0; i<length ; i++){
			
			for(int j=i; j<length; j++){
				
				for(int k=i; k<=j ; k++){
					System.out.print(array[k] + " ");
				}
				System.out.println();
			}
		}
	}

}
