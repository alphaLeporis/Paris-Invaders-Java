package be.uantwerpen.fti.ei.invaders.graphicsEngine;

import be.uantwerpen.fti.ei.invaders.AFact;
import be.uantwerpen.fti.ei.invaders.controlEngine.Input;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * This class will make the display and render bufferedimages to its canvas.
 */
public class Display extends JFrame {

    private final Canvas canvas;
    private static BackgroundManager backgroundManager;
    private final double xFactor;
    private final double yFactor;

    /**
     * This is the default constructor to set up a display
     * @param input Because our JFrame needs a KeyListener we add our (keyboard) input
     */
    public Display(Input input) {
        xFactor = (double) (Java2DFact.displayConfig.getConfigInt("WIDTH") / (double) AFact.gameConfig.getConfigInt("WIDTH"));
        yFactor = (double) (Java2DFact.displayConfig.getConfigInt("HEIGHT") / (double) AFact.gameConfig.getConfigInt("HEIGHT"));


        setTitle("Paris Invaders");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(Java2DFact.displayConfig.getConfigInt("WIDTH"),
                                              Java2DFact.displayConfig.getConfigInt("HEIGHT")));
        canvas.setFocusable(false);
        canvas.addMouseListener(input);
        canvas.addMouseMotionListener(input);
        add(canvas);
        addKeyListener(input);
        pack();

        canvas.createBufferStrategy(3);

        setLocationRelativeTo(null);
        setVisible(true);

        backgroundManager = new BackgroundManager();
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

        graphics.drawImage(backgroundManager.visualize(state), 0,0,null);

        state.getEntities()
                .forEach(entity -> graphics.drawImage(
                        entity.visualize(),
                        (int) Math.round(entity.getPosition().getX()*xFactor),
                        (int) Math.round(entity.getPosition().getY()*yFactor),
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
