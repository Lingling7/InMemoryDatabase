package fLeague;

import fLeague.rules.Ball;

public interface IBowler
{
    void ballDelivered(Ball ball);

    boolean isOverFinished();

    boolean hasDeliveredMaiden();

    int getBallsDelivered();

    int getRunsConceeded();

    boolean hasDeliveredLastBall();
}
