package be.uantwerpen.fti.ei.invaders.graphicsEngine;

import be.uantwerpen.fti.ei.invaders.controlEngine.Input;
import be.uantwerpen.fti.ei.invaders.gameEngine.Game;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * This class will make the display and render bufferedimages to its canvas.
 */
public class Display extends JFrame {
    private final Canvas canvas;

    /**
     * This is the default constructor to set up a display
     * @param width The width of the game
     * @param height The height of the game
     * @param input Because our JFrame needs a KeyListener we add our (keyboard) input
     */
    public Display(int width, int height, Input input) {
        setTitle("Paris Invaders");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setFocusable(false);
        canvas.addMouseListener(input);
        canvas.addMouseMotionListener(input);
        add(canvas);
        addKeyListener(input);
        pack();

        canvas.createBufferStrategy(3);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Rendering all the objects
     * @param state The renderer must have the current state to render al its entities or objects
     */
    public void render(State state) {
        BufferStrategy bufferStrategy = canvas.getBufferStrategy();
        Graphics graphics = bufferStrategy.getDrawGraphics();

        graphics.setColor(Color.WHITE);
        graphics.fillRect(0,0, canvas.getWidth(),canvas.getHeight());

        state.getEntities().stream()
                .forEach(entity -> graphics.drawImage(
                        entity.visualize(),
                        entity.getPosition().getX(),
                        entity.getPosition().getY(),
                        null
                ));

        state.getUiContainers().forEach(uiContainer -> graphics.drawImage(
                uiContainer.visualize(),
                uiContainer.getRelativePosition().getX(),
                uiContainer.getRelativePosition().getY(),
                null
        ));

        graphics.dispose();
        bufferStrategy.show();
    }
}
