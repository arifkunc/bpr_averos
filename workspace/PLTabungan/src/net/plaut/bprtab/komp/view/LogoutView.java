package net.plaut.bprtab.komp.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

import net.plaut.bprtab.komp.model.LoginModel;
import net.plaut.common.util.ImageIconUtil;
import java.awt.Panel;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Label;

public class LogoutView extends JDialog {
	private ImageIcon iconGambar;
	private LoginModel model;
	private JLabel lbGambar;

	/**
	 * Create the dialog.
	 */
	public LogoutView() {
		getContentPane().setBackground(new Color(255, 250, 205));
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				LogoutView.class
						.getResource("/net/plaut/bprtab/resources/Lock.png")));
		// super((Frame)rootFrame, modal);
		setResizable(false);
		setTitle("Logout");
		setBounds(200, 200, 384, 165);
		ImageIcon imc = new ImageIcon(getClass().getResource(
				"/net/plaut/bprtab/resources/Log.png"));
		iconGambar = ImageIconUtil.getThumbnail(imc, 100, 100);

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		Panel panel = new Panel();
		panel.setBackground(new Color(255, 250, 240));
		panel.setBounds(10, 10, 360, 117);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblAndaTelahLogout = new JLabel("Anda Telah Logout");
		lblAndaTelahLogout.setBounds(154, 57, 133, 18);
		panel.add(lblAndaTelahLogout);
		lblAndaTelahLogout.setFont(new Font("Arial", Font.BOLD, 15));

		JLabel lblTerimaKasih = new JLabel("Terima Kasih");
		lblTerimaKasih.setBounds(187, 31, 76, 15);
		panel.add(lblTerimaKasih);
		lblTerimaKasih.setFont(new Font("Arial", Font.PLAIN, 13));

		lbGambar = new JLabel();
		lbGambar.setBounds(10, 6, 100, 100);
		panel.add(lbGambar);
		lbGambar.setIcon(iconGambar);

		model = new LoginModel();
		setVisible(true);
		makeCenterPosition();
	}

	private void makeCenterPosition() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension dialogSize = this.getSize();
		int x = (screenSize.width - dialogSize.width) / 2;
		int y = (screenSize.height - dialogSize.height) / 2;
		setLocation(x, y);
	}
}
