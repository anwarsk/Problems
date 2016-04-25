package com.mazeyahoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* ==== DEFAULT-MAZE ========
0 1 2 3 4 5
0 S . . .
1 X X X . X X
2       .
3   X X X X
4       G X
5
*/

/**
 * This class responsible for initializing and handling operations related to the maze
 * 
 * @author Anwar
 *
 */
public class Maze
{
	char [][] matrix;
	Position start;
	List<Position> visited = new ArrayList<>();

	/**
	 * This constructor creates the Default maze with following configuration.
	 */
	public Maze()
	{
		// This is Default initialization

		this.matrix = new char[][] {
			{'S', ' ', ' ', ' ', ' ', ' '},
			{'X', 'X', 'X', ' ', 'X', 'X'},
			{' ', ' ', ' ', ' ', ' ', ' '},
			{' ', ' ', 'X', 'X', 'X', ' '},
			{' ', ' ', ' ', 'G', 'X', ' '},
			{' ', ' ', ' ', ' ', ' ', ' '}
		};
		this.start = new Position(0,0);
	}

	/**
	 * This constructor creates the random maze with provided length and breadth. It also generate random start and goal positions.
	 * 
	 * @param length
	 * 		Length of the maze
	 * @param breadth
	 * 		Breadth of the maze
	 */
	public Maze(int length, int breadth)
	{
		// This is Randomized initialization of the Maze with 20% probability of obstacles
				matrix = new char[length][breadth];
				Random randomNumGen = new Random();
				for(int i = 0; i < length; i++)
				{
					for (int j = 0; j < breadth; j++)
					{
						// Every position has 20% of probability of having 'X'
						int number = randomNumGen.nextInt(100);
						if(number < 20)
						{
							matrix[i][j] = 'X';
						}
						else
						{
							matrix[i][j] = ' ';
						}
					}
				}
		
				boolean isGoalAdded = false;
				while(!isGoalAdded)
				{
					int randomX = randomNumGen.nextInt(breadth);
					int randomY = randomNumGen.nextInt(length);
					
					if(matrix[randomY][randomX] != 'X')
					{
						matrix[randomY][randomX] = 'G';
						isGoalAdded = true;
					}
				}
				
				boolean isStartAdded = false;
				while(!isStartAdded)
				{
					int randomX = randomNumGen.nextInt(breadth);
					int randomY = randomNumGen.nextInt(length);
					
					if(matrix[randomY][randomX] != 'X' && matrix[randomY][randomX] != 'G')
					{
						matrix[randomY][randomX] = 'S';
						start = new Position(randomX, randomY);
						isStartAdded = true;
					}
				}
			
	}

	/**
	 * This function checks and returns whether the move to the specified coordinate is possible or not.
	 * 
	 * @param x
	 * 		X-Coordinate of the location
	 * @param y
	 * 		Y-Coordinate of the location
	 * 
	 * @return
	 * 		True if the move is valid and possible else False.
	 */
	public boolean isMovePossible(int x, int y)
	{
		boolean isMovePossible = false;

		if(x>=0 && x < matrix[0].length && y>=0 && y < matrix.length)
		{
			if(matrix[y][x] != 'X' && !visited.contains(new Position(x, y)))
			{
				isMovePossible = true;
			}
		}
		return isMovePossible;
	}

	/**
	 * This function prints the maze. Where 'S' denotes the start position,'G' 
	 * denotes the goal position and 'X' denotes the barriers.
	 */
	public void print()
	{
		System.out.println("\nMAZE:");
		System.out.print(" ");

		for(int j=0; j<matrix[0].length; j++)
		{
			System.out.print("  "+ j );
		}
		System.out.println("");
		for(int i=0; i< matrix.length; i++)
		{
			System.out.print(i);
			for(int j=0; j<matrix[0].length; j++)
			{
				System.out.print("  "+ matrix[i][j] );
			}

			System.out.println("");
		}
	}

	/**
	 * This function adds the specified position to the visited position list.
	 * 
	 * @param position
	 * 		Position to add 
	 * 	
	 */
	public void addVisitedCoordinate(Position position)
	{
		visited.add(position);
	}

	/**
	 * This function checks whether the specified position is Goal position or not.
	 * 
	 * @param position
	 * 		Position to check
	 * @return
	 * 		True if specified position is goal position else False.
	 */
	public boolean isGoal(Position position)
	{
		boolean isGoal = false;

		if(matrix[position.y][position.x] == 'G')
		{
			isGoal = true;
		}

		return isGoal;
	}


};
