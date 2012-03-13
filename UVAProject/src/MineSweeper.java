import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;
import java.util.ArrayList;


/*
10189 - Minesweeper UVA

The Problem

Have you ever played Minesweeper? It's a cute little game which comes within a certain Operating System which name we can't really remember. Well, the goal of the game is to find where are all the mines within a MxN field. To help you, the game shows a number in a square which tells you how many mines there are adjacent to that square. For instance, supose the following 4x4 field with 2 mines (which are represented by an * character):

*...
....
.*..
....
If we would represent the same field placing the hint numbers described above, we would end up with:
*100
2210
1*10
1110
As you may have already noticed, each square may have at most 8 adjacent squares.
The Input

The input will consist of an arbitrary number of fields. The first line of each field contains two integers n and m (0 < n,m <= 100) which stands for the number of lines and columns of the field respectively. The next n lines contains exactly m characters and represent the field. Each safe square is represented by an "." character (without the quotes) and each mine square is represented by an "*" character (also without the quotes). The first field line where n = m = 0 represents the end of input and should not be processed.

The Output

For each field, you must print the following message in a line alone:

Field #x:
Where x stands for the number of the field (starting from 1). The next n lines should contain the field with the "." characters replaced by the number of adjacent mines to that square. There must be an empty line between field outputs.
Sample Input

4 4
*...
....
.*..
....
3 5
**...
.....
.*...
0 0
Sample Output

Field #1:
*100
2210
1*10
1110

Field #2:
**100
33200
1*100


*/


class Mine
{
	String[][] mineTable,solution;
	int rows;
	int columns;
	public Mine()
	{
		mineTable=new String[4][4];
		this.rows=4;
		this.columns= 4;
	}
	public Mine(int rows, int columns)
	{
		mineTable = new String[rows][columns];
		this.rows=rows;
		this.columns= columns;
	}
	
	public void setMineByRow(int rowindex, String str)
	{
		if(str.length()!=columns)
			System.out.println("wrong input");
		else
		{
			int i=0;
			while(i<str.length())
			{
				mineTable[rowindex][i]=""+str.charAt(i);
				i++;
			}
		}
	}

	
	public void printMine()
	{
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<columns;j++)
				System.out.print(mineTable[i][j]+" ");
			System.out.println();
		}
		
	}
	
	public void printSolution()
	{
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<columns;j++)
				System.out.print(solution[i][j]+"");
			System.out.println();
		}
		
	}
	
	public void solveMine()
	{
		solution =  new String[rows][columns];
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<columns;j++)
			{
				 if(mineTable[i][j].equals("*"))
					 {
					 solution[i][j]="*";
					 adjacentFields(i, j);
					 }
				 else {
					//solution[i][j]=""+adjacentMines(i,j);
				}
				
			}
		}
		
		
		
		
		
	}
	
	
	public void adjacentFields(int row, int column)
	{
		/*int i=0,j=0;
		int imax,jmax;
		if(row>0)
			i=-1;
		if(row<rows)
			imax=rows;
		else {
			imax=rows-1;
		}
		if(column>0)
			j=-1;
		if(column<columns)
			jmax=columns;
		else {
			jmax = columns-1;
		}
		for(;i<imax;i++)
		{
			for(;j<jmax;j++)
			{
				if(!solution[i][j].equals("*"))
				solution[i][j] = ""+Integer.parseInt(solution[i][j])+1;
			}
			
		}*/
		
		
		if(row>0 && column>0)
		{
			solution[row][column] =""+ Integer.parseInt(solution[row][column])+1;
			solution[row][column] =""+ Integer.parseInt(solution[row][column])+1;
			solution[row][column] =""+Integer.parseInt(solution[row][column])+1;
			solution[row][column] =""+Integer.parseInt(solution[row][column])+1;
			
			
		}
		
		
	}
	
	public int adjacentMines(int row, int column)
	{
		int mines=0;
		if(row>0 && row<3)
		{
			int j=0;
			if(column>0 && column<3)
			{
				for(j=-1;j<1;j++)
					{	if(mineTable[row-1][column+j].equals("*"))
							mines++;
						if(mineTable[row][column+j].equals("*"))
							mines++;
						if(mineTable[row+1][column+j].equals("*"))
							mines++;
					
					}
			}
			else {
				for(j=0;j<1;j++)
					{	
						if(mineTable[row-1][column+j].equals("*"))
						mines++;
						if(mineTable[row][column+j].equals("*"))
							mines++;
						if(mineTable[row+1][column+j].equals("*"))
							mines++;
					}
			}
		}
		else 
		{
			int j=0;
			if(column>0 && column<3)
			{
				for(j=-1;j<1;j++)
					{	
						if(mineTable[row][column+j].equals("*"))
							mines++;
						
					
					}
			}
			else {
				for(j=0;j<1;j++)
					if(mineTable[row][column+j].equals("*"))
						mines++;
			}
			
		}
	
		return mines;
	}
	
}



public class MineSweeper {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println((int)'*');
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader bReader = new BufferedReader(isr);
		String str=null;
		try {
			
			ArrayList<Mine> mineMaze = new ArrayList<Mine>();
		
			while(!(str=bReader.readLine()).equals("0 0"))
			{
				
			   int rows = Integer.parseInt(str.substring(0,str.indexOf(" ")));
			   int columns = Integer.parseInt(str.substring(str.indexOf(" ")+1));
			   Mine objMine = new Mine(rows,columns);
			   mineMaze.add(objMine);
			   for(int i=0;i<rows;i++)
				   objMine.setMineByRow(i, bReader.readLine());
			   /*System.out.println("Mine----");
			   objMine.printMine();
			   objMine.solveMine();
			   System.out.println("Solution----");
			   objMine.printSolution();*/
			   
			   
			   
			   
			   
			}
		
			
			for(int i=0;i<mineMaze.size();i++)
			{
				System.out.println("Field #"+i);
				mineMaze.get(i).solveMine();
				mineMaze.get(i).printSolution();
				
			}
			
			
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("IO Exception..");
		}
	}

}
