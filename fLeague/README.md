Design fantasy league cricket. The design has to be extensible and should be pluggable within a server. Some rules are given and according to that points are assigned after every ball.

You server receives ball-by-ball updates. For each ball you get complete info on who bowled it, who was the batsmen, how many runs were scored, who fielded it and the wicket typw.

The players earn points based on the following rule:
There is a base score
1. Batsman - number of runs scored.
2. Bowler - 10 points for a wicket.
3 Fielder - 5 points for a catch.


Impact score- 
1. Batsman- Given when the player gets out. 2*number of runs scored by that batman
2. Bowler - 10 points in case of maiden over.

Milestone bonus -
1, Batsman - 50 points on reaching 50.
2. Bowler - 50 points on 5 wickets.
3. Fielder - 100 points on 5 dismissals (catches/runouts).

At the end of the match you need to show the top 10 players in order of decreasing number of points.

These rules can be changed at any point of time. Hence, your design should be able to accommodate addition/deletion/modification of these rules.
