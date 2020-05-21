package org.psnbtech.Items;

public class Item_DeleteSomeLine extends ItemType {
    Item_DeleteSomeLine(int x, int y, ItemManager itemManager) {
        super(x, y, itemManager);
        this.isBad = false;
        this.message = "Delete Some Line !!!";
    }

    // TODO
    @Override
    public void action() {

    }
}
