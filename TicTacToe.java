import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class TicTacToe extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField jtfSetSize;
	private JButton jbStart;
	private JMenu jmAbout;
	private JMenuItem jmiAbout;
	
	public TicTacToe()
	{
		setTitle("Welcome to TicTacToe!");
		setLayout(new GridLayout(3,0));
		
		createMenu();
		
		JPanel jpNorth = new JPanel();
		JPanel jpCenter = new JPanel();
		JPanel jpSouth = new JPanel();
		
		jtfSetSize = new JTextField(3);
		jbStart = new JButton("Start game");
		
		jpNorth.add(new JLabel("Welcome to a game of Tic Tac Toe! "));
		jpNorth.add(new JLabel("Please select the size of your board (from 3 to 10) and hit play! "));
		
		jpCenter.add(new JLabel("Set board size: "));
		jpCenter.add(jtfSetSize);
		
		jpSouth.add(jbStart);
		
		add(jpNorth, "North");
		add(jpCenter, "Center");
		add(jpSouth, "South");
		
		jbStart.addActionListener(this);
		
		setSize(450, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	private void createMenu()
	{
		JMenuBar jmb = new JMenuBar();
		
		jmAbout = new JMenu("Help");
		jmiAbout = new JMenuItem("About");
		jmAbout.add(jmiAbout);
		
		jmb.add(jmAbout);
		setJMenuBar(jmb);
		
		jmiAbout.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbStart)
		{
			try
			{
				int boardSize = Integer.parseInt(jtfSetSize.getText());
				
				if(boardSize > 10 || boardSize < 3)
					throw new NumberFormatException();
				
				new GameWindow(boardSize);
				
				dispose();
			}
			catch(NumberFormatException nfe)
			{
				JOptionPane.showMessageDialog(null, "Please insert a number from 3 to 10. ", "Number Format", JOptionPane.WARNING_MESSAGE);
			}
		}
		else if(e.getSource() == jmiAbout)
		{
			JOptionPane.showMessageDialog(null, "Tic-Tac-Toe\nBy Roman Pusec, 2014", "About", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public static void main(String[] args) {
		new TicTacToe();
	}
}
