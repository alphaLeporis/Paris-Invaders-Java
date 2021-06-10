/*
package be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.old;



import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Size;
import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.ImageUtils;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.UIComponent;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class UIContainer extends UIComponent {

    protected Color backgroundColor;
    protected Padding padding;
    protected Size fixedSize;

    protected final List<UIComponent> children;

    public UIContainer(Size windowSize) {
        super();
        backgroundColor = new Color(0, 0, 0, 0);
        padding = new Padding(5);
        children = new ArrayList<>();
        calculateSize();
        calculatePosition();
    }

    protected Size calculateContentSize() {
        int combinedChildHeight = 0;
        int widestChildWidth = 0;

        for(UIComponent uiComponent : children) {
            combinedChildHeight += uiComponent.getSize().getHeight() + uiComponent.getMargin().getVertical();

            if(uiComponent.getSize().getWidth() > widestChildWidth) {
                widestChildWidth = uiComponent.getSize().getWidth();
            }
        }

        return new Size(widestChildWidth, combinedChildHeight);
    }

    protected void calculateContentPosition() {
        int currentY = padding.getTop();

        for (UIComponent uiComponent : children) {
            currentY += uiComponent.getMargin().getTop();
            uiComponent.setRelativePosition(new Position(padding.getLeft(), currentY));
            uiComponent.setAbsolutePosition(new Position(padding.getLeft() + absolutePosition.getX(), currentY + absolutePosition.getY()));
            currentY += uiComponent.getSize().getHeight();
            currentY += uiComponent.getMargin().getBottom();
        }
    }

    private void calculateSize() {
        Size calculatedContentSize = calculateContentSize();
        size = fixedSize != null
                ? fixedSize
                : new Size(
                padding.getHorizontal() + calculatedContentSize.getWidth(),
                padding.getVertical() + calculatedContentSize.getHeight());
    }

    private void calculatePosition() {
        int x = padding.getLeft();
        if(alignment.getHorizontal().equals(Alignment.Position.CENTER)) {
            x = windowSize.getWidth() / 2 - size.getWidth() / 2;
        }
        if(alignment.getHorizontal().equals(Alignment.Position.END)) {
            x = windowSize.getWidth() - size.getWidth() - margin.getRight();
        }

        int y = padding.getTop();
        if(alignment.getVertical().equals(Alignment.Position.CENTER)) {
            y = windowSize.getHeight() / 2 - size.getHeight() / 2;
        }
        if(alignment.getVertical().equals(Alignment.Position.END)) {
            y = windowSize.getHeight() - size.getHeight() - margin.getBottom();
        }

        this.relativePosition = new Position(x, y);
        this.absolutePosition = new Position(x, y);
        calculateContentPosition();
    }

    @Override
    public Image visualize() {
        BufferedImage image = (BufferedImage) ImageUtils.createCompatibleImage(size, ImageUtils.ALPHA_BIT_MASKED);
        Graphics2D graphics = image.createGraphics();

        graphics.setColor(backgroundColor);
        graphics.fillRect(0, 0, size.getWidth(), size.getHeight());

        for(UIComponent uiComponent : children) {
            graphics.drawImage(
                    uiComponent.visualize(),
                    uiComponent.getRelativePosition().getX(),
                    uiComponent.getRelativePosition().getY(),
                    null
            );
        }

        graphics.dispose();
        return image;
    }

    @Override
    public void update(State state) {
        children.forEach(component -> component.update(state));
        calculateSize();
        calculatePosition();
    }

    public void addUIComponent(UIComponent uiComponent) {
        children.add(uiComponent);
    }

    public void setBackgroundColor(Color color) {
        backgroundColor = color;
    }

    public void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public void setFixedSize(Size fixedSize) {
        this.fixedSize = fixedSize;
    }
}
*/
