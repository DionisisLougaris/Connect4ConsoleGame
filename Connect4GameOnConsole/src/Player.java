import java.util.Random;
import java.util.Scanner;

public class Player {
	private String name;
	private char pawn;
	private Board x;

	public Player(String text1,char text2)
	{
		name=text1;
		pawn=text2;
	}
	//Info input
	public void readName(String id)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter the name of the "+ id +" player:");
		name = keyboard.nextLine();
		
	}
	public void readPawn(String name)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println(this.name + ",please select your chip:");
		pawn = keyboard.next().charAt(0);
		while(pawn != 'x' && pawn != 'o')
		{
			pawn = keyboard.next().charAt(0);
			
		}
		if(pawn == 'x') 
			System.out.println(name +" your chip is: o");	
		else
			System.out.println(name +" your chip is: x");	
		
	}
	public int chooseFirst(Player p,char[][] array)
	{
		int a=1;
	    int b=2;
	    int randomOfTwoInts = new Random().nextBoolean() ? a : b;
	    if(randomOfTwoInts==1)
	    	this.PlayMove(array);
	    else
	    	p.PlayMove(array);
	    
	   return randomOfTwoInts;
	    
	}
	//Column chosen by player
	public void PlayMove(char[][] array)
	{
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println(this.name + ",your turn.Select column:");
		int move=keyboard.nextInt()-1;
		int max=-1;
		for(int i=0;i<array.length;i++)
		{
			if(array[i][move]=='-')
				max=i;	
		}
		array[max][move]= this.getPawn();
		
		
		for(int i=0;i<array.length;i++)
		{
			System.out.print("| ");
			for(int j=0;j<array[0].length;j++)
				System.out.print(array[i][j] +" ");
			System.out.println("|"); 
		}	
		for(int i=0;i<(array[0].length+2)*2-1;i++)
			System.out.print("-");
		System.out.println();
		System.out.print("  ");
		for(int i=1;i<((array[0].length)+1);i++)
			System.out.print(i+" ");
		System.out.println();
	}
	//Win conditions
	public boolean VerticalWin(char[][] array)
	{
		for (int i = 0; i<array.length-3 ; i++ )
		{
	        for (int j = 0; j<array[0].length; j++)
	        {
	            if (array[i][j] == this.pawn && array[i+1][j] == this.pawn && array[i+2][j] == this.pawn && array[i+3][j] == this.pawn)
	            {
	                return true;
	            }  
	
	        }
	    }
		return false;
}
	
	public boolean HorizontalWin(char[][] array)
	{
		 for (int j = 0; j<array.length-3 ; j++ ){
		        for (int i = 0; i<array[0].length; i++){
		            if (array[i][j] == this.pawn && array[i][j+1] == this.pawn && array[i][j+2] == this.pawn && array[i][j+3] == this.pawn){
		                return true;
		            }           
		        }
		    }
		 return false;
		
	}
	public boolean AscendingDiagonalWin(char[][] array)
	{
		
		for (int i=3; i<array.length; i++){
	        for (int j=0; j<array[0].length-3; j++)
	        {
	            if (array[i][j] == this.pawn && array[i-1][j+1] == this.pawn && array[i-2][j+2] == this.pawn && array[i-3][j+3] == this.pawn)
	                return true;
	        }
	    }
		return false;
	}
	public boolean DescendingDiagonalWin(char[][] array)
	{
		for (int i=3; i<array.length; i++){
	        for (int j=3; j<array[0].length; j++)
	        {
	            if (array[i][j] == this.pawn && array[i-1][j-1] == this.pawn && array[i-2][j-2] == this.pawn && array[i-3][j-3] == this.pawn)
	                return true;
	        }
	    }
	    return false;
	}
	//Getters and Setters
	public char getPawn() {
		return pawn;
	}
	public void setPawn(char pawn) {
		this.pawn = pawn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
