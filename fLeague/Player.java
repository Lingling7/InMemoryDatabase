package fLeague;

import fLeague.ballProcessors.Ball;
import fLeague.ballProcessors.WicketType;

public class Player
{

    private int _runs;
    private int _ballsFaced;

    public void addPoints(int i)
    {

    }

    public int getRuns()
    {
        return _runs;

    }

    public int getBallsFaced()
    {


    }

    public void ballFaced(int runsScored)
    {
        _ballsFaced = _ballsFaced + 1;
        _runs = _runs + runsScored;
        checkForBoundaries();
    }

    public void ballDelivered()
    {

    }

    public void dismissed(Player bowler, Player fielder, WicketType wicketType)
    {

    }
}
