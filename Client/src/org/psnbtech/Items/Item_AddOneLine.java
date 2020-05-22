package org.psnbtech.Items;

public class Item_AddOneLine extends ItemType {
    Item_AddOneLine(int x, int y, ItemManager itemManager) {
        super(x, y, itemManager);
        this.isBad = false;
        this.message = "Add One Line ...";
    }

    // TODO
    @Override
    public void action() {
        itemManager.getBoard().addUnremovableLine();
    }
}
