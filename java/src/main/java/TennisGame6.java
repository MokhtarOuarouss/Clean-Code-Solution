public class TennisGame6 implements TennisGame {
    private final String player1Name;
    private final String player2Name;
    private int player1Score;
    private int player2Score;
    private final String[] SCORE_ARRAY = {"Love","Fifteen","Thirty","Forty","Deuce"};


    public TennisGame6(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    @Override
    public void wonPoint(String playerName) {
        if (this.player1Name.equals(playerName)){
            player1Score++;
        }  
        else {
            player2Score++;
        }
            

    }

    public String getScore()
    {

        if (player1Score == player2Score)
        {
            return getTieScore();
        }
        else if (player1Score >= 4 || player2Score >= 4)
        {
            return getEndGameScore();
        }
        else
        {
            return getRegularScore();  
        }

    }

    private String getTieScore() {
        String tieScore;
            switch (player1Score)
            {
                case 0:
                    tieScore = SCORE_ARRAY[0] + "-All";
                    break;
                case 1:
                    tieScore = SCORE_ARRAY[1] + "-All";
                    break;
                case 2:
                    tieScore = SCORE_ARRAY[2] +"-All";
                    break;
                default:
                    tieScore = SCORE_ARRAY[4] ;
                    break;
            }

            return tieScore;
    }

    private String getEndGameScore(){
        String endGameScore;

            if (player1Score - player2Score == 1) {
                endGameScore = "Advantage " + player1Name;
            } else if (player1Score - player2Score == -1) {
                endGameScore = "Advantage " + player2Name;
            } else if (player1Score - player2Score >= 2) {
                endGameScore = "Win for " + player1Name;
            } else {
                endGameScore = "Win for " + player2Name;
            }

            return endGameScore;
    }

    private String getRegularScore(){
        String regularScore;

            String score1 =  switch (player1Score)
            {
                case 0 -> SCORE_ARRAY[0];
                case 1 -> SCORE_ARRAY[1];
                case 2 -> SCORE_ARRAY[2];
                default -> SCORE_ARRAY[3];
            };

            var score2 =  switch (player2Score)
            {
                case 0 -> SCORE_ARRAY[0];
                case 1 -> SCORE_ARRAY[1];
                case 2 -> SCORE_ARRAY[2];
                default -> SCORE_ARRAY[3];
            };

            regularScore = score1 + "-" + score2;

            return regularScore;
    }
}
