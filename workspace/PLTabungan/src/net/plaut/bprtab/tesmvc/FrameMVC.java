package net.plaut.bprtab.tesmvc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FrameMVC extends JFrame implements ActionListener{
	private ModelMVC modelMVC;
	private ControllerMVC controllerMVC;
	
	public FrameMVC() {
		modelMVC = new ModelMVC();
		controllerMVC = new ControllerMVC(this, modelMVC);
	
		initComponents();
		setVisible(true);
		setSize(200,200);
		
		addListener();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void initComponents(){
		btAtas = new JButton("Atas");
		btKanan = new JButton("Kanan");
		btBawah = new JButton("Bawah");
		btKiri = new JButton("Kiri");
		lbArah = new JLabel("(DIAM)");
		
		setLayout(new BorderLayout());
		add(btAtas,BorderLayout.NORTH);
		add(btKanan,BorderLayout.EAST);
		add(btBawah,BorderLayout.SOUTH);
		add(btKiri,BorderLayout.WEST);
		add(lbArah,BorderLayout.CENTER);
	}
	
	private void addListener(){
		btAtas.addActionListener(this);
		btKanan.addActionListener(this);
		btBawah.addActionListener(this);
		btKiri.addActionListener(this);
	}
	
	//components
	private JButton btAtas, btKiri, btBawah, btKanan;
	private JLabel lbArah;

	public JLabel getLbArah() {
		return lbArah;
	}

	public void actionPerformed(ActionEvent actionEvent) {
		if(actionEvent.getSource() == btAtas)
			controllerMVC.setArah("ATAS");
		
		if(actionEvent.getSource() == btKanan)
			controllerMVC.setArah("KANAN");
		
		if(actionEvent.getSource() == btBawah)
			controllerMVC.setArah("BAWAH");
		
		if(actionEvent.getSource() == btKiri)
			controllerMVC.setArah("KIRI");
	}
	
	public static void main(String []args){
		FrameMVC f = new FrameMVC();
	}
}
