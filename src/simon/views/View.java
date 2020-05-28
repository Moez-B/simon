package simon.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import simon.models.sequences.SequenceListener;

public class View extends JPanel{
	private JLabel title;
	public JPanel a,b;
	private SequenceListener in;
	
	public View() {
		super();
		this.setBackground(Color.BLACK);
	}
	
	
	public void init() {	
		a=new JPanel(new GridLayout(2,1));
		title=new JLabel("Simon Says");
		title.setForeground(Color.WHITE);
	    title.setFont(new Font("Jokerman",Font.ITALIC,40));
	    
		
		a.add(title);
		a.setBackground(Color.BLACK);
		this.add(a);
				
	}
	
	public void endScreen() {
		title.setText("Incorrect Sequence ");
		repaint();
		
	}
	public void startScreen() {
		title.setText("Simon Says");
		repaint();
	}
	public void correctScreen() {
		title.setText("That is correct good job");
		repaint();
	}
	

}
