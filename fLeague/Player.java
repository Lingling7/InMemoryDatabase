package fLeague;

import fLeague.rules.Ball;
import fLeague.rules.WicketType;

public class Player implements IBatsman, IBowler
{

    private PlayerID _id;
    private int _runsScored;
    private int _ballsFaced;
    private int _foursScored;
    private int _ballsDelivered = 0;
    private int _runsConceeded;

    public Player(String team, String playerName)
    {
        _id = new PlayerID(team, playerName);
    }

    public void addPoints(int i)
    {

    }

    @Override
    public int getRunsScored()
    {
        return _runsScored;

    }

    @Override
    public int getBallsFaced()
    {
       return  _ballsFaced;
    }

    @Override
    public void ballFaced(Ball ball)
    {
        _ballsFaced = _ballsFaced + 1;
        _runsScored = _runsScored + ball.getRunsScored();
        checkForBoundaries(ball.getRunsScored());
    }

    private void checkForBoundaries(int runsScored)
    {
        if(runsScored == 4)
        {
            _foursScored = _foursScored + 1;
        }
    }

    @Override
    public void ballDelivered(Ball ball)
    {
        _ballsDelivered = _ballsDelivered +1;
        //TODO: add logic for detecting end of over and if it was a maiden
    }

    @Override
    public void dismissed(Player bowler, Player fielder, WicketType wicketType)
    {

    }

    @Override
    public boolean isOverFinished()
    {
        return false;
    }

    @Override
    public boolean hasDeliveredMaiden()
    {
       return false;
    }

    @Override
    public int getBallsDelivered()
    {
        return _ballsDelivered;
    }

    @Override
    public int getRunsConceeded()
    {
        return _runsConceeded;
    }

    @Override
    public boolean hasDeliveredLastBall()
    {
        return false;
    }

    public PlayerID getPlayerId()
    {
        return _id;
    }
}
