package be.uantwerpen.fti.ei.invaders.graphicsEngine.ui.core.old;

public class Padding {

    private int top;
    private int right;
    private int bottom;
    private int left;

    public Padding(int spacing) {
        this(spacing, spacing);
    }

    public Padding(int horizontal, int vertical) {
        this(vertical, horizontal, vertical, horizontal);
    }

    public Padding(int top, int right, int bottom, int left) {
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.left = left;
    }

    public int getTop() {
        return top;
    }

    public int getRight() {
        return right;
    }

    public int getBottom() {
        return bottom;
    }

    public int getLeft() {
        return left;
    }

    public int getVertical() {
        return top + bottom;
    }

    public int getHorizontal() {
        return right + left;
    }
}
