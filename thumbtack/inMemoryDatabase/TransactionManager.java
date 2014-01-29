package thumbtack.inMemoryDatabase;

import java.util.Map;
import java.util.Stack;

public class TransactionManager<T, U>
{
    private Stack<Transaction<T, U>> _transactions = new Stack<>();

    public void addEntry(T name, U value)
    {
        if (!_transactions.empty())
        {
            Transaction<T, U> transaction = _transactions.peek();
            transaction.add(name, value);
        }
    }

    public void beginNewTransaction()
    {
        Transaction<T, U> transaction = new Transaction<T, U>();
        _transactions.push(transaction);
    }

    public Map<T, U> rollbackCurrentTransaction() throws NoTransactionException
    {
        validateTransactionStackNotEmpty();
        return _transactions.pop().getMap();
    }


    public void commitAllTransactions() throws NoTransactionException
    {
        validateTransactionStackNotEmpty();
        _transactions.clear();
    }

    private void validateTransactionStackNotEmpty() throws NoTransactionException
    {
        if (_transactions.empty())
        {
            throw new NoTransactionException();
        }
    }
}
