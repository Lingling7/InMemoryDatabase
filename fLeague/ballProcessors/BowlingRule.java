package fLeague.ballProcessors;

import fLeague.IPlayerStore;
import fLeague.Player;
import fLeague.SearchQuery;

public class BowlingRule implements IBallProcessor
{
    private final IPlayerStore _playerStore;

    public BowlingRule(IPlayerStore store)
    {
        _playerStore = store;
    }

    @Override
    public void processBall(Ball ball)
    {
        SearchQuery bowler = getQuery(ball);
        Player player = _playerStore.getPlayer(bowler);
        player.ballDelivered();
        applyBaseScore(player, ball);
        applyImpactScore(player, ball);
        applyMilestoneBonus(player, ball);
        applyPaceBonus(player, ball);
    }

    private SearchQuery getQuery(Ball ball)
    {
        Ball.PlayerID bowler = ball.getBowler();
        return new SearchQuery(bowler.getTeam(), bowler.getName());
    }

    private void applyPaceBonus(Player player, Ball ball)
    {
       if(ball.isAWicket())
       {
           player.addPoints();
       }
    }

    private void applyMilestoneBonus(Player player, Ball ball)
    {

    }

    private void applyImpactScore(Player player, Ball ball)
    {

    }

    private void applyBaseScore(Player player, Ball ball)
    {
        if(ball.isAWicket())
        {
            if(canBeAttributedToBowler(player, ball))
            {
                player.addPoints();
            }
        }
    }

    private boolean canBeAttributedToBowler(Player player, Ball ball)
    {
        return true;
    }

}
