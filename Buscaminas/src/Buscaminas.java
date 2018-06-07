import java.util.Random;


public class Buscaminas  {
	

	


	public int rows, columns, numbombs = 10 ;
	

	
	public int[][] board = null;
	public int[][] label = null;
	

	
	public Buscaminas(int rows, int columns)
	{
		this.rows = rows;
		this.columns = columns;
		
		
		this.board = new int[rows][columns];
		this.bombas();
		
	}
	
	public void bombas()
	{
		
		Random rd = new Random();
		int x , y ;
		for(int i = 0; i < numbombs;i++ )
		{
			while (true)
			{
				x = rd.nextInt(this.rows);
				y = rd.nextInt(this.columns);
				if (this.board[x][y] == 0)
				{
					
					this.board[x][y] = 1;
					break;
				}					
			}
		}			
	}
       

	public static void main(String[] args) {
		
		}
	}


