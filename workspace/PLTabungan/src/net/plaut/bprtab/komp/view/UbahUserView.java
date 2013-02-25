package net.plaut.bprtab.komp.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
import net.plaut.bprtab.komp.model.TambahUserModel;
import net.plaut.bprtab.util.OnMemData;
import net.plaut.bprtab.util.PairedItemFactory;
import net.plaut.bprtab.util.SystemInformation;
import net.plaut.common.util.StringUtil;
import net.plaut.component.PComboBoxLoad;
import net.plaut.dbutil.db.DbConnection;

public class UbahUserView extends JInternalFrame {
	private JTextField tfUserName;
	private JPasswordField pfPassword1;
	private JPasswordField pfPassword2;
	private JButton btSave;
	private JButton btCancel;
	private JButton btFind;
	private TambahUserModel model;
	private Panel panel;
	private Panel panel_2;
	private PComboBoxLoad cbGrupLevel;
	private String selectedUsername;
	
	String[] usernameData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UbahUserView frame = new UbahUserView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UbahUserView() {
		setFrameIcon(new ImageIcon(UbahUserView.class.getResource("/net/plaut/bprtab/resources/UbahUser.png")));
		getContentPane().setBackground(new Color(255, 250, 205));
		getContentPane().setFont(new Font("Arial", Font.PLAIN, 15));
		setTitle("Ubah Data User");
		setBounds(100, 100, 399, 229);
		setClosable(true);
		setIconifiable(true);

		BpaUserGroupTableDao guDao = new BpaUserGroupTableDao();
		Connection con;
		ArrayList<BpaUserGroupTableRecord> listGroupUser;
		try {
			con = DbConnection.createConnection(SystemInformation.getConnectionInformation());
			BpaUserGroupSrcCond cond = new BpaUserGroupSrcCond();
			listGroupUser = guDao.executeQuery(con, cond);
		} catch (SQLException e) {
			listGroupUser = new ArrayList<BpaUserGroupTableRecord>();
		}
		List userGroupPairedItems = PairedItemFactory.fromUserGroupTableRecord(listGroupUser);
		
		usernameData = OnMemData.getInstance().getUsernameData();

		getContentPane().setLayout(null);

		panel_2 = new Panel();
		panel_2.setBackground(new Color(255, 250, 240));
		panel_2.setBounds(10, 156, 363, 37);
		getContentPane().add(panel_2);

		btSave = new JButton("Simpan");
		btSave.setIcon(new ImageIcon(UbahUserView.class.getResource("/net/plaut/bprtab/resources/Simpan.png")));
		panel_2.add(btSave);
		btSave.setFont(new Font("Arial", Font.BOLD, 15));

		btCancel = new JButton("Batal");
		btCancel.setIcon(new ImageIcon(UbahUserView.class.getResource("/net/plaut/bprtab/resources/Batal.png")));
		panel_2.add(btCancel);
		btCancel.setFont(new Font("Arial", Font.BOLD, 15));

		panel = new Panel();
		panel.setBackground(new Color(255, 250, 240));
		panel.setBounds(10, 10, 363, 140);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 11, 68, 18);
		panel.add(lblUsername);
		lblUsername.setFont(new Font("Arial", Font.PLAIN, 15));

		tfUserName = new JTextField();
		tfUserName.setEnabled(false);
		tfUserName.setBounds(171, 8, 95, 25);
		panel.add(tfUserName);
		tfUserName.setFont(new Font("Arial", Font.BOLD, 15));
		tfUserName.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 40, 76, 24);
		panel.add(lblPassword);
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 15));

		pfPassword1 = new JPasswordField();
		pfPassword1.setBounds(171, 40, 180, 25);
		panel.add(pfPassword1);
		pfPassword1.setFont(new Font("Arial", Font.BOLD, 15));
		pfPassword1.setColumns(10);

		JLabel lblPassword_1 = new JLabel("Ketik Ulang Password");
		lblPassword_1.setBounds(10, 72, 151, 24);
		panel.add(lblPassword_1);
		lblPassword_1.setFont(new Font("Arial", Font.PLAIN, 15));

		pfPassword2 = new JPasswordField();
		pfPassword2.setBounds(171, 72, 180, 25);
		panel.add(pfPassword2);
		pfPassword2.setFont(new Font("Arial", Font.BOLD, 15));
		pfPassword2.setColumns(10);

		JLabel lblLevel = new JLabel("Group Level");
		lblLevel.setBounds(10, 104, 99, 24);
		panel.add(lblLevel);
		lblLevel.setFont(new Font("Arial", Font.PLAIN, 15));

		cbGrupLevel = new PComboBoxLoad(userGroupPairedItems);
		cbGrupLevel.setFont(new Font("Arial", Font.BOLD, 15));
		cbGrupLevel.setBounds(171, 108, 180, 25);
		panel.add(cbGrupLevel);
		
		btFind = new JButton("Cari");
		btFind.setIcon(new ImageIcon(UbahUserView.class.getResource("/net/plaut/bprtab/resources/Cari.png")));
		btFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btFind.setFont(new Font("Arial", Font.BOLD, 15));
		btFind.setBounds(270, 8, 80, 26);
		panel.add(btFind);

		model = new TambahUserModel();
		addEvent();
	}

	private void addEvent() {
		btSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveAction(e);
			}
		});

		btCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showSelectUsernameDialog();
			}
		});
	}

	private void saveAction(ActionEvent e) {
		if (!isInputValid())
			return;
		Connection con;
		try {
			con = DbConnection.createConnection("localhost", "root", "",
					"bpr_averos");
			model.setUserName(tfUserName.getText());
			model.setPassword(new String(pfPassword1.getPassword()));
//			model.setIdGroupLevel(cbGroupLevel.getSelectedValue());

			BpaUserTableRecord record = new BpaUserTableRecord();
			record.setUsername(model.getUserName());
			record.setPassword(model.getPassword());
			record.setGroup(model.getIdGroupLevel());
			BpaUserTableDao userDao = new BpaUserTableDao();
			userDao.insert(con, record);
			JOptionPane.showMessageDialog(null, "User Berhasil Ditambahkan");
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}

	private boolean isInputValid() {
		if (StringUtil.isEmpty(tfUserName.getText())) {
			JOptionPane.showMessageDialog(null, "Username Masih Kosong");
			return false;
		}

		if (pfPassword1.getPassword() == null) {
			JOptionPane.showMessageDialog(null, "Password Masih Kosong");
			return false;
		}

		if (pfPassword2.getPassword() == null) {
			JOptionPane.showMessageDialog(null,
					"Konfirmasi Password Masih Kosong");
			return false;
		}

		String password1 = new String(pfPassword1.getPassword());
		String password2 = new String(pfPassword2.getPassword());
		if (!password1.equals(password2)) {
			JOptionPane.showMessageDialog(null,
					"Konfirmasi Password Tidak Sama");
			return false;
		}

		if (cbGrupLevel.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(null, "Group Level Belum Terpilih");
			return false;
		}

		return true;

	}
	
	private void showSelectUsernameDialog(){
		String selectedUsername =  (String)JOptionPane.showInputDialog(this, "Pilih Username", "Pilihan Username", JOptionPane.QUESTION_MESSAGE, null, usernameData, "");
		if(selectedUsername == null){
			selectedUsername = "";
		}
		tfUserName.setText(selectedUsername);
	}
}
