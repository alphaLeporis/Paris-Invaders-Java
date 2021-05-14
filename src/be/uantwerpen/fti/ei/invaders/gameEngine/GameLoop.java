package be.uantwerpen.fti.ei.invaders.gameEngine;


import be.uantwerpen.fti.ei.invaders.AFact;

/**
 * This class will make sure that our game works at a constant update and render rate across multiple OS'es
 */
public class GameLoop {
    private final Game game;
    private boolean running;
    private long lastUpdate = System.currentTimeMillis();
    private long nextStatTime;
    private int fps, ups;

    /**
     * To start the GameLoop we add a game and it will execute run() for us.
     * @param game is needed to call the update and render methods
     */
    public GameLoop(Game game)  {
        this.game = game;
        run();
    }

    /**
     * Starts the game
     */
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

    public void stop() {
        running = false;
    }

    /**
     * We will store the current time in lastUpdate.
     */
    private void startStopwatch() {
        lastUpdate = System.currentTimeMillis();
    }

    /**
     * Usually our update and render methods will be done before the end of our tick duration.
     * The default is 60 UPS and 60 FPS, any updates/renders beyond this will not affect the game.
     * Therefore we will put our processor in to sleep for the remaining time.
     * It is possible that our updates/renders take more time than 1 second, in this case our UPS/FPS will drop and the processor will not sleep.
     */
    private void sleepStopwatch() {
        double tickDuration = 1000.0d / (double) AFact.gameConfig.getConfigInt("UPDATES_PER_SECOND");
        long sleepTime = (long) tickDuration - (System.currentTimeMillis() - lastUpdate);
        if (sleepTime > 0) {
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * A small method to print our FPS and UPS in the terminal.
     */
    private void printStats() {
        if (System.currentTimeMillis() > nextStatTime) {
            System.out.printf("FPS: %d, UPS: %d%n", fps, ups);
            fps = 0;
            ups = 0;
            nextStatTime = System.currentTimeMillis() + 1000;
        }
    }

    /**
     * Calls update() in the game class.
     */
    private void update() {
        game.update();
        ups++;
    }

    /**
     * Calls render() in the game class.
     */
    private void render() {
        game.render();
        fps++;
    }
}
