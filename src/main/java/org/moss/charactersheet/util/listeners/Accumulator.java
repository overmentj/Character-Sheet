package org.moss.charactersheet.util.listeners;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.moss.charactersheet.interfaces.UpdateListener;
import org.moss.charactersheet.util.Adder;


/**
 * Accumulator listener is a type of listener that takes numerical values from multiple sources and adds then before
 * calling back to all listeners to notify them of the new value. <br />
 * <br />
 * Use the static methods to create accumulators:
 * <ul>
 * <li>{@link #createIntegerAccumulator(Object)}</li>
 * <li>{@link #createFloatAccumulator(Object)}</li>
 * </ul>
 * 
 * @author Robin
 * @param <T>
 */
public class Accumulator<T extends Number> implements ListenerHandler
{

    /** Set of all the listeners to call */
    Set<UpdateListener> listenersSet;

    /** Key for this Listener handler */
    private final Object key;

    private T internalValue = null;

    /** Adder to handle generic numbers */
    private final Adder<T> adder;


    /**
     * Creates a Integer accumulator
     * 
     * @param key
     * @return
     */
    public static Accumulator<Integer> createIntegerAccumulator(Object key)
    {
        Adder<Integer> intAdder = new Adder<Integer>()
        {

            @Override
            public Integer zero()
            {
                return 0;
            }

            @Override
            public Integer add(Integer lhs, Integer rhs)
            {
                return lhs + rhs;
            }
        };
        return new Accumulator<Integer>(key, intAdder);
    }

    /**
     * Creates a Float accumulator
     * 
     * @param key
     * @return
     */
    public static Accumulator<Float> createFloatAccumulator(Object key)
    {
        Adder<Float> intAdder = new Adder<Float>()
        {

            @Override
            public Float zero()
            {
                return 0F;
            }

            @Override
            public Float add(Float lhs, Float rhs)
            {
                return lhs + rhs;
            }
        };
        return new Accumulator<Float>(key, intAdder);
    }

    public Accumulator(Object key, Adder<T> adder)
    {
        listenersSet = Collections.newSetFromMap(new ConcurrentHashMap<UpdateListener, Boolean>());
        this.key = key;
        this.adder = adder;
        this.internalValue = adder.zero();
    }

    @SuppressWarnings("unchecked")
    @Override
    public void updateListeners(Object value)
    {

        if (value instanceof Number)
        {
            internalValue = adder.add(internalValue, (T) value);

            for (UpdateListener curListener : listenersSet)
            {
                curListener.update(key, value);
            }
        }
    }

    @Override
    public void addListener(UpdateListener listener)
    {
        this.listenersSet.add(listener);
    }

    @Override
    public void removeListener(UpdateListener listener)
    {
        this.listenersSet.remove(listener);
    }

    @Override
    public void addListeners(List<UpdateListener> listener)
    {
        this.listenersSet.addAll(listener);

    }

    @Override
    public void addListeners(UpdateListener... listener)
    {
        for (UpdateListener curListener : listener)
        {
            this.listenersSet.add(curListener);
        }
    }

    @Override
    public void removeListeners(List<UpdateListener> listener)
    {
        this.listenersSet.removeAll(listener);

    }

    @Override
    public void removeListeners(UpdateListener... listener)
    {
        for (UpdateListener curListener : listener)
        {
            this.listenersSet.remove(curListener);
        }
    }

}
