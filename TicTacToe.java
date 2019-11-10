//import java.util.*;
                     /// COMPELETED AT 17/08/2019 TIC TAC TOE GAME
public class TicTacToe 
{
	protected static final int X = 1, O = -1;
	protected static final int EMPTY=0;
	protected int board[][]=new int[3][3];
	protected int player;
	public TicTacToe()
	{
		clearBoard();
	}
	public void clearBoard()
	{
		for(int i=0;i<3;i++)		
		for(int j=0;j<3;j++)
        board[i][j]=EMPTY;
		player=X;
	}
	public void putMark(int i,int j) throws Exception
	{
		if((i<0) || (i>2)||(j<0)||(j>2))
			throw new Exception("Invalid Board Position");
		if(board[i][j]!=EMPTY)
			throw new Exception("Board Position Occupied");
		board[i][j]=player;
		player=-player;
	}
	public boolean isWin(int mark)
	{
		return  ((board[0][0]+board[0][1]+board[0][2]==mark*3)
				||(board[1][0]+board[1][1]+board[1][2]==mark*3)
				||(board[2][0]+board[2][1]+board[2][2]==mark*3)
				||(board[0][0]+board[1][0]+board[2][0]==mark*3)
				||(board[0][1]+board[1][1]+board[2][1]==mark*3)
				||(board[0][2]+board[1][2]+board[2][2]==mark*3)
				||(board[0][0]+board[1][1]+board[2][2]==mark*3)
				||(board[2][0]+board[1][1]+board[0][2]==mark*3));
	}
	public int winner()
	{
		if(isWin(X))
			return(X);
		else if(isWin(O))
			return(O);
		else
			return(0);
	}
	public String toString()
	{
		String s="";
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				switch(board[i][j]) {
				case X:s+="X";break;
				case O:s+="O";break;
				case EMPTY:s+=" ";break;
				}
				if(j<2)s+="|";
			}
			if(i<2)s+="\n-----\n";
		}
		return s;
	}
	public static void main(String arg[]) throws Exception
	{
		TicTacToe game=new TicTacToe();
		   /* FOR X                        FOR O  */
		game.putMark(1, 1);            game.putMark(0, 2);
		game.putMark(2, 2);            game.putMark(1, 0);
		game.putMark(0, 0);            game.putMark(2, 1);
		game.putMark(1, 2);            game.putMark(0, 1);
		game.putMark(2, 0);
		System.out.println(game.toString());
		int winningPlayer=game.winner();
		if(winningPlayer!=0)
		System.out.println("\n"+winningPlayer+ " wins");
		else
			System.out.println("Tie");
	}
}
