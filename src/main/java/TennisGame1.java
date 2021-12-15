
public class TennisGame1 implements TennisGame {
    
    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            scorePlayer1 += 1;
        else
            scorePlayer2 += 1;
    }

    public String getScore() {
        String score = "";
        if (scorePlayer1 == scorePlayer2)
        {
            score = getScoreWhenEquals();
        }
        else if (scorePlayer1 >=4 || scorePlayer2 >=4)
        {
            score = getScoreWhenHigherThan4();
        }
        else
        {
            score = getScoreArentEqualOrHigherTo4(score);
        }
        return score;
    }

    private String getScoreWhenHigherThan4() {
        int minusResult = scorePlayer1 - scorePlayer2;
        if(Math.abs(minusResult) == 1){
            return getScoreWhenDifferenceEqualsToAbs1(minusResult);
        }
        return  getScoreWhenDiferenceEqualsOrHigherThanAbs2(minusResult);
    }

    private String getScoreWhenDifferenceEqualsToAbs1(int minusResult) {
        if (minusResult==1) {
            return String.format("Advantage %s", player1Name);
        }
        return String.format("Advantage %s", player2Name);

    }

    private String getScoreWhenDiferenceEqualsOrHigherThanAbs2(int minusResult) {
        if (minusResult>=2){
            return String.format("Win for %s", player1Name);
        }
        return String.format("Win for %s", player2Name);
    }

    private String getScoreWhenEquals() {
        String score;
        switch (scorePlayer1)
        {
            case 0:
                score = "Love-All";
                return score;
            case 1:
                score = "Fifteen-All";
                return score;
            case 2:
                score = "Thirty-All";
                return score;
            default:
                score = "Deuce";
                return score;

        }
    }

    private String getScoreArentEqualOrHigherTo4(String score) {
        int tempScore;
        for (int i = 1; i<3; i++)
        {
            if (i==1) {
                tempScore = scorePlayer1;
            }
            else {
                score +="-"; tempScore = scorePlayer2;
            }
            score = getIndividualScore(score, tempScore);
        }
        return score;
    }

    private String getIndividualScore(String score, int tempScore) {
        switch(tempScore)
        {
            case 0:
                score =String.format("%sLove", score);
                break;
            case 1:
                score =String.format("%sFifteen", score);
                break;
            case 2:
                score =String.format("%sThirty", score);
                break;
            case 3:
                score =String.format("%sForty", score);
                break;
            default:
                break;
        }
        return score;
    }
}