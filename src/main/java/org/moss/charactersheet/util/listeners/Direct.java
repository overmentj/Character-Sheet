package org.moss.charactersheet.util.listeners;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.moss.charactersheet.interfaces.UpdateListener;

public class Direct implements ListenerHandler {

	/** Set of all the listeners to call */
	private final Set<UpdateListener> listenersSet;

	/** Key for this Listener handler */
	private final Object key;

	public Direct(Object key) {
		listenersSet = Collections
				.newSetFromMap(new ConcurrentHashMap<UpdateListener, Boolean>());
		this.key = key;
	}

	@Override
	public void updateListeners(Object value) {
		for (UpdateListener curListener : listenersSet) {
			curListener.update(key, value);
		}

	}

	@Override
	public void addListener(UpdateListener listener) {
		this.listenersSet.add(listener);

	}

	@Override
	public void removeListener(UpdateListener listener) {
		this.listenersSet.remove(listener);
	}

	@Override
	public void addListeners(List<UpdateListener> listener) {
		this.listenersSet.addAll(listener);

	}

	@Override
	public void addListeners(UpdateListener... listener) {
		for (UpdateListener curListener : listener) {
			this.listenersSet.add(curListener);
		}
	}

	@Override
	public void removeListeners(List<UpdateListener> listener) {
		this.listenersSet.removeAll(listener);

	}

	@Override
	public void removeListeners(UpdateListener... listener) {
		for (UpdateListener curListener : listener) {
			this.listenersSet.remove(curListener);
		}
	}

}
