package Ejercicios_Matrices;



public class Juego_De_La_Vida {

		
		public int rows, columns;
		public double aliveRate;
		public int[][] board = null;
		
		public Juego_De_La_Vida(int rows, int columns, double aliveRate)
		{
			this.rows = rows;
			this.columns = columns;
			this.aliveRate = aliveRate;
			
			this.board = new int[rows][columns];
			this.randomInit();
		}
		

		public void randomInit()
		{
			for(int i = 0; i < rows; i++)
				for(int j = 0; j < columns; j++)
					this.board[i][j] = Math.random() < aliveRate ? 1 : 0;
		}
		
		
		public int countNeighborsToroidal(int i, int j)
		{
			int width = board [i].length;
			int heigth = board .length;
			return board[(i - 1 + heigth) % heigth][(j - 1 + width) % width ] + board[(i - 1 + heigth) % heigth ][j] +
				   board[(i - 1 + heigth) % heigth][(j + 1) % width ]         + board[i][(j - 1 + width) % width] +
				   board [i][(j + 1)% width]  + board[(i + 1) % heigth][(j - 1 + width) % width] + 
				   board[(i + 1) % heigth][j] + board[(i + 1)% heigth][(j + 1) % width];
   		}
		
		
		public int countNeighbors(int i, int j)
		{
			int counter;
			if (i == 0){
				counter = board[i - 1][j] + board[i - 1][j + 1] +  board[i][j + 1]
						+ board[i + 1][j] + board[i + 1][j + 1];
			
				if(j == board[i].length -1)
					counter = board[i - 1][j - 1] +  board[i - 1][j] +  board[i][j - 1];
				else
					counter = board[i - 1][j - 1] + board[i - 1][j] + board[i - 1][j + 1] 
					        + board[i][j - 1]     + board[i][j + 1];
						
		}
		else
		{
			if (j == 0)
				counter = board[i - 1][j] + board[i - 1][j + 1] +  board[i][j + 1]
						+ board[i + 1][j] + board[i + 1][j + 1];
			else
				if(j == board[i].length -1)
					counter = board[i - 1][j - 1] +  board[i - 1][j] +  board[i][j - 1]
							+ board[i + 1][j - 1] + board [i + 1][j] ;
				else
					counter = board[i - 1][j - 1] + board[i - 1][j]  
					        + board[i - 1][j + 1] + board[i][j - 1]
							+ board[i][j + 1];
		}
		return counter;
		}
		
		
		
		public void iterations()
		{
			int[][] next_generation = this.board.clone();
			
			
			for(int x = 1; x < rows -1; x++) {
				for(int y = 1; y < columns - 1; y++) 
				{
					int counter = 0;
					for(int i = -1; i <= 1; i++) {
						for(int j = -1; j <= 1; j++)
						{
							counter +=board [x+i] [y+j];	
										
														
						}
					}
					counter -= board[x][y];
					
					if      ((board [x][y] == 1) && (counter <  2)) next_generation[x][y] = 0;
					else if ((board [x][y] == 1) && (counter >  3)) next_generation[x][y] = 0;
					else if ((board [x][y] == 0) && (counter == 3)) next_generation[x][y] = 1;
					else                                            next_generation[x][y] = board [x][y];
				}
			}
			board = next_generation.clone();

			
		
		}
	}

