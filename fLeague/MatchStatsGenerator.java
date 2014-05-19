package fLeague;

import fLeague.store.PlayerStore;

import java.util.List;

public class MatchStatsGenerator
{
    private PlayerStore _playerStore;

    public List<Player> getOrderedList()
    {
        List<Player> players = _playerStore.getAllPlayers();
        return null;
    }
}
