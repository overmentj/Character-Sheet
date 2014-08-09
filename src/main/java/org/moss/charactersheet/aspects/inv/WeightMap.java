package org.moss.charactersheet.aspects.inv;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WeightMap {

	private static final HashMap<Integer, HashSet<Integer>> STR_LOAD_MAP = new HashMap<Integer, HashSet<Integer>>();
	
	static
	{
		STR_LOAD_MAP.put(1, new HashSet<Integer>());
		STR_LOAD_MAP.get(1).add(3);
		
		
	}
	
}
