public class board {
    private char board[][];
    private int boardSize=3;
    private char p1Symbol;
    private int count;
    public static final int player1Wins = 1;
    public static final int player2Wins = 2;
    public static final int draw = 3;
    public static final int incomplete = 4;
    public static final int invalid = 5;
    public board(char p1Symbol,char p2Symbol){
        board = new char[3][3];
        for(int i = 0; i<boardSize ; i++){
            for(int j = 0; j <boardSize ; j++){
                board[i][j] =' ';
            }
        }
        this.p1Symbol = p1Symbol;
    }
    public int move(char symbol, int x, int y){
        if(x<0 || x>= boardSize || y<0 ||y>=boardSize || board[x][y] != ' '){
            return invalid;
        }
        board[x][y] = symbol;
        count++;
        if(board[x][0]==board[x][1] && board[x][0] == board[x][2]){
            return symbol == p1Symbol ? player1Wins:player2Wins;
        }
        if(board[0][y]==board[1][y] && board[0][y] == board[2][y]){
            return symbol == p1Symbol ? player1Wins:player2Wins;
        }
        if(board[0][0]!=' ' && board[0][0]==board[1][1] && board[0][0] == board[2][2]){
            return symbol == p1Symbol ? player1Wins:player2Wins;
        }
        if(board[0][2]!=' ' && board[0][2]==board[1][1] && board[0][2] == board[2][0]){
            return symbol == p1Symbol ? player1Wins:player2Wins;
        }
        if(count == boardSize*boardSize){
            return draw;
        }
        return incomplete;
    }
    public void print(){
        System.out.println("---------------");
        for(int i =0 ; i<boardSize ; i++){
            for(int j = 0; j<boardSize ; j++){
                System.out.print("| "+board[i][j]+" |");
            }
            System.out.println();
        }
        System.out.println("---------------");
    }
}
