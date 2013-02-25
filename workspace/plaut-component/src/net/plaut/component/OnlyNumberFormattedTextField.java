package net.plaut.component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.Format;

import javax.swing.JFormattedTextField;


public class OnlyNumberFormattedTextField extends JFormattedTextField implements KeyListener{
	
	OnlyNumberFormattedTextField(Format format){
		super(format);
		addKeyListener(this);
	}
	
	private boolean isContainsPointCharacter(){
		String text = getText();
		if(text.contains(new StringBuilder(".")))
			return true;
		else
			return false;
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if (!Character.isDigit(c)){
			if(c == '.' && !isContainsPointCharacter()){
			}
			else{
				e.consume(); // prevent event propagation
			}
		}
	}

}
