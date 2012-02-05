package com.teabreak.core.datasource;

import java.util.ArrayList;

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
	public ArrayList<AspectsInterface> getDataSetOfType(AspectsEnum dataType)
	{
		ArrayList<AspectsInterface> data = new ArrayList<AspectsInterface>();
		switch (dataType)
		{
		case Skill:
			data.add(new Skill(SkillEnum.Appraise, false, AbilityEnum.Int,
					"Appraise", "Appraise stuff", null));
			data.add(new Skill(SkillEnum.Balance, false, AbilityEnum.Dex,
					"Balance", "Balance stuff", null));
			data.add(new Skill(SkillEnum.Bluff, false, AbilityEnum.Cha,
					"Bluff", "Bluff stuff", null));
			break;

		case Class:
			data.add(new Class("Good", "Ave", "Shit", "Fighter"));
			data.add(new Class("Good", "Ave", "Shit", "Bard"));
			data.add(new Class("Good", "Ave", "Shit", "Cleric"));
			break;

		case Race:
			data.add(new Race(null, null, 20, 0, "Small", "Gnome"));
			data.add(new Race(null, null, 30, 0, "Medium", "Human"));
			data.add(new Race(null, null, 30, 0, "Medium", "Elf"));
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
