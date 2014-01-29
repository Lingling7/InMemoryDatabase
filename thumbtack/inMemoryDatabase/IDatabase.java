package thumbtack.inMemoryDatabase;

public interface IDatabase<T, U>
{
    public void set(T name, U value);

    public U get(T name);

    public void unset(T name);

    public int numEqualTo(U value);

    public void beginTransaction();

    public void rollbackTransaction() throws NoTransactionException;

    public void commitAllTransactions() throws NoTransactionException;
}
