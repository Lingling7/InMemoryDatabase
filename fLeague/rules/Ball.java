package fLeague.rules;

import fLeague.PlayerID;

public class Ball
{
    int _runsScored;
    private PlayerID _batsman;
    private PlayerID _bowler;
    private PlayerID _fielder;
    private WicketType _wicketType;

    public int getRunsScored()
    {
        return _runsScored;
    }

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

    public Ball setBatsman(PlayerID playerID)
    {
        _batsman = playerID;
        return this;
    }

    public Ball setBowler(PlayerID playerID)
    {
        _bowler = playerID;
        return this;
    }

    public Ball setFielder(PlayerID playerID)
    {
        _fielder = playerID;
        return this;
    }
    public Ball setWicketType(WicketType type)
    {
        _wicketType = type;
        return this;
    }



}
