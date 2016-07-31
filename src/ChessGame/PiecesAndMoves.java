package ChessGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



class PiecesAndMoves extends AllMoveAbs {
	
	protected int distX, distY, Found;
	protected int a, b, c, d;
	
	protected String str;
	protected JLabel Value ;
	protected Vector<String> v = new Vector<String>();
	protected Vector<String> history = new Vector<String>();
	protected Vector<String> WhiteHistory = new Vector<String>();
	protected JPanel[][] squares = new JPanel[8][8];
    protected ArrayList<Integer> num = new ArrayList<Integer>(); 
    protected static final Color LIGHT = new Color(248, 248, 248);
    protected static final Color DARK = new Color(178,	76,	71);


    protected static final Color SELECT = new Color(8421616);
    protected JFrame SideBar = new JFrame("Details");
    
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
    
    private JFrame Board = new JFrame();
	
	public JFrame getBoard() {
		return Board;
	}

	public void setBoard(JFrame board) {
		Board = board;
	}

	public void SidePane() {
		title.setSize(100, 20);
		title.setFont(new Font("Serif", Font.PLAIN, 18));
		title.setLocation(20, 30);
		title.setForeground(Color.BLUE);
		
		PlayerTurn.setSize(100, 20);
		PlayerTurn.setLocation(100, 30);
		PlayerTurn.setFont(new Font("Serif", Font.PLAIN, 18));
		
		Check.setSize(150, 20);
		Check.setLocation(25, 60);
		Check.setForeground(new Color(255, 20, 150));
		Check.setFont(new Font("Serif", Font.BOLD, 18));

		
		newGame.setSize(100, 30);
		newGame.setLocation(60, 120);
		
		
		about.setSize(100, 30);
		about.setLocation(60, 220);
	
		exit.setSize(100, 30);
		exit.setLocation(60, 320);
		
		newGame.addActionListener((ActionListener) this);
		about.addActionListener((ActionListener) this);
		exit.addActionListener((ActionListener) this);

	}

    @SuppressWarnings({ "unchecked", "rawtypes" })
	Map<Integer, JLabel> FairyPiece = new HashMap();
    {
    		FairyPiece.put(1, Princess);
    		FairyPiece.put(2, Empress);
    		FairyPiece.put(3, Grass);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	Map<Integer, JLabel> FairyPieceWhite = new HashMap();
    {
    		FairyPieceWhite.put(1, WhitePrincess);
    		FairyPieceWhite.put(2, WhiteEmpress);
    		FairyPieceWhite.put(3, WhiteGrass);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	Map<Integer, JLabel> Blackbox = new HashMap();
    {
    		Blackbox.put(1, label);
    		Blackbox.put(2, label2);
    		Blackbox.put(3, label3);
    		Blackbox.put(4, label4);
    		Blackbox.put(5, label5);
    		Blackbox.put(6, label6);
    		Blackbox.put(7, label7);
    		Blackbox.put(8, label8);
    		
    		Blackbox.put(9, label9);
    		Blackbox.put(10, label10);
    		Blackbox.put(11, label11);
    		Blackbox.put(12, label12);
    		Blackbox.put(13, label13);
    		Blackbox.put(14, label14);
    		Blackbox.put(15, label15);
    		Blackbox.put(16, label16);
    		
    		Blackbox.put(17, Empress);
    		Blackbox.put(18, Princess);
    		Blackbox.put(19, Grass);
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	Map<Integer, JLabel> Whitebox = new HashMap();
    {
    	Whitebox.put(1, lbl);
    	Whitebox.put(2, lbl2);
    	Whitebox.put(3, lbl3);
    	Whitebox.put(4, lbl4);
    	Whitebox.put(5, lbl5);
    	Whitebox.put(6, lbl6);
    	Whitebox.put(7, lbl7);
    	Whitebox.put(8, lbl8);
    		
    	Whitebox.put(9, lbl9);
    	Whitebox.put(10, lbl10);
    	Whitebox.put(11, lbl11);
    	Whitebox.put(12, lbl12);
    	Whitebox.put(13, lbl13);
    	Whitebox.put(14, lbl14);
    	Whitebox.put(15, lbl15);
    	Whitebox.put(16, lbl16);
    	
    	Whitebox.put(17, WhiteEmpress);
    	Whitebox.put(18, WhitePrincess);
    	Whitebox.put(19, WhiteGrass);
    }
    /* Storing every Label in Map */
    @SuppressWarnings({ "rawtypes", "unchecked" })
   	Map<String, JLabel> Blacklabels = new HashMap();
       {
       	
       	Blacklabels.put("label", label);
       	Blacklabels.put("label2", label2);
       	Blacklabels.put("label3", label3);
       	Blacklabels.put("label4", label4);
       	Blacklabels.put("label5", label5);
       	Blacklabels.put("label6", label6);
       	Blacklabels.put("label7", label7);
       	Blacklabels.put("label8", label8);
       	Blacklabels.put("label9", label9);
       	Blacklabels.put("label10", label10);
       	Blacklabels.put("label11", label11);
       	Blacklabels.put("label12", label12);
       	Blacklabels.put("label13", label13);
       	Blacklabels.put("label14", label14);
       	Blacklabels.put("label15", label15);
       	Blacklabels.put("label16", label16);
       	
       	Blacklabels.put("label17", Princess);
       	Blacklabels.put("label18", Empress);
       	Blacklabels.put("label19", Grass);

       }
 
       @SuppressWarnings({ "rawtypes", "unchecked" })
      	Map<String, JLabel> Whitelabels = new HashMap();
         {
      	Whitelabels.put("label20", lbl);
       	Whitelabels.put("label21", lbl2);
       	Whitelabels.put("label22", lbl3);
       	Whitelabels.put("label23", lbl4);
       	Whitelabels.put("label24", lbl5);
       	Whitelabels.put("label25", lbl6);
       	Whitelabels.put("label26", lbl7);
       	Whitelabels.put("label27", lbl8);
       	Whitelabels.put("label28", lbl9);
       	Whitelabels.put("label29", lbl10);
       	Whitelabels.put("label30", lbl11);
       	Whitelabels.put("label31", lbl12);
       	Whitelabels.put("label32", lbl13);
       	Whitelabels.put("label33", lbl14);
       	Whitelabels.put("label34", lbl15);
       	Whitelabels.put("label35", lbl16);
       	
       	Whitelabels.put("label36", WhiteEmpress);
       	Whitelabels.put("label37", WhitePrincess);
        Whitelabels.put("label38", WhiteGrass);
        
      }
        /* Set name for Every label */
    public void LabelName() {

		label.setName("label");
		label2.setName("label2");
		label3.setName("label3");
		label4.setName("label4");
		label5.setName("label5");
		label6.setName("label6");
		label7.setName("label7");
		label8.setName("label8");
		label9.setName("label9");
		label10.setName("label10");
		label11.setName("label11");
		label12.setName("label12");
		label13.setName("label13");
		label14.setName("label14");
		label15.setName("label15");
		label16.setName("label16");
		
		Princess.setName("label17");
		Empress.setName("label18");
		Grass.setName("label19");

		lbl.setName("label20");
		lbl2.setName("label21");
		lbl3.setName("label22");
		lbl4.setName("label23");
		lbl5.setName("label24");
		lbl6.setName("label25");
		lbl7.setName("label26");
		lbl8.setName("label27");
		lbl9.setName("label28");
		lbl10.setName("label29");
		lbl11.setName("label30");
		lbl12.setName("label31");
		lbl13.setName("label32");
		lbl14.setName("label33");
		lbl15.setName("label34");
		lbl16.setName("label35");
		
		WhiteEmpress.setName("label36");
		WhitePrincess.setName("label37");
		WhiteGrass.setName("label38");
    }


	
    
	public void BlackPawn() {
		try {
			squares[distX][distY].setBackground(SELECT);

		} catch (Exception e) {
			squares[0][0].setBackground(SELECT);
		}
		if(distX == 7){
			distX--;
		}
		if(PanelContainsBlack(squares[++distX][distY])== 0 && PanelContainsWhite(squares[distX][distY])== 0){
			squares[distX][distY].setBackground(SELECT);
			v.add(squares[distX][distY].getName());
		
		}
		/* Taking White Pieces */
		if(distY == 0 ){
			if(PanelContainsWhite(squares[distX][distY+1]) == 1){
				squares[distX][distY+1].setBackground(SELECT);
				v.add(squares[distX][distY+1].getName());
		
			}
		}
		else if(distY == 7 ){
			if(PanelContainsWhite(squares[distX][distY-1]) == 1){
				squares[distX][distY-1].setBackground(SELECT);
				v.add(squares[distX][distY-1].getName());
	
			}
			
		}
		else {
			if(PanelContainsWhite(squares[distX][distY+1]) == 1){
				squares[distX][distY+1].setBackground(SELECT);
				v.add(squares[distX][distY+1].getName());
	
			}
			if(PanelContainsWhite(squares[distX][distY-1]) == 1){
				squares[distX][distY-1].setBackground(SELECT);
				v.add(squares[distX][distY-1].getName());

			}
		}
		

	}
	public void WhitePawn() {
		squares[distX][distY].setBackground(SELECT);
		if(distX == 0){
			distX++;
		}
		if(PanelContainsBlack(squares[--distX][distY])== 0 && PanelContainsWhite(squares[distX][distY])== 0){
			squares[distX][distY].setBackground(SELECT);
			v.add(squares[distX][distY].getName());
		}
		/* Taking Black Piece */
		if(distY == 0 ){
			if(PanelContainsBlack(squares[distX][distY+1]) == 1){
				squares[distX][distY+1].setBackground(SELECT);
				v.add(squares[distX][distY+1].getName());
			}
		}
		else if(distY == 7 ){
			if(PanelContainsBlack(squares[distX][distY-1]) == 1){
				squares[distX][distY-1].setBackground(SELECT);
				v.add(squares[distX][distY-1].getName());
			}
		}
		else {
			if(PanelContainsBlack(squares[distX][distY+1]) == 1){
				squares[distX][distY+1].setBackground(SELECT);
				v.add(squares[distX][distY+1].getName());
			}
			if(PanelContainsBlack(squares[distX][distY-1]) == 1){
				squares[distX][distY-1].setBackground(SELECT);
				v.add(squares[distX][distY-1].getName());
			}
		}
		
		
		
	} /* End Both Pawn */
	
	public void BlackKingMove() {
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
				squares[a][c].setBackground(SELECT);
				v.add(squares[a][c].getName());
			}
			else {
				squares[a][c].setBackground(SELECT);
				v.add(squares[a][c].getName());
			}
			a = distX -1;
			if(PanelContainsBlack(squares[a][c]) == 1){
				
			}
			else if(PanelContainsWhite(squares[a][c]) == 1){
				squares[a][c].setBackground(SELECT);
				v.add(squares[a][c].getName());
			}
			else {
				squares[a][c].setBackground(SELECT);
				v.add(squares[a][c].getName());
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
				squares[b][d].setBackground(SELECT);
				v.add(squares[b][d].getName());
			}
			else {
				squares[b][d].setBackground(SELECT);
				v.add(squares[b][d].getName());
			}
			d = distY - 1;
			if(PanelContainsBlack(squares[b][d]) == 1){
				
			}
			else if(PanelContainsWhite(squares[b][d]) == 1){
				squares[b][d].setBackground(SELECT);
				v.add(squares[b][d].getName());
			}
			else {
				squares[b][d].setBackground(SELECT);
				v.add(squares[b][d].getName());
			}
			r = 1;
		}
		if(t == 0){
			if(PanelContainsBlack(squares[a][c]) == 1){
				
			}
			else if(PanelContainsWhite(squares[a][c]) == 1){
				squares[a][c].setBackground(SELECT);
				v.add(squares[a][c].getName());
			}
			else {
				squares[a][c].setBackground(SELECT);
				v.add(squares[a][c].getName());
			}
			
		}
		if(r == 0){
			if(PanelContainsBlack(squares[b][d]) == 1){
				
			}
			else if(PanelContainsWhite(squares[b][d]) == 1){
				squares[b][d].setBackground(SELECT);
				v.add(squares[b][d].getName());
			}
			else {
				squares[b][d].setBackground(SELECT);
				v.add(squares[b][d].getName());
			}
			
		}
		/* According to angle */
		if(distX != 7&& distX != 0 && distY != 7 && distY != 0){
			a = distX;
			b = distY;
			
			if(PanelContainsBlack(squares[a-1][b-1]) == 1){
				
			}
			else if(PanelContainsWhite(squares[a-1][b-1]) == 1){
				squares[a-1][b-1].setBackground(SELECT);
				v.add(squares[a-1][b-1].getName());
			}
			else {
				squares[a-1][b-1].setBackground(SELECT);
				v.add(squares[a-1][b-1].getName());
			}		

			if(PanelContainsBlack(squares[a+1][b+1]) == 1){
				
			}
			else if(PanelContainsWhite(squares[a+1][b+1]) == 1){
				squares[a+1][b+1].setBackground(SELECT);
				v.add(squares[a+1][b+1].getName());
			}
			else {
				squares[a+1][b+1].setBackground(SELECT);
				v.add(squares[a+1][b+1].getName());
			}
			
			if(PanelContainsBlack(squares[a-1][b+1]) == 1){
				
			}
			else if(PanelContainsWhite(squares[a-1][b+1]) == 1){
				squares[a-1][b+1].setBackground(SELECT);
				v.add(squares[a-1][b+1].getName());
			}
			else {
				squares[a-1][b+1].setBackground(SELECT);
				v.add(squares[a-1][b+1].getName());
			}
			
			if(PanelContainsBlack(squares[a+1][b-1]) == 1){
				
			}
			else if(PanelContainsWhite(squares[a+1][b-1]) == 1){
				squares[a+1][b-1].setBackground(SELECT);
				v.add(squares[a+1][b-1].getName());
			}
			else {
				squares[a+1][b-1].setBackground(SELECT);
				v.add(squares[a+1][b-1].getName());
			}
		}
		/* more condition  for corner side */
		else if(distX == 0){
			if(distY != 0 && distY != 7){
				/* Checking Piece Contain */
				if(PanelContainsBlack(squares[distX+1][distY-1]) == 1){
					
				}
				else if(PanelContainsWhite(squares[distX+1][distY-1]) == 1){
					squares[distX+1][distY-1].setBackground(SELECT);
					v.add(squares[distX+1][distY-1].getName());
				}
				else{
					squares[distX+1][distY-1].setBackground(SELECT);
					v.add(squares[distX+1][distY-1].getName());
				}
				
				if(PanelContainsBlack(squares[distX+1][distY+1]) == 1){
					
				}
				else if(PanelContainsWhite(squares[distX+1][distY+1]) == 1){
					squares[distX+1][distY+1].setBackground(SELECT);
					v.add(squares[distX+1][distY+1].getName());
				}
				else{
					squares[distX+1][distY+1].setBackground(SELECT);
					v.add(squares[distX+1][distY+1].getName());
				}
				
				
			}
			else if (distY == 0) {
				if(PanelContainsBlack(squares[distX+1][distY+1]) == 1){
					
				}
				else if(PanelContainsWhite(squares[distX+1][distY+1]) == 1){
					squares[distX+1][distY+1].setBackground(SELECT);
					v.add(squares[distX+1][distY+1].getName());
				}
				else{
					squares[distX+1][distY+1].setBackground(SELECT);
					v.add(squares[distX+1][distY+1].getName());
				}
				
			}
			else if (distY == 7) {
				if(PanelContainsBlack(squares[distX+1][distY-1]) == 1){
					
				}
				else if(PanelContainsWhite(squares[distX+1][distY-1]) == 1){
					squares[distX+1][distY-1].setBackground(SELECT);
					v.add(squares[distX+1][distY-1].getName());
				}
				else{
					squares[distX+1][distY-1].setBackground(SELECT);
					v.add(squares[distX+1][distY-1].getName());
				}
				
			}
		}
		else if(distX == 7){
			if(distY != 0 && distY != 7){
				if(PanelContainsBlack(squares[distX-1][distY-1]) == 1){
					
				}
				else if(PanelContainsWhite(squares[distX-1][distY-1]) == 1){
					squares[distX-1][distY-1].setBackground(SELECT);
					v.add(squares[distX-1][distY-1].getName());
				}
				else{
					squares[distX-1][distY-1].setBackground(SELECT);
					v.add(squares[distX-1][distY-1].getName());
				}
				
				if(PanelContainsBlack(squares[distX-1][distY+1]) == 1){
					
				}
				else if(PanelContainsWhite(squares[distX-1][distY+1]) == 1){
					squares[distX-1][distY+1].setBackground(SELECT);
					v.add(squares[distX-1][distY+1].getName());
				}
				else{
					squares[distX-1][distY+1].setBackground(SELECT);
					v.add(squares[distX-1][distY+1].getName());
				}
				
			}
			else if (distY == 0) {
				if(PanelContainsBlack(squares[distX-1][distY+1]) == 1){
					
				}
				else if(PanelContainsWhite(squares[distX-1][distY+1]) == 1){
					squares[distX-1][distY+1].setBackground(SELECT);
					v.add(squares[distX-1][distY+1].getName());
				}
				else{
					squares[distX-1][distY+1].setBackground(SELECT);
					v.add(squares[distX-1][distY+1].getName());
				}
				
			}
			else if (distY == 7) {
				if(PanelContainsBlack(squares[distX-1][distY-1]) == 1){
					
				}
				else if(PanelContainsWhite(squares[distX-1][distY-1]) == 1){
					squares[distX-1][distY-1].setBackground(SELECT);
					v.add(squares[distX-1][distY-1].getName());
				}
				else{
					squares[distX-1][distY-1].setBackground(SELECT);
					v.add(squares[distX-1][distY-1].getName());
				}
				
			}
		}
		/* For distY ( j ) */
		else if(distY == 0){
			if(distX != 0 && distX != 7){
				if(PanelContainsBlack(squares[distX-1][distY+1]) == 1){
					
				}
				else if(PanelContainsWhite(squares[distX-1][distY+1]) == 1){
					squares[distX-1][distY+1].setBackground(SELECT);
					v.add(squares[distX-1][distY+1].getName());
				}
				else{
					squares[distX-1][distY+1].setBackground(SELECT);
					v.add(squares[distX-1][distY+1].getName());
				}
				
				if(PanelContainsBlack(squares[distX+1][distY+1]) == 1){
					
				}
				else if(PanelContainsWhite(squares[distX+1][distY+1]) == 1){
					squares[distX+1][distY+1].setBackground(SELECT);
					v.add(squares[distX+1][distY+1].getName());
				}
				else{
					squares[distX+1][distY+1].setBackground(SELECT);
					v.add(squares[distX+1][distY+1].getName());
				}
				
			}
			else if (distX == 0) {
				if(PanelContainsBlack(squares[distX+1][distY+1]) == 1){
					
				}
				else if(PanelContainsWhite(squares[distX+1][distY+1]) == 1){
					squares[distX+1][distY+1].setBackground(SELECT);
					v.add(squares[distX+1][distY+1].getName());
				}
				else{
					squares[distX+1][distY+1].setBackground(SELECT);
					v.add(squares[distX+1][distY+1].getName());
				}
				
			}
			else if (distX == 7) {
				if(PanelContainsBlack(squares[distX-1][distY+1]) == 1){
					
				}
				else if(PanelContainsWhite(squares[distX-1][distY+1]) == 1){
					squares[distX-1][distY+1].setBackground(SELECT);
					v.add(squares[distX-1][distY+1].getName());
				}
				else{
					squares[distX-1][distY+1].setBackground(SELECT);
					v.add(squares[distX-1][distY+1].getName());
				}
				
			}
		}
		else if(distY == 7){
			if(distX != 0 && distX != 7){
				if(PanelContainsBlack(squares[distX-1][distY-1]) == 1){
					
				}
				else if(PanelContainsWhite(squares[distX-1][distY-1]) == 1){
					squares[distX-1][distY-1].setBackground(SELECT);
					v.add(squares[distX-1][distY-1].getName());
				}
				else{
					squares[distX-1][distY-1].setBackground(SELECT);
					v.add(squares[distX-1][distY-1].getName());
				}
				
				if(PanelContainsBlack(squares[distX+1][distY-1]) == 1){
					
				}
				else if(PanelContainsWhite(squares[distX+1][distY-1]) == 1){
					squares[distX+1][distY-1].setBackground(SELECT);
					v.add(squares[distX+1][distY-1].getName());
				}
				else{
					squares[distX+1][distY-1].setBackground(SELECT);
					v.add(squares[distX+1][distY-1].getName());
				}
				
			}
			else if (distX == 0) {
				if(PanelContainsBlack(squares[distX+1][distY-1]) == 1){
					
				}
				else if(PanelContainsWhite(squares[distX+1][distY-1]) == 1){
					squares[distX+1][distY-1].setBackground(SELECT);
					v.add(squares[distX+1][distY-1].getName());
				}
				else{
					squares[distX+1][distY-1].setBackground(SELECT);
					v.add(squares[distX+1][distY-1].getName());
				}
				
			}
			else if (distX == 7) {
				if(PanelContainsBlack(squares[distX-1][distY-1]) == 1){
					
				}
				else if(PanelContainsWhite(squares[distX-1][distY-1]) == 1){
					squares[distX-1][distY-1].setBackground(SELECT);
					v.add(squares[distX-1][distY-1].getName());
				}
				else{
					squares[distX-1][distY-1].setBackground(SELECT);
					v.add(squares[distX-1][distY-1].getName());
				}
			}
		}
	} /* End King move */
	
	public void WhiteKingMove() {
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
				squares[a][c].setBackground(SELECT);
				v.add(squares[a][c].getName());
			}
			else {
				squares[a][c].setBackground(SELECT);
				v.add(squares[a][c].getName());
			}
			a = distX -1;
			if(PanelContainsWhite(squares[a][c]) == 1){
				
			}
			else if(PanelContainsBlack(squares[a][c]) == 1){
				squares[a][c].setBackground(SELECT);
				v.add(squares[a][c].getName());
			}
			else {
				squares[a][c].setBackground(SELECT);
				v.add(squares[a][c].getName());
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
				squares[b][d].setBackground(SELECT);
				v.add(squares[b][d].getName());
			}
			else {
				squares[b][d].setBackground(SELECT);
				v.add(squares[b][d].getName());
			}
			d = distY - 1;
			if(PanelContainsWhite(squares[b][d]) == 1){
				
			}
			else if(PanelContainsBlack(squares[b][d]) == 1){
				squares[b][d].setBackground(SELECT);
				v.add(squares[b][d].getName());
			}
			else {
				squares[b][d].setBackground(SELECT);
				v.add(squares[b][d].getName());
			}
			r = 1;
		}
		if(t == 0){
			if(PanelContainsWhite(squares[a][c]) == 1){
				
			}
			else if(PanelContainsBlack(squares[a][c]) == 1){
				squares[a][c].setBackground(SELECT);
				v.add(squares[a][c].getName());
			}
			else {
				squares[a][c].setBackground(SELECT);
				v.add(squares[a][c].getName());
			}
			
		}
		if(r == 0){
			if(PanelContainsWhite(squares[b][d]) == 1){
				
			}
			else if(PanelContainsBlack(squares[b][d]) == 1){
				squares[b][d].setBackground(SELECT);
				v.add(squares[b][d].getName());
			}
			else {
				squares[b][d].setBackground(SELECT);
				v.add(squares[b][d].getName());
			}
			
		}
		/* According to angle */
		if(distX != 7&& distX != 0 && distY != 7 && distY != 0){
			a = distX;
			b = distY;
			
			if(PanelContainsWhite(squares[a-1][b-1]) == 1){
				
			}
			else if(PanelContainsBlack(squares[a-1][b-1]) == 1){
				squares[a-1][b-1].setBackground(SELECT);
				v.add(squares[a-1][b-1].getName());
			}
			else {
				squares[a-1][b-1].setBackground(SELECT);
				v.add(squares[a-1][b-1].getName());
			}		

			if(PanelContainsWhite(squares[a+1][b+1]) == 1){
				
			}
			else if(PanelContainsBlack(squares[a+1][b+1]) == 1){
				squares[a+1][b+1].setBackground(SELECT);
				v.add(squares[a+1][b+1].getName());
			}
			else {
				squares[a+1][b+1].setBackground(SELECT);
				v.add(squares[a+1][b+1].getName());
			}
			
			if(PanelContainsWhite(squares[a-1][b+1]) == 1){
				
			}
			else if(PanelContainsBlack(squares[a-1][b+1]) == 1){
				squares[a-1][b+1].setBackground(SELECT);
				v.add(squares[a-1][b+1].getName());
			}
			else {
				squares[a-1][b+1].setBackground(SELECT);
				v.add(squares[a-1][b+1].getName());
			}
			
			if(PanelContainsWhite(squares[a+1][b-1]) == 1){
				
			}
			else if(PanelContainsBlack(squares[a+1][b-1]) == 1){
				squares[a+1][b-1].setBackground(SELECT);
				v.add(squares[a+1][b-1].getName());
			}
			else {
				squares[a+1][b-1].setBackground(SELECT);
				v.add(squares[a+1][b-1].getName());
			}
		}
		/* more condition  for corner side */
		else if(distX == 0){
			if(distY != 0 && distY != 7){
				/* Checking Piece Contain */
				if(PanelContainsWhite(squares[distX+1][distY-1]) == 1){
					
				}
				else if(PanelContainsBlack(squares[distX+1][distY-1]) == 1){
					squares[distX+1][distY-1].setBackground(SELECT);
					v.add(squares[distX+1][distY-1].getName());
				}
				else{
					squares[distX+1][distY-1].setBackground(SELECT);
					v.add(squares[distX+1][distY-1].getName());
				}
				
				if(PanelContainsWhite(squares[distX+1][distY+1]) == 1){
					
				}
				else if(PanelContainsBlack(squares[distX+1][distY+1]) == 1){
					squares[distX+1][distY+1].setBackground(SELECT);
					v.add(squares[distX+1][distY+1].getName());
				}
				else{
					squares[distX+1][distY+1].setBackground(SELECT);
					v.add(squares[distX+1][distY+1].getName());
				}
				
				
			}
			else if (distY == 0) {
				if(PanelContainsWhite(squares[distX+1][distY+1]) == 1){
					
				}
				else if(PanelContainsBlack(squares[distX+1][distY+1]) == 1){
					squares[distX+1][distY+1].setBackground(SELECT);
					v.add(squares[distX+1][distY+1].getName());
				}
				else{
					squares[distX+1][distY+1].setBackground(SELECT);
					v.add(squares[distX+1][distY+1].getName());
				}
				
			}
			else if (distY == 7) {
				if(PanelContainsWhite(squares[distX+1][distY-1]) == 1){
					
				}
				else if(PanelContainsBlack(squares[distX+1][distY-1]) == 1){
					squares[distX+1][distY-1].setBackground(SELECT);
					v.add(squares[distX+1][distY-1].getName());
				}
				else{
					squares[distX+1][distY-1].setBackground(SELECT);
					v.add(squares[distX+1][distY-1].getName());
				}
				
			}
		}
		else if(distX == 7){
			if(distY != 0 && distY != 7){
				if(PanelContainsWhite(squares[distX-1][distY-1]) == 1){
					
				}
				else if(PanelContainsBlack(squares[distX-1][distY-1]) == 1){
					squares[distX-1][distY-1].setBackground(SELECT);
					v.add(squares[distX-1][distY-1].getName());
				}
				else{
					squares[distX-1][distY-1].setBackground(SELECT);
					v.add(squares[distX-1][distY-1].getName());
				}
				
				if(PanelContainsWhite(squares[distX-1][distY+1]) == 1){
					
				}
				else if(PanelContainsBlack(squares[distX-1][distY+1]) == 1){
					squares[distX-1][distY+1].setBackground(SELECT);
					v.add(squares[distX-1][distY+1].getName());
				}
				else{
					squares[distX-1][distY+1].setBackground(SELECT);
					v.add(squares[distX-1][distY+1].getName());
				}
				
			}
			else if (distY == 0) {
				if(PanelContainsWhite(squares[distX-1][distY+1]) == 1){
					
				}
				else if(PanelContainsBlack(squares[distX-1][distY+1]) == 1){
					squares[distX-1][distY+1].setBackground(SELECT);
					v.add(squares[distX-1][distY+1].getName());
				}
				else{
					squares[distX-1][distY+1].setBackground(SELECT);
					v.add(squares[distX-1][distY+1].getName());
				}
				
			}
			else if (distY == 7) {
				if(PanelContainsWhite(squares[distX-1][distY-1]) == 1){
					
				}
				else if(PanelContainsBlack(squares[distX-1][distY-1]) == 1){
					squares[distX-1][distY-1].setBackground(SELECT);
					v.add(squares[distX-1][distY-1].getName());
				}
				else{
					squares[distX-1][distY-1].setBackground(SELECT);
					v.add(squares[distX-1][distY-1].getName());
				}
				
			}
		}
		/* For distY ( j ) */
		else if(distY == 0){
			if(distX != 0 && distX != 7){
				if(PanelContainsWhite(squares[distX-1][distY+1]) == 1){
					
				}
				else if(PanelContainsBlack(squares[distX-1][distY+1]) == 1){
					squares[distX-1][distY+1].setBackground(SELECT);
					v.add(squares[distX-1][distY+1].getName());
				}
				else{
					squares[distX-1][distY+1].setBackground(SELECT);
					v.add(squares[distX-1][distY+1].getName());
				}
				
				if(PanelContainsWhite(squares[distX+1][distY+1]) == 1){
					
				}
				else if(PanelContainsBlack(squares[distX+1][distY+1]) == 1){
					squares[distX+1][distY+1].setBackground(SELECT);
					v.add(squares[distX+1][distY+1].getName());
				}
				else{
					squares[distX+1][distY+1].setBackground(SELECT);
					v.add(squares[distX+1][distY+1].getName());
				}
				
			}
			else if (distX == 0) {
				if(PanelContainsWhite(squares[distX+1][distY+1]) == 1){
					
				}
				else if(PanelContainsBlack(squares[distX+1][distY+1]) == 1){
					squares[distX+1][distY+1].setBackground(SELECT);
					v.add(squares[distX+1][distY+1].getName());
				}
				else{
					squares[distX+1][distY+1].setBackground(SELECT);
					v.add(squares[distX+1][distY+1].getName());
				}
				
			}
			else if (distX == 7) {
				if(PanelContainsWhite(squares[distX-1][distY+1]) == 1){
					
				}
				else if(PanelContainsBlack(squares[distX-1][distY+1]) == 1){
					squares[distX-1][distY+1].setBackground(SELECT);
					v.add(squares[distX-1][distY+1].getName());
				}
				else{
					squares[distX-1][distY+1].setBackground(SELECT);
					v.add(squares[distX-1][distY+1].getName());
				}
				
			}
		}
		else if(distY == 7){
			if(distX != 0 && distX != 7){
				if(PanelContainsWhite(squares[distX-1][distY-1]) == 1){
					
				}
				else if(PanelContainsBlack(squares[distX-1][distY-1]) == 1){
					squares[distX-1][distY-1].setBackground(SELECT);
					v.add(squares[distX-1][distY-1].getName());
				}
				else{
					squares[distX-1][distY-1].setBackground(SELECT);
					v.add(squares[distX-1][distY-1].getName());
				}
				
				if(PanelContainsWhite(squares[distX+1][distY-1]) == 1){
					
				}
				else if(PanelContainsBlack(squares[distX+1][distY-1]) == 1){
					squares[distX+1][distY-1].setBackground(SELECT);
					v.add(squares[distX+1][distY-1].getName());
				}
				else{
					squares[distX+1][distY-1].setBackground(SELECT);
					v.add(squares[distX+1][distY-1].getName());
				}
				
			}
			else if (distX == 0) {
				if(PanelContainsWhite(squares[distX+1][distY-1]) == 1){
					
				}
				else if(PanelContainsBlack(squares[distX+1][distY-1]) == 1){
					squares[distX+1][distY-1].setBackground(SELECT);
					v.add(squares[distX+1][distY-1].getName());
				}
				else{
					squares[distX+1][distY-1].setBackground(SELECT);
					v.add(squares[distX+1][distY-1].getName());
				}
				
			}
			else if (distX == 7) {
				if(PanelContainsWhite(squares[distX-1][distY-1]) == 1){
					
				}
				else if(PanelContainsBlack(squares[distX-1][distY-1]) == 1){
					squares[distX-1][distY-1].setBackground(SELECT);
					v.add(squares[distX-1][distY-1].getName());
				}
				else{
					squares[distX-1][distY-1].setBackground(SELECT);
					v.add(squares[distX-1][distY-1].getName());
				}
			}
		}
		
	} /* End White King move */

	public void BlackBishopMove() {
		int i=0, j=0;
		squares[distX][distY].setBackground(SELECT);
		/* according to i */
		if(distX < distY){
			i = distX;
			j = distY;
			for(; j<7; j++){
				if(PanelContainsBlack(squares[i+1][j+1]) == 1){
					break;
				}
				else if(PanelContainsWhite(squares[i+1][j+1]) == 1){
					squares[i+1][j+1].setBackground(SELECT);
					v.add(squares[i+1][j+1].getName());
					break;
				}
				else{
					squares[i+1][j+1].setBackground(SELECT);
					v.add(squares[i+1][j+1].getName());
				}
				i++;
			}
			j = distY;
			for(i = distX; i>0; i--){
				if(PanelContainsBlack(squares[i-1][j-1]) == 1){
					break;
				}
				else if(PanelContainsWhite(squares[i-1][j-1]) == 1){
					squares[i-1][j-1].setBackground(SELECT);
					v.add(squares[i-1][j-1].getName());
					break;
				}
				else{
					squares[i-1][j-1].setBackground(SELECT);
					v.add(squares[i-1][j-1].getName());
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
					squares[i+1][j+1].setBackground(SELECT);
					v.add(squares[i+1][j+1].getName());
					break;
				}
				else{
					squares[i+1][j+1].setBackground(SELECT);
					v.add(squares[i+1][j+1].getName());
				}
				j++;
			}
			i = distX;
			for(j = distY; j>0; j--){
				if(PanelContainsBlack(squares[i-1][j-1]) == 1){
					break;
				}
				else if(PanelContainsWhite(squares[i-1][j-1]) == 1){
					squares[i-1][j-1].setBackground(SELECT);
					v.add(squares[i-1][j-1].getName());
					break;
				}
				else{
					squares[i-1][j-1].setBackground(SELECT);
					v.add(squares[i-1][j-1].getName());
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
					squares[i-1][j+1].setBackground(SELECT);
					v.add(squares[i-1][j+1].getName());
					break;
				}
				else{
					squares[i-1][j+1].setBackground(SELECT);
					v.add(squares[i-1][j+1].getName());
				}
				j++;
			}
			i = distX;
			for(j = distY; j>0; j--){
				if(PanelContainsBlack(squares[i+1][j-1]) == 1){
					break;
				}
				else if(PanelContainsWhite(squares[i+1][j-1]) == 1){
					squares[i+1][j-1].setBackground(SELECT);
					v.add(squares[i+1][j-1].getName());
					break;
				}
				else{
					squares[i+1][j-1].setBackground(SELECT);
					v.add(squares[i+1][j-1].getName());
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
					squares[i+1][j-1].setBackground(SELECT);
					v.add(squares[i+1][j-1].getName());
					break;
				}
				else{
					squares[i+1][j-1].setBackground(SELECT);
					v.add(squares[i+1][j-1].getName());
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
					squares[i-1][j+1].setBackground(SELECT);
					v.add(squares[i-1][j+1].getName());
					break;
				}
				else{
					squares[i-1][j+1].setBackground(SELECT);
					v.add(squares[i-1][j+1].getName());
				}
				i--;
			}
			
			
		}
		
	} /* End Black BishpMove */
	
	public void WhiteBishopMove() {
		int i=0, j=0;
		squares[distX][distY].setBackground(SELECT);
		/* according to i */
		if(distX < distY){
			i = distX;
			j = distY;
			for(; j<7; j++){
				if(PanelContainsWhite(squares[i+1][j+1]) == 1){
					break;
				}
				else if(PanelContainsBlack(squares[i+1][j+1]) == 1){
					squares[i+1][j+1].setBackground(SELECT);
					v.add(squares[i+1][j+1].getName());
					break;
				}
				else{
					squares[i+1][j+1].setBackground(SELECT);
					v.add(squares[i+1][j+1].getName());
				}
				i++;
			}
			j = distY;
			for(i = distX; i>0; i--){
				if(PanelContainsWhite(squares[i-1][j-1]) == 1){
					break;
				}
				else if(PanelContainsBlack(squares[i-1][j-1]) == 1){
					squares[i-1][j-1].setBackground(SELECT);
					v.add(squares[i-1][j-1].getName());
					break;
				}
				else{
					squares[i-1][j-1].setBackground(SELECT);
					v.add(squares[i-1][j-1].getName());
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
					squares[i+1][j+1].setBackground(SELECT);
					v.add(squares[i+1][j+1].getName());
					break;
				}
				else{
					squares[i+1][j+1].setBackground(SELECT);
					v.add(squares[i+1][j+1].getName());
				}
				j++;
			}
			i = distX;
			for(j = distY; j>0; j--){
				if(PanelContainsWhite(squares[i-1][j-1]) == 1){
					break;
				}
				else if(PanelContainsBlack(squares[i-1][j-1]) == 1){
					squares[i-1][j-1].setBackground(SELECT);
					v.add(squares[i-1][j-1].getName());
					break;
				}
				else{
					squares[i-1][j-1].setBackground(SELECT);
					v.add(squares[i-1][j-1].getName());
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
					squares[i-1][j+1].setBackground(SELECT);
					v.add(squares[i-1][j+1].getName());
					break;
				}
				else{
					squares[i-1][j+1].setBackground(SELECT);
					v.add(squares[i-1][j+1].getName());
				}
				j++;
			}
			i = distX;
			for(j = distY; j>0; j--){
				if(PanelContainsWhite(squares[i+1][j-1]) == 1){
					break;
				}
				else if(PanelContainsBlack(squares[i+1][j-1]) == 1){
					squares[i+1][j-1].setBackground(SELECT);
					v.add(squares[i+1][j-1].getName());
					break;
				}
				else{
					squares[i+1][j-1].setBackground(SELECT);
					v.add(squares[i+1][j-1].getName());
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
					squares[i+1][j-1].setBackground(SELECT);
					v.add(squares[i+1][j-1].getName());
					break;
				}
				else{
					squares[i+1][j-1].setBackground(SELECT);
					v.add(squares[i+1][j-1].getName());
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
					squares[i-1][j+1].setBackground(SELECT);
					v.add(squares[i-1][j+1].getName());
					break;
				}
				else{
					squares[i-1][j+1].setBackground(SELECT);
					v.add(squares[i-1][j+1].getName());
				}
				i--;
			}

		}
		
		
	} /* End White BishpMove */
	
	public void BlackRookMove() {
		int i;
		squares[distX][distY].setBackground(SELECT);
		
		for(i= distX; i<7; i++){

			if(PanelContainsBlack(squares[i+1][distY]) == 1){
				break;
			}
			else if(PanelContainsWhite(squares[i+1][distY]) == 1){
				squares[i+1][distY].setBackground(SELECT);
				v.add(squares[i+1][distY].getName());
				break;
			}
			else{
				squares[i+1][distY].setBackground(SELECT);
				v.add(squares[i+1][distY].getName());
			}
	
		}
		for(i= distX; i>0; i--){
			if(PanelContainsBlack(squares[i-1][distY]) == 1){
				break;
			}
			else if(PanelContainsWhite(squares[i-1][distY]) == 1){
				squares[i-1][distY].setBackground(SELECT);
				v.add(squares[i-1][distY].getName());
				break;
			}
			else{
				squares[i-1][distY].setBackground(SELECT);
				v.add(squares[i-1][distY].getName());
			}

		}
		for(i= distY; i<7; i++){

			if(PanelContainsBlack(squares[distX][i+1])== 1){
				break;
			}
			else if(PanelContainsWhite(squares[distX][i+1]) == 1){
				squares[distX][i+1].setBackground(SELECT);
				v.add(squares[distX][i+1].getName());		
				break;
			}
			else {
				squares[distX][i+1].setBackground(SELECT);
				v.add(squares[distX][i+1].getName());
			}
		}
		for(i= distY; i>0; i--){
			if(PanelContainsBlack(squares[distX][i-1])== 1){
				break;
			}
			else if(PanelContainsWhite(squares[distX][i-1]) == 1){
				squares[distX][i-1].setBackground(SELECT);
				v.add(squares[distX][i-1].getName());		
				break;
			}
			else {
				squares[distX][i-1].setBackground(SELECT);
				v.add(squares[distX][i-1].getName());
			}
		}
	} /* End Rook Move */
	
	public void WhiteRookMove() {
		int i;
		squares[distX][distY].setBackground(SELECT);
		
		for(i= distX; i<7; i++){
			if(PanelContainsWhite(squares[i+1][distY]) == 1){
				break;
			}
			else if(PanelContainsBlack(squares[i+1][distY])== 1){
				squares[i+1][distY].setBackground(SELECT);
				v.add(squares[i+1][distY].getName());
				break;
			}
			else{
				squares[i+1][distY].setBackground(SELECT);
				v.add(squares[i+1][distY].getName());
			}
	
		}
		for(i= distX; i>0; i--){
		
			if(PanelContainsWhite(squares[i-1][distY]) == 1){
				break;
			}
			else if(PanelContainsBlack(squares[i-1][distY])== 1){
				squares[i-1][distY].setBackground(SELECT);
				v.add(squares[i-1][distY].getName());
				break;
			}
			else{
				squares[i-1][distY].setBackground(SELECT);
				v.add(squares[i-1][distY].getName());
			}

		}
		for(i= distY; i<7; i++){
			
			if(PanelContainsWhite(squares[distX][i+1])== 1){
				break;
			}
			else if(PanelContainsBlack(squares[distX][i+1])== 1){
				squares[distX][i+1].setBackground(SELECT);
				v.add(squares[distX][i+1].getName());
				break;
			}
			else{
				squares[distX][i+1].setBackground(SELECT);
				v.add(squares[distX][i+1].getName());
			}
		
		}
		for(i= distY; i>0; i--){
			if(PanelContainsWhite(squares[distX][i-1])== 1){
				break;
			}
			else if(PanelContainsBlack(squares[distX][i-1])== 1){
				squares[distX][i-1].setBackground(SELECT);
				v.add(squares[distX][i-1].getName());
				break;
			}
			else{
				squares[distX][i-1].setBackground(SELECT);
				v.add(squares[distX][i-1].getName());
			}
		}
		
	} /* End White Rook Move */
	
	public void BlackKnightMove() {
		int i = distX;
		int j = distY;
		squares[i][j].setBackground(SELECT);
		
		if(i-1 >= 0 && j-2 >= 0){
			if(PanelContainsBlack(squares[i-1][j-2])== 1){
				
			}
			else{
				squares[i-1][j-2].setBackground(SELECT);	
				v.add(squares[i-1][j-2].getName());
			}
		}
		if(i-1 >= 0 && j+2 <= 7){
			if(PanelContainsBlack(squares[i-1][j+2]) == 1){
				
			}
			else{
				squares[i-1][j+2].setBackground(SELECT);			
				v.add(squares[i-1][j+2].getName());
			}
		}
		if(i+1 <= 7 && j-2 >= 0){
			if(PanelContainsBlack(squares[i+1][j-2]) == 1){
				
			}
			else{
				squares[i+1][j-2].setBackground(SELECT);			
				v.add(squares[i+1][j-2].getName());
			}
		}
		if(i+1 <= 7 && j+2 <= 7){
			if(PanelContainsBlack(squares[i+1][j+2]) == 1){
				
			}
			else{
				squares[i+1][j+2].setBackground(SELECT);	
				v.add(squares[i+1][j+2].getName());
			}
		}
		if(i-2 >= 0 && j-1 >= 0){
			if(PanelContainsBlack(squares[i-2][j-1]) == 1){
				
			}
			else{
				squares[i-2][j-1].setBackground(SELECT);		
				v.add(squares[i-2][j-1].getName());
			}
		}
		if(i-2 >= 0 && j+1 <= 7){
			if(PanelContainsBlack(squares[i-2][j+1]) == 1){
				
			}
			else{
				squares[i-2][j+1].setBackground(SELECT);			
				v.add(squares[i-2][j+1].getName());
			}
		}
		if(i+2 <= 7 && j-1 >= 0){
			if(PanelContainsBlack(squares[i+2][j-1]) == 1){
				
			}
			else{
				squares[i+2][j-1].setBackground(SELECT);		
				v.add(squares[i+2][j-1].getName());
			}
		}
		if(i+2 <= 7 && j+1 <= 7){
			if(PanelContainsBlack(squares[i+2][j+1]) == 1){
				
			}
			else{
				squares[i+2][j+1].setBackground(SELECT);		
				v.add(squares[i+2][j+1].getName());
			}
		}
				
	} /* End Black Knight Move */
	
	public void WhiteKnightMove() {
		int i = distX;
		int j = distY;
		squares[i][j].setBackground(SELECT);
		
		if(i-1 >= 0 && j-2 >= 0){
			if(PanelContainsWhite(squares[i-1][j-2])== 1){
				
			}
			else{
				squares[i-1][j-2].setBackground(SELECT);	
				v.add(squares[i-1][j-2].getName());
			}
		}
		if(i-1 >= 0 && j+2 <= 7){
			if(PanelContainsWhite(squares[i-1][j+2]) == 1){
				
			}
			else{
				squares[i-1][j+2].setBackground(SELECT);			
				v.add(squares[i-1][j+2].getName());
			}
		}
		if(i+1 <= 7 && j-2 >= 0){
			if(PanelContainsWhite(squares[i+1][j-2]) == 1){
				
			}
			else{
				squares[i+1][j-2].setBackground(SELECT);			
				v.add(squares[i+1][j-2].getName());
			}
		}
		if(i+1 <= 7 && j+2 <= 7){
			if(PanelContainsWhite(squares[i+1][j+2]) == 1){
				
			}
			else{
				squares[i+1][j+2].setBackground(SELECT);	
				v.add(squares[i+1][j+2].getName());
			}
		}
		if(i-2 >= 0 && j-1 >= 0){
			if(PanelContainsWhite(squares[i-2][j-1]) == 1){
				
			}
			else{
				squares[i-2][j-1].setBackground(SELECT);		
				v.add(squares[i-2][j-1].getName());
			}
		}
		if(i-2 >= 0 && j+1 <= 7){
			if(PanelContainsWhite(squares[i-2][j+1]) == 1){
				
			}
			else{
				squares[i-2][j+1].setBackground(SELECT);			
				v.add(squares[i-2][j+1].getName());
			}
		}
		if(i+2 <= 7 && j-1 >= 0){
			if(PanelContainsWhite(squares[i+2][j-1]) == 1){
				
			}
			else{
				squares[i+2][j-1].setBackground(SELECT);		
				v.add(squares[i+2][j-1].getName());
			}
		}
		if(i+2 <= 7 && j+1 <= 7){
			if(PanelContainsWhite(squares[i+2][j+1]) == 1){
				
			}
			else{
				squares[i+2][j+1].setBackground(SELECT);		
				v.add(squares[i+2][j+1].getName());
			}
		}
		
				
	} /* End Knight Move */
	
	public void WhiteGrasshoper() {
		int i, j;
		
		squares[distX][distY].setBackground(SELECT);
		
		for(i= distX; i<6; i++){

			if(PanelContainsBlack(squares[i+1][distY]) == 1 || PanelContainsWhite(squares[i+1][distY]) == 1){
				if(PanelContainsBlack(squares[i+2][distY]) == 1){
					squares[i+2][distY].setBackground(SELECT);
					v.add(squares[i+2][distY].getName());
				}
				else if(PanelContainsWhite(squares[i+2][distY]) == 0){
					squares[i+2][distY].setBackground(SELECT);
					v.add(squares[i+2][distY].getName());
				}
				break;
			}
	
		}
		for(i= distX; i>1; i--){
			if(PanelContainsBlack(squares[i-1][distY]) == 1 || PanelContainsWhite(squares[i-1][distY]) == 1){
				
				if(PanelContainsBlack(squares[i-2][distY]) == 1){
					squares[i-2][distY].setBackground(SELECT);
					v.add(squares[i-2][distY].getName());
				}
				else if(PanelContainsWhite(squares[i-2][distY]) == 0){
					squares[i-2][distY].setBackground(SELECT);
					v.add(squares[i-2][distY].getName());
				}
				break;
			}

		}
		for(i= distY; i<6; i++){

			if(PanelContainsBlack(squares[distX][i+1])== 1|| PanelContainsWhite(squares[distX][i+1]) == 1){
				
				if(PanelContainsBlack(squares[distX][i+2]) == 1){
					squares[distX][i+2].setBackground(SELECT);
					v.add(squares[distX][i+2].getName());	
				}
				else if(PanelContainsWhite(squares[distX][i+2]) == 0){
					squares[distX][i+2].setBackground(SELECT);
					v.add(squares[distX][i+2].getName());	
				}
				break;
			}

		}
		for(i= distY; i>1; i--){
			if(PanelContainsBlack(squares[distX][i-1])== 1|| PanelContainsWhite(squares[distX][i-1]) == 1){
				
				if(PanelContainsBlack(squares[distX][i-2]) == 1){
					squares[distX][i-2].setBackground(SELECT);
					v.add(squares[distX][i-2].getName());	
				}
				else if(PanelContainsWhite(squares[distX][i-2]) == 0){
					squares[distX][i-2].setBackground(SELECT);
					v.add(squares[distX][i-2].getName());	
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
						squares[i+2][j+2].setBackground(SELECT);
						v.add(squares[i+2][j+2].getName());
					}
					else if(PanelContainsWhite(squares[i+2][j+2]) == 0){
						squares[i+2][j+2].setBackground(SELECT);
						v.add(squares[i+2][j+2].getName());
					}
					break;
				}
				
				i++;
			}
			j = distY;
			for(i = distX; i>1; i--){
				if(PanelContainsWhite(squares[i-1][j-1]) == 1 || PanelContainsBlack(squares[i-1][j-1]) == 1){
					if(PanelContainsBlack(squares[i-2][j-2]) == 1){
						squares[i-2][j-2].setBackground(SELECT);
						v.add(squares[i-2][j-2].getName());
					}
					else if(PanelContainsWhite(squares[i-2][j-2]) == 0){
						squares[i-2][j-2].setBackground(SELECT);
						v.add(squares[i-2][j-2].getName());
						
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
						squares[i+2][j+2].setBackground(SELECT);
						v.add(squares[i+2][j+2].getName());
					}
					else if(PanelContainsWhite(squares[i+2][j+2]) == 0){
						squares[i+2][j+2].setBackground(SELECT);
						v.add(squares[i+2][j+2].getName());
						
					}
					break;
				}
				
				j++;
			}
			i = distX;
			for(j = distY; j>1; j--){
				if(PanelContainsWhite(squares[i-1][j-1]) == 1 || PanelContainsBlack(squares[i-1][j-1]) == 1){
					if(PanelContainsBlack(squares[i-2][j-2]) == 1){
						squares[i-2][j-2].setBackground(SELECT);
						v.add(squares[i-2][j-2].getName());
					}
					else if(PanelContainsWhite(squares[i-2][j-2]) == 0){
						squares[i-2][j-2].setBackground(SELECT);
						v.add(squares[i-2][j-2].getName());
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
						squares[i-2][j+2].setBackground(SELECT);
						v.add(squares[i-2][j+2].getName());
					}
					else if(PanelContainsWhite(squares[i-2][j+2]) == 0){
						squares[i-2][j+2].setBackground(SELECT);
						v.add(squares[i-2][j+2].getName());
					
					}
					break;
				}
				j++;
			}
			i = distX;
			for(j = distY; j>1; j--){
				if(PanelContainsWhite(squares[i+1][j-1]) == 1 || PanelContainsBlack(squares[i+1][j-1]) == 1){
					if(PanelContainsBlack(squares[i+2][j-2]) == 1){
						squares[i+2][j-2].setBackground(SELECT);
						v.add(squares[i+2][j-2].getName());
					}
					else if(PanelContainsWhite(squares[i+2][j-2]) == 0){
						squares[i+2][j-2].setBackground(SELECT);
						v.add(squares[i+2][j-2].getName());
					
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
						squares[i+2][j-2].setBackground(SELECT);
						v.add(squares[i+2][j-2].getName());
					}
					else if(PanelContainsWhite(squares[i+2][j-2]) == 0){
						squares[i+2][j-2].setBackground(SELECT);
						v.add(squares[i+2][j-2].getName());
					
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
						squares[i-2][j+2].setBackground(SELECT);
						v.add(squares[i-2][j+2].getName());
					}
					else if(PanelContainsWhite(squares[i-2][j+2]) == 0){
						squares[i-2][j+2].setBackground(SELECT);
						v.add(squares[i-2][j+2].getName());
						
					}
					break;
				}
				i--;
			}

		}
		
	} /* End Grasshopper Move */
	public void BlackGrasshoper() {
		int i, j;
		
		squares[distX][distY].setBackground(SELECT);
		
		for(i= distX; i<6; i++){

			if(PanelContainsBlack(squares[i+1][distY]) == 1 || PanelContainsWhite(squares[i+1][distY]) == 1){
				if(PanelContainsWhite(squares[i+2][distY]) == 1){
					squares[i+2][distY].setBackground(SELECT);
					v.add(squares[i+2][distY].getName());
				}
				else if(PanelContainsBlack(squares[i+2][distY]) == 0){
					squares[i+2][distY].setBackground(SELECT);
					v.add(squares[i+2][distY].getName());
				}
				break;
			}
	
		}
		for(i= distX; i>1; i--){
			if(PanelContainsBlack(squares[i-1][distY]) == 1 || PanelContainsWhite(squares[i-1][distY]) == 1){
				
				if(PanelContainsWhite(squares[i-2][distY]) == 1){
					squares[i-2][distY].setBackground(SELECT);
					v.add(squares[i-2][distY].getName());
				}
				else if(PanelContainsBlack(squares[i-2][distY]) == 0){
					squares[i-2][distY].setBackground(SELECT);
					v.add(squares[i-2][distY].getName());
				}
				break;
			}

		}
		for(i= distY; i<6; i++){

			if(PanelContainsBlack(squares[distX][i+1])== 1|| PanelContainsWhite(squares[distX][i+1]) == 1){
				
				if(PanelContainsWhite(squares[distX][i+2]) == 1){
					squares[distX][i+2].setBackground(SELECT);
					v.add(squares[distX][i+2].getName());	
				}
				else if(PanelContainsBlack(squares[distX][i+2]) == 0){
					squares[distX][i+2].setBackground(SELECT);
					v.add(squares[distX][i+2].getName());	
				}
				break;
			}

		}
		for(i= distY; i>1; i--){
			if(PanelContainsBlack(squares[distX][i-1])== 1|| PanelContainsWhite(squares[distX][i-1]) == 1){
				
				if(PanelContainsWhite(squares[distX][i-2]) == 1){
					squares[distX][i-2].setBackground(SELECT);
					v.add(squares[distX][i-2].getName());	
				}
				else if(PanelContainsBlack(squares[distX][i-2]) == 0){
					squares[distX][i-2].setBackground(SELECT);
					v.add(squares[distX][i-2].getName());	
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
						squares[i+2][j+2].setBackground(SELECT);
						v.add(squares[i+2][j+2].getName());
					}
					else if(PanelContainsBlack(squares[i+2][j+2]) == 0){
						squares[i+2][j+2].setBackground(SELECT);
						v.add(squares[i+2][j+2].getName());
					}
					break;
				}
				
				i++;
			}
			j = distY;
			for(i = distX; i>1; i--){
				if(PanelContainsWhite(squares[i-1][j-1]) == 1 || PanelContainsBlack(squares[i-1][j-1]) == 1){
					if(PanelContainsWhite(squares[i-2][j-2]) == 1){
						squares[i-2][j-2].setBackground(SELECT);
						v.add(squares[i-2][j-2].getName());
					}
					else if(PanelContainsBlack(squares[i-2][j-2]) == 0){
						squares[i-2][j-2].setBackground(SELECT);
						v.add(squares[i-2][j-2].getName());
						
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
						squares[i+2][j+2].setBackground(SELECT);
						v.add(squares[i+2][j+2].getName());
					}
					else if(PanelContainsBlack(squares[i+2][j+2]) == 0){
						squares[i+2][j+2].setBackground(SELECT);
						v.add(squares[i+2][j+2].getName());
						
					}
					break;
				}
				
				j++;
			}
			i = distX;
			for(j = distY; j>1; j--){
				if(PanelContainsWhite(squares[i-1][j-1]) == 1 || PanelContainsBlack(squares[i-1][j-1]) == 1){
					if(PanelContainsWhite(squares[i-2][j-2]) == 1){
						squares[i-2][j-2].setBackground(SELECT);
						v.add(squares[i-2][j-2].getName());
					}
					else if(PanelContainsBlack(squares[i-2][j-2]) == 0){
						squares[i-2][j-2].setBackground(SELECT);
						v.add(squares[i-2][j-2].getName());
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
						squares[i-2][j+2].setBackground(SELECT);
						v.add(squares[i-2][j+2].getName());
					}
					else if(PanelContainsBlack(squares[i-2][j+2]) == 0){
						squares[i-2][j+2].setBackground(SELECT);
						v.add(squares[i-2][j+2].getName());
					
					}
					break;
				}
				j++;
			}
			i = distX;
			for(j = distY; j>1; j--){
				if(PanelContainsWhite(squares[i+1][j-1]) == 1 || PanelContainsBlack(squares[i+1][j-1]) == 1){
					if(PanelContainsWhite(squares[i+2][j-2]) == 1){
						squares[i+2][j-2].setBackground(SELECT);
						v.add(squares[i+2][j-2].getName());
					}
					else if(PanelContainsBlack(squares[i+2][j-2]) == 0){
						squares[i+2][j-2].setBackground(SELECT);
						v.add(squares[i+2][j-2].getName());
					
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
						squares[i+2][j-2].setBackground(SELECT);
						v.add(squares[i+2][j-2].getName());
					}
					else if(PanelContainsBlack(squares[i+2][j-2]) == 0){
						squares[i+2][j-2].setBackground(SELECT);
						v.add(squares[i+2][j-2].getName());
					
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
						squares[i-2][j+2].setBackground(SELECT);
						v.add(squares[i-2][j+2].getName());
					}
					else if(PanelContainsBlack(squares[i-2][j+2]) == 0){
						squares[i-2][j+2].setBackground(SELECT);
						v.add(squares[i-2][j+2].getName());
						
					}
					break;
				}
				i--;
			}

		}
	} /* End Black Grasshoper */

	protected int PanelContainsBlack(JPanel panel) {
		for (Entry<Integer, JLabel> entry : Blackbox.entrySet()) {

			Value = entry.getValue();
			if (panel == Value.getParent()) { /* Works */
				 return 1;
			}
		}
		return 0;
	}

	protected int PanelContainsWhite(JPanel panel) {
		for (Entry<Integer, JLabel> entry : Whitebox.entrySet()) {

			Value = entry.getValue();
			if (panel == Value.getParent()) { /* Works */
				 return 1;
			}
		}
		return 0;
	}
	
}
