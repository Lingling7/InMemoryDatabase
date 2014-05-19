package fLeague.test;

import fLeague.Player;
import fLeague.handlers.IncomingBallInfoHandler;
import fLeague.handlers.Request;
import fLeague.rules.Ball;
import fLeague.store.PlayerStore;

public class Test
{
    public static void main(String[] args)
    {

        IncomingBallInfoHandler handler = new IncomingBallInfoHandler();
        final Player sachin = new Player("INDIA","Sachin");
        final Player shoaib = new Player("PAK","Shoaib");
        final Player afridi = new Player("PAK","afridi");

        //The same playstore has to be accessible to all the rules
        PlayerStore currentMatchPlayStore = new PlayerStore();
        currentMatchPlayStore.addPlayer(sachin);
        currentMatchPlayStore.addPlayer(shoaib);
        currentMatchPlayStore.addPlayer(afridi);

        Request firstBall = new Request()
        {
            @Override
            public Object getObject()
            {
                return new Ball().setBatsman(sachin.getPlayerId()).setBowler(shoaib.getPlayerId()).setFielder(afridi.getPlayerId());
            }
        };
        handler.handleRequest(firstBall);

    }

}
