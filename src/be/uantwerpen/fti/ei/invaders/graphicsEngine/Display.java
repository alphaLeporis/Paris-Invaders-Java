package be.uantwerpen.fti.ei.invaders.graphicsEngine;

import be.uantwerpen.fti.ei.invaders.AFact;
import be.uantwerpen.fti.ei.invaders.controlEngine.Input;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.sprites.SpriteLibrary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferStrategy;

/**
 * This class will make the display and render bufferedimages to its canvas.
 */
public class Display extends JFrame {

    private final Canvas canvas;
    private final SpriteLibrary spriteLibrary;
    private static BackgroundManager backgroundManager;
    private double xFactor;
    private double yFactor;

    /**
     * This is the default constructor to set up a display
     * @param input Because our JFrame needs a KeyListener we add our (keyboard) input
     */
    public Display(Input input, SpriteLibrary spriteLibrary) {
        this.spriteLibrary = spriteLibrary;
        backgroundManager = new BackgroundManager();
        canvas = new Canvas();

        setTitle("Paris Invaders");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        resizeHandler();


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

        graphics.setColor(Color.BLACK);
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


    public void resizeHandler() {
        if (Java2DFact.displayConfig.getConfigInt("FULLSCREEN") == 1) {
            xFactor = Toolkit.getDefaultToolkit().getScreenSize().getWidth() / (double) AFact.gameConfig.getConfigInt("WIDTH");
            yFactor = Toolkit.getDefaultToolkit().getScreenSize().getHeight() / (double) AFact.gameConfig.getConfigInt("HEIGHT");
            setExtendedState(JFrame.MAXIMIZED_BOTH);
            setUndecorated(true);
            setVisible(true);
            setResizable(false);
            windowResizer((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
            canvas.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
            setSize(Toolkit.getDefaultToolkit().getScreenSize());

        } else {
            setVisible(true);
            setResizable(true);
            canvas.setPreferredSize(new Dimension(Java2DFact.gameConfig.getConfigInt("WIDTH"), Java2DFact.gameConfig.getConfigInt("HEIGHT")));
            setPreferredSize(new Dimension(Java2DFact.gameConfig.getConfigInt("WIDTH"), Java2DFact.gameConfig.getConfigInt("HEIGHT")));
            xFactor = Java2DFact.gameConfig.getConfigInt("WIDTH") / (double) AFact.gameConfig.getConfigInt("WIDTH");
            yFactor = Java2DFact.gameConfig.getConfigInt("HEIGHT") / (double) AFact.gameConfig.getConfigInt("HEIGHT");


            addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    setPreferredSize(e.getComponent().getSize());
                    pack();
                    windowResizer(getContentPane().getWidth(), getContentPane().getHeight());
                    canvas.setPreferredSize(getContentPane().getPreferredSize());

                    xFactor = getContentPane().getWidth() / (double) AFact.gameConfig.getConfigInt("WIDTH");
                    yFactor = getContentPane().getHeight() / (double) AFact.gameConfig.getConfigInt("HEIGHT");

                }
            });
        }
    }


    public void windowResizer(int width, int height) {
        backgroundManager.resize(width, height);
        spriteLibrary.resize(width/(double) AFact.gameConfig.getConfigInt("WIDTH"),
                            height/(double) AFact.gameConfig.getConfigInt("HEIGHT"));
    }
}
