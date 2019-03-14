// nog niet klaar
import java.util.Scanner;

public class TicTacToe
{

	private static char[][] board = new char[3][3];

	public static void main( String[] args )
	{
    Scanner keyboard = new Scanner(System.in);
		int row, column;

		char currentPlayer = 'X';
		boolean won = false;
		boolean tie = false;

		initBoard();
		displayBoard2();
		System.out.print(currentPlayer + ", choose your location (row, column): ");
		row = keyboard.nextInt();
		column = keyboard.nextInt();
		board[row][column] = currentPlayer;

		displayBoard2();

		// bij deze opdracht heb ik heel lang vast gezeten doordat ik (!won || !tie) had terwijl ik dacht dat het aan de methods 'checkWin' en 'checkTie' lag...
		while (!won && !tie) {
			if (currentPlayer == 'O')
			{
				currentPlayer = 'X';
			}
			else
			{
				currentPlayer = 'O';
			}

			boolean valid = false;
			System.out.print(currentPlayer + ", choose your location (row, column): ");
			row = keyboard.nextInt();
			column = keyboard.nextInt();

			if (board[row][column] == ' ')
			{
				valid = true;
			}

			while(!valid)
			{
				System.out.print(currentPlayer + ", that spot is already taken. Try again: ");
				row = keyboard.nextInt();
				column = keyboard.nextInt();

				if (board[row][column] == ' ')
				{
					valid = true;
				}
			}

			board[row][column] = currentPlayer;

			won = checkWin();
			tie = checkTie();

			displayBoard2();
		}

		if (tie)
		{
			System.out.println("It's a tie!");
		} else
		{
			System.out.println(currentPlayer + ", you won!");
		}

	}

	public static void initBoard()
	{
		// fills up the board with blanks
		for ( int r=0; r<3; r++ )
			for ( int c=0; c<3; c++ )
				board[r][c] = ' ';
	}


	public static void displayBoard()
	{
    System.out.println();
		System.out.println("  0  " + board[0][0] + "|" + board[0][1] + " |" + board[0][2]);
		System.out.println("    --+--+--");
		System.out.println("  1  " + board[1][0] + "|" + board[1][1] + " |" + board[1][2]);
		System.out.println("    --+--+--");
		System.out.println("  2  " + board[2][0] + "|" + board[2][1] + " |" + board[2][2]);
		System.out.println("     0 1 2 ");
  	System.out.println();
	}

	public static boolean checkWin()
	{
		for (int r = 0; r < 3; r++)
		{
			// horizontal
			if (board[r][0] == board[r][1] && board[r][1] == board[r][2] && board[r][0] != ' ')
			{
				return true;
			}

			// vertical
			else if (board[0][r] == board[1][r] && board[1][r] == board[2][r] && board[2][r] != ' ')
			{
				return true;
			}
		}

		// diagonal
		if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2] != ' ')
		{
			return true;
		} else if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[2][0] != ' ')
		{
			return true;
		}

		return false;
	}

	public static boolean checkTie()
	{
		boolean[] b = new boolean[3];

		for (int r = 0; r < 3; r++)
		{
			if (board[r][0] != ' ' && board[r][1] != ' ' && board[r][2] != ' ')
			{
				b[r] = true;
			}
		}

		if (b[0] && b[1] && b[2])
		{
			return true;
		}
		else
		{
			return false;
		}

	}


	public static void displayBoard2()
	{
		System.out.println();
		System.out.println("\t  0 1 2 ");
		for ( int r=0; r<3; r++ )
		{
			System.out.print("\t"+r+" ");
			for ( int c=0; c<3; c++ )
			{
				System.out.print( board[r][c] + " " );
			}
			System.out.println();
		}
		System.out.println();
	}
}
