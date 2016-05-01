import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField; 


public class mainGUI extends JFrame implements WindowListener,ActionListener {
	JButton bntRandom;
	JButton bntLoad;
	JLabel lblStatus;
	JFileChooser fileDialog;
	RecursTest rt = new RecursTest();
	static mainGUI startWindow;
	
	public static void main(String[] args) {  
		startWindow = new mainGUI("Rom Randomizer");
		startWindow.setSize(350,200);
		startWindow.setVisible(true);
		
		
		//JFrame frame = new JFrame("Rom Randomizer");
        //frame.setSize(350, 200);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //JPanel panel = new JPanel();
        //FlowLayout panelFlowLayout = new FlowLayout();
        //panelFlowLayout.setVgap(50);
        //panel.setLayout(panelFlowLayout);
        //frame.add(panel);
        
        
        //addWindowListner(this);
        //JButton bntRandom = new JButton("Randomize");
        //bntRandom.setEnabled(false);
        //JButton bntLoad = new JButton("Load Roms");
        
        //panel.add(bntLoad);
        //panel.add(bntRandom);
        //panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
        //frame.setVisible(true);
	}

	
	public mainGUI(String title){
		super(title);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FlowLayout panelFlowLayout = new FlowLayout();
		setLayout(panelFlowLayout);
		bntRandom = new JButton("Randomize");
		bntRandom.setEnabled(false);
		bntLoad = new JButton("Load");
		lblStatus = new JLabel("Click Load");
		fileDialog = new JFileChooser();
		add(bntLoad);
		add(bntRandom);
		add(lblStatus);
		
		bntLoad.addActionListener(this);
		bntRandom.addActionListener(new randomAction(rt));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			fileDialog.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int returnVal = fileDialog.showOpenDialog(startWindow);
			 if (returnVal == JFileChooser.APPROVE_OPTION) {
				 lblStatus.setText("Loading ROMS");
				 rt.loadRoms(fileDialog.getSelectedFile().getAbsolutePath());
				 	if (!rt.checkListIsEmpty())
				 	{
				 		bntRandom.setEnabled(true);
				 		lblStatus.setText("Loading Complete, Click Random");
				 	}
				 	else
				 	{
				 		bntRandom.setEnabled(false);
				 		lblStatus.setText("No supported Roms found, choose a different directory");
				 	}
			 }
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		dispose();
        System.exit(0);
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

class randomAction implements ActionListener { 
RecursTest rt;
public randomAction(RecursTest obj)
{
	rt = obj;
}
	
	public void actionPerformed(ActionEvent e) {
		 try {
			rt.pickRandomRom();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    }
	
}