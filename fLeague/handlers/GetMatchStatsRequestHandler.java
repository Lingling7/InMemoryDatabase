package fLeague.handlers;

import fLeague.MatchStatsGenerator;
import fLeague.Player;

import java.util.List;

public class GetMatchStatsRequestHandler implements IRequestHandler
{
    @Override
    public Response handleRequest(Request data)
    {
        //TODO : read Match points and respond

        List<Player> list = new MatchStatsGenerator().getOrderedList();

        return null;
    }
}
