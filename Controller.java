public class Controller 
{
	private String playerTurn;
	private Board board;
	private SideHud sideHud;
	private int crossWon = 0;
	private int noughtWon = 0;
	private int round = 1;
	
	public Controller(int stageSize)
	{
		board = new Board(stageSize);
		sideHud = new SideHud();
		
		//randomly select cross or nought
		if(Math.random() < 0.5)
			playerTurn = Block.MARK_CROSS;
		else
			playerTurn = Block.MARK_NOUGHT;
		
		updateSideHud();
	}
	
	public void writeMark(Block b)
	{
		if(playerTurn == Block.MARK_CROSS && !b.getDisabled())
			b.drawCross();
		else if(playerTurn == Block.MARK_NOUGHT && !b.getDisabled())
			b.drawNought();
	}
	
	public boolean isGameOver()
	{
		if(checkHoriz() || checkVert() || checkLeftDiag() || checkRightDiag())
		{
			round++;
			
			if(playerTurn == Block.MARK_NOUGHT)
				noughtWon++;
			else if(playerTurn == Block.MARK_CROSS)
				crossWon++;
			
			return true;
		}
		
		return false;
	}
	
	private boolean checkHoriz()
	{
		Block[][] blocks = board.getBlocks();
		Block[] markBlocks = new Block[blocks[0].length]; 
		for(int r = 0; r < blocks.length; r++){
			for(int c = 0; c < blocks[r].length; c++){
				markBlocks[c] = blocks[r][c];
				if(!blocks[r][c].toString().equals(playerTurn)){
					markBlocks = null;
					markBlocks = new Block[blocks[0].length];
					break;
				}
				else if(c == blocks[r].length-1){
					for(int i = 0; i < markBlocks.length; i++)
						markBlocks[i].setMatch();
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean checkVert()
	{
		Block[][] blocks = board.getBlocks();
		Block[] markBlocks = new Block[blocks[0].length]; 
		for(int c = 0; c < blocks.length; c++){
			for(int r = 0; r < blocks[c].length; r++){
				markBlocks[r] = blocks[r][c];
				if(!blocks[r][c].toString().equals(playerTurn)){
					markBlocks = null;
					markBlocks = new Block[blocks[0].length];
					break;
				}
				else if(r == blocks[c].length-1){
					for(int i = 0; i < markBlocks.length; i++)
						markBlocks[i].setMatch();
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean checkLeftDiag()
	{
		Block[][] blocks = board.getBlocks();
		Block[] markBlocks = new Block[blocks.length]; 
		
		int col = 0;
		int row = 0;
		
		for(int i = 0; i < blocks.length; i++){
			markBlocks[i] = blocks[row][col];
			if(!blocks[row][col].toString().equals(playerTurn))
				return false;
			col++;
			row++;
		}
		
		for(int i = 0; i < markBlocks.length; i++)
			markBlocks[i].setMatch();
		
		return true;
	}
	
	private boolean checkRightDiag()
	{
		Block[][] blocks = board.getBlocks();
		Block[] markBlocks = new Block[blocks.length]; 
		
		int col = blocks.length-1;
		int row = 0;
		
		for(int i = 0; i < blocks.length; i++){
			markBlocks[i] = blocks[row][col];
			if(!blocks[row][col].toString().equals(playerTurn))
				return false;
			col--;
			row++;
		}
		
		for(int i = 0; i < markBlocks.length; i++)
			markBlocks[i].setMatch();
		
		return true;
	}
	
	public boolean isBoardFull()
	{
		Block[][] blocks = board.getBlocks();
		
		for(int r = 0; r < blocks.length; r++){
			for(int c = 0; c < blocks[r].length; c++){
				if(blocks[r][c].toString().equals(Block.MARK_NONE))
					return false;
			}
		}
		
		round++;
		
		return true;
	}
	
	public void resetBoard()
	{
		board.resetBoard();
	}
	
	public Board getBoard()
	{
		return board;
	}
	
	public void updateSideHud()
	{
		sideHud.setTurn(playerTurn);
		sideHud.setXTimesWon(crossWon);
		sideHud.setOTimesWon(noughtWon);
		sideHud.setRound(round);
	}
	
	public void resetSideHud()
	{
		crossWon = 0;
		noughtWon = 0;
		round = 1;
		updateSideHud();
		
		Block[][] blocks = board.getBlocks();
		
		for(int r = 0; r < blocks.length; r++){
			for(int c = 0; c < blocks[r].length; c++){
				blocks[r][c].resetBlock();
			}
		}
	}
	
	public void changePlayerTurn()
	{
		if(playerTurn == Block.MARK_NOUGHT)
			playerTurn = Block.MARK_CROSS;
		else if(playerTurn == Block.MARK_CROSS)
			playerTurn = Block.MARK_NOUGHT;
	}
	
	public SideHud getSideHud()
	{
		return sideHud;
	}
	
	public String getPlayerTurn()
	{
		return playerTurn;
	}
}
