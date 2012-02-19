package com.teabreak.core.aspects.enums;

public enum SaveEnum
{
	Fort, Ref, Will;

	// I'm not keen on this but it is effective, ideas?
	public enum saveScore
	{
		Good(2), Poor(3);

		private int divisor;

		private saveScore(int divisor)
		{
			this.divisor = divisor;
		}
	}

	public static int getBaseSave(int level, saveScore score)
	{
		// TODO: Check this always rounds down
		return level / score.divisor;
	}
}
