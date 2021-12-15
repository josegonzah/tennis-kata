
public class TennisGame2 implements TennisGame
{
    public int scorePlayer1 = 0;
    public int scorePlayer2 = 0;
    
    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;
    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";
        
        score = checkTieGame(score);
        score = checkStartGame(score);
        score = checkPlayerOneWinning(score);
        score = checkPlayerTwoWinning(score);
        score = postGame(score);
        return score;
    }

    private String postGame(String score) {
        if(scorePlayer1 >= 4 || scorePlayer2 >=4){
            score = checkGameFinished(score);
        }
        return score;
    }

    private String checkGameFinished(String score) {
        if(scorePlayer1 - scorePlayer2 >= 2){
            score = "Win for player 1";
        }
        if(scorePlayer2 - scorePlayer2 >= 2){
            score = "Win for player 2";
        }
        return score;
    }

    private String checkPlayerTwoWinning(String score) {
        if(scorePlayer2 > scorePlayer1){
            score = getScoreP2Winning(score);
        }
        return score;
    }

    private String getScoreP2Winning(String score) {
        String tempScoreP1 = "";
        String tempScoreP2 = "";
        if(scorePlayer2 < 4){
            tempScoreP1 = buildScoreP1();
            tempScoreP2 = buildScoreP2();
            score = tempScoreP1 + "-" + tempScoreP2;

        }
        if(scorePlayer2 >= 3){
            score = "Advantage player2";
        }
        return score;
    }

    private String buildScoreP2() {
        switch(scorePlayer2){
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
        }
        return "Love";
    }

    private String buildScoreP1() {

        switch(scorePlayer1){
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
        }
        return "Love";
    }

    private String checkPlayerOneWinning(String score) {
        if(scorePlayer1 > scorePlayer2){
            score = getScoreP1Winning(score);
        }
        return score;
    }

    private String getScoreP1Winning(String score) {
        String tempScoreP1 = "";
        String tempScoreP2 = "";
        if(scorePlayer1 < 4){
            tempScoreP1 = buildScoreP1();
            tempScoreP2 = buildScoreP2();
            score = tempScoreP1 + "-" + tempScoreP2;
        }
        if(scorePlayer2 >= 3){
            score = "Advantage player 1";
        }
        return score;
    }

    private String checkStartGame(String score) {
        String tempScoreP1 = "";
        String tempScoreP2 = "";
        if (scorePlayer1 > 0 || scorePlayer2 > 0){
            tempScoreP1 = buildScoreP1();
            tempScoreP2 = buildScoreP2();
            score = tempScoreP1 + "-" + tempScoreP2;
        }
        return score;
    }

    private String checkTieGame(String score) {
        if(scorePlayer1 == scorePlayer2){
            score = getScoreTied(score);
        }
        return score;
    }

    private String getScoreTied(String score) {
        if(scorePlayer1 < 4){
            switch(scorePlayer1){
                case 0:
                    return "Love-All";
                case 1:
                    return "Fifteen-All";
                default:
                    return "Thirty-All";
            }
        }
        if (scorePlayer1 >= 3){
            score = "Deuce";
        }
        return score;
    }


    public void wonPoint(String player) {
        if (player == "player1")
            scorePlayer1++;
        else
            scorePlayer2++;
    }
}