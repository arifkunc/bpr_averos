package net.plaut.bprtab;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import net.plaut.bprtab.komp.view.MainFrame;
import net.plaut.bprtab.util.LoginInformation;
import net.plaut.bprtab.util.OnMemData;

public class ApplicationAveros {
	
	private MainFrame mainFrame;
	private LoginInformation lInfo;
	
	public void init(){
		mainFrame = MainFrame.getInstance();
		lInfo = LoginInformation.getInstance();
		initOnMemData();
	}
	
	public void setLookAndFeel(){
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {

        } catch (InstantiationException ex) {

        } catch (IllegalAccessException ex) {

        } catch (UnsupportedLookAndFeelException ex) {

        }
        System.out.println(UIManager.getSystemLookAndFeelClassName());
	}
	
	public void initOnMemData(){
		OnMemData onMemData = OnMemData.getInstance();
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {	                
	                ApplicationAveros averosBPR = new ApplicationAveros();
	                averosBPR.setLookAndFeel();
	                averosBPR.init();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
