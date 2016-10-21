/*
 * Program to find the shortest path in 
 * an undirected graph from source to 
 * destination
 */
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Dijkstra {
	private static void InitializeList(List<Integer>q, int totalNodes) {
		for(int i = 0; i < totalNodes; i++) {
			q.add(i);
		}
	}
	
	private static int findTotalNodes(int[][]matrix) {
		Set<Integer>nodes = new HashSet<Integer>();
		for(int row = 0; row < matrix.length; row++) {
			for(int col = 0; col < 2; col++) {
				nodes.add(matrix[row][col]);
			}
		}
		return nodes.size();
	}
	private static void InitializeShortestDistance(int[]arr) {
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.MAX_VALUE;
		}
	}
	
	public static int findShortestDistance(int[][]neighbors, int source, int destination) {
		//int shortestDistance = 0;
		int totalNodes = findTotalNodes(neighbors);
		List<Integer>unVisited = new LinkedList<Integer>();
		InitializeList(unVisited, totalNodes); 	//Initialize to infinity
		int[]shortestDistanceFromSource = new int[totalNodes];
		InitializeShortestDistance(shortestDistanceFromSource);
		int current = source;
		shortestDistanceFromSource[0] = 0;
		
		while(current != 0 ) {
			if(!unVisited.isEmpty()) {
				unVisited.remove(current);
			}
			int nextCurrent = 0;
			int nextShortestDistance = Integer.MAX_VALUE;
			for(int row = 0; row < neighbors.length; row++) {
				if(neighbors[row][0] == current) {
					int distance = 0;
					int temp = neighbors[row][1];
					if(unVisited.contains(temp)) {
						distance = neighbors[row][2];
						if(distance < nextShortestDistance) {
							nextShortestDistance = distance;
							nextCurrent = temp;
						}
					}
					int newDistance = distance + shortestDistanceFromSource[current - 1];
					shortestDistanceFromSource[temp] = newDistance;
				}
			}
			current = nextCurrent;
			
		}
		
		return shortestDistanceFromSource[destination - 1];
	}
	public static void main(String[]args) {
		
		int[][]neighbors = {{1,2,2}
							,{1,4,4}
							,{2,3,1}
							,{3,4,3}
							,{4,5,1}};
		int shortestDistance = findShortestDistance(neighbors, 1, 5);
		System.out.print("The shortest distance is "+shortestDistance);
	}

}
