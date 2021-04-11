package be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.sprites;

import be.uantwerpen.fti.ei.invaders.gameEngine.GameSettings;

import java.awt.*;
import java.awt.image.BufferedImage;

public class AnimationManager {
    private final SpriteSet spriteSet;
    private BufferedImage currentAnimationSheet;
    private final int updatePerFrame;
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
                frameIndex* GameSettings.SPRITE_SIZE,
                0,
                GameSettings.SPRITE_SIZE,
                GameSettings.SPRITE_SIZE
        );
    }

    public void update() {
        currentFrameTime ++;

        if (currentFrameTime >= updatePerFrame) {
            currentFrameTime = 0;
            frameIndex++;
            System.out.println(frameIndex);

            if (frameIndex >= currentAnimationSheet.getWidth() / GameSettings.SPRITE_SIZE ) {
                frameIndex = 0;
            }
        }
    }

    public void playAnimation(String name) {
        this.currentAnimationSheet = (BufferedImage) spriteSet.get(name);
    }

}
