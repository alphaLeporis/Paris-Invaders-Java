package be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core;



import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Size;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.ImageUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

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

    @Override
    public void update(State state) {
        createFont();
        calculateSize();
    }

    protected void calculateSize() {
        FontMetrics fontMetrics = new Canvas().getFontMetrics(font);
        int width = fontMetrics.stringWidth(text);
        int height = fontMetrics.getHeight();

        if(dropShadow) {
            width += dropShadowOffset;
        }

        size = new Size(width, height);
    }

    protected void createFont() {
        if (xFactor!=0) fontSize = (int) (baseFontSize*xFactor);
        font = new Font(fontFamily, fontStyle, fontSize);
    }

    public void setText(String text) {
        this.text = text;
    }

    @SuppressWarnings("unused")
    public String getText() {
        return text;
    }
}
