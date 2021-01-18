package majorandminor;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.*;
import java.awt.*;


public class Keyer extends JFrame{
	
	private GetKeys g;
	private JFrame f;
	private JComboBox avKeys;
	private JComboBox alKeys;
	private JTextField output;
	
	
	public Keyer() {
		
		g = new GetKeys();
		
		f = new JFrame();
		
		String[] abc = new String[] {"Natural minor","Harmonic minor", 
				"Melodic minor","Natural major","Harmonic major"};
		avKeys = new JComboBox(abc);
		avKeys.setBounds(60,0,130,30);
		
		avKeys.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	updateText();
			}
		});
		
		alKeys = new JComboBox(g.getAllKeys());
		alKeys.setBounds(0,0,60,30);
		
		alKeys.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent el) {
		    	updateText();
			}
		});
		
		output = new JTextField(10);
		output.setText(":)");
		
		f.add(avKeys);
		f.add(alKeys);
		f.add(output);
		f.setSize(400,400);
		f.setLayout(new GridLayout(0,1));
		f.pack();
		f.setAlwaysOnTop(true);
		f.setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		updateText();

	}
	
	private void updateText() {
		output.setText(Arrays.toString(g.getOctave(alKeys.getSelectedIndex(), avKeys.getSelectedIndex())));
	}
	
	public static void main(String[] args) {
		new Keyer();
	}
	
}