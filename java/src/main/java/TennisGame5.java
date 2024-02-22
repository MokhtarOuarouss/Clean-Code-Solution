import java.util.HashMap;
import java.util.Map;

public class TennisGame5 implements TennisGame {

    private final String player1Name;
    private final String player2Name;
    private int player1Score;
    private int player2Score;
    private final String[] SCORE_ARRAY = {"Love","Fifteen","Thirty","Forty","Deuce"};


    public TennisGame5(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    @Override
    public void wonPoint(String playerName) {
        if (this.player1Name.equals(playerName))
            player1Score++;
        else if (this.player2Name.equals(playerName))
            player2Score++;
        else
            throw new IllegalArgumentException("Invalid player name.");
    }

    @Override
    public String getScore() {
        
        while (player1Score > 4 || player2Score > 4) {
            player1Score--;
            player2Score--;
        }

        var lookup = new HashMap<Map.Entry, String>();
        lookup.put(Map.entry(0, 0), SCORE_ARRAY[0]+ "-All");
        lookup.put(Map.entry(0, 1), SCORE_ARRAY[0]+ "-"+SCORE_ARRAY[1]);
        lookup.put(Map.entry(0, 2), SCORE_ARRAY[0]+ "-"+SCORE_ARRAY[2]);
        lookup.put(Map.entry(0, 3), SCORE_ARRAY[0]+ "-"+SCORE_ARRAY[3]);
        lookup.put(Map.entry(0, 4), "Win for "+this.player2Name);
        lookup.put(Map.entry(1, 0), SCORE_ARRAY[1] + "-"+SCORE_ARRAY[0]);
        lookup.put(Map.entry(1, 1), SCORE_ARRAY[1] + "-All");
        lookup.put(Map.entry(1, 2), SCORE_ARRAY[1] + "-"+SCORE_ARRAY[2]);
        lookup.put(Map.entry(1, 3), SCORE_ARRAY[1] + "-"+SCORE_ARRAY[3]);
        lookup.put(Map.entry(1, 4), "Win for "+this.player2Name);
        lookup.put(Map.entry(2, 0), SCORE_ARRAY[2] + "-"+SCORE_ARRAY[0]);
        lookup.put(Map.entry(2, 1), SCORE_ARRAY[2] + "-"+SCORE_ARRAY[1]);
        lookup.put(Map.entry(2, 2), SCORE_ARRAY[2] + "-All");
        lookup.put(Map.entry(2, 3), SCORE_ARRAY[2] + "-"+SCORE_ARRAY[3]);
        lookup.put(Map.entry(2, 4), "Win for "+this.player2Name);
        lookup.put(Map.entry(3, 0), SCORE_ARRAY[3] + "-"+SCORE_ARRAY[0]);
        lookup.put(Map.entry(3, 1), SCORE_ARRAY[3] + "-"+SCORE_ARRAY[1]);
        lookup.put(Map.entry(3, 2), SCORE_ARRAY[3] + "-"+SCORE_ARRAY[2]);
        lookup.put(Map.entry(3, 3), SCORE_ARRAY[4]);
        lookup.put(Map.entry(3, 4), "Advantage "+this.player2Name);
        lookup.put(Map.entry(4, 0), "Win for "+this.player1Name);
        lookup.put(Map.entry(4, 1), "Win for "+this.player1Name);
        lookup.put(Map.entry(4, 2), "Win for "+this.player1Name);
        lookup.put(Map.entry(4, 3), "Advantage "+this.player1Name);
        lookup.put(Map.entry(4, 4), SCORE_ARRAY[4]);

        var entry = Map.entry(player1Score, player2Score);
        if (lookup.containsKey(entry)) {
            return lookup.get(entry);
        } else {
            throw new IllegalArgumentException("Invalid score.");
        }
    }
}
