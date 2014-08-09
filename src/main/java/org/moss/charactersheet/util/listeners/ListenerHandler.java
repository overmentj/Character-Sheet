package org.moss.charactersheet.util.listeners;

import java.util.List;

import org.moss.charactersheet.interfaces.UpdateListener;

public interface ListenerHandler {

	
	public void updateListeners(Object value);
	
	public void addListener(UpdateListener listener);
	
	public void addListeners(List<UpdateListener> listener);
	
	public void addListeners(UpdateListener... listener);
	
	public void removeListener(UpdateListener listener);
	
	public void removeListeners(List<UpdateListener> listener);
	
	public void removeListeners(UpdateListener... listener);
}
