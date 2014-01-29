package thumbtack.inMemoryDatabase;

import java.util.HashMap;
import java.util.Map;

public class Transaction<T,U>
{
    Map<T,U> _map = new HashMap<T,U>();

    public void add(T name, U oldValue)
    {
        if(_map.containsKey(name))
        {
            return;
        }
        else
        {
            _map.put(name, oldValue);
        }

    }

    public Map<T,U> getMap()
    {
       return _map;
    }
}
