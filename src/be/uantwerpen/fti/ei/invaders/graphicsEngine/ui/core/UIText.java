package be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core;



import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Size;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.ImageUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UIText extends UIComponent {

    private String text;
    private final int fontSize;
    private final int fontStyle;
    private final String fontFamily;
    private final Color color;

    private final boolean dropShadow;
    private final int dropShadowOffset;
    private final Color shadowColor;

    private Font font;

    public UIText(String text) {
        this.text = text;
        this.fontSize = 18;
        this.fontStyle = Font.BOLD;
        this.fontFamily = "Joystix Monospace";
        this.color = Color.WHITE;

        this.dropShadow = true;
        this.dropShadowOffset = 2;
        this.shadowColor = new Color(140,140, 140);
    }

    @Override
    public Image visualize() {
        BufferedImage image = (BufferedImage) ImageUtils.createCompatibleImage(size, ImageUtils.ALPHA_BIT_MASKED);
        Graphics2D graphics = image.createGraphics();
        graphics.setFont(font);

        if(dropShadow) {
            graphics.setColor(shadowColor);
            graphics.drawString(text, padding.getLeft() + dropShadowOffset, fontSize + padding.getTop() + dropShadowOffset);
        }

        graphics.setColor(color);
        graphics.drawString(text, padding.getLeft(), fontSize + padding.getTop());

        graphics.dispose();
        return image;
    }

    @Override
    public void update(State state) {
        createFont();
        calculateSize();
    }

    private void calculateSize() {
        FontMetrics fontMetrics = new Canvas().getFontMetrics(font);
        int width = fontMetrics.stringWidth(text) + padding.getHorizontal();
        int height = fontMetrics.getHeight() + padding.getVertical();

        if(dropShadow) {
            width += dropShadowOffset;
        }

        size = new Size(width, height);
    }

    private void createFont() {
        font = new Font(fontFamily, fontStyle, fontSize);
    }

    public void setText(String text) {
        this.text = text;
    }
}
