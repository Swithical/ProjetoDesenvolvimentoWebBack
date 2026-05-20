package main.model;

public class Score {

    private String playerName;
    private String testName;
    private int score;

    public Score() {
    }

    public Score(String playerName, String testName, int score) {
        this.playerName = playerName;
        this.testName = testName;
        this.score = score;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}