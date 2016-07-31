package ChessGame;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;



abstract class  AllMoveAbs extends Player{
	
	JButton newGame = new JButton("New Game");
	JButton about = new JButton("About");
	JButton exit = new JButton("Exit");
			
	JLabel title = new JLabel("Turn For : ");
		
	JLabel Check = new JLabel();	

	
	/* Black Pieces */
    JLabel label = new JLabel(new ImageIcon(getClass().getResource("/BlackPawn.png")));
    JLabel label2 = new JLabel(new ImageIcon(getClass().getResource("/BlackPawn.png")));
    JLabel label3 = new JLabel(new ImageIcon(getClass().getResource("/BlackPawn.png")));
    JLabel label4 = new JLabel(new ImageIcon(getClass().getResource("/BlackPawn.png")));
    JLabel label5 = new JLabel(new ImageIcon(getClass().getResource("/BlackPawn.png")));
    JLabel label6 = new JLabel(new ImageIcon(getClass().getResource("/BlackPawn.png")));
    JLabel label7 = new JLabel(new ImageIcon(getClass().getResource("/BlackPawn.png")));
    JLabel label8 = new JLabel(new ImageIcon(getClass().getResource("/BlackPawn.png")));
    
    JLabel label9 = new JLabel(new ImageIcon(getClass().getResource("/BlackKnight.png")));
    JLabel label10 = new JLabel(new ImageIcon(getClass().getResource("/BlackKnight.png")));
    JLabel label11 = new JLabel(new ImageIcon(getClass().getResource("/BlackRook.png")));
    JLabel label12 = new JLabel(new ImageIcon(getClass().getResource("/BlackRook.png")));
    JLabel label13 = new JLabel(new ImageIcon(getClass().getResource("/BlackBishop.png")));
    JLabel label14 = new JLabel(new ImageIcon(getClass().getResource("/BlackBishop.png")));
    JLabel label15 = new JLabel(new ImageIcon(getClass().getResource("/BlackQueen.png")));
    JLabel label16 = new JLabel(new ImageIcon(getClass().getResource("/BlackKing.png")));
    
    JLabel Princess = new JLabel(new ImageIcon(getClass().getResource("/BlackPrincess.png")));    
    JLabel Empress = new JLabel(new ImageIcon(getClass().getResource("/BlackEmpress.png")));
    JLabel Grass = new JLabel(new ImageIcon(getClass().getResource("/BlackGrass.png"))); 
    
  /* White Pieces */
  JLabel lbl = new JLabel(new ImageIcon(getClass().getResource("/WhitePawn.png")));
  JLabel lbl2 = new JLabel(new ImageIcon(getClass().getResource("/WhitePawn.png")));
  JLabel lbl3 = new JLabel(new ImageIcon(getClass().getResource("/WhitePawn.png")));
  JLabel lbl4 = new JLabel(new ImageIcon(getClass().getResource("/WhitePawn.png")));
  JLabel lbl5 = new JLabel(new ImageIcon(getClass().getResource("/WhitePawn.png")));
  JLabel lbl6 = new JLabel(new ImageIcon(getClass().getResource("/WhitePawn.png")));
  JLabel lbl7 = new JLabel(new ImageIcon(getClass().getResource("/WhitePawn.png")));
  JLabel lbl8 = new JLabel(new ImageIcon(getClass().getResource("/WhitePawn.png")));
  
  JLabel lbl9 = new JLabel(new ImageIcon(getClass().getResource("/WhiteKnight.png")));
  JLabel lbl10 = new JLabel(new ImageIcon(getClass().getResource("/WhiteKnight.png")));
  JLabel lbl11 = new JLabel(new ImageIcon(getClass().getResource("/WhiteRook.png")));
  JLabel lbl12 = new JLabel(new ImageIcon(getClass().getResource("/WhiteRook.png")));
  JLabel lbl13 = new JLabel(new ImageIcon(getClass().getResource("/WhiteBishop.png")));
  JLabel lbl14 = new JLabel(new ImageIcon(getClass().getResource("/WhiteBishop.png")));
  JLabel lbl15 = new JLabel(new ImageIcon(getClass().getResource("/WhiteQueen.png")));
  JLabel lbl16 = new JLabel(new ImageIcon(getClass().getResource("/WhiteKing.png")));

  JLabel WhitePrincess = new JLabel(new ImageIcon(getClass().getResource("/WhitePrincess.png")));
  JLabel WhiteEmpress = new JLabel(new ImageIcon(getClass().getResource("/WhiteEmpress.png")));
  JLabel WhiteGrass = new JLabel(new ImageIcon(getClass().getResource("/WhiteGrass.png"))); 	
  
	abstract public void BlackPawn();
	abstract public void WhitePawn();
	abstract public void BlackKingMove();
	abstract public void WhiteKingMove();
	abstract public void BlackKnightMove();
	abstract public void WhiteKnightMove();
	abstract public void BlackRookMove();
	abstract public void WhiteRookMove();
	abstract public void WhiteBishopMove();
	abstract public void WhiteGrasshoper();
	abstract public void BlackGrasshoper();
	
}