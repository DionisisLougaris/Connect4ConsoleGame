import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.Random;


public class Main {

	public static void main(String[] args) {
		System.out.println("This is score 4!");
		
		Player p1 = new Player(" ",' ');
		p1.readName("1st");
		
		Player p2 = new Player(" ",' ');
		p2.readName("2nd");
		
		p1.readPawn(p2.getName());
		if(p1.getPawn()=='x')
			p2.setPawn('o');
		else 
			p2.setPawn('x');
		
		Board info = new Board(0,0);
		info.readBoard();
	    char[][] connect4 = new char[info.getRows()][info.getCols()];
	    connect4=createBoard(info.getRows(),info.getCols());
	    info.printBoard(connect4);
	    int first=p1.chooseFirst(p2,connect4);
	    int turn=first;
	    boolean win=false;
	   //Game 
	  while(isFull(connect4)== false && win==false)
	  {
		  if(turn%2==1)
		  {
			  p2.PlayMove(connect4);
			  turn++;
			  if(p2.VerticalWin(connect4)==true)
			  {
				  System.out.println(p2.getName()+",has won,Good Game!");
				  win=true;
			  }
			  
			  if(p2.HorizontalWin(connect4)==true)
			  {
				  System.out.println(p2.getName()+",has won,Good Game!");
				  win=true;
			  }
			  if(p2.AscendingDiagonalWin(connect4)==true)
			  {
				  System.out.println(p2.getName()+",has won,Good Game!");
				  win=true;
			  }
			  if(p2.DescendingDiagonalWin(connect4)==true)
			  {
				  System.out.println(p2.getName()+",has won,Good Game!");
				  win=true;
			  }
			  
		  }	
		  else if(turn%2==0)
		  {
			  p1.PlayMove(connect4);
			  turn++;
			  if(p1.VerticalWin(connect4)==true)
			  {
				  System.out.println(p1.getName()+",has won,Good Game!");
				  win=true;
			  }
			  
			  if(p1.HorizontalWin(connect4)==true)
			  {
				  System.out.println(p1.getName()+",has won,Good Game!");
				  win=true;
			  }
			  if(p1.AscendingDiagonalWin(connect4)==true)
			  {
				  System.out.println(p1.getName()+",has won,Good Game!");
				  win=true;
			  }
			  if(p1.DescendingDiagonalWin(connect4)==true)
			  {
				  System.out.println(p1.getName()+",has won,Good Game!");
				  win=true;
			  }
		  }
		  
	  }
	}
	//Board creation
	public static char[][]createBoard(int x,int y) 
	{	
			char[][] array= new char[x][y];
			for(int i=0;i<x;i++)
			{
				for(int j=0;j<y;j++)
				{
					array[i][j]='-';	
				}
			}
			return array;		
	}
	//Checking capacity
	public static boolean isFull(char[][] array)
	{
		for(int i=0;i<array.length;i++)
			for(int j=0;j<array[0].length;j++)
				if(array[i][j]=='-')
					return false;
		System.out.println("Draw! Well Played!");
		return true;
				
	}
}
