package org.psnbtech.Items;

public class Item_ReverseKey extends ItemType {
    private static int TIME_LIMIT = 30;
    Item_ReverseKey(int x, int y, ItemManager itemManager) {
        super(x, y, itemManager);
        this.isBad = true;
        this.message = "Just 30 Seconds, Reverse Left and Right Key ...";
    }

    @Override
    public void action() {
        long startTime = System.currentTimeMillis();
        long end = startTime + TIME_LIMIT*1000;
        itemManager.getTetris().setReverseIndex(true);
        while(System.currentTimeMillis() < end){
        }
        itemManager.getTetris().setReverseIndex(false);
    }
}
