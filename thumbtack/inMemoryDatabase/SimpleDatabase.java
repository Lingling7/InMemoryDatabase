package thumbtack.inMemoryDatabase;

import java.util.Map;

public class SimpleDatabase<T, U> implements IDatabase<T, U>
{
    private IStore<T, U> _store;
    private TransactionManager<T, U> _manager = new TransactionManager<>();

    public SimpleDatabase(IStore<T, U> store)
    {
        _store = store;
    }

    @Override
    public void set(T name, U value)
    {
        _manager.addEntry(name, _store.get(name));
        _store.set(name, value);
    }

    @Override
    public U get(T name)
    {
        return _store.get(name);
    }

    @Override
    public void unset(T name)
    {
        _manager.addEntry(name, _store.get(name));
        _store.unset(name);

    }

    @Override
    public int numEqualTo(U value)
    {
        return _store.numEqualTo(value);
    }

    @Override
    public void beginTransaction()
    {
        _manager.beginNewTransaction();
    }

    @Override
    public void rollbackTransaction() throws NoTransactionException
    {
        Map<T, U> map = _manager.rollbackCurrentTransaction();
        revertTransaction(map);
    }


    @Override
    public void commitAllTransactions() throws NoTransactionException
    {
        _manager.commitAllTransactions();
    }

    private void revertTransaction(Map<T, U> map)
    {
        for (Map.Entry<T, U> entry : map.entrySet())
        {
            T name = entry.getKey();
            U value = entry.getValue();
            if (value != null)
            {
                _store.set(name, value);
            }
            else
            {
                _store.unset(name);
            }
        }
    }

}
