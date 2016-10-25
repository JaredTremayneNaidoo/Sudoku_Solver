import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.beans.PropertyChangeEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

public class GuiSodoku {
	static long executiontime;
	static String message;
	static int [] StringtoArray =new int[81];
	static int [][] A=new int[9][9];
	static JPanel panel_1 = new JPanel();
	private JFrame frmSudokuSolver;

	public static void main(String args[]) {
		String S = null, SS[] = null;
		
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sudoku","java","java");
		System.out.println("Connection to the Sudoku Database has been established...");
		PreparedStatement statement=con.prepareStatement("select * from sudoku ORDER BY RAND() LIMIT 1");
		ResultSet result=statement.executeQuery();
		
		if(result.next()){
			S=result.getString("SudokuPuzzle");
			//System.out.println(S);
			//System.out.println();
		}
		for(int i=0;i<S.length();i++){
				SS=S.split("");
			}
		 for (int i = 0; i < 9*9; i++) {
				StringtoArray[i]=Integer.parseInt(SS[i]);
				}
		}
		catch(Exception E){
			System.out.println(E);
		}		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiSodoku window = new GuiSodoku();
					window.frmSudokuSolver.setVisible(true);
					
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		 long startTime=System.currentTimeMillis();
		  if (!CorrectValues(A)){
			  message ="Invalid Input";
		     // System.out.println("Invalid input!");
		      }
		    else if (evaluate(A)) {
		    	 System.out.println();
		    	 message="The solution is found!";
		     // System.out.println("The solution is found:");
		    	 Displaysolvedpuzzle(A);
		    }
		    else{
		    	message="No solution";
		     // System.out.println("No solution found");
		    }
		  	long endTime=System.currentTimeMillis();
		  	executiontime=endTime-startTime;
		  
		  
		  }
	
	public GuiSodoku() {
		initialize();
	}

	private void initialize() {
		frmSudokuSolver = new JFrame();
		frmSudokuSolver.setBackground(Color.BLUE);
		frmSudokuSolver.setTitle("Sudoku Solver");
		frmSudokuSolver.getContentPane().setBackground(new Color(0, 191, 255));
		frmSudokuSolver.setBounds(100, 100, 704, 429);
		frmSudokuSolver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSudokuSolver.getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 235));
		panel.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new LineBorder(new Color(0, 0, 0), 2)));
		panel.setBounds(20, 145, 273, 203);
		frmSudokuSolver.getContentPane().add(panel);
		panel.setLayout(new GridLayout(9, 9));
		
		 int AA [][]=createBoard(StringtoArray);
		 for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				String o=Integer.toString(AA[i][j]);
				panel.add(new JTextField(o));
				
			}
		}
		 JLabel labeloutcome = new JLabel("");
		 labeloutcome.setFont(new Font("Tahoma", Font.BOLD, 12));
			labeloutcome.setBounds(406, 111, 227, 23);
			frmSudokuSolver.getContentPane().add(labeloutcome);
			labeloutcome.setVisible(false);
		 JLabel lbltimetaken = new JLabel("0.00");
		 lbltimetaken.setFont(new Font("Tahoma", Font.BOLD, 13));
			
			lbltimetaken.setBounds(563, 362, 115, 23);
			frmSudokuSolver.getContentPane().add(lbltimetaken);
			lbltimetaken.setVisible(false);
			JLabel lbltime = new JLabel("Total time to evaluate puzzle");
			lbltime.setFont(new Font("Tahoma", Font.BOLD, 13));
			lbltime.setBounds(360, 366, 193, 14);
			frmSudokuSolver.getContentPane().add(lbltime);
			lbltime.setVisible(false);
		panel.setVisible(false);
		panel_1.setBackground(new Color(135, 206, 235));
		panel_1.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new LineBorder(new Color(0, 0, 0), 2)));
		panel_1.setVisible(false);
		JButton btnNewButton = new JButton("Get a Random Sudoku Puzzle");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(new Color(135, 206, 250));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(20, 68, 273, 33);
		frmSudokuSolver.getContentPane().add(btnNewButton);
		JButton btnNewButton_1 = new JButton("Solve Puzzle ");
		btnNewButton_1.setIcon(null);
		btnNewButton_1.setBackground(new Color(135, 206, 250));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setVisible(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_1.setVisible(true);
				lbltime.setVisible(true);
				String time=Long.toString(executiontime);
				lbltimetaken.setText(time + " Milliseconds");
			lbltimetaken.setVisible(true);
			labeloutcome.setVisible(true);
			labeloutcome.setText(message);
			
			}});
		btnNewButton_1.setBounds(360, 68, 273, 33);
		frmSudokuSolver.getContentPane().add(btnNewButton_1);
		panel_1.setBounds(360, 145, 273, 203);
		frmSudokuSolver.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(9,9));
		
		JLabel lblNewLabel = new JLabel("Sudoku Solver");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(20, 11, 637, 46);
		frmSudokuSolver.getContentPane().add(lblNewLabel);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 
				panel.setVisible(true);
				btnNewButton_1.setVisible(true);
				
			}
		});
	}
	public static int[][] createBoard(int [] puzzle){
		int[][] SudokuBoard=new int[9][];
		for(int i=0;i<9;i++){
			SudokuBoard[i]=new int[9];
			System.out.println();
			for(int j=0;j<9;j++){
				SudokuBoard[i][j]=puzzle[(i*9)+j];
				//System.out.print(SudokuBoard[i][j]+ " ");
	}
		}
		return SudokuBoard;
	}
		 public static int[][] EmptyCells(int[][] B) {
			    // Determine the number of free cells 
			    int TotalFree = 0;   
			    for (int i = 0; i < 9; i++)
			      for (int j = 0; j < 9; j++) 
			        if (B[i][j] == 0) 
			        	TotalFree++; 
			    // Store free cell positions into freeCellList 
			    int[][] AllEmptyCells = new int[TotalFree][2];
			    int count = 0;
			    for (int i = 0; i < 9; i++)
			      for (int j = 0; j < 9; j++) 
			        if (B[i][j] == 0) {
			        	AllEmptyCells[count][0] = i;
			        	AllEmptyCells[count++][1] = j;
			        }
			    return AllEmptyCells;
			  }

			  /** Display solved puzzle */
			  public static void Displaysolvedpuzzle(int[][] B) {
				   update();
			   /* for (int i = 0; i < 9; i++) {
			      for (int j = 0; j < 9; j++)
			        System.out.print(B[i][j] + " ");
			      System.out.println();
			    }*/
}
			  public static void update(){
				  if(evaluate(A)){
					  for (int r = 0; r < 9; r++){
						  for (int u = 0; u < 9; u++){
							  String Q=Integer.toString(A[r][u]);
							  panel_1.add( new JLabel(Q));}// Move to the next free cell 
	}      
}
	 }
			  /** Search for Solution */
			  public static boolean evaluate(int[][] B) {
			    int[][] AllEmptyCells =EmptyCells(B); // Free cells
			    if (AllEmptyCells.length == 0) 
			      return true; // "No free cells");
			    int k = 0; // Start from the first free cell      
			    while (true) {
			      int i = AllEmptyCells[k][0];
			      int j = AllEmptyCells[k][1];
			      if (B[i][j] == 0) 
			        B[i][j] = 1; 
			      // Fill the free cell with number 1

			      if (CorrectValues(i, j, B)) {
			        if (k + 1 == AllEmptyCells.length) { // No more free cells 
			        	return true; // A solution is found
			        }
			        else { // Move to the next free cell
			          k++;
			        }
			      }
			      else if (B[i][j] < 9) {
			        // Fill the free cell with the next possible value
			        B[i][j] = B[i][j] + 1; 
			      }
			      else { // free cell grid[i][j] is 9, backtrack
			        while (B[i][j] == 9) {
			          if (k == 0) {
			            return false; // No possible value
			          }
			          B[i][j] = 0; // Reset to free cell
			          k--; // Backtrack to the preceding free cell
			          i = AllEmptyCells[k][0];
			          j = AllEmptyCells[k][1];
			        }
			        // Fill the free cell with the next possible value, 
			        // search continues from this free cell at k
			        B[i][j] = B[i][j] + 1; 
			      }
			    }  
			  }
			  public static boolean CorrectValues(int i, int j, int[][] B) {
			    // Check whether grid[i][j] is valid at the i's row
			    for (int column = 0; column < 9; column++){
			      if (column != j && B[i][column] == B[i][j]){
			        return false;}
			    }
			    // Check whether grid[i][j] is valid at the j's column
			    for (int row = 0; row < 9; row++){
			      if (row != i && B[row][j] == B[i][j]){
			        return false;}
			    }
			    // Check whether grid[i][j] is valid in the 3 by 3 box
			    for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++){
			      for (int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++){
			        if (row != i && col != j && B[row][col] == B[i][j]){
			          return false;
			        }
			      }
			    }
			    return true; // The current value at grid[i][j] is valid
			      }

			  /** Check if the puzzle is valid */
			  public static boolean CorrectValues(int[][] B) {
			    for (int i = 0; i < 9; i++){
			      for (int j = 0; j < 9; j++){
			        if (B[i][j] < 0 || B[i][j] > 9 || (B[i][j] != 0 && !CorrectValues(i, j, B))) {
			          return false;
			        }
			       
			      }
			}   return true; 
			  }

}
