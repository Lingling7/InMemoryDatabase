package thumbtack.inMemoryDatabase;

import java.util.HashMap;
import java.util.Map;

public class SimpleStore<T, U> implements IStore<T, U>
{

    private Map<T, U> _map = new HashMap<T, U>();
    private Map<U, Integer> _countMap = new HashMap<U, Integer>();

    @Override
    public void set(T name, U value)
    {
        unset(name);
        _map.put(name, value);
        if (_countMap.containsKey(value))
        {
            int currentCount = _countMap.get(value);
//            System.out.println("adding " + value + ": " + (currentCount + 1));
            _countMap.put(value, (currentCount + 1));
        }
        else
        {
//            System.out.println("adding " + value + "to : " + 1);
            _countMap.put(value, 1);
        }
    }

    @Override
    public U get(T name)
    {
        return _map.get(name);
    }

    @Override
    public void unset(T name)
    {
        U value = _map.remove(name);
        if (value != null)
        {
            int currentCount = _countMap.get(value);
            _countMap.put(value, currentCount - 1);
        }
    }

    @Override
    public int numEqualTo(U value)
    {
        Integer integer = _countMap.get(value);
        if (integer != null)
        {
            return integer;
        }
        else
        {
            return 0;
        }
    }
}
