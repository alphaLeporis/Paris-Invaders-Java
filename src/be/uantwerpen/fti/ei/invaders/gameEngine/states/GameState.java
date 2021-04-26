package be.uantwerpen.fti.ei.invaders.gameEngine.states;


import be.uantwerpen.fti.ei.invaders.controlEngine.Controller;
import be.uantwerpen.fti.ei.invaders.controlEngine.EnemyController;
import be.uantwerpen.fti.ei.invaders.controlEngine.NPCInput;
import be.uantwerpen.fti.ei.invaders.gameEngine.Condition;
import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.gameEngine.GameSettings;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.EnemyEntity;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.PlayerEntity;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.game.UIGameStats;

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
        initializeCharacters();

        initializeConditions();
        //uiContainers.add(new UIGameStats(windowSize, this));

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
        this.uiContainers = previousState.getUiContainers();

        playing = true;
        initializeConditions();
        audioPlayer.playMusic("game.wav");
    }

    /**
     * Initializes the movable characters. The player and multiple enemies.
     */
    private void initializeCharacters() {
        entities.add(afact.getPlayerEntity(input));

        initializeEntities(3);
    }

    private void initializeEntities(int levels) {
        int stepSize = GameSettings.GAME_SIZE.getWidth() / (GameSettings.ENEMIES_PER_ROW+1);
        System.out.println(stepSize);
        Controller enemyController = new EnemyController(new NPCInput(this));

        for (int i=1; i <= levels; i++) {
            for (int j=1; j <= GameSettings.ENEMIES_PER_ROW; j++) {
                entities.add(afact.getEnemyEntity(enemyController, (j*stepSize - GameSettings.ENTITY_WIDTH/2), (i*100 - GameSettings.ENTITY_HEIGHT/2)));
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
                .filter(e -> e.getPosition().getY() > GameSettings.GAME_SIZE.getHeight() - GameSettings.ENTITY_HEIGHT * 1.5)
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
     * This method will be used to generate bonuses with a predefined chance.
     */
    private void generateBonus() {
        if(Math.random() * 1000 < GameSettings.CHANCE_NEW_BONUS) {
            entities.add(afact.getBonusEntity());
        }

    }

    /**
     * If the player loses this method will be called and state will change to the LostState.
     */
    private void lose() {
        playing = false;
        setNextState(new LostState(game));
        System.out.println("LOST");
    }

    /**
     * If the player wins this method will be called and state will change to the WinState.
     */
    private void win() {
        playing = false;
        setNextState(new WonState(game));
        System.out.println("WON");
    }

}
