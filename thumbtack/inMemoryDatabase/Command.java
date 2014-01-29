package thumbtack.inMemoryDatabase;

public class Command<T, U>
{
    private Operation _operation;
    private T _key;
    private U _value;

    public Command(Operation operation)
    {
        _operation = operation;
    }

    public void setKey(T key)
    {
        _key = key;
    }

    public void setValue(U value)
    {
        _value = value;
    }

    public boolean is(Operation operation)
    {
        return _operation.equals(operation);
    }

    public T getKey()
    {
        return _key;
    }

    public U getValue()
    {
        return _value;
    }

    public enum Operation
    {
        BEGIN, END, GET, SET, UNSET, COMMIT, ROLLBACK, NUMEQUALTO
    }
}
