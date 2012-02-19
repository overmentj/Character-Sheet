package com.teabreak.core.datasource;

import com.teabreak.core.aspects.AspectsInterface;

/**
 * Interface for access to data
 * 
 * @author Robin
 * 
 */
public interface GetData
{
	public <T> AspectsInterface getDataOfType(String file, Class<T> classOfT);
}
