package com.teabreak.core.aspects;

public enum AlignmentEnum {
	
	CG ("Chaotic", "Good", "Stuff"),
	CN ("Chaotic", "Neutral", "Stuff"),
	CE ("Chaotic", "Evil", "Stuff"),
	NG ("Neutral", "Neutral", "Stuff"),
	NN ("Neutral", "Neutral", "Stuff"),
	NE ("Neutral", "Evil", "Stuff"),
	LG ("Lawful", "Good", "Stuff"),
	LN ("Lawful", "Neutral", "Stuff"),
	LE ("Lawful", "Evil", "Stuff");
	
	private String order;
	private String morality;
	private String text;
	
	AlignmentEnum(String order, String morality, String text) {
	this.order = order;
	this.morality = morality;
	this.text = text;	
	}

	public String getEnumAlignmentText()
	{
		return text;
	}
	
	public String getEnumAlignmentMorality()
	{
		return morality;
	}
	
	public String getEnumAlignmentOrder()
	{
		return order;
	}
	
}


