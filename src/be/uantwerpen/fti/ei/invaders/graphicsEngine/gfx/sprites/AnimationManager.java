package be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.sprites;

import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.ImageUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class AnimationManager {
    private final SpriteSet spriteSet;
    private BufferedImage currentAnimationSheet;
    private String currentAnimationSheetName;
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
        this.currentAnimationSheet = ImageUtils.convertToBufferedImage(spriteSet.get(currentAnimationSheetName));

        try {
            return currentAnimationSheet.getSubimage(
                    frameIndex* spriteSet.spriteWidth,
                    0,
                    spriteSet.spriteWidth,
                    spriteSet.spriteHeight
            );
        } catch (Exception e) {
            System.out.println("It looks like the resizing was too slow :/ no problem it will be reade next time :)"+e);
        }
        return null;
    }

    public void update() {
        currentFrameTime ++;

        if (currentFrameTime >= updatePerFrame) {
            currentFrameTime = 0;
            frameIndex++;

            if (frameIndex >= currentAnimationSheet.getWidth() / spriteSet.spriteWidth ) {
                frameIndex = 0;
            }
        }
    }

    public void playAnimation(String name) {
        this.currentAnimationSheetName = name;
        this.currentAnimationSheet = ImageUtils.convertToBufferedImage(spriteSet.get(currentAnimationSheetName));
    }

}
