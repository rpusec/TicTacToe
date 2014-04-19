import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;

public class Block extends JButton
{
	private static final long serialVersionUID = 1L;
	private boolean disabled = false;
	public static final String MARK_CROSS = "X";
	public static final String MARK_NOUGHT = "O";
	public static final String MARK_NONE = "none";
	private String tagged = MARK_NONE;
	
	public Block()
	{
		super();
		setBackground(Color.WHITE);
		setFocusPainted(false);
	}
	
	public void drawCross()
	{
		tagged = MARK_CROSS;
		setIcon(new CrossIcon(getSize().width));
		setAsDisabled();
	}
	
	public void drawNought()
	{
		tagged = MARK_NOUGHT;
		setIcon(new NoughtIcon(getSize().width));
		setAsDisabled();
	}
	
	public void setMatch()
	{
		setBackground(new Color(210, 255, 208));
	}
	
	private void setAsDisabled()
	{
		disabled = true;
	}
	
	public boolean getDisabled()
	{
		return disabled;
	}
	
	public void resetBlock()
	{
		disabled = false;
		tagged = "none";
		setBackground(Color.WHITE);
		setIcon(null);
	}
	
	public String toString()
	{
		return tagged;
	}
	
	private class CrossIcon implements Icon
	{
		private int size;
		
		public CrossIcon(int size)
		{
			this.size = size;
			this.size /= 2;
		}
		
		@Override
		public int getIconHeight() {
			return size;
		}

		@Override
		public int getIconWidth() {
			return size;
		}

		@Override
		public void paintIcon(Component c, Graphics g, int x, int y) {
			Graphics2D g2 = (Graphics2D) g.create();
			
			g2.setColor(Color.BLACK);
			g2.drawLine(9, 65, 65, 9);
			g2.drawLine(65, 65, 9, 9);
			
			g2.dispose();
		}
	}
	
	private class NoughtIcon implements Icon
	{
		private int size;
		
		public NoughtIcon(int size)
		{
			this.size = size;
		}
		
		@Override
		public int getIconHeight() {
			return size;
		}

		@Override
		public int getIconWidth() {
			return size;
		}

		@Override
		public void paintIcon(Component c, Graphics g, int x, int y) {
			Graphics2D g2 = (Graphics2D) g.create();
			
			g2.setColor(Color.BLACK);
			g2.drawOval(10, 10, 60, 60);
			
			g2.dispose();
		}
	}
}
