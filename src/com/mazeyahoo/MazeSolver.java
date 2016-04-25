package com.mazeyahoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This is maze solver holding the main method and executes the program.
 * 
 * @author Anwar
 *
 */
public class MazeSolver {

	/**
	 * Main method.
	 * 
	 */
	public static void main(String[] args) {
		
		//Generate random maze with length, breadth
		//Maze maze = new Maze(5,5);
		Maze maze = new Maze();
		maze.print();
		List<Integer> movesList = findPath(maze,maze.start);
		printMoves(movesList);
	}

	/**
	 * This method print the resultant moves traced to reach from Start position to Goal position.
	 * @param movesList
	 * 		List of moves
	 */
	public static void printMoves(List<Integer> movesList)
	{
		if(movesList.isEmpty())
		{
			System.out.println("There is no path from Start to Goal.");
			return;
		}

		System.out.print("\n*** Moves To Reach Goal *** : \n(U- UP | R - RIGHT | D - DOWN | L - LEFT )\n\nStart");
		for(int move : movesList)
		{
			String moveName = "";
			switch (move) {
			case 0:
				moveName = "Goal Reached!";
				break;
			case 1:
				moveName = "U";
				break;
			case 2:
				moveName = "R";
				break;
			case 3:
				moveName = "D";
				break;
			case 4:
				moveName = "L";
				break;
			default:
				break;
			}
			System.out.print(" -> " + moveName);
		}


	}

	/**
	 * This method traverse path from mentioned start position to to the goal position in the specified maze.
	 * 
	 * @param maze
	 * 		Maze object to traverse
	 * @param start
	 * 		Start position in the maze.
	 * 
	 * @return
	 * 		List of moves to reach the Goal position from Start position.
	 */
	public static List<Integer> findPath(Maze maze, Position start)
	{
		/*
		  1- UpMove, 2-RightMove, 3-DownMove, 4-LeftMove
		 */
		List<Integer> movesList = new ArrayList<Integer>();

		maze.addVisitedCoordinate(start);
		if(maze.isGoal(start))
		{
			// Goal is reached add 0 to moves list and return
			movesList.add(0);
			return movesList;
		}
		else
		{
			Position currentPosition = new Position(start.x, start.y);
			Position nextPosition = null;
			
			/*
			 * This DFS approach, This code try to traverse the graph recursively in order of moves- 1, 2, 3, 4 and stops when 
			 * goal position is reached and returns the list of move to calling function.
			 */
			// 1. Move Up
			if(maze.isMovePossible(currentPosition.x, currentPosition.y-1))
			{
				nextPosition = new Position(currentPosition);
				nextPosition.y -= 1;
				movesList = findPath(maze, nextPosition);
				if(!movesList.isEmpty())
				{
					movesList.add(0, 1);
					return movesList;
				}
			}

			// 2. Move Right
			if(maze.isMovePossible(currentPosition.x+1, currentPosition.y))
			{
				nextPosition = new Position(currentPosition);
				nextPosition.x += 1;

				movesList = findPath(maze, nextPosition);
				if(!movesList.isEmpty())
				{
					movesList.add(0, 2);
					return movesList;
				}
			}

			// 2. Move Down
			if(maze.isMovePossible(currentPosition.x, currentPosition.y+1))
			{
				nextPosition = new Position(currentPosition);
				nextPosition.y += 1;

				movesList = findPath(maze, nextPosition);
				if(!movesList.isEmpty())
				{
					movesList.add(0, 3);
					return movesList;
				}
			}

			// 2. Move Left
			if(maze.isMovePossible(currentPosition.x-1, currentPosition.y))
			{
				nextPosition = new Position(currentPosition);
				nextPosition.x -= 1;

				movesList = findPath(maze, nextPosition);
				if(!movesList.isEmpty())
				{
					movesList.add(0, 4);
					return movesList;
				}
			}

		}

		// if all the possible paths at given position are exhausted then return
		return movesList;
	}

}
