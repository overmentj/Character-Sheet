package com.teabreak.core;

// Written by Mike .. 02/12

public class DiceRolling {
	private RandomNumberGenerator rng = new RandomNumberGenerator();
	
	//TODO: Mike, can you fill out functions?
	
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
	 * Rolls a number of dice and returns an int
	 * @param method gives information on how to set the dice
	 * @return dice value
	 */
	
	public int rollDice(String method) // Tom's Temporary Thing.
	{
		return 1;
	}
	
}
