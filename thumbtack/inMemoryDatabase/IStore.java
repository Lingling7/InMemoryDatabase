package thumbtack.inMemoryDatabase;

public interface IStore<T, U>
{
    public void set(T name, U value);

    public U get(T name);

    public void unset(T name);

    public int numEqualTo(U value);
}
