package com.teabreak.core.datasource;

import java.util.ArrayList;
import java.util.HashMap;

import com.teabreak.core.aspects.AspectsEnum;
import com.teabreak.core.aspects.AspectsInterface;
import com.teabreak.core.aspects.Class;
import com.teabreak.core.aspects.Race;
import com.teabreak.core.aspects.Skill;
import com.teabreak.core.aspects.enums.AbilityEnum;
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
	public HashMap<String, AspectsInterface> getDataSetOfType(
			AspectsEnum dataType)
	{
		HashMap<String, AspectsInterface> data = new HashMap<String, AspectsInterface>();
		switch (dataType)
		{
		case Skill:
			// data.put("Apraise", new Skill(SkillEnum.Appraise, false,
			// AbilityEnum.Int,
			// "Appraise", "Appraise stuff", null))
			// data.add(new Skill(SkillEnum.Appraise, false, AbilityEnum.Int,
			// "Appraise", "Appraise stuff", null));
			// data.add(new Skill(SkillEnum.Balance, false, AbilityEnum.Dex,
			// "Balance", "Balance stuff", null));
			// data.add(new Skill(SkillEnum.Bluff, false, AbilityEnum.Cha,
			// "Bluff", "Bluff stuff", null));
			break;

		case Class:
			data.put("Fighter", new Class("Good", "Ave", "Shit", "Fighter", "Fighter is a class, the only one we don't actually have :S"));
			data.put("Bard", new Class("Good", "Ave", "Shit", "Bard", "Mike makes an amazingly sexy bard that Tom cannot resist"));
			data.put("Cleric", new Class("Good", "Ave", "Shit", "Cleric", "Danny's a cleric.. yes he is.. he is"));
			break;

		case Race:
			data.put("Gnome", new Race(null, null, 20, 0, "Small", "Gnome",
					"Short stop.. aka mike"));
			data.put("Human", new Race(null, null, 30, 0, "Medium", "Human", "Boring"));
			data.put("Elf", new Race(null, null, 30, 0, "Medium", "Elf", "In the words of Linda \"Pointy Features\""));
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
