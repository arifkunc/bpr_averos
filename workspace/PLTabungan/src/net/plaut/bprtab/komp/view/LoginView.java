package net.plaut.bprtab.komp.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.plaut.bprtab.dao.BpaUserGroupTableDao;
import net.plaut.bprtab.dao.BpaUserGroupTableRecord;
import net.plaut.bprtab.dao.BpaUserTableDao;
import net.plaut.bprtab.dao.BpaUserTableRecord;
import net.plaut.bprtab.dao.condition.BpaUserGroupSrcCond;
import net.plaut.bprtab.dao.condition.BpaUserSrcCond;
import net.plaut.bprtab.komp.model.LoginModel;
import net.plaut.bprtab.logic.AuthenticatingFacade;
import net.plaut.bprtab.util.DbCommand;
import net.plaut.bprtab.util.LoginInformation;
import net.plaut.common.util.ImageIconUtil;

public class LoginView extends JInternalFrame {
	private JButton btOK;
	private JButton btCancel;
	private JTextField tfUserName;
	private JPasswordField pfPassword;
	private JLabel lbGambar;
	private ImageIcon iconGambar;
	private LoginModel model;

	/**
	 * Create the dialog.
	 */
	public LoginView() {
		getContentPane().setBackground(new Color(255, 250, 205));
		setFrameIcon(new ImageIcon(SetorTabunganView.class.getResource("/net/plaut/bprtab/resources/Unlock.png")));
		// super((Frame)rootFrame, modal);
		setResizable(false);
		setTitle("Login");
		setClosable(true);
		setIconifiable(true);
		setBounds(200, 200, 396, 163);
		getContentPane().setLayout(null);
		ImageIcon imc = new ImageIcon(getClass().getResource("/net/plaut/bprtab/resources/Log.png"));
		iconGambar = ImageIconUtil.getThumbnail(imc, 100, 100);

		Panel panel = new Panel();
		panel.setBackground(new Color(255, 250, 240));
		panel.setBounds(10, 8, 360, 117);
		getContentPane().add(panel);
		panel.setLayout(null);

		lbGambar = new JLabel();
		lbGambar.setBounds(8, 6, 100, 100);
		panel.add(lbGambar);
		lbGambar.setIcon(iconGambar);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(113, 8, 84, 18);
		panel.add(lblUsername);
		lblUsername.setFont(new Font("Arial", Font.BOLD, 15));

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(113, 40, 81, 18);
		panel.add(lblPassword);
		lblPassword.setFont(new Font("Arial", Font.BOLD, 15));

		tfUserName = new JTextField();
		tfUserName.setBounds(200, 8, 150, 24);
		panel.add(tfUserName);
		tfUserName.setFont(new Font("Arial", Font.PLAIN, 15));
		tfUserName.setColumns(10);

		pfPassword = new JPasswordField();
		pfPassword.setBounds(200, 40, 150, 24);
		panel.add(pfPassword);
		pfPassword.setFont(new Font("Arial", Font.PLAIN, 15));

		btOK = new JButton("Login");
		btOK.setIcon(new ImageIcon(LoginView.class.getResource("/net/plaut/bprtab/resources/Submit.png")));
		btOK.setBounds(160, 72, 94, 30);
		panel.add(btOK);
		btOK.setFont(new Font("Arial", Font.BOLD, 15));

		btCancel = new JButton("Batal");
		btCancel.setIcon(new ImageIcon(LoginView.class.getResource("/net/plaut/bprtab/resources/Batal.png")));
		btCancel.setBounds(258, 72, 94, 30);
		panel.add(btCancel);
		btCancel.setFont(new Font("Arial", Font.BOLD, 15));

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		makeCenterPosition();

		addListener();
		model = new LoginModel();
	}

	private void addListener() {
		btOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionLogin(e);
			}
		});

		btCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionCancel(e);
			}
		});
	}

	private void makeCenterPosition() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension dialogSize = this.getSize();
		int x = (screenSize.width - dialogSize.width) / 2;
		int y = (screenSize.height - dialogSize.height) / 2;
		setLocation(x, y);
	}

	private void resetField() {
		tfUserName.setText("");
		pfPassword.setText("");
	}

	// ^_^ ^_^ ^_^ ^_^ ^_^ ^_^ ^_^ ^_^ ^_^ ^_^ ^_^ ^_^ ^_^ ^_^ ^_^ ^_^
	// All method for event handling
	private void actionCancel(ActionEvent e) {
		this.dispose();
	}

	private void actionLogin(ActionEvent e) {
		try {
			Connection con = DbCommand.getConnection();
			String username = tfUserName.getText();
			char[] passwordArray = pfPassword.getPassword();
			String password = new String(passwordArray);
			
			AuthenticatingFacade facade = AuthenticatingFacade.getInstance();
			int login = facade.login(con, username, password);
			if(login == 1){
				MainFrame mf = MainFrame.getInstance();
				LoginInformation loginInfo = LoginInformation.getInstance();
				mf.activateButton(loginInfo.getUserGroup());
				mf.switchPanelCard(loginInfo.getUserGroup());
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Login Gagal");
				model.resetModel();
				resetField();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
