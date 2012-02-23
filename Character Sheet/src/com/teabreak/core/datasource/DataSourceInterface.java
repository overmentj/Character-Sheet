package com.teabreak.core.datasource;

import java.util.ArrayList;
import java.util.SortedMap;

import com.teabreak.core.aspects.AspectsEnum;
import com.teabreak.core.aspects.AspectsInterface;
import com.teabreak.core.aspects.Skill;

public interface DataSourceInterface
{

	/**
	 * 
	 * @return
	 */
	public abstract AspectsInterface getDateOfType(AspectsEnum dataType);

	// public abstract ArrayList<AspectsInterface> getDataSetOfType(AspectsEnum
	// dataType);
	public abstract SortedMap<String, AspectsInterface> getDataSetOfType(
			AspectsEnum dataType);

	public abstract void putData(String filename, AspectsInterface data);

	public abstract void putDataSet(String filename,
			SortedMap<String, ? extends AspectsInterface> dataSet);

}
