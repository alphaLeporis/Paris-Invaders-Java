package be.uantwerpen.fti.ei.invaders.graphicsEngine.state;

import be.uantwerpen.fti.ei.invaders.controlEngine.EnemyController;
import be.uantwerpen.fti.ei.invaders.controlEngine.Input;
import be.uantwerpen.fti.ei.invaders.controlEngine.PlayerController;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.entities.Java2DEnemyEntity;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.entities.Java2DPlayerEntity;

public class GameState extends State {
    public GameState(Input input) {
        super(input);
        initializeCharacters();
    }

    private void initializeCharacters() {
        Java2DPlayerEntity player = new Java2DPlayerEntity(new PlayerController(input));
        entities.add(player);
        initializeEnemies();
    }

    private void initializeEnemies() {
        entities.add(new Java2DEnemyEntity(new EnemyController(),1));
    }


}
