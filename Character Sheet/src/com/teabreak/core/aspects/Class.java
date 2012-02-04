package com.teabreak.core.aspects;

import java.util.ArrayList;

import com.teabreak.core.aspects.enums.SkillEnum;

/**
 * 
 * @author Robin
 *
 */
public class Class implements AspectsInterface {

	private final AspectsEnum TYPE = AspectsEnum.Class;
	
	private String willSaveLevel;
	private String reflexSaveLevel;
	private String fortitudeSaveLevel;
	
	private ArrayList<SkillEnum> classSkills;
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AspectsEnum getType() {
		return TYPE;
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
