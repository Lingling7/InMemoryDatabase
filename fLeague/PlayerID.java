package fLeague;

public class PlayerID
{
    private String _teamName;
    private String _name;

    public PlayerID(String teamName, String name)
    {
        _teamName = teamName;
        _name = name;
    }

    public String getTeam()
    {
        return _teamName;
    }

    public String getName()
    {
        return _name;
    }
}