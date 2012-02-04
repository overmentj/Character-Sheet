package com.teabreak.core.aspects.enums;

public enum AlignmentEnum {
	
	CG ("Chaotic", "Good", "Chaotic Good is known as the 'Beatific', 'Rebel', or 'Cynic' alignment. A Chaotic Good character favors change for a greater good, disdains bureaucratic organizations that get in the way of social improvement, and places a high value on personal freedom, not only for oneself, but for others as well. They always intend to do the right thing, but their methods are generally disorganized and often out of alignment with the rest of society"),
	CN ("Chaotic", "Neutral", "Chaotic Neutral is called the 'Anarchist' or 'Free Spirit' alignment. A character of this alignment is an individualist who follows his or her own heart, and generally shirks rules and traditions. Although they promote the ideals of freedom, it is their own freedom that comes first. Good and Evil come second to their need to be free, and the only reliable thing about them is how totally unreliable they are."),
	CE ("Chaotic", "Evil", "Chaotic Evil is referred to as the 'Destroyer' or 'Demonic' alignment. Characters of this alignment tend to have no respect for rules, other people's lives, or anything but their own desires, which are typically selfish and cruel. They set a high value on personal freedom, but do not have any regard for the lives or freedom of other people. They do not work well in groups, as they resent being given orders, and usually behave themselves only out of fear of punishment. It is not compulsory for a Chaotic Evil character to be constantly performing sadistic acts just for the sake of being evil, or constantly disobeying orders just for the sake of causing chaos. "),
	NG ("Neutral", "Good", "Neutral Good is known as the 'Benefactor' alignment. A Neutral Good character is guided by his conscience and typically acts altruistically, without regard for or against Lawful precepts such as rules or tradition. In the event that doing the right thing requires the bending or breaking of rules, they do not suffer the same inner conflict that a Lawful Good character would."),
	NN ("Neutral", "Neutral", "Neutral alignment, also referred to as True Neutral or Neutral Neutral, is called the 'Undecided' or 'Nature's' alignment. This alignment represents Neutral on both axes, and tends not to feel strongly towards any alignment. A farmer whose primary overriding concern is to feed his family is of this alignment. Some Neutral characters, rather than feeling undecided, are committed to a balance between the alignments. They may see good, evil, law and chaos as simply prejudices and dangerous extremes. Druids frequently follow this True Neutral dedication to balance."),
	NE ("Neutral", "Evil", "Neutral Evil is called the 'Malefactor' alignment. Characters of this alignment are typically selfish and have no qualms about turning on their allies-of-the-moment. They have no compunctions about harming others to get what they want, but neither will they go out of their way to cause carnage or mayhem when they see no direct benefit to it. They abide by laws for only as long as it is convenient for them. A villain of this alignment can be more dangerous than either Lawful or Chaotic Evil characters, since he is neither bound by any sort of honor or tradition nor disorganized and pointlessly violent."),
	LG ("Lawful", "Good", "Lawful Good is known as the 'Saintly' or 'Crusader' alignment. A Lawful Good character typically acts with compassion, and always with honor and a sense of duty. Lawful Good characters, especially paladins, may sometimes find themselves faced with the dilemma of whether to obey law or good when the two conflict—for example, upholding a sworn oath when it would lead innocents to come to harm—or conflicts between two orders, such as between their religious law and the law of the local ruler."),
	LN ("Lawful", "Neutral", "Lawful Neutral is called the 'Judge' or 'Disciplined' alignment. A Lawful Neutral character typically believes strongly in Lawful concepts such as honor, order, rules and tradition, and often follows a personal code. Characters of this alignment are neutral with regard to good and evil. This does not mean that Lawful Neutral characters are amoral or immoral, or do not have a moral compass, but simply that their moral considerations come a distant second to what their code, tradition, or law dictates."),
	LE ("Lawful", "Evil", "Lawful Evil is referred to as the 'Dominator' or 'Diabolic' alignment. Characters of this alignment see a well-ordered system as being easier to exploit, and show a combination of desirable and undesirable traits; while they usually obey their superiors and keep their word, they care nothing for the rights and freedoms of other individuals and are not averse to twisting the rules to work in their favor. Like Lawful Good Paladins, Lawful Evil characters may sometimes find themselves faced with the dilemma of whether to obey law or evil when the two conflict.");
	
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


