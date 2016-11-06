/*
 * Given an NxN grid with an array of lamp coordinates. 
 * Each lamp provides illumination to every square on their x axis, 
 * every square on their y axis, and every square that lies in their diagonal (
 * think of a Queen in chess). Given an array of query coordinates, determine whether 
 * that point is illuminated or not.
 */
public class LampIllumination {
	public void illuminateLamps(boolean[][]grid, Coordinates[]coordinate){
		for(int index = 0; index < coordinate.length; index++){
			int x = coordinate[index].getXCoordinate(),
				y = coordinate[index].getYCoordinate(),
				diagonal_start_row = 0, 
				diagonal_start_col = 0;
			
			/*illuminate the rows */
			for(int col = 0; col < grid.length; col++) {
				grid[x][col] = true;
			}
			
			/*illuminate the columns*/
			for(int row = 0; row < grid.length; row++) {
				grid[row][y] = true;
			}
			
			/*illuminate diagonals */
			if(y > x) {
				diagonal_start_col = y - x;
			}
			else if(x > y) {
				diagonal_start_row = x - y;
			}
			while(diagonal_start_row < grid.length && 
				  diagonal_start_col < grid.length) {
				grid[diagonal_start_row][diagonal_start_col] = true;
				diagonal_start_row++;
				diagonal_start_col++;
			}
		}
	}
	
	public boolean isIlluminated(Coordinates coordinate, boolean[][]grid) {
		return grid[coordinate.getXCoordinate()][coordinate.getYCoordinate()];
	}
	public static void main(String[]args) {
		LampIllumination li = new LampIllumination();
		Coordinates[]coordinates = { new Coordinates(1,3), 
                                     new Coordinates(3, 4),
                                     new Coordinates(1, 2) };
		boolean[][]illuminationLamp = new boolean[5][5];
		li.illuminateLamps(illuminationLamp, coordinates);
		System.out.println("The illuminated diagonal is ");
		
		for(int row = 0; row < illuminationLamp.length; row++) {
			for(int col = 0; col < illuminationLamp.length; col++) {
				System.out.print(illuminationLamp[row][col] +" ");
			}
			System.out.println();
		}
		Coordinates[]query = {new Coordinates(2, 1),
							  new Coordinates(3,3),
							  new Coordinates(4, 0)};
		for(Coordinates coordinate : query)
			System.out.println(li.isIlluminated(coordinate, illuminationLamp));
	
	}
}
