package com.teabreak.core.datasource;

import java.util.ArrayList;
import java.util.HashMap;

import com.teabreak.core.aspects.AspectsEnum;
import com.teabreak.core.aspects.AspectsInterface;

public interface DataSourceInterface
{

	/**
	 * 
	 * @return
	 */
	public abstract AspectsInterface getDateOfType(AspectsEnum dataType);
	
	//public abstract ArrayList<AspectsInterface> getDataSetOfType(AspectsEnum dataType);
	public abstract HashMap<String, AspectsInterface> getDataSetOfType(AspectsEnum dataType);
	
	public abstract void putData(ArrayList<AspectsInterface> data, AspectsEnum dataType);

	public abstract void putData(AspectsInterface data, AspectsEnum dataType);

	
	
}
