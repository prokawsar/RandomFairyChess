package ChessGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.Random;

import javax.swing.*;

public class ChessBoard extends PiecesAndMoves implements MouseListener, ActionListener {	


	public void addPanel() {
		
		SidePane();
		panel1.setSize(480, 450);
		panel1.setLocation(0, 0);
		panel1.setBackground(Color.BLACK);

		panel2.setSize(220, 480);
		panel2.setLocation(482, 0);
		panel2.setLayout(null);
		panel2.setBackground(DARK);
		
		panel2.add(title);
		panel2.add(PlayerTurn);
		panel2.add(Check);
		panel2.add(newGame);
		panel2.add(about);
		panel2.add(exit);
	}


	public ChessBoard() {
    	getBoard().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	getBoard().setSize(700,480);
    	getBoard().setResizable(false);
    	getBoard().setLocationRelativeTo(null);
    	getBoard().setLayout(null);
    	getBoard().setTitle("Random Fairy Chess");
    	
    	getBoard().add(panel1);
		getBoard().add(panel2);
    
    }
	public void Instruction() {

		JOptionPane.showMessageDialog(null, "This is a Fairy Chess. It has 3 Fairy pieces.\n\n"
				+ "Which are Princess, Empress and Grasshoper.\n\nIt is Functioned with Mouse Click.\n\n" +
				"All Pieces are setuped Randomly.\n\n", "Instruction", 1);
	}

    
    public void showBoard()
    {
    	getBoard().setVisible(true);
    	PlayerTurn.setForeground(Color.WHITE);
    	PlayerTurn.setText(" White");
	
    }
    
    public void createSquares()
    {	
    	int x = 0;
    	LabelName();
    	panel1.setLayout(new GridLayout(8,8));
		
        for(int i=0;i<8;i++){
        	
            for(int j=0;j<8;j++){
            	
                JPanel panel = new JPanel();
                panel.addMouseListener(this);
                panel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                panel1.add(panel);
                
                squares[i][j] = panel;
                if(i==0 && j==0){
                	squares[i][j].setName("panel");
                }
                else squares[i][j].setName("panel"+x);
                
                x++; 
            } 
          
        }
        Repaint();
        
    }
    
  
	public void RandomlyAddPieces() {
		
    	int n, i, j, x= 0;
    	int randNum, fairyNum;
    	Random rand = new Random();
    	
    	for(i = 0; i < 16; i++)  {   
			num.add(i+1);     
		} 
		Collections.shuffle(num); 
		randNum = rand.nextInt((15 - 1) + 1) + 1;
		
		fairyNum = rand.nextInt((3 - 1) + 1) + 1;
		
		for(i=0; i<2; i++){
			for(j = 0; j<8; j++){
				if(num.get(x) == randNum){
					FairyPiece.get(fairyNum).addMouseListener(this);
					squares[i][j].add(FairyPiece.get(fairyNum));
			
				}
				else{
					n = num.get(x);
					Blackbox.get(n).addMouseListener(this);
					squares[i][j].add(Blackbox.get(n));
				}
				x++;
			}
		}
	
		Collections.shuffle(num); 
		
		randNum = rand.nextInt((15 - 1) + 1) + 1;
		fairyNum = rand.nextInt((3 - 1) + 1) + 1;
		
		x = 0;
		for(i=6; i<8; i++){
			for(j = 0; j<8; j++){
				if(num.get(x)== randNum){
					FairyPieceWhite.get(fairyNum).addMouseListener(this);
					squares[i][j].add(FairyPieceWhite.get(fairyNum));
			
				}
				else{
					n = num.get(x);
					Whitebox.get(n).addMouseListener(this);
					squares[i][j].add(Whitebox.get(n));
				
				}
				x++;
			}
			
		}
		
	}
	private void Repaint() {
		int i, j;
		for(i=0; i<8; i++){
			for(j=0; j<8; j++){
				if((i+j) % 2 == 0){
					squares[i][j].setBackground(LIGHT);
				}
				else squares[i][j].setBackground(DARK);
				
			}
		}
	} /* End Repaint */
	
	public void Check() {
		int i, j, t =0;
		for(i=0; i<8; i++){
			for(j=0; j<8; j++){
				if(str == squares[i][j].getName()){
					distX = i;
					distY = j;
					t = 1;
					break;
				}
			} if(t == 1){
				break;
			}
		}
	}
	public void Check(JLabel jl) {
		
		int i, j, t =0;
		for(i=0; i<8; i++){
			if(jl.getParent() == null) break;
			for(j=0; j<8; j++){

				if (jl.getParent().getName() == squares[i][j].getName()) {
					distX = i;
					distY = j;
					t = 1;
					break;
				}
			} if(t == 1){
				break;
			}
		}
	}

	
    int ClickCount = 1, Flag;
    String CompName;
    String LabelName;
 
    
	@Override
	public void mouseClicked(MouseEvent e) {

		str = null;
		Found = 0;
	
		if(ClickCount == 1){
			/* On 1st Click getting Label Name */
			LabelName = ((Component) e.getSource()).getName();
		}
		else CompName = ((Component) e.getSource()).getName();

		Repaint();

		if(ClickCount == 1){ /* Checking for 1st Click */
			str = ((Component) e.getSource()).getParent().getName();

		if(Player == 1){ /* Checking for Black */
			
				if (e.getSource() == label16){
					ClickCount = 0;
					Check();
					BlackKingMove();
					squares[distX][distY].setBackground(SELECT);

				}
				else if(e.getSource() == label15){
					ClickCount = 0;
					Check();
					BlackBishopMove();
					BlackRookMove();

				}
				else if(e.getSource() == label13 || e.getSource() == label14){
					ClickCount = 0;
					Check();
					BlackBishopMove();
		
				}
				else if( e.getSource() == label11 || e.getSource() == label12){
		
					ClickCount = 0;
						Check();
						BlackRookMove();
					}
				else if(e.getSource() == label9 || e.getSource() == label10){
			
					ClickCount = 0;
						Check();
						BlackKnightMove();
					}
				else if(e.getSource() == Princess){
					ClickCount = 0;
					Check();
					BlackBishopMove();
					BlackKnightMove();
				}
				else if(e.getSource() == Empress){
					ClickCount = 0;
					Check();
					BlackRookMove();
					BlackKnightMove();
				}
				else if(e.getSource() == Grass){
					ClickCount = 0;
					Check();
					BlackGrasshoper();
				}
				else{
					if(e.getSource()== label || e.getSource()== label2 || e.getSource()== label3 || e.getSource()== label4 || e.getSource()== label5 ||
					e.getSource()== label6 ||e.getSource()== label7 ||e.getSource()== label8){
			
						ClickCount = 0;
						Check();
						BlackPawn();
						
					}
				
				}
				
		} /* End for Black Player Move */
			
		/* Start Checking White */ /* Player 1 */
			else{
				/* if Selected Piece White King */
				if (e.getSource() == lbl16 ) {
					ClickCount = 0;
					Check();
					WhiteKingMove();
					squares[distX][distY].setBackground(SELECT);
		
				}
			/* checking for White Queen */
			else if (e.getSource() == lbl15) {
				ClickCount = 0;
				Check();
				WhiteBishopMove();
				WhiteRookMove();
		
			}
			/* checking for White Bishop Pieces */
			else if(e.getSource() == lbl13 || e.getSource() == lbl14 ){
				ClickCount = 0;
				Check();
				WhiteBishopMove();
				
			}
			/* Checking for White Rook */
			else if(e.getSource() == lbl11 || e.getSource() == lbl12 ){
				ClickCount = 0;
				Check();
				WhiteRookMove();
		
			} /* End Rook */
			else if(e.getSource() == lbl9 || e.getSource() == lbl10 ){
				ClickCount = 0;
				Check();
				WhiteKnightMove();
							
			} /* End Knight */ 
			else if(e.getSource() == WhitePrincess){
				ClickCount = 0;
				Check();
				WhiteBishopMove();
				WhiteKnightMove();
			}
			else if(e.getSource() == WhiteEmpress){
				ClickCount = 0;
				Check();
				WhiteRookMove();
				WhiteKnightMove();
			}
			else if(e.getSource() == WhiteGrass){
				ClickCount = 0;
				Check();
				WhiteGrasshoper();
			}
			else{
				/* Checking for all White Pawn */
				if(e.getSource()== lbl || e.getSource()== lbl2 || e.getSource()== lbl3 || e.getSource()== lbl4 || e.getSource()== lbl5 ||
					e.getSource()== lbl6 ||e.getSource()== lbl7 ||e.getSource()== lbl8){
				
						ClickCount = 0;
						Check();
						WhitePawn();
						
					}
	
			} /* End Pawn */
		
		} /* Checking Move valid or not on 2nd Click */
			
		}  /* Below code for 2nd Click */
		else {
			str = ((Component) e.getSource()).getParent().getName();
			
			Flag = 0;
			Value = null ;
			
			if (Player == 0) { /* Checking for Black */

				BlackPiece();
				
				if (Flag == 1) {
					Remove();

					/* Replacing White Piece ( difference in str ) */
					for (int i1 = 0; i1 < v.size(); i1++) {
						if (str == v.get(i1)) {
							
							squares[distX][distY].add(Whitelabels.get(LabelName));
							PlayerTurn();
							break;

						}
					}
				}

				else { /* For Blank Square */
					
					for (int x = 0; x < 8; x++) {
						for (int y = 0; y < 8; y++) {
							if (squares[x][y].getName() == CompName) {
								distX = x;
								distY = y;
								break;
							}
						}
					}
					ReplaceWhite();

				}

			}
			else {
				/* for White */

				WhitePiece();
				
				if (Flag == 1) {
					Remove();
					
					/* Replacing Black Piece ( difference in str )  */
					for (int i = 0; i < v.size(); i++) {
						if (str == v.get(i)) {
							
							squares[distX][distY].add(Blacklabels.get(LabelName));
							PlayerTurn();
							break;

						}
					}
				}

				else { /* For Blank Square */
					for (int x = 0; x < 8; x++) {
						for (int y = 0; y < 8; y++) {
							if (squares[x][y].getName() == CompName) {
								distX = x;
								distY = y;
								break;
							}
						}
					}
					ReplaceBlack();
					
				}

			}
			//Here code for check kings //
			WhiteKingCheck();
			int i2, i3, f = 0;
			for (i2 = 0; i2 < history.size(); i2++) {
				if (lbl16.getParent().getName() == history.get(i2)) {

					Check.setVisible(true);
					Check.setText("White King Check");
			
					f = 1;
					break;

				}
			}
			
			if(i2 == history.size()){
				Check.setVisible(false);
			}

			
			BlackKingCheck();
			for (i3 = 0; i3 < WhiteHistory.size(); i3++) {
				if (label16.getParent().getName() == WhiteHistory.get(i3)) {
					Check.setVisible(true);
					Check.setText("Black King Check");
				
					break;

				}
			}
			
			if(WhiteHistory.size() == i3 && f == 0){
				Check.setVisible(false);
			}

			ClickCount = 1;
			v.clear();
			history.clear();
			WhiteHistory.clear();
			distX = 0;
			distY = 0;
		}
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}

	private void BlackPiece(){
		for (Entry<String, JLabel> entry : Blacklabels.entrySet()) {
			String key = entry.getKey();
			Value = entry.getValue();
			if (CompName == key) {
				Flag = 1;

				break;
			}

		}
	}
	private void WhitePiece() {
		
		for (Entry<String, JLabel> entry : Whitelabels.entrySet()) {
			String key = entry.getKey();
			Value = entry.getValue();
			if (CompName == key) {
				Flag = 1;
	
				break;
			}
		}
	}
	private void Remove() {
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				if (squares[x][y].getName() == str) {
					distX = x;
					distY = y;
					squares[distX][distY].remove(Value);
					break;
				}
			}
		}
	}
	private void ReplaceWhite() {
		for (int i1 = 0; i1 < v.size(); i1++) {
			if (CompName == v.get(i1)) {

				squares[distX][distY].add(Whitelabels.get(LabelName));
				PlayerTurn();
				break;

			}
		}
	}
	private void ReplaceBlack() {
		for (int i1 = 0; i1 < v.size(); i1++) {
			if (CompName == v.get(i1)) {

				squares[distX][distY].add(Blacklabels.get(LabelName));
				PlayerTurn();
				break;

			}
		}
	}
//	private void PlayerTurn() {
//		
//		if (Player == 1) {
//			Player = 0;
//			PlayerTurn.setForeground(Color.WHITE);
//			PlayerTurn.setText("White");
//		} else {
//			Player = 1;
//			PlayerTurn.setForeground(Color.BLACK);
//			PlayerTurn.setText("Black");
//		}
//		
//	}
	
	
	public void WhiteKingCheck() {
		Check(label);
		BlackPawnPossible();
		Check(label2);
		BlackPawnPossible();
		Check(label3);
		BlackPawnPossible();
		Check(label4);
		BlackPawnPossible();
		Check(label5);
		BlackPawnPossible();
		Check(label6);
		BlackPawnPossible();
		Check(label7);
		BlackPawnPossible();
		Check(label8);
		BlackPawnPossible();
		
		Check(label9);
		BlackKnightPossible();
		Check(label10);
		BlackKnightPossible();
		
		Check(label11);
		BlackRookPossible();
		Check(label12);
		BlackRookPossible();
		
		Check(label13);
		BlackBishopPossible();
		Check(label14);
		BlackBishopPossible();
		
		Check(label15);
		BlackRookPossible();
		BlackBishopPossible();
		
		Check(Princess);
		BlackBishopPossible();
		BlackKnightPossible();
		
		Check(Empress);
		BlackRookPossible();
		BlackKnightPossible();
		
		Check(Grass);
		BlackGrasshoperPossible();
			
	}
	public void BlackKingCheck() {
		Check(lbl);
		WhitePawnPossible();
		Check(lbl2);
		WhitePawnPossible();
		Check(lbl3);
		WhitePawnPossible();
		Check(lbl4);
		WhitePawnPossible();
		Check(lbl5);
		WhitePawnPossible();
		Check(lbl6);
		WhitePawnPossible();
		Check(lbl7);
		WhitePawnPossible();
		Check(lbl8);
		WhitePawnPossible();
		
		Check(lbl9);
		WhiteKnightPossible();
		Check(lbl10);
		WhiteKnightPossible();
		
		Check(lbl11);
		WhiteRookPossible();
		Check(lbl12);
		WhiteRookPossible();
		
		Check(lbl13);
		WhiteBishopPossible();
		Check(lbl14);
		WhiteBishopPossible();
		
		Check(lbl15);
		WhiteRookPossible();
		WhiteBishopPossible();
		
		Check(WhitePrincess);
		WhiteBishopPossible();
		WhiteKnightPossible();
		
		Check(WhiteEmpress);
		WhiteRookPossible();
		WhiteKnightPossible();
		
		Check(WhiteGrass);
		WhiteGrasshoperPossible();
			
	}
	
	public void BlackRookPossible() {
		int i;
		
		for(i= distX; i<7; i++){

			if(PanelContainsBlack(squares[i+1][distY]) == 1){
				break;
			}
			else if(PanelContainsWhite(squares[i+1][distY]) == 1){
				history.add(squares[i+1][distY].getName());
				break;
			}
			else{
				history.add(squares[i+1][distY].getName());
			}
	
		}
		for(i= distX; i>0; i--){
			if(PanelContainsBlack(squares[i-1][distY]) == 1){
				break;
			}
			else if(PanelContainsWhite(squares[i-1][distY]) == 1){
				history.add(squares[i-1][distY].getName());
				break;
			}
			else{
				history.add(squares[i-1][distY].getName());
			}

		}
		for(i= distY; i<7; i++){

			if(PanelContainsBlack(squares[distX][i+1])== 1){
				break;
			}
			else if(PanelContainsWhite(squares[distX][i+1]) == 1){
				history.add(squares[distX][i+1].getName());		
				break;
			}
			else {
				history.add(squares[distX][i+1].getName());
			}
		}
		for(i= distY; i>0; i--){
			if(PanelContainsBlack(squares[distX][i-1])== 1){
				break;
			}
			else if(PanelContainsWhite(squares[distX][i-1]) == 1){
				history.add(squares[distX][i-1].getName());		
				break;
			}
			else {
				history.add(squares[distX][i-1].getName());
			}
		}
	} /* End Rook Move */
	public void BlackPawnPossible() {
		if(distX == 7){
			distX--;
		}
		if(PanelContainsBlack(squares[++distX][distY])== 0 && PanelContainsWhite(squares[distX][distY])== 0){
			history.add(squares[distX][distY].getName());
		}
		/* Taking White Pieces */
		if(distY == 0 ){
			if(PanelContainsWhite(squares[distX][distY+1]) == 1){
				history.add(squares[distX][distY+1].getName());
			}
		}
		else if(distY == 7 ){
			if(PanelContainsWhite(squares[distX][distY-1]) == 1){
				history.add(squares[distX][distY-1].getName());
			}
			
		}
		else {
			if(PanelContainsWhite(squares[distX][distY+1]) == 1){
				history.add(squares[distX][distY+1].getName());
			}
			if(PanelContainsWhite(squares[distX][distY-1]) == 1){
				history.add(squares[distX][distY-1].getName());
			}
		}

	}
	public void WhitePawnPossible() {
		if(distX == 0){
			distX++;
		}
		if(PanelContainsBlack(squares[--distX][distY])== 0 && PanelContainsWhite(squares[distX][distY])== 0){
			WhiteHistory.add(squares[distX][distY].getName());
		}
		/* Taking Black Piece */
		if(distY == 0 ){
			if(PanelContainsBlack(squares[distX][distY+1]) == 1){
				WhiteHistory.add(squares[distX][distY+1].getName());
			}
		}
		else if(distY == 7 ){
			if(PanelContainsBlack(squares[distX][distY-1]) == 1){
				WhiteHistory.add(squares[distX][distY-1].getName());
			}
		}
		else {
			if(PanelContainsBlack(squares[distX][distY+1]) == 1){
				WhiteHistory.add(squares[distX][distY+1].getName());
			}
			if(PanelContainsBlack(squares[distX][distY-1]) == 1){
				WhiteHistory.add(squares[distX][distY-1].getName());
			}
		}
		
	} /* End Both Pawn */
	
	public void BlackKingPossible() {
		int t =0, r =0;
		/* For straight position */
		
		if(distX==0 ){
			a = distX +1;
			c = distY;
		}
		else if(distX == 7){
			a = distX -1;
			c = distY;
		}
		else {
			a = distX+1;
			c = distY;
			if(PanelContainsBlack(squares[a][c]) == 1){
				
			}
			else if(PanelContainsWhite(squares[a][c]) == 1){
				history.add(squares[a][c].getName());
			}
			else {
				history.add(squares[a][c].getName());
			}
			a = distX -1;
			if(PanelContainsBlack(squares[a][c]) == 1){
				
			}
			else if(PanelContainsWhite(squares[a][c]) == 1){
				history.add(squares[a][c].getName());
			}
			else {
				history.add(squares[a][c].getName());
			}
			t = 1;
		}
		if(distY==0 ){
			b = distX;
			d = distY +1;
		}
		else if(distY == 7){
			b = distX;
			d = distY -1;
		}
		else {
			d = distY+1;
			b = distX;
			if(PanelContainsBlack(squares[b][d]) == 1){
				
			}
			else if(PanelContainsWhite(squares[b][d]) == 1){
				history.add(squares[b][d].getName());
			}
			else {
				history.add(squares[b][d].getName());
			}
			d = distY - 1;
			if(PanelContainsBlack(squares[b][d]) == 1){
				
			}
			else if(PanelContainsWhite(squares[b][d]) == 1){
				history.add(squares[b][d].getName());
			}
			else {
				history.add(squares[b][d].getName());
			}
			r = 1;
		}
		if(t == 0){
			if(PanelContainsBlack(squares[a][c]) == 1){
				
			}
			else if(PanelContainsWhite(squares[a][c]) == 1){
				history.add(squares[a][c].getName());
			}
			else {
				history.add(squares[a][c].getName());
			}
			
		}
		if(r == 0){
			if(PanelContainsBlack(squares[b][d]) == 1){
				
			}
			else if(PanelContainsWhite(squares[b][d]) == 1){
				history.add(squares[b][d].getName());
			}
			else {
				history.add(squares[b][d].getName());
			}
			
		}
		/* According to angle */
		if(distX != 7&& distX != 0 && distY != 7 && distY != 0){
			a = distX;
			b = distY;
			
			if(PanelContainsBlack(squares[a-1][b-1]) == 1){
				
			}
			else if(PanelContainsWhite(squares[a-1][b-1]) == 1){
				history.add(squares[a-1][b-1].getName());
			}
			else {
				history.add(squares[a-1][b-1].getName());
			}		

			if(PanelContainsBlack(squares[a+1][b+1]) == 1){
				
			}
			else if(PanelContainsWhite(squares[a+1][b+1]) == 1){
				history.add(squares[a+1][b+1].getName());
			}
			else {
				history.add(squares[a+1][b+1].getName());
			}
			
			if(PanelContainsBlack(squares[a-1][b+1]) == 1){
				
			}
			else if(PanelContainsWhite(squares[a-1][b+1]) == 1){
				history.add(squares[a-1][b+1].getName());
			}
			else {
				history.add(squares[a-1][b+1].getName());
			}
			
			if(PanelContainsBlack(squares[a+1][b-1]) == 1){
				
			}
			else if(PanelContainsWhite(squares[a+1][b-1]) == 1){
				history.add(squares[a+1][b-1].getName());
			}
			else {
				history.add(squares[a+1][b-1].getName());
			}
		}
		/* more condition  for corner side */
		else if(distX == 0){
			if(distY != 0 && distY != 7){
				/* Checking Piece Contain */
				if(PanelContainsBlack(squares[distX+1][distY-1]) == 1){
					
				}
				else if(PanelContainsWhite(squares[distX+1][distY-1]) == 1){
					history.add(squares[distX+1][distY-1].getName());
				}
				else{
					history.add(squares[distX+1][distY-1].getName());
				}
				
				if(PanelContainsBlack(squares[distX+1][distY+1]) == 1){
					
				}
				else if(PanelContainsWhite(squares[distX+1][distY+1]) == 1){
					history.add(squares[distX+1][distY+1].getName());
				}
				else{
					history.add(squares[distX+1][distY+1].getName());
				}
				
				
			}
			else if (distY == 0) {
				if(PanelContainsBlack(squares[distX+1][distY+1]) == 1){
					
				}
				else if(PanelContainsWhite(squares[distX+1][distY+1]) == 1){
					history.add(squares[distX+1][distY+1].getName());
				}
				else{
					history.add(squares[distX+1][distY+1].getName());
				}
				
			}
			else if (distY == 7) {
				if(PanelContainsBlack(squares[distX+1][distY-1]) == 1){
					
				}
				else if(PanelContainsWhite(squares[distX+1][distY-1]) == 1){
					history.add(squares[distX+1][distY-1].getName());
				}
				else{
					history.add(squares[distX+1][distY-1].getName());
				}
				
			}
		}
		else if(distX == 7){
			if(distY != 0 && distY != 7){
				if(PanelContainsBlack(squares[distX-1][distY-1]) == 1){
					
				}
				else if(PanelContainsWhite(squares[distX-1][distY-1]) == 1){
					history.add(squares[distX-1][distY-1].getName());
				}
				else{
					history.add(squares[distX-1][distY-1].getName());
				}
				
				if(PanelContainsBlack(squares[distX-1][distY+1]) == 1){
					
				}
				else if(PanelContainsWhite(squares[distX-1][distY+1]) == 1){
					history.add(squares[distX-1][distY+1].getName());
				}
				else{
					history.add(squares[distX-1][distY+1].getName());
				}
				
			}
			else if (distY == 0) {
				if(PanelContainsBlack(squares[distX-1][distY+1]) == 1){
					
				}
				else if(PanelContainsWhite(squares[distX-1][distY+1]) == 1){
					history.add(squares[distX-1][distY+1].getName());
				}
				else{
					history.add(squares[distX-1][distY+1].getName());
				}
				
			}
			else if (distY == 7) {
				if(PanelContainsBlack(squares[distX-1][distY-1]) == 1){
					
				}
				else if(PanelContainsWhite(squares[distX-1][distY-1]) == 1){
					history.add(squares[distX-1][distY-1].getName());
				}
				else{
					history.add(squares[distX-1][distY-1].getName());
				}
				
			}
		}
		/* For distY ( j ) */
		else if(distY == 0){
			if(distX != 0 && distX != 7){
				if(PanelContainsBlack(squares[distX-1][distY+1]) == 1){
					
				}
				else if(PanelContainsWhite(squares[distX-1][distY+1]) == 1){
					history.add(squares[distX-1][distY+1].getName());
				}
				else{
					history.add(squares[distX-1][distY+1].getName());
				}
				
				if(PanelContainsBlack(squares[distX+1][distY+1]) == 1){
					
				}
				else if(PanelContainsWhite(squares[distX+1][distY+1]) == 1){
					history.add(squares[distX+1][distY+1].getName());
				}
				else{
					history.add(squares[distX+1][distY+1].getName());
				}
				
			}
			else if (distX == 0) {
				if(PanelContainsBlack(squares[distX+1][distY+1]) == 1){
					
				}
				else if(PanelContainsWhite(squares[distX+1][distY+1]) == 1){
					history.add(squares[distX+1][distY+1].getName());
				}
				else{
					history.add(squares[distX+1][distY+1].getName());
				}
				
			}
			else if (distX == 7) {
				if(PanelContainsBlack(squares[distX-1][distY+1]) == 1){
					
				}
				else if(PanelContainsWhite(squares[distX-1][distY+1]) == 1){
					history.add(squares[distX-1][distY+1].getName());
				}
				else{
					history.add(squares[distX-1][distY+1].getName());
				}
				
			}
		}
		else if(distY == 7){
			if(distX != 0 && distX != 7){
				if(PanelContainsBlack(squares[distX-1][distY-1]) == 1){
					
				}
				else if(PanelContainsWhite(squares[distX-1][distY-1]) == 1){
					history.add(squares[distX-1][distY-1].getName());
				}
				else{
					history.add(squares[distX-1][distY-1].getName());
				}
				
				if(PanelContainsBlack(squares[distX+1][distY-1]) == 1){
					
				}
				else if(PanelContainsWhite(squares[distX+1][distY-1]) == 1){
					history.add(squares[distX+1][distY-1].getName());
				}
				else{
					history.add(squares[distX+1][distY-1].getName());
				}
				
			}
			else if (distX == 0) {
				if(PanelContainsBlack(squares[distX+1][distY-1]) == 1){
					
				}
				else if(PanelContainsWhite(squares[distX+1][distY-1]) == 1){
					history.add(squares[distX+1][distY-1].getName());
				}
				else{
					history.add(squares[distX+1][distY-1].getName());
				}
				
			}
			else if (distX == 7) {
				if(PanelContainsBlack(squares[distX-1][distY-1]) == 1){
					
				}
				else if(PanelContainsWhite(squares[distX-1][distY-1]) == 1){
					history.add(squares[distX-1][distY-1].getName());
				}
				else{
					history.add(squares[distX-1][distY-1].getName());
				}
			}
		}
	} /* End King move */
	
	public void WhiteKingPossible() {
		int t =0, r =0;
		/* For straight position */
		
		if(distX==0 ){
			a = distX +1;
			c = distY;
		}
		else if(distX == 7){
			a = distX -1;
			c = distY;
		}
		else {
			a = distX+1;
			c = distY;
			if(PanelContainsWhite(squares[a][c]) == 1){
				
			}
			else if(PanelContainsBlack(squares[a][c]) == 1){
				WhiteHistory.add(squares[a][c].getName());
			}
			else {
				WhiteHistory.add(squares[a][c].getName());
			}
			a = distX -1;
			if(PanelContainsWhite(squares[a][c]) == 1){
				
			}
			else if(PanelContainsBlack(squares[a][c]) == 1){
				WhiteHistory.add(squares[a][c].getName());
			}
			else {
				WhiteHistory.add(squares[a][c].getName());
			}
			t = 1;
		}
		if(distY==0 ){
			b = distX;
			d = distY +1;
		}
		else if(distY == 7){
			b = distX;
			d = distY -1;
		}
		else {
			d = distY+1;
			b = distX;
			if(PanelContainsWhite(squares[b][d]) == 1){
				
			}
			else if(PanelContainsBlack(squares[b][d]) == 1){
				WhiteHistory.add(squares[b][d].getName());
			}
			else {
				WhiteHistory.add(squares[b][d].getName());
			}
			d = distY - 1;
			if(PanelContainsWhite(squares[b][d]) == 1){
				
			}
			else if(PanelContainsBlack(squares[b][d]) == 1){
				WhiteHistory.add(squares[b][d].getName());
			}
			else {
				WhiteHistory.add(squares[b][d].getName());
			}
			r = 1;
		}
		if(t == 0){
			if(PanelContainsWhite(squares[a][c]) == 1){
				
			}
			else if(PanelContainsBlack(squares[a][c]) == 1){
				WhiteHistory.add(squares[a][c].getName());
			}
			else {
				WhiteHistory.add(squares[a][c].getName());
			}
			
		}
		if(r == 0){
			if(PanelContainsWhite(squares[b][d]) == 1){
				
			}
			else if(PanelContainsBlack(squares[b][d]) == 1){
				WhiteHistory.add(squares[b][d].getName());
			}
			else {
				WhiteHistory.add(squares[b][d].getName());
			}
			
		}
		/* According to angle */
		if(distX != 7&& distX != 0 && distY != 7 && distY != 0){
			a = distX;
			b = distY;
			
			if(PanelContainsWhite(squares[a-1][b-1]) == 1){
				
			}
			else if(PanelContainsBlack(squares[a-1][b-1]) == 1){
				WhiteHistory.add(squares[a-1][b-1].getName());
			}
			else {
				WhiteHistory.add(squares[a-1][b-1].getName());
			}		

			if(PanelContainsWhite(squares[a+1][b+1]) == 1){
				
			}
			else if(PanelContainsBlack(squares[a+1][b+1]) == 1){
				WhiteHistory.add(squares[a+1][b+1].getName());
			}
			else {
				WhiteHistory.add(squares[a+1][b+1].getName());
			}
			
			if(PanelContainsWhite(squares[a-1][b+1]) == 1){
				
			}
			else if(PanelContainsBlack(squares[a-1][b+1]) == 1){
				WhiteHistory.add(squares[a-1][b+1].getName());
			}
			else {
				WhiteHistory.add(squares[a-1][b+1].getName());
			}
			
			if(PanelContainsWhite(squares[a+1][b-1]) == 1){
				
			}
			else if(PanelContainsBlack(squares[a+1][b-1]) == 1){
				WhiteHistory.add(squares[a+1][b-1].getName());
			}
			else {
				WhiteHistory.add(squares[a+1][b-1].getName());
			}
		}
		/* more condition  for corner side */
		else if(distX == 0){
			if(distY != 0 && distY != 7){
				/* Checking Piece Contain */
				if(PanelContainsWhite(squares[distX+1][distY-1]) == 1){
					
				}
				else if(PanelContainsBlack(squares[distX+1][distY-1]) == 1){
					WhiteHistory.add(squares[distX+1][distY-1].getName());
				}
				else{
					WhiteHistory.add(squares[distX+1][distY-1].getName());
				}
				
				if(PanelContainsWhite(squares[distX+1][distY+1]) == 1){
					
				}
				else if(PanelContainsBlack(squares[distX+1][distY+1]) == 1){
					WhiteHistory.add(squares[distX+1][distY+1].getName());
				}
				else{
					WhiteHistory.add(squares[distX+1][distY+1].getName());
				}
				
				
			}
			else if (distY == 0) {
				if(PanelContainsWhite(squares[distX+1][distY+1]) == 1){
					
				}
				else if(PanelContainsBlack(squares[distX+1][distY+1]) == 1){
					WhiteHistory.add(squares[distX+1][distY+1].getName());
				}
				else{
					WhiteHistory.add(squares[distX+1][distY+1].getName());
				}
				
			}
			else if (distY == 7) {
				if(PanelContainsWhite(squares[distX+1][distY-1]) == 1){
					
				}
				else if(PanelContainsBlack(squares[distX+1][distY-1]) == 1){
					WhiteHistory.add(squares[distX+1][distY-1].getName());
				}
				else{
					WhiteHistory.add(squares[distX+1][distY-1].getName());
				}
				
			}
		}
		else if(distX == 7){
			if(distY != 0 && distY != 7){
				if(PanelContainsWhite(squares[distX-1][distY-1]) == 1){
					
				}
				else if(PanelContainsBlack(squares[distX-1][distY-1]) == 1){
					WhiteHistory.add(squares[distX-1][distY-1].getName());
				}
				else{
					WhiteHistory.add(squares[distX-1][distY-1].getName());
				}
				
				if(PanelContainsWhite(squares[distX-1][distY+1]) == 1){
					
				}
				else if(PanelContainsBlack(squares[distX-1][distY+1]) == 1){
					WhiteHistory.add(squares[distX-1][distY+1].getName());
				}
				else{
					WhiteHistory.add(squares[distX-1][distY+1].getName());
				}
				
			}
			else if (distY == 0) {
				if(PanelContainsWhite(squares[distX-1][distY+1]) == 1){
					
				}
				else if(PanelContainsBlack(squares[distX-1][distY+1]) == 1){
					WhiteHistory.add(squares[distX-1][distY+1].getName());
				}
				else{
					WhiteHistory.add(squares[distX-1][distY+1].getName());
				}
				
			}
			else if (distY == 7) {
				if(PanelContainsWhite(squares[distX-1][distY-1]) == 1){
					
				}
				else if(PanelContainsBlack(squares[distX-1][distY-1]) == 1){
					WhiteHistory.add(squares[distX-1][distY-1].getName());
				}
				else{
					WhiteHistory.add(squares[distX-1][distY-1].getName());
				}
				
			}
		}
		/* For distY ( j ) */
		else if(distY == 0){
			if(distX != 0 && distX != 7){
				if(PanelContainsWhite(squares[distX-1][distY+1]) == 1){
					
				}
				else if(PanelContainsBlack(squares[distX-1][distY+1]) == 1){
					WhiteHistory.add(squares[distX-1][distY+1].getName());
				}
				else{
					WhiteHistory.add(squares[distX-1][distY+1].getName());
				}
				
				if(PanelContainsWhite(squares[distX+1][distY+1]) == 1){
					
				}
				else if(PanelContainsBlack(squares[distX+1][distY+1]) == 1){
					WhiteHistory.add(squares[distX+1][distY+1].getName());
				}
				else{
					WhiteHistory.add(squares[distX+1][distY+1].getName());
				}
				
			}
			else if (distX == 0) {
				if(PanelContainsWhite(squares[distX+1][distY+1]) == 1){
					
				}
				else if(PanelContainsBlack(squares[distX+1][distY+1]) == 1){
					WhiteHistory.add(squares[distX+1][distY+1].getName());
				}
				else{
					WhiteHistory.add(squares[distX+1][distY+1].getName());
				}
				
			}
			else if (distX == 7) {
				if(PanelContainsWhite(squares[distX-1][distY+1]) == 1){
					
				}
				else if(PanelContainsBlack(squares[distX-1][distY+1]) == 1){
					WhiteHistory.add(squares[distX-1][distY+1].getName());
				}
				else{
					WhiteHistory.add(squares[distX-1][distY+1].getName());
				}
				
			}
		}
		else if(distY == 7){
			if(distX != 0 && distX != 7){
				if(PanelContainsWhite(squares[distX-1][distY-1]) == 1){
					
				}
				else if(PanelContainsBlack(squares[distX-1][distY-1]) == 1){
					WhiteHistory.add(squares[distX-1][distY-1].getName());
				}
				else{
					WhiteHistory.add(squares[distX-1][distY-1].getName());
				}
				
				if(PanelContainsWhite(squares[distX+1][distY-1]) == 1){
					
				}
				else if(PanelContainsBlack(squares[distX+1][distY-1]) == 1){
					WhiteHistory.add(squares[distX+1][distY-1].getName());
				}
				else{
					WhiteHistory.add(squares[distX+1][distY-1].getName());
				}
				
			}
			else if (distX == 0) {
				if(PanelContainsWhite(squares[distX+1][distY-1]) == 1){
					
				}
				else if(PanelContainsBlack(squares[distX+1][distY-1]) == 1){
					WhiteHistory.add(squares[distX+1][distY-1].getName());
				}
				else{
					WhiteHistory.add(squares[distX+1][distY-1].getName());
				}
				
			}
			else if (distX == 7) {
				if(PanelContainsWhite(squares[distX-1][distY-1]) == 1){
					
				}
				else if(PanelContainsBlack(squares[distX-1][distY-1]) == 1){
					WhiteHistory.add(squares[distX-1][distY-1].getName());
				}
				else{
					WhiteHistory.add(squares[distX-1][distY-1].getName());
				}
			}
		}
	} /* End White King move */

	public void BlackBishopPossible() {
		int i=0, j=0;
		
		/* according to i */
		if(distX < distY){
			i = distX;
			j = distY;
			for(; j<7; j++){
				if(PanelContainsBlack(squares[i+1][j+1]) == 1){
					break;
				}
				else if(PanelContainsWhite(squares[i+1][j+1]) == 1){
					history.add(squares[i+1][j+1].getName());
					break;
				}
				else{
					history.add(squares[i+1][j+1].getName());
				}
				i++;
			}
			j = distY;
			for(i = distX; i>0; i--){
				if(PanelContainsBlack(squares[i-1][j-1]) == 1){
					break;
				}
				else if(PanelContainsWhite(squares[i-1][j-1]) == 1){
					history.add(squares[i-1][j-1].getName());
					break;
				}
				else{
					history.add(squares[i-1][j-1].getName());
				}
				j--;
			}
		}
		/* according to j */
		else {
			i = distX;
			j = distY;
			for(; i<7; i++){
				if(PanelContainsBlack(squares[i+1][j+1]) == 1){
					break;
				}
				else if(PanelContainsWhite(squares[i+1][j+1]) == 1){
					history.add(squares[i+1][j+1].getName());
					break;
				}
				else{
					history.add(squares[i+1][j+1].getName());
				}
				j++;
			}
			i = distX;
			for(j = distY; j>0; j--){
				if(PanelContainsBlack(squares[i-1][j-1]) == 1){
					break;
				}
				else if(PanelContainsWhite(squares[i-1][j-1]) == 1){
					history.add(squares[i-1][j-1].getName());
					break;
				}
				else{
					history.add(squares[i-1][j-1].getName());
				}
				i--;
			}
		}
		/* 0,7 to 7,0*/
		if(distX+distY < 7){
			i = distX;
			j = distY;
			for(; i>0; i--){
				if(PanelContainsBlack(squares[i-1][j+1]) == 1){
					break;
				}
				else if(PanelContainsWhite(squares[i-1][j+1]) == 1){
					history.add(squares[i-1][j+1].getName());
					break;
				}
				else{
					history.add(squares[i-1][j+1].getName());
				}
				j++;
			}
			i = distX;
			for(j = distY; j>0; j--){
				if(PanelContainsBlack(squares[i+1][j-1]) == 1){
					break;
				}
				else if(PanelContainsWhite(squares[i+1][j-1]) == 1){
					history.add(squares[i+1][j-1].getName());
					break;
				}
				else{
					history.add(squares[i+1][j-1].getName());
				}
				i++;
			}
		}
		else{
			i = distX;
			j = distY;
			
			for(; i<7; i++){
				if(PanelContainsBlack(squares[i+1][j-1]) == 1){
					break;
				}
				else if(PanelContainsWhite(squares[i+1][j-1]) == 1){
					history.add(squares[i+1][j-1].getName());
					break;
				}
				else{
					history.add(squares[i+1][j-1].getName());
				}
				j--;
			}
			
			i = distX;
			j = distY;
			
			for(; j<7; j++){
				if(PanelContainsBlack(squares[i-1][j+1]) == 1){
					break;
				}
				else if(PanelContainsWhite(squares[i-1][j+1]) == 1){
					history.add(squares[i-1][j+1].getName());
					break;
				}
				else{
					history.add(squares[i-1][j+1].getName());
				}
				i--;
			}
			
			
		}
		
	} /* End Black BishpMove */
	
	public void WhiteBishopPossible() {
		int i=0, j=0;
		/* according to i */
		if(distX < distY){
			i = distX;
			j = distY;
			for(; j<7; j++){
				if(PanelContainsWhite(squares[i+1][j+1]) == 1){
					break;
				}
				else if(PanelContainsBlack(squares[i+1][j+1]) == 1){
					WhiteHistory.add(squares[i+1][j+1].getName());
					break;
				}
				else{
					WhiteHistory.add(squares[i+1][j+1].getName());
				}
				i++;
			}
			j = distY;
			for(i = distX; i>0; i--){
				if(PanelContainsWhite(squares[i-1][j-1]) == 1){
					break;
				}
				else if(PanelContainsBlack(squares[i-1][j-1]) == 1){
					WhiteHistory.add(squares[i-1][j-1].getName());
					break;
				}
				else{
					WhiteHistory.add(squares[i-1][j-1].getName());
				}
				j--;
			}
		}
		/* according to j */
		else {
			i = distX;
			j = distY;
			for(; i<7; i++){
				if(PanelContainsWhite(squares[i+1][j+1]) == 1){
					break;
				}
				else if(PanelContainsBlack(squares[i+1][j+1]) == 1){
					WhiteHistory.add(squares[i+1][j+1].getName());
					break;
				}
				else{
					WhiteHistory.add(squares[i+1][j+1].getName());
				}
				j++;
			}
			i = distX;
			for(j = distY; j>0; j--){
				if(PanelContainsWhite(squares[i-1][j-1]) == 1){
					break;
				}
				else if(PanelContainsBlack(squares[i-1][j-1]) == 1){
					WhiteHistory.add(squares[i-1][j-1].getName());
					break;
				}
				else{
					WhiteHistory.add(squares[i-1][j-1].getName());
				}
				i--;
			}
		}
		/* 0,7 to 7,0*/
		if(distX+distY < 7){
			i = distX;
			j = distY;
			
			for(; i>0; i--){
				if(PanelContainsWhite(squares[i-1][j+1]) == 1){
					break;
				}
				else if(PanelContainsBlack(squares[i-1][j+1]) == 1){
					WhiteHistory.add(squares[i-1][j+1].getName());
					break;
				}
				else{
					WhiteHistory.add(squares[i-1][j+1].getName());
				}
				j++;
			}
			i = distX;
			for(j = distY; j>0; j--){
				if(PanelContainsWhite(squares[i+1][j-1]) == 1){
					break;
				}
				else if(PanelContainsBlack(squares[i+1][j-1]) == 1){
					WhiteHistory.add(squares[i+1][j-1].getName());
					break;
				}
				else{
					WhiteHistory.add(squares[i+1][j-1].getName());
				}
				i++;
			}
		}
		else{
			i = distX;
			j = distY;
			
			for(; i<7; i++){
				if(PanelContainsWhite(squares[i+1][j-1]) == 1){
					break;
				}
				else if(PanelContainsBlack(squares[i+1][j-1]) == 1){
					WhiteHistory.add(squares[i+1][j-1].getName());
					break;
				}
				else{
					WhiteHistory.add(squares[i+1][j-1].getName());
				}
				j--;
			}
			
			i = distX;
			j = distY;
			
			for(; j<7; j++){
				if(PanelContainsWhite(squares[i-1][j+1]) == 1){
					break;
				}
				else if(PanelContainsBlack(squares[i-1][j+1]) == 1){
					WhiteHistory.add(squares[i-1][j+1].getName());
					break;
				}
				else{
					WhiteHistory.add(squares[i-1][j+1].getName());
				}
				i--;
			}

		}
		
	} /* End White BishpMove */
	
	public void WhiteRookPossible() {
		int i;
		
		for(i= distX; i<7; i++){
			if(PanelContainsWhite(squares[i+1][distY]) == 1){
				break;
			}
			else if(PanelContainsBlack(squares[i+1][distY])== 1){
				WhiteHistory.add(squares[i+1][distY].getName());
				break;
			}
			else{
				WhiteHistory.add(squares[i+1][distY].getName());
			}
	
		}
		for(i= distX; i>0; i--){
		
			if(PanelContainsWhite(squares[i-1][distY]) == 1){
				break;
			}
			else if(PanelContainsBlack(squares[i-1][distY])== 1){
				WhiteHistory.add(squares[i-1][distY].getName());
				break;
			}
			else{
				WhiteHistory.add(squares[i-1][distY].getName());
			}

		}
		for(i= distY; i<7; i++){
			
			if(PanelContainsWhite(squares[distX][i+1])== 1){
				break;
			}
			else if(PanelContainsBlack(squares[distX][i+1])== 1){
				WhiteHistory.add(squares[distX][i+1].getName());
				break;
			}
			else{
				WhiteHistory.add(squares[distX][i+1].getName());
			}
		
		}
		for(i= distY; i>0; i--){
			if(PanelContainsWhite(squares[distX][i-1])== 1){
				break;
			}
			else if(PanelContainsBlack(squares[distX][i-1])== 1){
				WhiteHistory.add(squares[distX][i-1].getName());
				break;
			}
			else{
				WhiteHistory.add(squares[distX][i-1].getName());
			}
		}
	} /* End White Rook Move */
	
	public void BlackKnightPossible() {
		int i = distX;
		int j = distY;
		
		if(i-1 >= 0 && j-2 >= 0){
			if(PanelContainsBlack(squares[i-1][j-2])== 1){
				
			}
			else{
				history.add(squares[i-1][j-2].getName());
			}
		}
		if(i-1 >= 0 && j+2 <= 7){
			if(PanelContainsBlack(squares[i-1][j+2]) == 1){
				
			}
			else{			
				history.add(squares[i-1][j+2].getName());
			}
		}
		if(i+1 <= 7 && j-2 >= 0){
			if(PanelContainsBlack(squares[i+1][j-2]) == 1){
				
			}
			else{			
				history.add(squares[i+1][j-2].getName());
			}
		}
		if(i+1 <= 7 && j+2 <= 7){
			if(PanelContainsBlack(squares[i+1][j+2]) == 1){
				
			}
			else{	
				history.add(squares[i+1][j+2].getName());
			}
		}
		if(i-2 >= 0 && j-1 >= 0){
			if(PanelContainsBlack(squares[i-2][j-1]) == 1){
				
			}
			else{	
				history.add(squares[i-2][j-1].getName());
			}
		}
		if(i-2 >= 0 && j+1 <= 7){
			if(PanelContainsBlack(squares[i-2][j+1]) == 1){
				
			}
			else{		
				history.add(squares[i-2][j+1].getName());
			}
		}
		if(i+2 <= 7 && j-1 >= 0){
			if(PanelContainsBlack(squares[i+2][j-1]) == 1){
				
			}
			else{		
				history.add(squares[i+2][j-1].getName());
			}
		}
		if(i+2 <= 7 && j+1 <= 7){
			if(PanelContainsBlack(squares[i+2][j+1]) == 1){
				
			}
			else{		
				history.add(squares[i+2][j+1].getName());
			}
		}
				
	} /* End Black Knight Move */
	
	public void WhiteKnightPossible() {
		int i = distX;
		int j = distY;
		
		if(i-1 >= 0 && j-2 >= 0){
			if(PanelContainsWhite(squares[i-1][j-2])== 1){
				
			}
			else{
				WhiteHistory.add(squares[i-1][j-2].getName());
			}
		}
		if(i-1 >= 0 && j+2 <= 7){
			if(PanelContainsWhite(squares[i-1][j+2]) == 1){
				
			}
			else{			
				WhiteHistory.add(squares[i-1][j+2].getName());
			}
		}
		if(i+1 <= 7 && j-2 >= 0){
			if(PanelContainsWhite(squares[i+1][j-2]) == 1){
				
			}
			else{			
				WhiteHistory.add(squares[i+1][j-2].getName());
			}
		}
		if(i+1 <= 7 && j+2 <= 7){
			if(PanelContainsWhite(squares[i+1][j+2]) == 1){
				
			}
			else{	
				WhiteHistory.add(squares[i+1][j+2].getName());
			}
		}
		if(i-2 >= 0 && j-1 >= 0){
			if(PanelContainsWhite(squares[i-2][j-1]) == 1){
				
			}
			else{		
				WhiteHistory.add(squares[i-2][j-1].getName());
			}
		}
		if(i-2 >= 0 && j+1 <= 7){
			if(PanelContainsWhite(squares[i-2][j+1]) == 1){
				
			}
			else{			
				WhiteHistory.add(squares[i-2][j+1].getName());
			}
		}
		if(i+2 <= 7 && j-1 >= 0){
			if(PanelContainsWhite(squares[i+2][j-1]) == 1){
				
			}
			else{		
				WhiteHistory.add(squares[i+2][j-1].getName());
			}
		}
		if(i+2 <= 7 && j+1 <= 7){
			if(PanelContainsWhite(squares[i+2][j+1]) == 1){
				
			}
			else{		
				WhiteHistory.add(squares[i+2][j+1].getName());
			}
		}
				
	} /* End Knight Move */
	
	public void WhiteGrasshoperPossible() {
		int i, j;
		
		
		for(i= distX; i<6; i++){

			if(PanelContainsBlack(squares[i+1][distY]) == 1 || PanelContainsWhite(squares[i+1][distY]) == 1){
				if(PanelContainsBlack(squares[i+2][distY]) == 1){
					WhiteHistory.add(squares[i+2][distY].getName());
				}
				else if(PanelContainsWhite(squares[i+2][distY]) == 0){
					WhiteHistory.add(squares[i+2][distY].getName());
				}
				break;
			}
	
		}
		for(i= distX; i>1; i--){
			if(PanelContainsBlack(squares[i-1][distY]) == 1 || PanelContainsWhite(squares[i-1][distY]) == 1){
				
				if(PanelContainsBlack(squares[i-2][distY]) == 1){
					WhiteHistory.add(squares[i-2][distY].getName());
				}
				else if(PanelContainsWhite(squares[i-2][distY]) == 0){
					WhiteHistory.add(squares[i-2][distY].getName());
				}
				break;
			}

		}
		for(i= distY; i<6; i++){

			if(PanelContainsBlack(squares[distX][i+1])== 1|| PanelContainsWhite(squares[distX][i+1]) == 1){
				
				if(PanelContainsBlack(squares[distX][i+2]) == 1){
					WhiteHistory.add(squares[distX][i+2].getName());	
				}
				else if(PanelContainsWhite(squares[distX][i+2]) == 0){
					WhiteHistory.add(squares[distX][i+2].getName());	
				}
				break;
			}

		}
		for(i= distY; i>1; i--){
			if(PanelContainsBlack(squares[distX][i-1])== 1|| PanelContainsWhite(squares[distX][i-1]) == 1){
				
				if(PanelContainsBlack(squares[distX][i-2]) == 1){
					WhiteHistory.add(squares[distX][i-2].getName());	
				}
				else if(PanelContainsWhite(squares[distX][i-2]) == 0){
					WhiteHistory.add(squares[distX][i-2].getName());	
				}
				break;
			}
		}
		/* End Rook side */
	
		
		/* Start Bishop side, according to i */

		if(distX < distY){
			i = distX;
			j = distY;
			for(; j<6; j++){
				if(PanelContainsWhite(squares[i+1][j+1]) == 1 || PanelContainsBlack(squares[i+1][j+1]) == 1){
					if(PanelContainsBlack(squares[i+2][j+2]) == 1){
						WhiteHistory.add(squares[i+2][j+2].getName());
					}
					else if(PanelContainsWhite(squares[i+2][j+2]) == 0){
						WhiteHistory.add(squares[i+2][j+2].getName());
					}
					break;
				}
				
				i++;
			}
			j = distY;
			for(i = distX; i>1; i--){
				if(PanelContainsWhite(squares[i-1][j-1]) == 1 || PanelContainsBlack(squares[i-1][j-1]) == 1){
					if(PanelContainsBlack(squares[i-2][j-2]) == 1){
						WhiteHistory.add(squares[i-2][j-2].getName());
					}
					else if(PanelContainsWhite(squares[i-2][j-2]) == 0){
						WhiteHistory.add(squares[i-2][j-2].getName());
						
					}
					break;
				}		
				j--;
			}
		}
		/* according to j */
		else {
			i = distX;
			j = distY;
			for(; i<6; i++){
				if(PanelContainsWhite(squares[i+1][j+1]) == 1 || PanelContainsBlack(squares[i+1][j+1]) == 1){
					if(PanelContainsBlack(squares[i+2][j+2]) == 1){
						WhiteHistory.add(squares[i+2][j+2].getName());
					}
					else if(PanelContainsWhite(squares[i+2][j+2]) == 0){
						WhiteHistory.add(squares[i+2][j+2].getName());
						
					}
					break;
				}
				
				j++;
			}
			i = distX;
			for(j = distY; j>1; j--){
				if(PanelContainsWhite(squares[i-1][j-1]) == 1 || PanelContainsBlack(squares[i-1][j-1]) == 1){
					if(PanelContainsBlack(squares[i-2][j-2]) == 1){
						WhiteHistory.add(squares[i-2][j-2].getName());
					}
					else if(PanelContainsWhite(squares[i-2][j-2]) == 0){
						WhiteHistory.add(squares[i-2][j-2].getName());
					}
					break;
				}
				
				i--;
			}
		}
		/* 0,7 to 7,0*/
		if(distX+distY < 7){
			i = distX;
			j = distY;
			
			for(; i>1; i--){
				if(PanelContainsWhite(squares[i-1][j+1]) == 1 || PanelContainsBlack(squares[i-1][j+1]) == 1){
					if(PanelContainsBlack(squares[i-2][j+2]) == 1){
						WhiteHistory.add(squares[i-2][j+2].getName());
					}
					else if(PanelContainsWhite(squares[i-2][j+2]) == 0){
						WhiteHistory.add(squares[i-2][j+2].getName());
					
					}
					break;
				}
				j++;
			}
			i = distX;
			for(j = distY; j>1; j--){
				if(PanelContainsWhite(squares[i+1][j-1]) == 1 || PanelContainsBlack(squares[i+1][j-1]) == 1){
					if(PanelContainsBlack(squares[i+2][j-2]) == 1){
						WhiteHistory.add(squares[i+2][j-2].getName());
					}
					else if(PanelContainsWhite(squares[i+2][j-2]) == 0){
						WhiteHistory.add(squares[i+2][j-2].getName());
					
					}
					break;
				}
				
				i++;
			}
		}
		else{
			i = distX;
			j = distY;
			
			for(; i<6; i++){
				if(PanelContainsWhite(squares[i+1][j-1]) == 1 || PanelContainsBlack(squares[i+1][j-1]) == 1){
					if(PanelContainsBlack(squares[i+2][j-2]) == 1){
						WhiteHistory.add(squares[i+2][j-2].getName());
					}
					else if(PanelContainsWhite(squares[i+2][j-2]) == 0){
						WhiteHistory.add(squares[i+2][j-2].getName());
					
					}
					break;
				}
				j--;
			}
			
			i = distX;
			j = distY;
			
			for(; j<6; j++){
				if(PanelContainsWhite(squares[i-1][j+1]) == 1 || PanelContainsBlack(squares[i-1][j+1]) == 1){
					if(PanelContainsBlack(squares[i-2][j+2]) == 1){
						WhiteHistory.add(squares[i-2][j+2].getName());
					}
					else if(PanelContainsWhite(squares[i-2][j+2]) == 0){
						WhiteHistory.add(squares[i-2][j+2].getName());
						
					}
					break;
				}
				i--;
			}

		}
	} /* End Grasshopper Move */
	public void BlackGrasshoperPossible() {
		int i, j;
		
		
		for(i= distX; i<6; i++){

			if(PanelContainsBlack(squares[i+1][distY]) == 1 || PanelContainsWhite(squares[i+1][distY]) == 1){
				if(PanelContainsWhite(squares[i+2][distY]) == 1){
					history.add(squares[i+2][distY].getName());
				}
				else if(PanelContainsBlack(squares[i+2][distY]) == 0){
					history.add(squares[i+2][distY].getName());
				}
				break;
			}
	
		}
		for(i= distX; i>1; i--){
			if(PanelContainsBlack(squares[i-1][distY]) == 1 || PanelContainsWhite(squares[i-1][distY]) == 1){
				
				if(PanelContainsWhite(squares[i-2][distY]) == 1){
					history.add(squares[i-2][distY].getName());
				}
				else if(PanelContainsBlack(squares[i-2][distY]) == 0){
					history.add(squares[i-2][distY].getName());
				}
				break;
			}

		}
		for(i= distY; i<6; i++){

			if(PanelContainsBlack(squares[distX][i+1])== 1|| PanelContainsWhite(squares[distX][i+1]) == 1){
				
				if(PanelContainsWhite(squares[distX][i+2]) == 1){
					history.add(squares[distX][i+2].getName());	
				}
				else if(PanelContainsBlack(squares[distX][i+2]) == 0){
					history.add(squares[distX][i+2].getName());	
				}
				break;
			}

		}
		for(i= distY; i>1; i--){
			if(PanelContainsBlack(squares[distX][i-1])== 1|| PanelContainsWhite(squares[distX][i-1]) == 1){
				
				if(PanelContainsWhite(squares[distX][i-2]) == 1){
					history.add(squares[distX][i-2].getName());	
				}
				else if(PanelContainsBlack(squares[distX][i-2]) == 0){
					history.add(squares[distX][i-2].getName());	
				}
				break;
			}
		}
		/* End Rook side */
	
		
		/* Start Bishop side, according to i */

		if(distX < distY){
			i = distX;
			j = distY;
			for(; j<6; j++){
				if(PanelContainsWhite(squares[i+1][j+1]) == 1 || PanelContainsBlack(squares[i+1][j+1]) == 1){
					if(PanelContainsWhite(squares[i+2][j+2]) == 1){
						history.add(squares[i+2][j+2].getName());
					}
					else if(PanelContainsBlack(squares[i+2][j+2]) == 0){
						history.add(squares[i+2][j+2].getName());
					}
					break;
				}
				
				i++;
			}
			j = distY;
			for(i = distX; i>1; i--){
				if(PanelContainsWhite(squares[i-1][j-1]) == 1 || PanelContainsBlack(squares[i-1][j-1]) == 1){
					if(PanelContainsWhite(squares[i-2][j-2]) == 1){
						history.add(squares[i-2][j-2].getName());
					}
					else if(PanelContainsBlack(squares[i-2][j-2]) == 0){
						history.add(squares[i-2][j-2].getName());
						
					}
					break;
				}		
				j--;
			}
		}
		/* according to j */
		else {
			i = distX;
			j = distY;
			for(; i<6; i++){
				if(PanelContainsWhite(squares[i+1][j+1]) == 1 || PanelContainsBlack(squares[i+1][j+1]) == 1){
					if(PanelContainsWhite(squares[i+2][j+2]) == 1){
						history.add(squares[i+2][j+2].getName());
					}
					else if(PanelContainsBlack(squares[i+2][j+2]) == 0){
						history.add(squares[i+2][j+2].getName());
						
					}
					break;
				}
				
				j++;
			}
			i = distX;
			for(j = distY; j>1; j--){
				if(PanelContainsWhite(squares[i-1][j-1]) == 1 || PanelContainsBlack(squares[i-1][j-1]) == 1){
					if(PanelContainsWhite(squares[i-2][j-2]) == 1){
						history.add(squares[i-2][j-2].getName());
					}
					else if(PanelContainsBlack(squares[i-2][j-2]) == 0){
						history.add(squares[i-2][j-2].getName());
					}
					break;
				}
				
				i--;
			}
		}
		/* 0,7 to 7,0*/
		if(distX+distY < 7){
			i = distX;
			j = distY;
			
			for(; i>1; i--){
				if(PanelContainsWhite(squares[i-1][j+1]) == 1 || PanelContainsBlack(squares[i-1][j+1]) == 1){
					if(PanelContainsWhite(squares[i-2][j+2]) == 1){
						history.add(squares[i-2][j+2].getName());
					}
					else if(PanelContainsBlack(squares[i-2][j+2]) == 0){
						history.add(squares[i-2][j+2].getName());
					
					}
					break;
				}
				j++;
			}
			i = distX;
			for(j = distY; j>1; j--){
				if(PanelContainsWhite(squares[i+1][j-1]) == 1 || PanelContainsBlack(squares[i+1][j-1]) == 1){
					if(PanelContainsWhite(squares[i+2][j-2]) == 1){
						history.add(squares[i+2][j-2].getName());
					}
					else if(PanelContainsBlack(squares[i+2][j-2]) == 0){
						history.add(squares[i+2][j-2].getName());
					
					}
					break;
				}
				
				i++;
			}
		}
		else{
			i = distX;
			j = distY;
			
			for(; i<6; i++){
				if(PanelContainsWhite(squares[i+1][j-1]) == 1 || PanelContainsBlack(squares[i+1][j-1]) == 1){
					if(PanelContainsWhite(squares[i+2][j-2]) == 1){
						history.add(squares[i+2][j-2].getName());
					}
					else if(PanelContainsBlack(squares[i+2][j-2]) == 0){
						history.add(squares[i+2][j-2].getName());
					
					}
					break;
				}
				j--;
			}
			
			i = distX;
			j = distY;
			
			for(; j<6; j++){
				if(PanelContainsWhite(squares[i-1][j+1]) == 1 || PanelContainsBlack(squares[i-1][j+1]) == 1){
					if(PanelContainsWhite(squares[i-2][j+2]) == 1){
						history.add(squares[i-2][j+2].getName());
					}
					else if(PanelContainsBlack(squares[i-2][j+2]) == 0){
						history.add(squares[i-2][j+2].getName());
						
					}
					break;
				}
				i--;
			}

		}
	} /* End Black Grasshoper */
	


	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand() == "New Game"){
			getBoard().dispose();
	
			ChessBoard MainBoard = new ChessBoard();
		 	MainBoard.addPanel();
			MainBoard.createSquares();
			MainBoard.RandomlyAddPieces();
			MainBoard.showBoard();
		}
		if(ae.getActionCommand() == "About"){
			JOptionPane.showMessageDialog(null, "Author: Kawsar Ahmed (ProKawsar)\n"
					+ "App Catagory: Game\nCreate Date:   04.04.16", "About", 1);
		}
		if(ae.getActionCommand() == "Exit"){
			int n = JOptionPane.showConfirmDialog(  
	                null,
	                "Are you sure want to Exit?" ,
	                "",
	                JOptionPane.YES_NO_OPTION);

	      if(n == JOptionPane.YES_OPTION)
	      {
	    	  System.exit(1);
	      }
	      else
	      {
	  		
	      }
		}
	}


	
}
