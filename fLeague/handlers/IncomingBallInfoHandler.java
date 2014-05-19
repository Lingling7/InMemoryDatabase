package fLeague.handlers;

import fLeague.rules.Ball;
import fLeague.rules.IBallRule;
import fLeague.rules.RuleFactory;

import java.util.ArrayList;
import java.util.List;

public class IncomingBallInfoHandler implements IRequestHandler
{
    List<IBallRule> _rules = new ArrayList<>();
    //Using a string for simplicity. should ideally be a request object

    public IncomingBallInfoHandler()
    {
        _rules.add(RuleFactory.getBattingRule());
        _rules.add(RuleFactory.getBowlingRule());
        _rules.add(RuleFactory.getFieldingRule());
        _rules.add(RuleFactory.getMatchRule());
    }

    @Override
    public Response handleRequest(Request request)
    {
        Ball ball = convertToBall(request);
        for(IBallRule rule: _rules)
        {
            rule.processBall(ball);
        }
        return null;
    }

    private Ball convertToBall(Request request)
    {
        return (Ball)request;
    }
}
