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

public class GameState extends State {
    private List<Condition> victoryConditions;
    private List<Condition> defeatConditions;
    private boolean playing;

    public GameState(Game game, State previousState) {
        super(game);
        this.entities = previousState.getEntities();
        this.uiContainers = previousState.getUiContainers();

        playing = true;
        initializeConditions();
        audioPlayer.playMusic("game.wav");
    }

    public GameState(Game game) {
        super(game);

        playing = true;
        initializeCharacters();

        initializeConditions();
        uiContainers.add(new UIGameStats(windowSize, this));

        audioPlayer.playMusic("game.wav");
    }

    private void initializeCharacters() {
        entities.add(afact.getPlayerEntity(input));

        Controller enemyController = new EnemyController(new NPCInput(this));
        for (int i=0; i<10; i++) {
            entities.add(afact.getEnemyEntity(enemyController, i));
        }
    }

    private void initializeConditions() {
        victoryConditions = List.of(() -> getNumberOfEnemies() == 0);
        defeatConditions = List.of(() ->  !isPlayerAlive() | areEnemiesTooLow());
    }

    private boolean areEnemiesTooLow() {
        return entities.stream()
                .filter(e -> e instanceof EnemyEntity)
                .filter(e -> e.getPosition().getY() > GameSettings.HEIGHT - GameSettings.ENTITY_HEIGHT * 1.5)
                .toArray().length > 0;
    }

    private boolean isPlayerAlive() {
        return entities.stream()
                .filter(e -> e instanceof PlayerEntity)
                .toArray().length == 1;
    }

    private int getNumberOfEnemies() {
        return entities.stream()
                .filter(e -> e instanceof EnemyEntity)
                .toArray().length;
    }

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

    private void generateBonus() {
        if(Math.random() * 1000 < GameSettings.CHANCE_NEW_BONUS) {
            entities.add(afact.getBonusEntity());
        }

    }

    private void lose() {
        playing = false;
        setNextState(new LostState(game));
        System.out.println("LOST");
    }

    private void win() {
        playing = false;
        setNextState(new WonState(game));
        System.out.println("WON");
    }

}
