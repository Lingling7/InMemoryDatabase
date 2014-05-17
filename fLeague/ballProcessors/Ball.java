package fLeague.ballProcessors;

public class Ball
{
    int _runsScored;
    private PlayerID _batsman;
    private PlayerID _bowler;
    private PlayerID _fielder;
    private WicketType _wicketType;

    public boolean isAWicket()
    {
        return false;
    }

    public PlayerID getBatsman()
    {
        return _batsman;

    }

    public PlayerID getBowler()
    {
        return _bowler;
    }

    public PlayerID getFielder()
    {
        return _fielder;
    }

    public WicketType getWicketType()
    {
        return _wicketType;
    }

    public class PlayerID
    {
        public String getTeam()
        {

        }

        public String getName()
        {
            return null;
        }
    }
}
