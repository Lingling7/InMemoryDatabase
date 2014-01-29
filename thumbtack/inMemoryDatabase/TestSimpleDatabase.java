package thumbtack.inMemoryDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestSimpleDatabase
{
    public static void main(String args[]) throws IOException
    {
        IStore<String, Integer> _store = new SimpleStore<>();
        IDatabase<String, Integer> _database = new SimpleDatabase<>(_store);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Command<String, Integer> command = readAndParseCommand(reader);

        while (!command.is(Command.Operation.END))
        {
            processCommand(_database, command);
            command = readAndParseCommand(reader);
        }
    }

    private static void processCommand(IDatabase<String, Integer> _database, Command<String, Integer> command)
    {
        if (command.is(Command.Operation.SET))
        {
            _database.set(command.getKey(), command.getValue());
        }
        else if (command.is(Command.Operation.GET))
        {
            Integer value = _database.get(command.getKey());
            if (value != null)
            {
                System.out.println(value);
            }
            else
            {
                System.out.println("NULL");
            }
        }
        else if (command.is(Command.Operation.NUMEQUALTO))
        {
            Integer count = _database.numEqualTo(command.getValue());
            System.out.println(count);
        }
        else if (command.is(Command.Operation.UNSET))
        {
            _database.unset(command.getKey());
        }
        else if (command.is(Command.Operation.BEGIN))
        {
            _database.beginTransaction();
        }
        else if (command.is(Command.Operation.ROLLBACK))
        {
            try
            {
                _database.rollbackTransaction();
            }
            catch (NoTransactionException e)
            {
                System.out.println("NO TRANSACTION");
            }
        }
        else if (command.is(Command.Operation.COMMIT))
        {
            try
            {
                _database.commitAllTransactions();
            }
            catch (NoTransactionException e)
            {
                System.out.println("NO TRANSACTION");
            }
        }
        else
        {
            System.out.println("Unknown command");
        }
    }

    private static Command<String, Integer> readAndParseCommand(BufferedReader reader) throws IOException
    {
        String input = reader.readLine();
        return getCommandFromInput(input);
    }

    private static Command<String, Integer> getCommandFromInput(String input)
    {
        String[] splitArray = input.split(" ");
        Command.Operation operation = Command.Operation.valueOf(splitArray[0]);
        String key = null;
        Integer value = null;
        switch (operation)
        {
            case UNSET:
            case GET:
                key = splitArray[1];
                break;
            case SET:
                key = splitArray[1];
                value = Integer.parseInt(splitArray[2]);
                break;
            case NUMEQUALTO:
                value = Integer.parseInt(splitArray[1]);
                break;
            default:
                break;
        }
        Command<String, Integer> command = new Command<String, Integer>(operation);
        command.setKey(key);
        command.setValue(value);
        return command;
    }
}

