import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class GameWindow extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JMenu jmFile, jmOptions, jmAbout;
	private JMenuItem jmiExit, jmiClear, jmiAbout;
	private Controller controller;
	
	public GameWindow(int stageSize)
	{
		//setting up the menu
		createMenu();
		
		//setting up the controller
		controller = new Controller(stageSize);
		
		//title, layout
		setTitle("Tic Tac Toe");
		setLayout(new BorderLayout());
		
		//adding the board
		add(controller.getBoard(), "Center");
		add(controller.getSideHud(), "South");
		
		//adding action listeners
		Block[][] blocks = controller.getBoard().getBlocks();
		for(int r = 0; r < blocks.length; r++){
			for(int c = 0; c < blocks[r].length; c++){
				blocks[r][c].addActionListener(this);
			}
		}
		
		//setting up the initial information
		setSize(500, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	private void createMenu()
	{
		JMenuBar jmb = new JMenuBar();
		
		jmFile = new JMenu("File");
		jmOptions = new JMenu("Options");
		jmAbout = new JMenu("Help");
		
		jmiExit = new JMenuItem("Exit");
		jmiClear = new JMenuItem("Reset");
		jmiAbout = new JMenuItem("About");
		
		jmFile.add(jmiExit);
		jmOptions.add(jmiClear);
		jmAbout.add(jmiAbout);
		
		jmb.add(jmFile);
		jmb.add(jmOptions);
		jmb.add(jmAbout);
		
		setJMenuBar(jmb);
		
		jmiExit.addActionListener(this);
		jmiClear.addActionListener(this);
		jmiAbout.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() instanceof Block)
		{
			controller.writeMark((Block) e.getSource());
			
			if(controller.isGameOver()){
				JOptionPane.showMessageDialog(null, "Yay, team " + controller.getPlayerTurn() + " has won! ", "Game Over!", JOptionPane.INFORMATION_MESSAGE);
				controller.resetBoard();
			}
			else if(controller.isBoardFull()){
				JOptionPane.showMessageDialog(null, "Well, looks like nobody won. ", "Game Over!", JOptionPane.INFORMATION_MESSAGE);
				controller.resetBoard();
			}
			
			controller.updateSideHud();
		}
		else
		{
			if(e.getSource() == jmiExit)
			{
				System.exit(0);
			}
			else if(e.getSource() == jmiClear)
			{
				controller.resetSideHud();
			}
			else if(e.getSource() == jmiAbout)
			{
				JOptionPane.showMessageDialog(null, "Tic-Tac-Toe\nBy Roman Pusec, 2014", "About", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
