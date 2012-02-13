package com.teabreak.core.dicebag;


public class rngTest
{
	public static void main(String[] args)
	{
		RandomNumberGenerator rng = new RandomNumberGenerator();
		Integer six = 0;
		Integer five = 0;
		Integer four = 0;
		Integer three = 0;
		Integer two = 0;
		Integer one = 0;

		int result = 0;
		for (int i = 0; i < 10000000; i++)
		{
			result = rng.Roll_Die(6);
			switch (result)
			{
			case 1:
				one += 1;
				break;
			case 2:
				two += 1;
				break;
			case 3:
				three += 1;
				break;
			case 4:
				four += 1;
				break;
			case 5:
				five += 1;
				break;
			case 6:
				six += 1;
				break;
			}

		}
		System.out.println(six);
		System.out.println(five);
		System.out.println(four);
		System.out.println(three);
		System.out.println(two);
		System.out.println(one);

	}
}
