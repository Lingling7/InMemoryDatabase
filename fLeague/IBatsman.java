package fLeague;

import fLeague.rules.Ball;
import fLeague.rules.WicketType;

public interface IBatsman
{
    int getRunsScored();

    int getBallsFaced();

    void ballFaced(Ball ball);

    void dismissed(Player bowler, Player fielder, WicketType wicketType);
}
