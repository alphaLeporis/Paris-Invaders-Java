/*
package be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.old;


import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Position;
import be.uantwerpen.fti.ei.invaders.gameEngine.entities.movement.Size;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.UIComponent;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.old.UIContainer;

public class VerticalContainer extends UIContainer {
    public VerticalContainer(Size windowSize) {
        super(windowSize);
    }

    @Override
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

    @Override
    protected void calculateContentPosition() {
        int currentY = padding.getTop();

        for(UIComponent uiComponent : children) {
            currentY += uiComponent.getMargin().getTop();
            uiComponent.setRelativePosition(new Position(padding.getLeft(), currentY));
            uiComponent.setAbsolutePosition(new Position(padding.getLeft() + absolutePosition.getX(), currentY + absolutePosition.getY()));
            currentY += uiComponent.getSize().getHeight();
            currentY += uiComponent.getMargin().getBottom();
        }
    }
}
*/
