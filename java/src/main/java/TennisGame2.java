
public class TennisGame2 implements TennisGame
{
    public int player1Point = 0;
    public int player2Point = 0;
    
    public String player1Res = "";
    public String player2Res = "";
    private String player1Name;
    private String player2Name;

    private final String[] SCORE_ARRAY = {"Love","Fifteen","Thirty","Forty","Deuce"};


    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";

        if ( player2Point==0 || player1Point==0 )
        {
            
            if(player1Point > 0 ){
                player1Res = SCORE_ARRAY[player1Point];
                player2Res = SCORE_ARRAY[0];
            }
            if(player2Point > 0){
                player1Res = SCORE_ARRAY[0];
                player2Res = SCORE_ARRAY[player2Point];
            }
            
            score = player1Res + "-" + player2Res;
        }



        if ((player1Point < 4 || player2Point < 4) && (player1Point >=2 || player2Point >=2)){
           
            player1Res = SCORE_ARRAY[player1Point];
            player2Res = SCORE_ARRAY[player2Point];
            score = player1Res + "-" + player2Res;
        }


        if (player1Point == player2Point )
        {
            if (player1Point < 3) {
                score =  SCORE_ARRAY[player1Point] +"-All";
            }
            else if (player1Point>=3) {
                score = SCORE_ARRAY[4];
            }
            
            
        }

        
        if (player1Point > player2Point && player2Point >= 3)
        {
            score = "Advantage " + this.player1Name;
        }
        
        if (player2Point > player1Point && player1Point >= 3)
        {
            score = "Advantage "+this.player2Name;
        }
        
        if (player1Point>=4 && player2Point>=0 && (player1Point-player2Point)>=2)
        {
            score = "Win for " + this.player1Name;
        }
        if (player2Point>=4 && player1Point>=0 && (player2Point-player1Point)>=2)
        {
            score = "Win for "+this.player2Name;
        }
        return score;
    }
    
    

    public void wonPoint(String player) {
        if (player1Name.equals(player))
            player1Point++;
        else
            player2Point++;
    }
}