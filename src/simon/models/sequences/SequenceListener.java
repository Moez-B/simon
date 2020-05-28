package simon.models.sequences;

import simon.Utils;
import simon.controllers.ColourSquare;
import simon.views.View;

public class SequenceListener extends Thread {
	private ColourSquare[] squares;
	private View listenView;
	
	public int[] generated; // generated sequence
	private int[] reset; // reset default user input sequence arr
	private int state;
	private SequenceGenerator in;
	public SequenceListener(ColourSquare[] squares, SequenceGenerator in,View view) {
		this.squares = squares;
		this.in=in;
		this.listenView=view;
		this.reset = in.reset;
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println("");
			if(this.in.sequenceInput[this.reset.length-1] != 5) {
				if(Utils.areEqual(this.generated,this.in.sequenceInput)) {
					listenView.correctScreen();
					Utils.delay(5000);
				}
				else {
					listenView.endScreen();
					Utils.delay(5000);
				}
				this.in.sequenceInput = new int[4];
				this.in.sequenceInput = this.reset(in.reset.length);
				Utils.delay(500);
				listenView.startScreen();
				this.generated=in.generateSequence();
			}
			
		}
		
	}//run method
	
	public int[] reset(int len) {
		int[] ret = new int[len];
		for(int i = 0; i < len; ++i) {
			ret[i] = 5;
		}
		return ret;
	}
	
}
