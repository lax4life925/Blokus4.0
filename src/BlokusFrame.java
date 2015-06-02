import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class BlokusFrame extends JFrame {
	int playerNum = 0;
	public static final int width = 1200;
	public static final int height = 800;
	public static  int numPlayers;
	public BlokusFrame(){
		super("Blokus");
		setLayout(new BorderLayout());
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setBounds(0,0,width,height);
		JOptionPane jop = new JOptionPane();
		jop.showMessageDialog(null, "Welcome to Blokus. You will now input each player's name.");
		setUpMenu();
		
		
	}

	private void setUpMenu() {
		// TODO Auto-generated method stub
		BlokusMenu bm = new BlokusMenu(this);
		this.add(bm);
		pack();
	}

	public void addPanel(int n) {
		BlokusPanel bp = new BlokusPanel();
		bp.setNumPlayers(n);
		this.add(bp);
		pack();
		setResizable(false);
	}

	

	
	
}
