package org.psnbtech;
import java.util.Random;


// TODO ! Item 보여줄 때 이미지..? 같은 걸로 바꾸기..!
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


    private BoardPanel board;
    public Items(BoardPanel board){
        this.board = board;
    }
    public void setBoard(BoardPanel board){ this.board = board; }
    public BoardPanel getBoard(){ return board; }

    private static final int COUNT_OF_GOODS = 3;
    private static final int COUNT_OF_BADS = 3;

    private static final int TIME_LIMIT = 30;

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

    public void ActionDeleteAllBlocks(BoardPanel board){
        board.clear();
    }
    public void ActionDeleteSomeLine(){
        // 못 지우는 라인 있는지 파악, 몇 줄인지도 파악
        // 못 지우는 라인 하나, 그냥 라인 하나 지우기
    }
    public void ActionDoubleScore(boolean scoreIndex){
        long startTime = System.currentTimeMillis();
        long end = startTime + TIME_LIMIT*1000;
        scoreIndex = true;
        while(System.currentTimeMillis() < end){
        }
        scoreIndex = false;
    }

    public void ActionDisableRotate(){
        // 키 이벤트 index 만들고 > true일 때만 동작하게
        // 시간 체크 시작
        // index false로
        // 삼십초 지나면 index true로 하고 종료
    }
    public void ActionReverseKey(){
        // 좌우 방향키에 index 만들고 > index false이면 세팅 반대로
        // 시간 체크 시작
        // index false로
        // 삼십초 지나면 index true로 하고 종료

    }
    public void ActionAddOneLine(){

    }


    // Function : actionItem - operate..? run..? the item > case to each item
    public void actionItem(int itemIndex){
       switch (itemIndex){
           case 1:
               ActionDeleteAllBlocks(board);
               break;
           case 2:
               ActionDeleteSomeLine();
               break;
           case 3:
               //TODO ! ActionDoubleScore(board.); > 구조를 어떻게 할지 생각해보기.. ! Tetris에 역할을 얼마만큼 줄 것인
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

    // TODO ! Function : itemLocation - decide the location of items ( param : tile info..? boar지d info..?)
    int[] getItemLocation(BoardPanel board){
        int[] result = new int[2];
        int[] target;
        //for(int i=0;  )

        return result;
    }

    // TODO ! Item generating term > 5 tetromino
    // Function : itemUpdate - return item randomly
    Type itemGenerate(){
        ITEM_COUNT++;
        if(CUR_ITEM > COUNT_OF_GOODS){
            return Bads[CUR_ITEM-1];
        }
        else{
            return Goods[CUR_ITEM%(COUNT_OF_GOODS+1)];
        }
    }

    // TODO ! Function : DeleteItem - 그냥 아이템 삭제하기
    // TODO 나쁜 아이템은 시간( 1bag term ) 체크하기 > 안에서 delete 함수
    // TODO 좋은 아이템은 사용하면 > 안에서 delete 함수
}


