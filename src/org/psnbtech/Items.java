package org.psnbtech;
import java.util.Random;

/*
 * TODO ! Tetris :
 * 아이템 객체 선언하고
 * 특정 시간마다 랜덤 아이템 받기 ( 조건 - 보드에 아이템이 몇 개 이상 쌓이지 않도록..?! > 이 변수는 Items 클래스에 두기..! )
 * 아이템 보드에 보여주기
 */


// TODO ! Item 보여줄 때 이미지..? 같은 걸로 바꾸기..!
// TODO ! 점수 제도 ..?
public class Items {

    public class Type {
        private int index;
        private String message;
        public Type(int index, String message){
            this.index = index;
            this.message = message;
        }
        public void setIndex(int index){
            this.index = index;
        }
        public int getIndex(){
            return index;
        }
        public void setMessage(String message){
            this.message = message;
        }
        public String getMessage(){
            return message;
        }
    }

    private static final int COUNT_OF_GOODS = 3;
    private static final int COUNT_OF_BADS = 3;

    // Definition : Good Items
    Type DeleteAllBlocks = new Type(1, "Delete All Blocks !!!");
    Type DeleteSomeLine = new Type(3, "Delete One Line !!!");
    Type DoubleScore = new Type(5, "Just 30 Seconds, Double Score !!!");

    // Definition : Bad Items
    Type DisableRotate = new Type(8, "Just 30 Seconds, Disable Rotate ...");
    Type ReverseKey = new Type(10, "Just 30 Seconds, Reverse Left and Right Key ...");
    Type AddOneLine = new Type(13, "Add One Line ...");

    Type Goods[] = {DeleteAllBlocks, DeleteSomeLine, DoubleScore};
    Type Bads[] = {DisableRotate, ReverseKey, AddOneLine};

    private static int ITEM_COUNT = 0;
    private static int CUR_ITEM;

    private Random random;
    // Function : generateRandomItems - same chance in good and bad and all the items
    public void generateRandomItem(){
        random = new Random();
        CUR_ITEM = random.nextInt(COUNT_OF_GOODS + COUNT_OF_BADS - 1) + 1;
    }

    // TODO ! each Function : eachActionItem
    public void ActionDeleteAllBlocks(){

    }
    public void ActionDeleteSomeLine(){

    }
    public void ActionDoubleScore(){

    }

    public void ActionDisableRotate(){

    }
    public void ActionReverseKey(){

    }
    public void ActionAddOneLine(){

    }


    // Function : actionItem - operate..? run..? the item > case to each item
    public void actionItem(int itemIndex){
       switch (itemIndex){
           case 1:
               ActionDeleteAllBlocks();
               break;
           case 2:
               ActionDeleteSomeLine();
               break;
           case 3:
               ActionDoubleScore();
               break;
           case 4:
               ActionDisableRotate();
               break;
           case 5:
               ActionReverseKey();
               break;
           case 6:
               ActionAddOneLine();
               break;
       }
    }

    // TODO ! Function : itemLocation - decide the location of items ( param : tile info..? board info..?)

    // Function : itemUpdate - return item randomly
    Type itemUpdate(){
        ITEM_COUNT++;
        if(CUR_ITEM > COUNT_OF_GOODS){
            return Bads[CUR_ITEM-1];
        }
        else{
            return Goods[CUR_ITEM%(COUNT_OF_GOODS+1)];
        }
    }

}


