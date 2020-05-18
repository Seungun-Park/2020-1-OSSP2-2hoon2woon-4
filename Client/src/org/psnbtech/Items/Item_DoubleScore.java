package org.psnbtech.Items;

public class Item_DoubleScore extends ItemType {
    private static int TIME_LIMIT = 30;
    Item_DoubleScore(int x, int y, ItemManager itemManager) {
        super(x, y, itemManager);
        this.isBad = false;
        this.message = "Just 30 Seconds, Double Score !!!";
    }

    @Override
    public void action() {
        long startTime = System.currentTimeMillis();
        long end = startTime + TIME_LIMIT*1000;
        itemManager.getTetris().setScoreIndex(true);
        while(System.currentTimeMillis() < end){
        }
        itemManager.getTetris().setScoreIndex(false);
    }
}
