import java.awt.*;

import javax.swing.*;

public class SideHud extends JPanel {
	private static final long serialVersionUID = 1L;
	private JPanel jpTurn, jpTimesWon, jpRound;
	private JLabel jlTurn, jlXTimesWon, jlOTimesWon, jlRound;
	
	public SideHud()
	{
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		
		jpTurn 			= new JPanel();
		jpTimesWon 		= new JPanel();
		jpTimesWon.setLayout(new BorderLayout());
		jpRound 		= new JPanel();
		
		jpTurn.setBorder(BorderFactory.createTitledBorder("Turn"));
		jpTimesWon.setBorder(BorderFactory.createTitledBorder("Times Won"));
		jpRound.setBorder(BorderFactory.createTitledBorder("Round"));
		
		jlTurn 			= new JLabel("test 1", JLabel.CENTER);
		jlXTimesWon 	= new JLabel("test 2", JLabel.CENTER);
		jlOTimesWon 	= new JLabel("test 3", JLabel.CENTER);
		jlRound 		= new JLabel("test 4", JLabel.CENTER);
		
		jpTurn.add(jlTurn);
		jpTimesWon.add(jlXTimesWon, "North");
		jpTimesWon.add(jlOTimesWon, "South");
		jpRound.add(jlRound);
		
		add(jpTurn, "North");
		add(jpTimesWon, "Center");
		add(jpRound, "South");
	}
	
	public void setTurn(String plTurn)
	{
		jlTurn.setText("It is currently " + plTurn + "'s turn. ");
	}
	
	public void setXTimesWon(int timesWon)
	{
		jlXTimesWon.setText("Team X won " + timesWon + " times. ");
	}
	
	public void setOTimesWon(int timesWon)
	{
		jlOTimesWon.setText("Team O won " + timesWon + " times. ");
	}
	
	public void setRound(int newRound)
	{
		jlRound.setText("Round: " + newRound);
	}
}
