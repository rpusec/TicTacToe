import java.awt.*;

import javax.swing.*;

public class Board extends JPanel
{
	private static final long serialVersionUID = 1L;
	private Block[][] blocks; //contains the blocks
	
	public Board(int stageSize)
	{
		blocks = new Block[stageSize][stageSize];
		setLayout(new GridLayout(stageSize, stageSize));
		buildBoard();
	}
	
	private void buildBoard()
	{	
		//adding blocks to array and to board
		for(int r = 0; r < blocks.length; r++){
			for(int c = 0; c < blocks[r].length; c++){
				Block b = new Block();
				blocks[r][c] = b;	//adds to array
				add(b); 			//adds to board
			}
		}
	}
	
	public void resetBoard()
	{
		for(int r = 0; r < blocks.length; r++){
			for(int c = 0; c < blocks[r].length; c++){
				blocks[r][c].resetBlock();
			}
		}
	}
	
	public Block[][] getBlocks()
	{
		return blocks;
	}
}
