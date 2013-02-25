package net.plaut.component;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;


public class IconTextButton extends JButton{
	
	public IconTextButton(String text, String iconPath){
		super(text);
		ImageIcon imgIcon = new ImageIcon(iconPath);
		setVerticalTextPosition(SwingConstants.BOTTOM);
		setHorizontalTextPosition(SwingConstants.CENTER);
		setIcon(imgIcon);
	}
	
}
