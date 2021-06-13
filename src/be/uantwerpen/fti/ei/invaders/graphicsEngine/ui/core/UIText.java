package be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core;

import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Size;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.ImageUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * UIText component, based on UIComponent.
 * This component shows text in a UI container.
 */
public class UIText extends UIComponent {
    private String text;
    private final int baseFontSize;
    private int fontSize;
    private final int fontStyle;
    private final String fontFamily;
    public Color color;

    private final boolean dropShadow;
    private final int dropShadowOffset;
    private final Color shadowColor;

    private Font font;

    /**
     * The constructor makes a text component.
     * @param text is the text you want to display.
     * @param position is the position of where the text is in game-units.
     */
    public UIText(String text, Position position) {
        this.position = position;
        this.text = text;
        this.baseFontSize = 24;
        this.fontSize = baseFontSize;
        this.fontStyle = Font.BOLD;
        //noinspection SpellCheckingInspection
        this.fontFamily = "Joystix Monospace";
        this.color = Color.WHITE;

        this.dropShadow = true;
        this.dropShadowOffset = 2;
        this.shadowColor = new Color(140,140, 140);
    }

    /**
     * @return an image that holds the text.
     */
    @Override
    public Image visualize() {
        BufferedImage image = (BufferedImage) ImageUtils.createCompatibleImage(size);
        Graphics2D graphics = image.createGraphics();
        graphics.setFont(font);

        if(dropShadow) {
            graphics.setColor(shadowColor);
            graphics.drawString(text, dropShadowOffset, fontSize + dropShadowOffset);
        }

        graphics.setColor(color);
        graphics.drawString(text, 0, fontSize);

        graphics.dispose();
        return image;
    }

    /**
     * @param state is needed to know where the update takes place.
     */
    @Override
    public void update(State state) {
        createFont();
        calculateSize();
    }

    /**
     * Calculates the size of the image based on font size.
     */
    protected void calculateSize() {
        FontMetrics fontMetrics = new Canvas().getFontMetrics(font);
        int width = fontMetrics.stringWidth(text);
        int height = fontMetrics.getHeight();

        if(dropShadow) {
            width += dropShadowOffset;
        }

        size = new Size(width, height);
    }

    /**
     * Creates a font, based on the constructor data.
     * Inside here we also change the fontsize based on the window size.
     */
    protected void createFont() {
        if (xFactor!=0) fontSize = (int) (baseFontSize*xFactor);
        font = new Font(fontFamily, fontStyle, fontSize);
    }

    /**
     * @param text is the new text we want to display
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the text that is currently displayed.
     */
    @SuppressWarnings("unused")
    public String getText() {
        return text;
    }
}
