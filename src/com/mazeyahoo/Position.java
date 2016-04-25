package com.mazeyahoo;

/**
 * This class holds a position X and Y Coordinates.
 * 
 * @author Anwar
 *
 */
public class Position
{
	public int x;
	public int y;

	/**
	 * This constructor creates a position object with specified x and y coordinates.
	 * 
	 * @param x
	 * 		X-Coordinate of position
	 * @param y
	 * 		Y-Coordinate of position
	 */
	public Position(int x, int y)
	{
		this.x=x;
		this.y=y;
	}

	/**
	 * This is a clone constructor creates the copy of the specified position of object.
	 * 
	 * @param positionToClone
	 * 		Position object to copy
	 */
	public Position(Position positionToClone) 
	{
		this.x = positionToClone.x;
		this.y = positionToClone.y;
	}

	@Override
	/**
	 * This is a overridden equals method for Position class.
	 * 
	 * @param obj
	 * 		object to compare
	 * @return
	 * 		True if the object is of type position and have same X and Y Coordinates.
	 */
	public boolean equals(Object obj) {
		boolean isEqual = false;
		if(obj instanceof Position)
		{
			if(obj == this)
			{
				isEqual = true;
			}
			else
			{
				Position otherCoordinate = (Position) obj;
				if(otherCoordinate.x == this.x && otherCoordinate.y == this.y)
				{
					isEqual = true;
				}
			}
		}
		else
		{
			isEqual = super.equals(obj);
		}

		return isEqual;
	}
}