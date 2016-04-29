import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField; 

public class mainGUI {
	public static void main(String[] args) {  
		JFrame frame = new JFrame("Rom Randomizer");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        FlowLayout panelFlowLayout = new FlowLayout();
        //panelFlowLayout.setVgap(50);
        panel.setLayout(panelFlowLayout);
        frame.add(panel);
        
        
        JButton bntRandom = new JButton("Randomize");
        JButton bntLoad = new JButton("Load Roms");
        
        panel.add(bntLoad);
        panel.add(bntRandom);
        //panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
        frame.setVisible(true);
	}
}
