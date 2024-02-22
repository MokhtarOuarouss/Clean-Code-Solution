public class TennisGame4 implements TennisGame {

    int player1Score;
    int player2Score;
    String player1Name;
    String player2Name;

    public TennisGame4(String player1, String player2) {
        this.player1Name = player1;
        this.player2Name = player2;
    }

    @java.lang.Override
    public void wonPoint(String playerName) {
        if (player1Name.equals(playerName))
            this.player1Score++;
        else
            this.player2Score++;
    }

    @java.lang.Override
    public String getScore() {
        TennisResult result = new Deuce(
                this, new GameServer(
                        this, new GameReceiver(
                                this, new AdvantageServer(
                                        this, new AdvantageReceiver(
                                                this, new DefaultResult(this)))))).getResult();
        return result.format();
    }

    boolean receiverHasAdvantage() {
        return player2Score >= 4 && (player2Score - player1Score) == 1;
    }

    boolean serverHasAdvantage() {
        return player1Score >= 4 && (player1Score - player2Score) == 1;
    }

    boolean receiverHasWon() {
        return player2Score >= 4 && (player2Score - player1Score) >= 2;
    }

    boolean serverHasWon() {
        return player1Score >= 4 && (player1Score - player2Score) >= 2;
    }

    boolean isDeuce() {
        return player1Score >= 3 && player2Score >= 3 && player1Score == player2Score;
    }
}

class TennisResult {
    String player1Score;
    String player2Score;

    TennisResult(String player1Score, String player2Score) {
        this.player1Score = player1Score;
        this.player2Score = player2Score;
    }

    String format() {
        if ("".equals(this.player2Score))
            return this.player1Score;
        if (player1Score.equals(player2Score))
            return player1Score + "-All";
        return this.player1Score + "-" + this.player2Score;
    }
}

interface ResultProvider {
    TennisResult getResult();
}

class Deuce implements ResultProvider {
    private final TennisGame4 game;
    private final ResultProvider nextResult;

    public Deuce(TennisGame4 game, ResultProvider nextResult) {
        this.game = game;
        this.nextResult = nextResult;
    }

    @Override
    public TennisResult getResult() {
        if (game.isDeuce())
            return new TennisResult("Deuce", "");
        return this.nextResult.getResult();
    }
}

class GameServer implements ResultProvider {
    private final TennisGame4 game;
    private final ResultProvider nextResult;

    public GameServer(TennisGame4 game, ResultProvider nextResult) {
        this.game = game;
        this.nextResult = nextResult;
    }

    @Override
    public TennisResult getResult() {
        if (game.serverHasWon())
            return new TennisResult("Win for " + game.player1Name, "");
        return this.nextResult.getResult();
    }
}

class GameReceiver implements ResultProvider {
    private final TennisGame4 game;
    private final ResultProvider nextResult;

    public GameReceiver(TennisGame4 game, ResultProvider nextResult) {
        this.game = game;
        this.nextResult = nextResult;
    }

    @Override
    public TennisResult getResult() {
        if (game.receiverHasWon())
            return new TennisResult("Win for " + game.player2Name, "");
        return this.nextResult.getResult();
    }
}

class AdvantageServer implements ResultProvider {
    private final TennisGame4 game;
    private final ResultProvider nextResult;

    public AdvantageServer(TennisGame4 game, ResultProvider nextResult) {
        this.game = game;
        this.nextResult = nextResult;
    }

    @Override
    public TennisResult getResult() {
        if (game.serverHasAdvantage())
            return new TennisResult("Advantage " + game.player1Name, "");
        return this.nextResult.getResult();
    }
}

class AdvantageReceiver implements ResultProvider {

    private final TennisGame4 game;
    private final ResultProvider nextResult;

    public AdvantageReceiver(TennisGame4 game, ResultProvider nextResult) {
        this.game = game;
        this.nextResult = nextResult;
    }

    @Override
    public TennisResult getResult() {
        if (game.receiverHasAdvantage())
            return new TennisResult("Advantage " + game.player2Name, "");
        return this.nextResult.getResult();
    }
}

class DefaultResult implements ResultProvider {

    private static final String[] scores = {"Love", "Fifteen", "Thirty", "Forty"};

    private final TennisGame4 game;

    public DefaultResult(TennisGame4 game) {
        this.game = game;
    }

    @Override
    public TennisResult getResult() {
        return new TennisResult(scores[game.player1Score], scores[game.player2Score]);
    }
}
