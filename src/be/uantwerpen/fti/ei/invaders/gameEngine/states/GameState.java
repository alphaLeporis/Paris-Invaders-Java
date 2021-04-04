package be.uantwerpen.fti.ei.invaders.gameEngine.states;

import be.uantwerpen.fti.ei.invaders.AFact;
import be.uantwerpen.fti.ei.invaders.audioEngine.AudioPlayer;
import be.uantwerpen.fti.ei.invaders.controlEngine.Controller;
import be.uantwerpen.fti.ei.invaders.controlEngine.EnemyController;
import be.uantwerpen.fti.ei.invaders.controlEngine.Input;
import be.uantwerpen.fti.ei.invaders.controlEngine.NPCInput;
import be.uantwerpen.fti.ei.invaders.gameEngine.Game;

import java.awt.*;
import java.util.List;
import java.util.concurrent.locks.Condition;

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
        //initializeConditions();

        audioPlayer.playMusic("game.wav");
    }

    private void initializeCharacters() {
        entities.add(afact.getPlayerEntity(input));

//        Controller enemyController = new EnemyController(new NPCInput(this));
//        for (int i=0; i<10; i++) {
//            entities.add(afact.getEnemyEntity(enemyController, i));
//        }
    }

/*    private void initializeConditions() {
        victoryConditions = List.of(() -> getNumberOfEnemies() == 0);
        defeatConditions = List.of(() ->  isPlayerAlive());
    }*/

    @Override
    public void update(Game game) {
        super.update(game);

/*        if(playing) {
            if(victoryConditions.stream().allMatch(Condition::isMet)) {
                win();
            }

            if(defeatConditions.stream().allMatch(Condition::isMet)) {
                lose();
            }
        }*/
    }

    private void lose() {
        playing = false;
    }

    private void win() {
        playing = false;
    }

}
