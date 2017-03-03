
public class SpiralMatrix {
	public static void printSpiralMatrix(int[][]matrix) {
		if(matrix == null){
			return;
		}
		int numRows = matrix.length,
			numCols = matrix[0].length,
			startRow = 0,
			startCol = 0,
			endRow = (numRows + 1) / 2,
			endCol = (numCols + 1) / 2;
		
		while(startCol <= endRow && startCol <= endCol) {
			int currRow = startRow,
				currCol = startCol;
			
			/**** Top Row ****/
			while(currCol <= numCols - 1 - startCol) {
				System.out.print(matrix[currRow][currCol++] + " ");
			}
			
			/**** Right Column ****/
			currRow++;
			currCol--;
			while(currRow <= numRows - 1 - startRow) {
				System.out.print(matrix[currRow++][currCol] + " ");
			}
			
			/**** Bottom Row ****/
			currCol--;
			currRow--;
			while(currCol >= startCol) {
				System.out.print(matrix[currRow][currCol--] + " ");
			}
			currRow--;
			currCol++;
			
			/**** Left Row ****/
			while(currRow > startRow) {
				System.out.print(matrix[currRow--][currCol] + " ");
			}
			startRow = currRow + 1;
			startCol++;
		}
	}
	public static void main(String[]args) {
		int[][]matrix = {{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16}};
	printSpiralMatrix(matrix);
	}
}
