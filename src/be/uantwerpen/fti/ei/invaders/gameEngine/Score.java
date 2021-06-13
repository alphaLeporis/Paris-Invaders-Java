package be.uantwerpen.fti.ei.invaders.gameEngine;

import be.uantwerpen.fti.ei.invaders.AFact;

/**
 * In this class we keep the score.
 */
public class Score {
    private int score;

    /**
     * Constructor starts with a score of 0
     */
    public Score() {
        score = 0;
    }

    /**
     * Is called when the player kills an enemy
     */
    public void playerKills() {
        score += AFact.gameConfig.getConfigInt("SCORE_PLAYER_KILLS");
    }

    /**
     * Is called when the player hits a block
     */
    public void playerHitsBlock() {
        score -= AFact.gameConfig.getConfigInt("SCORE_PLAYER_BLOCK");
    }

    /**
     * Is called when an enemy hits the player
     */
    public void enemyHitsPlayer() {
        score -= AFact.gameConfig.getConfigInt("SCORE_PLAYER_HIT");
    }

    /**
     * Is called when the player catches a good bonus
     */
    public void playerGoodBonus() {
        score += AFact.gameConfig.getConfigInt("SCORE_PLAYER_GOOD_BONUS");
    }

    /**
     * Is called when the player catches a bad bonus
     */
    public void playerBadBonus() {
        score -= AFact.gameConfig.getConfigInt("SCORE_PLAYER_BAD_BONUS");
    }

    /**
     * Is called when the player gets to a new level
     */
    public void playerNewLevel() {
        score += AFact.gameConfig.getConfigInt("SCORE_PLAYER_NEW_LEVEL");
    }

    /**
     * Is called when the player wins
     */
    public void playerWins() {
        score += AFact.gameConfig.getConfigInt("SCORE_PLAYER_WINS");
    }

    /**
     * @return nicely formatted score in string.
     */
    public String getFormattedScore() {
        String scoreString = String.valueOf(score);
        return "0".repeat(Math.max(0, 5 - scoreString.length())) + scoreString;
    }

    /**
     * Resets the score to 0.
     */
    public void reset() {
        score = 0;
    }
}
