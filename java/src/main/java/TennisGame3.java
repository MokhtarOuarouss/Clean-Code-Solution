import java.lang.Math;
public class TennisGame3 implements TennisGame {
    
    
    private int player1Point;
    private int player2Point;
    private String player1Name;
    private String player2Name;
    private final String[] SCORE_ARRAY = {"Love","Fifteen","Thirty","Forty","Deuce"};


    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String scoreArray;
        String winnerPlayerName;
        if (player1Point < 4 && player2Point < 4 && !(player1Point + player2Point == 6)) {

            scoreArray = SCORE_ARRAY[player1Point];

            if (player1Point == player2Point) return scoreArray + "-All" ;
            else return scoreArray + "-" + SCORE_ARRAY[player2Point] ;

        } else {
            if (player1Point == player2Point)
                return "Deuce";

            if (player1Point > player2Point) winnerPlayerName = player1Name;
            else winnerPlayerName =  player2Name;
            
            if (Math.abs(player1Point-player2Point) == 1 )  return "Advantage " + winnerPlayerName;
            else return "Win for " + winnerPlayerName;
            
        }
    }
    
    public void wonPoint(String playerName) {
        if (this.player1Name.equals(playerName))
            this.player1Point += 1;
        else
            this.player2Point += 1;
        
    }

}
