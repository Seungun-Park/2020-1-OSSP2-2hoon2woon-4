package org.psnbtech.Items;

public class Item_DisableRotate extends ItemType {
    private static int TIME_LIMIT = 30;
    Item_DisableRotate(int x, int y, ItemManager itemManager) {
        super(x, y, itemManager);
        this.isBad = true;
        this.message = "Just 30 Seconds, Disable Rotate ...";
    }

    @Override
    public void action() {
        long startTime = System.currentTimeMillis();
        long end = startTime + TIME_LIMIT*1000;
        itemManager.getTetris().setRotationIndex(false);
        while(System.currentTimeMillis() < end){
        }
        itemManager.getTetris().setRotationIndex(true);
    }
}
