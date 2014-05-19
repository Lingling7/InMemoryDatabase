package fLeague.store;

import fLeague.Player;
import fLeague.PlayerID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerStore implements IPlayerStore
{
    Map<PlayerID, Player> _map = new HashMap<>();

    @Override
    public void addPlayer(Player player)
    {
        _map.put(player.getPlayerId(), player);
    }

    @Override
    public void removePlayer(Player player)
    {
        _map.remove(player.getPlayerId());
    }

    @Override
    public Player getPlayer(PlayerID playerId)
    {
        return _map.get(playerId);
    }

    public List<Player> getAllPlayers()
    {
        return new ArrayList<>(_map.values());
    }
}
