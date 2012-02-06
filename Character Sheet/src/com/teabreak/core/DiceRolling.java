package com.teabreak.core;

import java.util.Arrays;

// Written by Mike .. 02/12

public class DiceRolling {
	private RandomNumberGenerator rng = new RandomNumberGenerator();
	
	String methodList;
	
	/**
	 * Rolls a single dice of size diceSize
	 * @param diceSize size of dice rolled
	 * @return dice value
	 */
	
	public int rollDice(int diceSize){
		
		// Forward call to the Random_Number_Generator package
		int Return_Value = rng.Roll_Die(diceSize);
		
		return Return_Value;
	}
	
	/**
	 * Rolls numDice of size DiceSize, with modifiers and using a set method
	 * @param diceSize Size of the dice
	 * @param numDice Number of dice
	 * @param modifiers positive/negative modifiers
	 * @return dice value
	 */
	
	public int rollDice(int diceSize, int numDice, int modifiers){
		
		int Total = 0;
		
		for (int Index = 0; Index < numDice; Index++)
		{
			Total = Total + rng.Roll_Die(diceSize);
		}
		
		Total = Total + modifiers;
					
		return Total;
	}

	/**
	 * Takes the number of D6 to roll (values of best n used) to determine the value of a stat.
	 * @param numDice the number of dice rolled (3,4 or 5 at present)
	 * @param bestOf the best n dice used to generate the value
	 * @return the final value.
	 */
	public int rollDice(int numDice, int bestOf){
	
	// 3D6 - take best 3
	// 4D6 - take best 3
	// 5D6 - take best 3
		int Total = 0;
		int[] Rolls = new int[numDice];
		
		// Populate the array with values
		for (int Index1 = 0; Index1 < numDice; Index1++)
		{
			Rolls[Index1] = rng.Roll_Die(6);
		}
		
		// Sort the array into ASCENDING numerical order
		Arrays.sort(Rolls);
		
		// get the length of the array
		int RollsLength = Rolls.length;
		
		// take the highest n dice and add them together
		for (int Index2 = RollsLength - bestOf; Index2 < bestOf; Index2++)
		{
			Total = Total + Rolls[Index2];
		}
	
		return Total;
		
	}
		
	/**
	 * Rolls a number of dice and returns an int
	 * @param method gives information on how to set the dice
	 * @return dice value
	 */
	
	public int rollDice(String method) // Tom's Temporary Thing.
	{
		return 1;
	}
	
}
