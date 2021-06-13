package be.uantwerpen.fti.ei.invaders.gameEngine.states;


import be.uantwerpen.fti.ei.invaders.AFact;
import be.uantwerpen.fti.ei.invaders.controlEngine.Controller;
import be.uantwerpen.fti.ei.invaders.controlEngine.EnemyController;
import be.uantwerpen.fti.ei.invaders.controlEngine.NPCInput;
import be.uantwerpen.fti.ei.invaders.gameEngine.Condition;
import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.EnemyEntity;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.PlayerEntity;

import java.util.List;

/**
 * This is the most important state: the GameState.
 * This GameState will hold the playable entities.
 */
public class GameState extends State {
    private List<Condition> victoryConditions;
    private List<Condition> defeatConditions;
    private boolean playing;

    /**
     * This is the base constructor and will create a game without a previous state (new game).
     * @param game is needed to pass to super to store the needed game variables stored in game.
     */
    public GameState(Game game) {
        super(game);
        playing = true;
        currentGameLevel = 1;
        game.resetScore();

        initializeCharacters();
        initializeConditions();

        audioPlayer.playMusic("game.wav");
    }

    /**
     * This is the alternative constructor and will create a game wit a previous state (returning from pause).
     * @param game is needed to pass to super to store the needed game variables stored in game.
     * @param previousState is needed to know what the state was like before leaving.
     */
    public GameState(Game game, State previousState) {
        super(game);
        this.entities = previousState.getEntities();
        this.score = previousState.getScore();
        playing = true;
        initializeConditions();
        audioPlayer.playMusic("game.wav");
    }

    /**
     * At every update we will check the conditions and generate bonuses.
     * @param game is needed to pass to super.
     */
    @Override
    public void update(Game game) {
        super.update(game);
        generateBonus();

        if(playing) {
            if(victoryConditions.stream().allMatch(Condition::isMet)) {
                win();
            }

            if(defeatConditions.stream().allMatch(Condition::isMet)) {
                lose();
            }
        }
    }

    /**
     * Initializes the movable characters. The player and multiple enemies.
     */
    private void initializeCharacters() {
        entities.add(afact.getPlayerEntity(input));
        entities.add(afact.getBlockEntity(1036,600));
        entities.add(afact.getBlockEntity(736,600));
        entities.add(afact.getBlockEntity(416,600));
        entities.add(afact.getBlockEntity(100,600));
        initializeEnemies(1);
    }

    /**
     * Initializes the enemies for a given levels
     * @param levels is needed to initialize different level.
     */
    private void initializeEnemies(int levels) {
        int stepSize = AFact.gameConfig.getConfigInt("WIDTH") / (AFact.gameConfig.getConfigInt("ENEMIES_PER_ROW")+1);
        Controller enemyController = new EnemyController(new NPCInput(this));

        for (int i=1; i <= levels; i++) {
            for (int j=1; j <= AFact.gameConfig.getConfigInt("ENEMIES_PER_ROW"); j++) {
                entities.add(afact.getEnemyEntity(enemyController, (j*stepSize - AFact.gameConfig.getConfigInt("ENTITY_WIDTH")/2),
                        (i*100 - AFact.gameConfig.getConfigInt("ENTITY_HEIGHT")/2)));
            }
        }
    }

    /**
     * Initializes the conditions that will determine if the player won or lost.
     */
    private void initializeConditions() {
        victoryConditions = List.of(() -> getNumberOfEnemies() == 0);
        defeatConditions = List.of(() ->  !isPlayerAlive() | areEnemiesTooLow());
    }

    /**
     * @return a boolean that tells the conditions when the enemies get too close.
     */
    private boolean areEnemiesTooLow() {
        return entities.stream()
                .filter(e -> e instanceof EnemyEntity)
                .filter(e -> e.getPosition().getY() > AFact.gameConfig.getConfigInt("HEIGHT") - AFact.gameConfig.getConfigInt("ENTITY_HEIGHT") * 1.5)
                .toArray().length > 0;
    }

    /**
     * @return a boolean that tells the conditions if the player has been hit by a bullet
     */
    private boolean isPlayerAlive() {
        return entities.stream()
                .filter(e -> e instanceof PlayerEntity)
                .toArray().length == 1;
    }

    /**
     * @return a boolean that tells the conditions if the player has killed all the enemies
     */
    private int getNumberOfEnemies() {
        return entities.stream()
                .filter(e -> e instanceof EnemyEntity)
                .toArray().length;
    }

    /**
     * This method will be used to generate bonuses with a predefined chance.
     */
    private void generateBonus() {
        if(Math.random() * 1000 < AFact.gameConfig.getConfigInt("CHANCE_NEW_BONUS")) {
            entities.add(afact.getBonusEntity());
        }

    }

    /**
     * If the player loses this method will be called and state will change states to the LostState.
     */
    private void lose() {
        playing = false;
        setNextState(new LostState(game));
        System.out.println("LOST");
    }

    /**
     * If the player wins this method will be called and state will change to the WinState (after 3 levels).
     */
    private void win() {
        currentGameLevel ++;
        if (currentGameLevel > 3) {
            playing = false;
            score.playerWins();
            setNextState(new WonState(game));
            System.out.println("WON");
        }
        score.playerNewLevel();
        audioPlayer.playSound("next-level.wav");
        restartGame();
    }

    /**
     * We can restart the game after going to a new level with this method.
     */
    private void restartGame() {
        System.out.println("Current game level: "+currentGameLevel);
        initializeEnemies(2);
    }
}
