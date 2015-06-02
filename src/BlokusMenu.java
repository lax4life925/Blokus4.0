import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class BlokusMenu extends JPanel{

private JTextField jtf;
private JButton enter;
private JButton done;
private List<String> playerNames;
int i = 0;
private BlokusFrame blokF;
	public BlokusMenu(BlokusFrame bf){
		super();
		blokF = bf;
		enter = new JButton();
		enter.setText("Enter");
		playerNames = new ArrayList<String>();
		enter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				playerNames.add(jtf.getText());
				i++;
				
				if(i == 3){
					blokF.addPanel(i+1);
					removeAllTheShit();
				}
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
				blokF.addPanel(i+1);
				removeAllTheShit();
			}
			
		});
		this.add(enter,0);
		this.add(jtf,1);
		this.add(done,2);
	}
	protected void removeAllTheShit() {
		// TODO Auto-generated method stub
		this.removeAll();
	}

}
