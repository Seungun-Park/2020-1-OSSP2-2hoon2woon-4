package org.psnbtech.Items;

public class Item_DeleteAllBlocks extends ItemType {
    Item_DeleteAllBlocks(int x, int y, ItemManager itemManager) {
        super(x,y,itemManager);
        this.isBad = false;
        this.message = "Delete All Blocks !!!";
    }

    @Override
    public void action() {
        itemManager.getBoard().clear();
    }
}
