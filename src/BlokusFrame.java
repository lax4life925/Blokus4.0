import java.awt.BorderLayout;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class BlokusFrame extends JFrame {
	int playerNum = 0;
	boolean DEBUG_MODE = false;
	public static final int width = 1200;
	public static final int height = 800;
	public static  int numPlayers;
	private BlokusMenu bm;
	public BlokusFrame(){
		super("Blokus");
		setLayout(new BorderLayout());
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setBounds(0,0,width,height);
		
		if(DEBUG_MODE){
			List<String> names = new ArrayList<String>();
			for(int i = 1; i <= 2; i++)
				names.add("BLOCKING CPU" + i);
			for(int i = 1; i <=2; i++)
				names.add("RANDOM CPU" + i);
			BlokusPanel bp = new BlokusPanel(names);
			this.add(bp);
		}
			
		else{
			JOptionPane.showMessageDialog(null, "Welcome to Blokus. You will now input each player's name.");
			setUpMenu();
		}
		
		
	}

	private void setUpMenu() {
		// TODO Auto-generated method stub
		bm = new BlokusMenu(this);
		this.add(bm);
		pack();
	}

	

	public void recievePlayerList(List<String> playerNames) {
		// TODO Auto-generated method stub
		BlokusPanel bp = new BlokusPanel(playerNames);
		this.add(bp);
		this.remove(bm);
		pack();
		setResizable(false);
	}

	

	
	
}
