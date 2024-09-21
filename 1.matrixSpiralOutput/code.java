/*
	PRINT MATRIX IN SPIRAL FASHION (SECOND ALGORITHM)

			
	
		k is row pointer   l is col pointer
		r = 4   c = 4    size is 4   so r c are limits pointer
		k refers to r  and l refers to c
		
		i fondamentalmente ti serve come loop pointer nel for loop 

	***	each loop: k l increase = starting point will be INSIDE 'next' matrix, r c decrement = 'smaller' matrix   === spiral
		
		method(int[][]matrix, int r, int c) {              r c are row col pointers

			int i, k = 0 , l = 0;   three pointers

			while(k < r && l < c ) {
			
				for (i =l; i < c; i++) {sop(matrix[k][i]);}   k++;                 // i refers to l col reference. l cannot go beyond the limit pointer c; k is the row = no change.
												   // once the loop is finished, increment k row pointer: next iteration goes top bottom: if you don't increment,
												   // last iterated data from this loop will get repeated. 

				for(i=k; i < r; i++) {	sop(matrix[i][c-1]; } c--;                 // top bottom iteration. i referes to k row pointer AS STARTIN POINT. k cannot exceed the r size pointer so i has to be less than r size limit.
												   // c-1 is the last col: you don't change col here. AT EACH STEP INCREASE THE POINTER i, NOT THE REFERENCE k;
												   // after the for loop decrement c to avoid nullPointerException in next loops (c = 4 nullPointer).

				if(k < r) { 

					for(i = c; i >=l; i--) {sop(matrix[r-1][i])} r--;          // backwards: i takes c size pointer as reference, not k, not l. c from last loop is at 3 partition. so it's bottom
												   // so i starts at bottom. i has to iterate until l size pointer. l is 0.
												   // after for loop, decrement r: r referes to row size of matrix. at next loop you interate a *** smaller matrix;
					}

				if(l < c) { 
				
					for(i=r-1; i >=k; i--) {sop(matrix[i][l])} l++;            // bottom top: i takes r -1. r was just decremented to 3 for ***resize. but you don't want to repeate same
												   // last data as the last partition printed in the previous for loop, so i starts at r-1 = upper;
											           // remember that k col pointerwas incremented to 1 so you can use it as limit condition;
											           // after loop, increase l which is the col pointer. next while loop, the left right for loop will start from
											           // 1 and not to 0, so it's a ***smaller matrix;
												   

					}
			}
		} 

*/

public class Spiral {
	public Spiral () {}

	public static void printMatrixSpiral(int[][] matrix, int r, int c) {

		int k = 0;
		int l = 0;
		int i = 0;

		while( k < r && l < c) {

			for (i = l; i < c; i++) {
                        	System.out.print(matrix[k][i] + " ");
			}
			k++;

			for (i = k; i < r; i++) {
				System.out.print(matrix[i][c-1] + " ");
			}
			c--;

			if (k < r) {
			
				for (i = c-1; i >= l; i--) {
					System.out.print(matrix[r-1][i] + " ");
				}
				r--;
			}
			
			if (l < c) {
			
				for (i = r-1; i >= k; i--) {
					System.out.print(matrix[i][l] + " ");
				}
				l++;
			} 
		}	

	}

	
	public static void main(String[] args) {
		Spiral s = new Spiral();
		
		int[][] m = {
				{1,2,3,4},
				{5,6,7,8},			
				{9,10,11,12},	
				{13,14,15,16},										
			};

		int rowSize = 4;
		int colSize = 4;
		
		s.printMatrixSpiral(m, rowSize, colSize);
	}
	
}
