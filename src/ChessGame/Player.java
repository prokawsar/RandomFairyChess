package ChessGame;

import java.awt.Color;

import javax.swing.JLabel;

class Player {
	
	static int Player = 0;
	JLabel PlayerTurn = new JLabel();
	
	protected void PlayerTurn() {
		
		if (Player == 1) {
			Player = 0;
			PlayerTurn.setForeground(Color.WHITE);
			PlayerTurn.setText("White");
		} else {
			Player = 1;
			PlayerTurn.setForeground(Color.BLACK);
			PlayerTurn.setText("Black");
		}
		
	}
}
