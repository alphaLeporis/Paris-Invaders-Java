package be.uantwerpen.fti.ei.invaders.gameEngine.states;

import be.uantwerpen.fti.ei.invaders.AFact;
import be.uantwerpen.fti.ei.invaders.audioEngine.AudioPlayer;
import be.uantwerpen.fti.ei.invaders.controlEngine.Controller;
import be.uantwerpen.fti.ei.invaders.controlEngine.EnemyController;
import be.uantwerpen.fti.ei.invaders.controlEngine.Input;
import be.uantwerpen.fti.ei.invaders.controlEngine.NPCInput;
import be.uantwerpen.fti.ei.invaders.gameEngine.Condition;
import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.gameEngine.GameSettings;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.EnemyEntity;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.PlayerEntity;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class GameState extends State {
    private List<Condition> victoryConditions;
    private List<Condition> defeatConditions;
    private boolean playing;

    public GameState(Game game) {
        super(game);

        //Todo: add background
        playing = true;
        initializeCharacters();

        //Todo: add UI
        //initializeUI(windowSize);
        initializeConditions();

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

        if(playing) {
            if(victoryConditions.stream().allMatch(Condition::isMet)) {
                win();
            }

            if(defeatConditions.stream().allMatch(Condition::isMet)) {
                lose();
            }
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
