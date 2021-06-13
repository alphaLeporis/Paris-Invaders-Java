package be.uantwerpen.fti.ei.invaders.graphicsEngine.ui;

import be.uantwerpen.fti.ei.invaders.gameEngine.states.State;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.Display;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.backgrounds.BackgroundLibrary;
import be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.UIComponent;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class VisualisationObjects {
    private final Display display;
    private BackgroundLibrary backgroundLibrary;
    private Image background;
    private List<UIComponent> uiComponents;

    public VisualisationObjects(Display display) {
        this.display = display;
        uiComponents = new ArrayList<>();
        backgroundLibrary = display.getBackgroundLibrary();
    }

    public void setBackground(String backgroundName) {
        this.background = backgroundLibrary.getBackground(backgroundName);
    }

    public void addUiComponent(UIComponent uiComponent) {
        uiComponents.add(uiComponent);
    }

    public Image getBackground() {
        return background;
    }

    public List<UIComponent> getUiComponents() {
        return uiComponents;
    }

    public void update(State state) {
        uiComponents.forEach(component -> component.resize(display.xFactor, display.yFactor));
        uiComponents.forEach(component -> component.update(state));
    }
}
