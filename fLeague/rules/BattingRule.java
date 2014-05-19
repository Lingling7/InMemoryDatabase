package fLeague.rules;

import fLeague.Player;
import fLeague.store.IPlayerStore;

public class BattingRule implements IBallRule
{
    private static final int SIXER = 6;
    private static final int PENALTY_FOR_DUCK = -5;
    private static final int POINTS_FOR_SIXER = 2;
    private static final int MILESTONE_BONUS = 10;
    private static final int BONUS_CRITERIA = 25;
    IPlayerStore _playerStore;

    public BattingRule(IPlayerStore store)
    {
        _playerStore = store;
    }

    @Override
    public void processBall(Ball ball)
    {
        Player player = _playerStore.getPlayer(ball.getBatsman());
        player.ballFaced(ball);
        checkIfBatsmanDismissed(ball, player);
        applyBaseScore(player, ball);
        applyImpactScore(player, ball);
        applyMilestoneBonus(player, ball);
        applyPaceBonus(player, ball);
    }

    private void checkIfBatsmanDismissed(Ball ball, Player player)
    {
        if (ball.isAWicket())
        {
            Player bowlingPlayer = _playerStore.getPlayer(ball.getBowler());
            Player fielder = _playerStore.getPlayer(ball.getFielder());
            player.dismissed(bowlingPlayer, fielder, ball.getWicketType());
        }
    }

    private void applyPaceBonus(Player player, Ball ball)
    {
        if (ball.isAWicket())
        {
            player.addPoints(player.getRunsScored() - player.getBallsFaced());
        }
    }

    private void applyMilestoneBonus(Player player, Ball ball)
    {
        if (isEligibleForMilestoneBonus(player, ball))
        {
            player.addPoints(MILESTONE_BONUS);
        }
    }

    private boolean isEligibleForMilestoneBonus(Player player, Ball ball)
    {
        int existingRuns = player.getRunsScored();
        int newRuns = player.getRunsScored() + ball._runsScored;
        return newRuns / BONUS_CRITERIA - existingRuns / BONUS_CRITERIA == 1;
    }

    private void applyImpactScore(Player player, Ball ball)
    {
        if (ball._runsScored == SIXER)
        {
            player.addPoints(POINTS_FOR_SIXER);
        }

        if (ball.isAWicket())
        {
            if (player.getRunsScored() == 0)
            {
                player.addPoints(PENALTY_FOR_DUCK);
            }
        }
    }

    private void applyBaseScore(Player player, Ball ball)
    {
        player.addPoints(ball._runsScored);
    }
}
