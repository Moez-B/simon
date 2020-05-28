package simon.models.sequences;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;

import simon.Utils;
import simon.controllers.ColourSquare;
import simon.views.View;

public class SequenceGenerator {

	View g=new View();
	public ColourSquare[] squares=new ColourSquare[4];
	private int length;
	private int level;
	private int delay;
	private int repeats; //add this later for number of iterations of squares lighting up
	private Random rand = new Random();
	public int[] sequenceInput;
	public int[] reset;
	
	public SequenceGenerator(int level,View view) {
		this.level = level;
		if(this.level == 1) {
			this.delay = 1000;
			this.reset = Utils.RESET_4;
		}
		else if(this.level == 2) {
			this.delay = 700;
			this.reset = Utils.RESET_4;
		}
		else if(this.level == 3) {
			this.delay = 700;
			this.reset = Utils.RESET_5;
		}
		else if(this.level == 4) {
			this.delay = 300;
			this.reset = Utils.RESET_6;
		}
		else if(this.level == 5) {
			this.delay = 700;
			this.reset = Utils.RESET_7;
		}
		sequenceInput = this.reset;
		this.length = sequenceInput.length;
		g.setLayout(new GridLayout(2,2));
		squares[0]=new ColourSquare(Color.RED,0,this,g);
		squares[1]=new ColourSquare(Color.YELLOW,1,this,g);
		squares[2]=new ColourSquare(Color.BLUE,2,this,g);
		squares[3]=new ColourSquare(Color.GREEN,3,this,g);
		view.init();
		view.a.add(g);
		
	}
	
	public int[] generateSequence() {
		int temp;
		int[] sequence = new int[this.length];
		for(int i = 0; i < this.length; ++i) {
			temp = this.rand.nextInt(4);
			sequence[i] = temp;
			this.squares[temp].glow();
			Utils.delay(this.delay);
			this.squares[temp].unglow();
			Utils.delay(this.delay);
		}
		return sequence;
	}
	
}
