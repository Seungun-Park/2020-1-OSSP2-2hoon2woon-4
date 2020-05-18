package org.psnbtech.Items;

public abstract class ItemType {

    protected boolean isBad;
    protected int count;
    protected String message;
    protected int x;
    protected int y;
    protected ItemManager itemManager;

    ItemType(int x, int y, ItemManager itemManager){
        this.x = x;
        this.y = y;
        this.itemManager = itemManager;
        this.count = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public abstract void action();
}
