import java.util.Scanner;

public class Board {
	private int rows;
	private int cols;
	
	public Board(int x,int y)
	{
		rows=x;
		cols=y;
	}
	//Info input
	public void readBoard() 
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter the number of rows:");
		rows=keyboard.nextInt();
		while(rows < 4 || rows>15)
		{
			System.out.println("Incorrect input. Please enter the number of rows:");
			rows=keyboard.nextInt();
		}
		System.out.println("Please enter the number of columns:");
		cols=keyboard.nextInt();
		while(cols < 4 || cols>15)
		{
			System.out.println("Incorrect input. Please enter the number of columns:");
			cols=keyboard.nextInt();
		}
	}
	//Info output
	public void printBoard(char[][] table)
	{
		for(int i=0;i<table.length;i++)
		{
			System.out.print("| ");
			for(int j=0;j<table[0].length;j++)
				System.out.print(table[i][j] +" ");
			System.out.println("|"); 
		}	
		for(int i=0;i<(table[0].length+2)*2-1;i++)
			System.out.print("-");
		System.out.println();
		System.out.print("  ");
		for(int i=1;i<((table[0].length)+1);i++)
			System.out.print(i+" ");
		System.out.println();
	}
	
	//Getters and Setters
	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}
	
}
