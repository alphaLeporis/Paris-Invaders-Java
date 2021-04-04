package be.uantwerpen.fti.ei.invaders.gameEngine;

import be.uantwerpen.fti.ei.invaders.AFact;

public class GameLoop {
    private final Game game;
    private boolean running;
    private long lastUpdate = System.currentTimeMillis();
    private long nextStatTime;
    private int fps, ups;

    public GameLoop(Game game)  {
        this.game = game;
        run();
    }

    public void run() {
        running = true;
        nextStatTime = System.currentTimeMillis() + 1000;

        while (running) {
            startStopwatch();
            update();
            render();
            sleepStopwatch();
            printStats();
        }
    }

    private void startStopwatch() {
        lastUpdate = System.currentTimeMillis();
    }

    private void sleepStopwatch() {
        double tickDuration = 1000.0d / (double) GameSettings.UPDATES_PER_SECOND;
        long sleepTime = (long) tickDuration - (System.currentTimeMillis() - lastUpdate);
        if (sleepTime > 0) {
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void printStats() {
        if (System.currentTimeMillis() > nextStatTime) {
            System.out.printf("FPS: %d, UPS: %d%n", fps, ups);
            fps = 0;
            ups = 0;
            nextStatTime = System.currentTimeMillis() + 1000;
        }
    }

    private void update() {
        game.update();
        ups++;
    }

    private void render() {
        game.render();
        fps++;
    }
}
