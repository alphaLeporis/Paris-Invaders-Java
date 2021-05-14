package be.uantwerpen.fti.ei.invaders.gameEngine;

import be.uantwerpen.fti.ei.invaders.AFact;

public class Timer {
    private int updatesTillNow;
    private boolean isRunning;


    public Timer() {
        this.updatesTillNow = 0;
        start();
    }

    public void update() {
        if (isRunning)
            updatesTillNow++;
    }

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

    public void start() {
        isRunning = true;
    }

    public void stop() {
        isRunning = false;
    }
}
