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

import javax.swing.JButton;
import javax.swing.JComboBox;
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
import net.plaut.common.util.StringUtil;
import net.plaut.dbutil.db.DbConnection;
import javax.swing.ImageIcon;

public class HapusUserView extends JInternalFrame {
	private JTextField tfUserName;
	private JButton btSave;
	private JButton btCancel;
	private TambahUserModel model;
	private Panel panel;
	private Panel panel_1;
	private JTextField tfGrupLevel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HapusUserView frame = new HapusUserView();
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
	public HapusUserView() {
		setFrameIcon(new ImageIcon(HapusUserView.class.getResource("/net/plaut/bprtab/resources/HapusUser.png")));
		getContentPane().setBackground(new Color(255, 250, 205));
		getContentPane().setFont(new Font("Arial", Font.PLAIN, 15));
		setTitle("Hapus User");
		setBounds(100, 100, 399, 168);
		setClosable(true);
		setIconifiable(true);

		BpaUserGroupTableDao guDao = new BpaUserGroupTableDao();
		Connection con;
		try {
			con = DbConnection.createConnection("localhost", "root", "",
					"bpr_averos");
		} catch (SQLException e1) {
			con = null;
		}
		ArrayList<BpaUserGroupTableRecord> listGroupUser;
		try {
			BpaUserGroupSrcCond cond = new BpaUserGroupSrcCond();
			listGroupUser = guDao.executeQuery(con, cond);
		} catch (SQLException e) {
			listGroupUser = new ArrayList<BpaUserGroupTableRecord>();
		}

		getContentPane().setLayout(null);

		panel_1 = new Panel();
		panel_1.setBackground(new Color(255, 250, 240));
		panel_1.setBounds(10, 95, 363, 37);
		getContentPane().add(panel_1);

		btSave = new JButton("Hapus");
		btSave.setIcon(new ImageIcon(HapusUserView.class.getResource("/net/plaut/bprtab/resources/Simpan.png")));
		panel_1.add(btSave);
		btSave.setFont(new Font("Arial", Font.BOLD, 15));

		btCancel = new JButton("Batal");
		btCancel.setIcon(new ImageIcon(HapusUserView.class.getResource("/net/plaut/bprtab/resources/Batal.png")));
		panel_1.add(btCancel);
		btCancel.setFont(new Font("Arial", Font.BOLD, 15));

		panel = new Panel();
		panel.setBackground(new Color(255, 250, 240));
		panel.setBounds(10, 10, 363, 79);
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

		JLabel lblLevel = new JLabel("Group Level");
		lblLevel.setBounds(10, 40, 99, 24);
		panel.add(lblLevel);
		lblLevel.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JButton btnNewButton = new JButton("Cari");
		btnNewButton.setIcon(new ImageIcon(HapusUserView.class.getResource("/net/plaut/bprtab/resources/Cari.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setBounds(270, 8, 80, 26);
		panel.add(btnNewButton);
		
		tfGrupLevel = new JTextField();
		tfGrupLevel.setFont(new Font("Arial", Font.BOLD, 15));
		tfGrupLevel.setEnabled(false);
		tfGrupLevel.setColumns(10);
		tfGrupLevel.setBounds(171, 44, 180, 25);
		panel.add(tfGrupLevel);

		model = new TambahUserModel();
		addEvent();
	}

	private void addEvent() {
//		btSave.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				saveAction(e);
//			}
//		});

		btCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

//	private void saveAction(ActionEvent e) {
//		if (!isInputValid())
//			return;
//		Connection con;
//		try {
//			con = DbConnection.createConnection("localhost", "root", "",
//					"bpr_averos");
//			model.setUserName(tfUserName.getText());
//			model.setPassword(new String(pfPassword1.getPassword()));
////			model.setIdGroupLevel(cbGroupLevel.getSelectedValue());
//
//			BpaUserTableRecord record = new BpaUserTableRecord();
//			record.setUsername(model.getUserName());
//			record.setPassword(model.getPassword());
//			record.setGroup(model.getIdGroupLevel());
//			BpaUserTableDao userDao = new BpaUserTableDao();
//			userDao.insert(con, record);
//			JOptionPane.showMessageDialog(null, "User Berhasil Ditambahkan");
//		} catch (SQLException e1) {
//			JOptionPane.showMessageDialog(null, e1.getMessage());
//		}
//	}

	private boolean isInputValid() {
		if (StringUtil.isEmpty(tfUserName.getText())) {
			JOptionPane.showMessageDialog(null, "Username Masih Kosong");
			return false;
		}

//		if (pfPassword1.getPassword() == null) {
//			JOptionPane.showMessageDialog(null, "Password Masih Kosong");
//			return false;
//		}
//
//		if (pfPassword2.getPassword() == null) {
//			JOptionPane.showMessageDialog(null,
//					"Konfirmasi Password Masih Kosong");
//			return false;
//		}

//		String password1 = new String(pfPassword1.getPassword());
//		String password2 = new String(pfPassword2.getPassword());
//		if (!password1.equals(password2)) {
//			JOptionPane.showMessageDialog(null,
//					"Konfirmasi Password Tidak Sama");
//			return false;
//		}
//
//		if (cbGroupLevel.getSelectedIndex() == -1) {
//			JOptionPane.showMessageDialog(null, "Group Level Belum Terpilih");
//			return false;
//		}

		return true;

	}
}
