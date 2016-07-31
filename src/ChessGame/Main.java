package ChessGame;

public class Main {

	 public static void main(String args[])
	    {
		 ChessBoard MainBoard = new ChessBoard();
		 	MainBoard.addPanel();
			MainBoard.createSquares();
			MainBoard.RandomlyAddPieces();
			MainBoard.showBoard();
			MainBoard.Instruction();
	    }
	 

}
