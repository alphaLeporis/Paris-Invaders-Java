package be.uantwerpen.fti.ei.invaders.gameEngine;

import be.uantwerpen.fti.ei.invaders.AFact;

/**
 * This is an in-game timer.
 */
public class Timer {
    private int updatesTillNow;
    private boolean isRunning;

    /**
     * Creates a new timer starting at 0.
     */
    public Timer() {
        this.updatesTillNow = 0;
        start();
    }

    /**
     * Is called every update and is used to determine the current time.
     */
    public void update() {
        if (isRunning)
            updatesTillNow++;
    }

    /**
     * @return a formatted string representation of the in-game timer.
     */
    public String getFormattedTime() {
        StringBuilder stringBuilder = new StringBuilder();
        int minutes = updatesTillNow / AFact.gameConfig.getConfigInt("UPDATES_PER_SECOND") / 60;
        int seconds = updatesTillNow / AFact.gameConfig.getConfigInt("UPDATES_PER_SECOND") % 60;

        if(minutes < 10) {
            stringBuilder.append(0);
        }
        stringBuilder.append(minutes);
        stringBuilder.append(":");

        if(seconds < 10) {
            stringBuilder.append(0);
        }
        stringBuilder.append(seconds);
        return stringBuilder.toString();
    }

    /**
     * Starts the timer.
     */
    public void start() {
        isRunning = true;
    }

    /**
     * Stops the timer.
     */
    public void stop() {
        isRunning = false;
    }
}
