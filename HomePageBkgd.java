import java.awt.*; 
import java.awt.event.*;
import javax.swing.*; 

public class HomePageBkgd extends JFrame{

	public void paint() {
		setLayout(new GridLayout(8,8));
		for (int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				JPanel panel = new JPanel();
				if(i%2 == 0) {
					if(j%2 == 0) {
						panel.setBackground(Colors.LIGHT_BROWN);
					} else {
						panel.setBackground(Colors.DARK_BROWN);
					}
				} else {
					if(j%2 == 1) {
						panel.setBackground(Colors.LIGHT_BROWN);
					} else {
						panel.setBackground(Colors.DARK_BROWN);
					}
				}
				add(panel);
			}
		}
		setVisible(true);
	}
}
