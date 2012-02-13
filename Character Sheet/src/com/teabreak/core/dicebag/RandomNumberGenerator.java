package com.teabreak.core.dicebag;

// Written by Mike .. 02/12

public class RandomNumberGenerator {

	// Pseudo random number stream placeholder variables
	private static double Current_Stream_Value = 0.1; // Current Stream Value
	private static int Counter = 99999; // Counter variable

	// Method to generate a URN in the range 0..1
	// Input current stream value
	// Return Double (will need scalar modification).
	private double Create_Uniform_Random_Number() {
		// Define Variables

		final double a = 15107.0; // Multiplicative PRIME index
		final double m = 7237.0; // Numeric base (PRIME)
		final double c = 54321.0; // Step-wise Distorter
		
		// Calculate next number in stream based on
		double Return_Value = ((a * Current_Stream_Value + c) % m) / (m - 1);
		Current_Stream_Value = Return_Value;
		
		return Return_Value;
	}

	// Method to generate a RN scaled by Die No. (SINGLE DIE)
	// Input Die size (e.g: 6 for D6, 10 for D10 .....)
	// Return Integer value (result for die)
	protected int Roll_Die(int Die_Size) {

		// Reset stream variable IF we are 1000 entries into the stream
		if (Counter >= 3000) {
			Current_Stream_Value = System.currentTimeMillis();
			Counter = 0;
		}
		;

		// Return value is Ceiling(rand{0..1} * Die_No)
		int Return_Value = (int) Math.ceil
				(Die_Size * Create_Uniform_Random_Number());

		return Return_Value;
	}

}
