
public class TennisGame1 implements TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;
    private final String[] SCORE_ARRAY = {"Love","Fifteen","Thirty","Forty","Deuce"};

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if ( this.player1Name.equals(playerName))
            player1Score++;
        else
            player2Score++;
    }

    public String getScore() {
        String score = "";
        int tempScore = 0;
        if (player1Score == player2Score)
        {
            tempScore = player1Score;
            switch (tempScore)
            {
                case 0:
                        score = SCORE_ARRAY[tempScore] + "-All";
                    break;
                case 1:
                        score =SCORE_ARRAY[tempScore] + "-All";
                    break;
                case 2:
                        score =SCORE_ARRAY[tempScore] + "-All";
                    break;
                default:
                        score = SCORE_ARRAY[4];
                    break;
                
            }
        }
        else if (player1Score >= 4 || player2Score >= 4)
        {
            int differenceScore = player1Score - player2Score;
            if (differenceScore == 1) score = "Advantage " + this.player1Name;
            else if (differenceScore == -1) score = "Advantage "+ this.player2Name ;
            else if (differenceScore >= 2) score = "Win for " + this.player1Name;
            else score = "Win for " + this.player2Name;
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = player1Score;
                else { score += "-"; tempScore = player2Score;}
                switch(tempScore)
                {
                    case 0:
                        score += SCORE_ARRAY[tempScore];
                        break;
                    case 1:
                        score += SCORE_ARRAY[tempScore];
                        break;
                    case 2:
                        score += SCORE_ARRAY[tempScore];
                        break;
                    case 3:
                        score += SCORE_ARRAY[tempScore];
                        break;
                }
            }
        }
        return score;
    }
}
