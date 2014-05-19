package fLeague.rules;

import fLeague.store.IPlayerStore;
import fLeague.Player;

public class BowlingRule implements IBallRule
{
    private static final int WICKET_BONUS = 20;
    private static final int MAIDEN_BONUS = 20;
    private static final int SECOND_WICKET_MS_BONUS = 10;
    private static final int THIRD_WICKET_OR_GREATER_MS_BONUS = 10;

    private final IPlayerStore _playerStore;

    public BowlingRule(IPlayerStore store)
    {
        _playerStore = store;
    }

    @Override
    public void processBall(Ball ball)
    {
        Player player = _playerStore.getPlayer(ball.getBowler());
        player.ballDelivered(ball);
        applyBaseScore(player, ball);
        applyImpactScore(player, ball);
        applyMilestoneBonus(player, ball);
        applyPaceBonus(player, ball);
    }

    private void applyPaceBonus(Player player, Ball ball)
    {
        if (player.hasDeliveredLastBall())
        {
            double bonus = 1.5 * player.getBallsDelivered() - player.getRunsConceeded();
            if (bonus > 0)
            {
                player.addPoints((int) (2 * bonus));
            }
        }
    }

    private void applyMilestoneBonus(Player player, Ball ball)
    {
        if (ball.isAWicket())
        {
            if (isSecondWicket(player))
            {
                player.addPoints(SECOND_WICKET_MS_BONUS);
            }
            else if (isThirdWicketOrGreater(player))
            {
                player.addPoints(THIRD_WICKET_OR_GREATER_MS_BONUS);
            }
        }

    }

    private boolean isThirdWicketOrGreater(Player player)
    {
        return false;
    }

    private boolean isSecondWicket(Player player)
    {
        return false;
    }

    private void applyImpactScore(Player player, Ball ball)
    {
        if (ball._runsScored == 0)
        {
            player.addPoints(1);
        }
        if (player.isOverFinished())
        {
            if (player.hasDeliveredMaiden())
            {
                player.addPoints(MAIDEN_BONUS);
            }
        }

    }

    private void applyBaseScore(Player player, Ball ball)
    {
        if (ball.isAWicket())
        {
            if (canBeAttributedToBowler(player, ball))
            {
                player.addPoints(WICKET_BONUS);
            }
        }
    }

    private boolean canBeAttributedToBowler(Player player, Ball ball)
    {
        return true;
    }

}
