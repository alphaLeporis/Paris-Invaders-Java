package be.uantwerpen.fti.ei.invaders.graphicsEngine.sprites;

import be.uantwerpen.fti.ei.invaders.graphicsEngine.Java2DFact;

import java.awt.*;
import java.awt.image.BufferedImage;

public class AnimationManager {
    private SpriteSet spriteSet;
    private BufferedImage currentAnimationSheet;
    private int updatePerFrame;
    private int currentFrameTime;
    private int frameIndex;

    public AnimationManager(SpriteSet spriteSet) {
        this.spriteSet = spriteSet;
        this.updatePerFrame = 5;
        this.frameIndex = 0;
        this.currentFrameTime = 0;
        playAnimation("image");
    }

    public Image getSprite() {
        return currentAnimationSheet.getSubimage(
                frameIndex* Java2DFact.SPRITE_SIZE,
                0,
                Java2DFact.SPRITE_SIZE,
                Java2DFact.SPRITE_SIZE
        );
    }

    public void update() {
        currentFrameTime ++;

        if (currentFrameTime >= updatePerFrame) {
            currentFrameTime = 0;
            frameIndex++;

            if (frameIndex >= currentAnimationSheet.getWidth() / Java2DFact.SPRITE_SIZE - 1) {
                frameIndex = 0;
            }
        }
    }

    public void playAnimation(String name) {
        this.currentAnimationSheet = (BufferedImage) spriteSet.get(name);
    }

}
