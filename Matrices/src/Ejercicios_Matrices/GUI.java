package Ejercicios_Matrices;

import processing.core.PApplet;


	public class GUI extends PApplet {

		/*
		 * 
		 */
		public int width = 900, height = 600, size = 3, rule = 90;
		public int rows = height / size, columns = width / size;
		//Fractales chaos = new Fractales(rule, rows, columns);
		Juego_De_La_Vida life = new Juego_De_La_Vida(rows, columns, 0.15);
		
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
			
			//For Game of Life
			for(int i = 0; i < rows; i++)
			{
				for(int j = 0; j < columns; j++)
				{
					if(life.board[i][j] == 0)
						fill(0);
					else
						fill(255);
					
					rect(j * size, i * size, size, size);
				}
			}
			
			life.iterations();
			
			//For chaos 
			/*for(int i = 0; i < rows; i++)
				for(int j = 0; j < columns; j++)
				{
					if(chaos.matrix[i][j] == 0)
						fill(0);
					else
						fill(255);
					
					rect(j * size, i * size, size, size);
				}
					
			chaos.iterations();*/
						
			try
			{
				Thread.sleep(100);
			}
			catch(Exception ex) {}
		}
		
		
		/**
		 * 
		 * @param args
		 */
		public static void main(String[] args) 
		{
			String[] appletArgs = new String[] {"Ejercicios_Matrices.GUI"};
			PApplet.main(appletArgs);
		}
	}