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

    private static final int COUNT_OF_GOODS = 7;
    private static final int COUNT_OF_BADS = 7;

    // Definition : Good Items
    Type DeleteAllBlocks = new Type(1, "Delete All Blocks !!!");
    Type SpeedDown = new Type(2, "Just 30 Seconds, Speed Down !!!");
    Type DeleteOneLine = new Type(3, "Delete One Line !!!");
    Type DeleteTwoLine = new Type(4, "Delete Two Line !!!");
    Type DoubleScore = new Type(5, "Just 30 Seconds, Double Score !!!");
    Type MoreHold = new Type(6, "Just One Time, One More Hold !!!");
    Type MoreNext = new Type(7, "Just One Time, One More Next !!!");

    // Definition : Bad Items
    Type DisableRotate = new Type(8, "Just 30 Seconds, Disable Rotate ...");
    Type SpeedUp = new Type(9, "Just 30 Seconds, Speed Up ...");
    Type ReverseKey = new Type(10, "Just 30 Seconds, Reverse Left and Right Key ...");
    Type HideNext = new Type(11, "Just 30 Seconds, Hide Next Block ...");
    Type HideField = new Type(12, "Just 30 Seconds, Can't See Board ...");
    Type AddOneLine = new Type(13, "Add One Line ...");
    Type AddTwoLine = new Type(14, "Add Two Lines ...");

    Type Goods[] = {DeleteAllBlocks, SpeedDown, DeleteOneLine, DeleteTwoLine, DoubleScore, MoreHold, MoreNext};
    Type Bads[] = {DisableRotate, SpeedUp, ReverseKey, HideNext, HideField, AddOneLine, AddTwoLine};

    private static int ITEM_COUNT = 0;
    private static int CUR_ITEM;

    private Random random;
    // Function : generateRandomItems - same chance in good and bad and all the items
    public void generateRandomItem(){
        random = new Random();
        CUR_ITEM = random.nextInt(13) + 1;
    }

    // TODO ! each Function : eachActionItem
    public void ActionDeleteAllBlocks(){

    }
    public void ActionSpeedDown(){

    }
    public void ActionDeleteOneLine(){

    }
    public void ActionDeleteTwoLine(){

    }
    public void ActionDoubleScore(){

    }
    public void ActionMoreHold(){

    }
    public void ActionMoreNext(){

    }

    public void ActionDisableRotate(){

    }
    public void ActionSpeedUp(){

    }
    public void ActionReverseKey(){

    }
    public void ActionHideNext(){

    }
    public void ActionHideField(){

    }
    public void ActionAddOneLine(){

    }
    public void ActionAddTwoLine(){

    }


    // Function : actionItem - operate..? run..? the item > case to each item
    public void actionItem(int itemIndex){
       switch (itemIndex){
           case 1:
               ActionDeleteAllBlocks();
               break;
           case 2:
               ActionSpeedDown();
               break;
           case 3:
               ActionDeleteOneLine();
               break;
           case 4:
               ActionDeleteTwoLine();
               break;
           case 5:
               ActionDoubleScore();
               break;
           case 6:
               ActionMoreHold();
               break;
           case 7:
               ActionMoreNext();
               break;
           case 8:
               ActionDisableRotate();
               break;
           case 9:
               ActionSpeedUp();
               break;
           case 10:
               ActionReverseKey();
               break;
           case 11:
               ActionHideNext();
               break;
           case 12:
               ActionHideField();
               break;
           case 13:
               ActionAddOneLine();
               break;
           case 14:
               ActionAddTwoLine();
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


