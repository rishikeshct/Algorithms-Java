package com.geeksforgeeksalgos.solutions;

public class CostPalidrome {

	public static void main(String[] args) {
		String str = "abcdef";
		String[] ary = str.split("");
		int length = ary.length;
		int cost = 0;
		for (int i = 0; i < length; i++) {
			if(!ary[i].equals(ary[length-1])){
				if(ary[i].compareTo(ary[length-1])>0){
					cost= cost + ary[length-1].charAt(0) - 'a' + 1;
					System.out.println(cost);
				}
				else if(ary[i].compareTo(ary[length-1])<0){
					cost= cost + ary[i].charAt(0) - 'a' + 1;
					System.out.println(cost);
				}
			}
			length--;
		}
		System.out.println(cost);
	}
}
