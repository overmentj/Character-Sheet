package org.moss.charactersheet.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.moss.charactersheet.interfaces.UpdateListener;


public class ListenerFactory
{
    private static final Logger LOGGER = Logger.getLogger(ListenerFactory.class);

    private static Map<Object, Set<UpdateListener>> listeners = new HashMap<>();
    private static Map<Object, Object> lastValues = new HashMap<>();


    public static void registerListener(Object key, UpdateListener value)
    {
        if (!listeners.containsKey(key))
        {
            LOGGER.warn("No caller has registered yet: " + key);
            listeners.put(key, new HashSet<UpdateListener>());
        }

        if (lastValues.containsKey(key))
        {
            value.update(key, lastValues.get(key));
        }

        listeners.get(key).add(value);
    }

    public static void registerCaller(Object key)
    {
        LOGGER.trace("Registering caller: " + key);

        if (!listeners.containsKey(key))
        {
            listeners.put(key, new HashSet<UpdateListener>());
        }
    }

    public static void callback(Object key, Object value)
    {
        if (listeners.containsKey(key))
        {
            lastValues.put(key, value);
            for (UpdateListener listener : listeners.get(key))
            {
                listener.update(key, value);
            }
        }
    }
}
