package fLeague;

public interface IPlayerStore
{
    public void addPlayer(Player player);

    public void removePlayer(Player player);

    public Player getPlayer(SearchQuery query);
}
