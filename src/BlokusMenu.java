import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.io.BufferedInputStream;
import java.io.FileInputStream;


public class BlokusMenu extends JPanel{

private JTextField jtf;
private JButton enter;
private JButton done;
private List<String> playerNames;
private int numPlayers = 0;
private BlokusFrame blokF;
int numberOfCPU = 0;
	public BlokusMenu(BlokusFrame bf){
		super();
		this.setPreferredSize(new Dimension(500,500));
		try {
			//System.out.print("test");
		    InputStream is = new BufferedInputStream(new FileInputStream("Blokus.jpg"));
		    Image blokusPic = ImageIO.read(is);
		    JLabel pic = new JLabel(new ImageIcon(blokusPic));
			this.add(pic);
			} catch (IOException ex) {}
		
		blokF = bf;
		enter = new JButton();
		enter.setText("Enter");
		playerNames = new ArrayList<String>();
		enter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				addPlayer(jtf.getText());
			}
		});
		
		jtf = new JTextField();
		jtf.setText("Enter player name here");
		
		done = new JButton();
		done.setText("Done adding players.");
		done.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				doneAddingPlayers();
			}
			
		});
		JButton addAI = new JButton();
		addAI.setText("Add easy AI");
		addAI.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Aputo-generated method stub
				numberOfCPU++;
				addPlayer("EASY CPU " + numberOfCPU);
			}
		
			
		});
		JButton addBlockingAI = new JButton();
		addBlockingAI.setText("Add hard AI");
		addBlockingAI.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				numberOfCPU++;
				addPlayer("HARD CPU " + numberOfCPU);
			}
		});
		this.add(addAI);
		this.add(addBlockingAI);
		this.add(enter,0);
		this.add(jtf,1);
		this.add(done,2);
	}
	protected void doneAddingPlayers() {
		// TODO Auto-generated method stub
		blokF.recievePlayerList(this.playerNames);
		this.removeAll();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for(int a = 0; a < this.playerNames.size();a++){
			String str = "Player ";
			str+= ((a+1) + " : " + this.playerNames.get(a));
			g.drawString(str, 20, 60+30*(a+1));
		}
	}
	private void addPlayer(String string) {
		// TODO Auto-generated method stub
		this.playerNames.add(string);
		if(playerNames.size() == 4)
			doneAddingPlayers();
		else
			repaint();
	}

}
