package be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.sprites;

import be.uantwerpen.fti.ei.invaders.graphicsEngine.gfx.ImageUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * This is the animationmanager, it takes care of the sprite animations.
 */
public class AnimationManager {
    private final SpriteSet spriteSet;
    private BufferedImage currentAnimationSheet;
    private String currentAnimationSheetName;
    private final int updatePerFrame;
    private int currentFrameTime;
    private int frameIndex;

    /**
     * The constructor creates a new animation instance.
     * @param spriteSet is needed to get all the sprites available.
     */
    public AnimationManager(SpriteSet spriteSet) {
        this.spriteSet = spriteSet;
        this.updatePerFrame = 5;
        this.frameIndex = 0;
        this.currentFrameTime = 0;
        playAnimation("image");
    }

    /**
     * Updates the animationframe. At the gevin updates per frame, a new frame will be selected.
     */
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

    /**
     * This method returns the correct sprite frame at a specific moment.
     * Sometimes an excception will print. This is because of the resizing.
     * The actual resizing takes longer than this method.
     * @return an image of the sprite frame.
     */
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

    /**
     * Can be used to play a different animation. (Not the default: 'image')
     * @param name is needed to know what animation to play.
     */
    public void playAnimation(String name) {
        this.currentAnimationSheetName = name;
        this.currentAnimationSheet = ImageUtils.convertToBufferedImage(spriteSet.get(currentAnimationSheetName));
    }

}
