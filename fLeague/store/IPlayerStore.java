package fLeague.store;

import fLeague.Player;
import fLeague.PlayerID;

public interface IPlayerStore
{
    public void addPlayer(Player player);

    public void removePlayer(Player player);

    public Player getPlayer(PlayerID query);
}
