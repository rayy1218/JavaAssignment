import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;



public class Game implements ActionListener {
    //int[][] map;
    //int move;

    private int Dimension = 4; 					//Dimension of Board
    private int Size = Dimension * Dimension;	//Total Size of Board
    private int Height = 500, Width = 500;		//Height and Width of Board
    private int emptyCell = Size;				//Total empty Cells in the Beginning

    final String[] WIN = new String[Size-1];
    private JButton[][] bbt = new JButton[Dimension][Dimension];
    private JFrame fr = new JFrame("This is a Test Frame");
	private JPanel pn = new JPanel();


    //Constructor to start a game
    public Game() {
    	for (int i = 1; i < Size; i++) {
            WIN[i-1] = Integer.toString(i);
        }

        System.out.println("Win State:" + Arrays.asList(WIN) );
    }

    public static void main(String[] args)
    {
    	Game game = new Game();
    	game.GameBoard();
    }

    private int getIndex(int i, int j) {
        return ((i * Dimension) + j);
    }

    public void GameBoard () {
    	ArrayList<Integer> list = new ArrayList<Integer>(Size);

        list = new ArrayList<Integer>(Size);
        for (int i = 0; i <= Size - 1; i++) {
            list.add(i);
        }

        Collections.shuffle(list);


    	System.out.println("Initial Board state:" + list);

    	for (int i = 0; i < Size; i++) {
            final int ROW = i / Dimension;  // row number from index
            final int COL = i % Dimension;   // column number from index
            bbt[ROW][COL] = new JButton(String.valueOf(list.get(i)));
            // Initializes the empty square and hide it
            if (list.get(i) == 0) {
                emptyCell = i;
                bbt[ROW][COL].setVisible(false);
            }

            // Decorating each square
            bbt[ROW][COL].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            bbt[ROW][COL].setBackground(Color.DARK_GRAY);
            bbt[ROW][COL].setForeground(Color.magenta);
            bbt[ROW][COL].setFont(new Font("Times New Roman", Font.BOLD, 50));
            bbt[ROW][COL].addActionListener(this);
            pn.add(bbt[ROW][COL]);
        }

    	fr.setSize(Height,Width);
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Initializing the Panel and the Content in it
		pn.setLayout(new GridLayout(Dimension, Dimension));
		pn.setBackground(Color.LIGHT_GRAY);

		java.awt.Container content = fr.getContentPane();
        content.add(pn, BorderLayout.CENTER);
        content.setBackground(Color.GRAY);
        fr.setVisible(true);

    }

    public void actionPerformed(ActionEvent event) throws IllegalArgumentException {
        JButton buttonPressed = (JButton) event.getSource();
        int index = indexOf(buttonPressed.getText());
        if (index == -1) {
            throw (new IllegalArgumentException("Index must be between 0-15"));
        }
        int row = index / Dimension;
        int column = index % Dimension;

        // If pressed button in same row or same column
        move(row, column);

        // If the game is finished and completed, "You Win the Game" a dialog will appear
        if (checkWin()) {
            JOptionPane.showMessageDialog(null, "You Win The Game.");
        }
    }

    private int indexOf(String cellNum) {
        for (int ROW = 0; ROW < bbt.length; ROW++) {
            for (int COL = 0; COL < bbt[ROW].length; COL++) {
                if (bbt[ROW][COL].getText().equals(cellNum)) {
                    return (getIndex(ROW, COL));
                }
            }
        }
        return -1;   // Wrong input returns -1
    }

    //Try to move a number in the map return if the move is valid
    public boolean move(int row, int col) {
    	final int empRow = emptyCell / Dimension;	// Empty cell row number
        final int empCol = emptyCell % Dimension;	// Empty cell column number
        int RowDiff = empRow - row;
        int ColDiff = empCol - col;
        boolean InRow = (row == empRow);
        boolean InCol = (col == empCol);
        boolean NotDiagonal = (InRow || InCol);

        if(NotDiagonal) {
        	int Difference = Math.abs(ColDiff);

        	// if - ve Difference, move the tile to the left by 1
        	if (ColDiff < 0 & InRow) {
                for (int i = 0; i < Difference; i++) {
                    bbt[empRow][empCol + i].setText(
                    	bbt[empRow][empCol + (i + 1)].getText()
                    );
                }
        	}

        	// if + ve Difference, move the tile to the right by 1
        	else if (ColDiff > 0 & InRow) {
                for (int i = 0; i < Difference; i++) {
                    bbt[empRow][empCol - i].setText(
                    	bbt[empRow][empCol - (i + 1)].getText()
                    );
                }
            }

        	Difference = Math.abs(RowDiff);

        	// if - ve Difference, move the tile to the up by 1
        	if (RowDiff < 0 & InCol) {
                for (int i = 0; i < Difference; i++) {
                    bbt[empRow + i][empCol].setText(
                    	bbt[empRow + (i + 1)][empCol].getText()
                    );
                }

            }

        	// if + ve Difference, move the tile to the down by 1
        	else if (RowDiff > 0 & InCol) {
                for (int i = 0; i < Difference; i++) {
                	bbt[empRow - i][empCol].setText(
                        bbt[empRow - (i + 1)][empCol].getText()
                    );
                }
        	}
        	bbt[empRow][empCol].setVisible(true);
            bbt[row][col].setText(Integer.toString(0));
            bbt[row][col].setVisible(false);
            emptyCell = getIndex(row, col);
        }
        return true;
    }


    public boolean checkWin() {
        for(int i = WIN.length - 1; i >= 0; i--) {
            String number = bbt[i / Dimension][i % Dimension].getText();
            if (!number.equals(WIN[i])) {
                return false;	// If any of the index is not aligned will return false
            }
        }
        return true;
    }
}
