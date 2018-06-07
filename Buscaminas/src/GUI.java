

import processing.core.PApplet;


	public class GUI extends PApplet {

		/*
		 * 
		 */
		public int width = 360, height = 360, size = 40, rule = 90;
		public int rows = 9, columns = 9;
		Buscaminas busca = new Buscaminas(rows, columns);
		
		/**
		 * 
		 */
		public void settings()
		{
			size(width, height);
		}
			
		
		/**
		 * 
		 */
		public void draw()
		{
			background(0);
			stroke(20);
			
			for(int i = 0; i < rows; i++)
			{
				
				for(int j =0; j < columns; j++)
				{
					if(busca.board[i][j] == 1)
						fill(255,0,0);
					else
						fill(255);
					
					rect(i * size , j * size , size, size);
					fill(0,255,0);
					if (busca.board[i ][j ] != 0){
					text(busca.board[i][j] , (i * size)+size/2 , (j * size)+size/2);
					}
				}
			}							
		}
		
		public void mousePressed() 
		{
			int x = mouseX/width;
			int y = mouseY/width;
			int s = 0;
			
			for (int i = 1; i < busca.board.length; i++ ) {
				for (int j = 1; j < busca.board.length; j++ ) {
					System.out.println("dx , Dy" + i + j);
					if (inbounds((x + i),(y + j)) && busca.board[y + j][x + i]==1) {
						s=+1;
					}
					if (s > 0) {
						busca.board[y][x] =s;
							
					}
				}
				
			}
			
		}
		
		public boolean inbounds (int x ,int y ) {
			
			if ( x >= 0 && x < columns && y < rows) {
				return true;
				
			}
			return false;
		}
		
		/**
		 * 
		 * @param args
		 */
		public static void main(String[] args) 
		{
			String[] appletArgs = new String[] {"GUI"};
			PApplet.main(appletArgs);
		}
	}
	