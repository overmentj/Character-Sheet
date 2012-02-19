package com.teabreak.core.datasource;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

import com.teabreak.core.aspects.AspectsEnum;
import com.teabreak.core.aspects.AspectsInterface;
import com.teabreak.core.aspects.CharClass;
import com.teabreak.core.aspects.Race;
import com.teabreak.core.aspects.Skill;
import com.teabreak.core.aspects.enums.AbilityEnum;
import com.teabreak.core.aspects.enums.SaveEnum;
import com.teabreak.core.aspects.enums.SkillEnum;

public class TestDataSource implements DataSourceInterface
{

	@Override
	public AspectsInterface getDateOfType(AspectsEnum dataType)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortedMap<String, AspectsInterface> getDataSetOfType(
			AspectsEnum dataType)
	{
		SortedMap<String, AspectsInterface> data = new TreeMap<String, AspectsInterface>();
		switch (dataType)
		{
		case Skill:
			data.put("Apraise",
					new Skill(1, SkillEnum.Appraise, false, AbilityEnum.Int,
							"Appraise", "Appraise stuff", null, true));
			data.put("Balance",
					new Skill(2, SkillEnum.Balance, false, AbilityEnum.Dex,
							"Balance", "Balance stuff", null, true));
			data.put("Bluff",
					new Skill(3, SkillEnum.Bluff, false, AbilityEnum.Cha,
							"Bluff", "Bluff stuff", null, true));
			break;

		case Class:
			data.put("Fighter",
					new CharClass(
							SaveEnum.saveScore.Good,
							SaveEnum.saveScore.Good,
							SaveEnum.saveScore.Good,
							"Fighter",
							"Fighter is a class, the only one we don't actually have :S",
							new String[]
							{ "Climb", "Craft", "Handle Animal", "Intimidate" },
							"PHB"));
			data.put("Bard",
					new CharClass(
							SaveEnum.saveScore.Good,
							SaveEnum.saveScore.Good,
							SaveEnum.saveScore.Good,
							"Bard",
							"Mike makes an amazingly sexy bard that Tom cannot resist",
							new String[]
							{ "Appraise", "Balance", "Bluff", "Climb" }, "PHB"));

			data.put("Cleric",
					new CharClass(
							SaveEnum.saveScore.Good,
							SaveEnum.saveScore.Good,
							SaveEnum.saveScore.Good, "Cleric",
							"Danny's a cleric.. yes he is.. he is",
							new String[]
							{ "Concentration", "Craft", "Diplomacy", "Heal" },
							"PHB"));
			break;

		case Race:
			data.put("Gnome",
					new Race(null, null, 20, 0, "Small", "Gnome",
							"Short stop.. aka mike"));
			data.put("Human",
					new Race(null, null, 30, 0, "Medium", "Human", "Boring"));
			data.put("Elf",
					new Race(null, null, 30, 0, "Medium", "Elf",
							"In the words of Linda \"Pointy Features\""));
			break;

		case Feat:
			break;

		case Spell:
			break;

		case Equipment:
			break;
		}
		return data;
	}

	@Override
	public void putData(ArrayList<AspectsInterface> data, AspectsEnum dataType)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void putData(AspectsInterface data, AspectsEnum dataType)
	{
		// TODO Auto-generated method stub

	}

}
