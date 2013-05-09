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
import java.util.HashMap;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import net.plaut.bprtab.komp.model.TambahUserModel;
import net.plaut.bprtab.logic.UserFacade;
import net.plaut.bprtab.logic.UserLogic;
import net.plaut.bprtab.object.AddUserDto;
import net.plaut.bprtab.object.UpdateUserDto;
import net.plaut.bprtab.util.DbCommand;
import net.plaut.bprtab.util.OnMemData;
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
	private PComboBoxLoad cbGroupLevel;
	private String selectedUsername;

	private HashMap<String, String> userGroupMap;
	private String[] userGroupId;
	private String[] userGroupName;

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

		BpaUserGroupTableDao guDao = BpaUserGroupTableDao.getInstance();
		Connection con;
		ArrayList<BpaUserGroupTableRecord> userGroupList;
		try {
			con = DbCommand.getConnection();
			userGroupList = guDao.executeQuery(con, null);
		} catch (SQLException e) {
			userGroupList = new ArrayList<BpaUserGroupTableRecord>();
		}
		userGroupMap = getUserGroupMap(userGroupList);
		userGroupId = getUserGroupId(userGroupList);
		userGroupName = getUserGroupName(userGroupList);

		usernameData = SystemInformation.createUsernameData();

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

		cbGroupLevel = new PComboBoxLoad(userGroupId, userGroupName);
		cbGroupLevel.setFont(new Font("Arial", Font.BOLD, 15));
		cbGroupLevel.setBounds(171, 108, 180, 25);
		panel.add(cbGroupLevel);

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
				updateAction(e);
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

	private void updateAction(ActionEvent e) {
		if (!isInputValid()){
			return;
		}

		try {
			Connection con = DbCommand.getConnection();
			UserFacade facade = UserFacade.getInstance();
			UpdateUserDto dto = new UpdateUserDto();
			dto.setOldUsername(selectedUsername);
			dto.setUsername(tfUserName.getText());
			dto.setPassword(new String(pfPassword1.getPassword()));
			dto.setGroupLevelId((String) cbGroupLevel.getSelectedValue());
			facade.updateUser(con, dto);
			JOptionPane.showMessageDialog(null, "User baru berhasil diubah");
			clearInput();
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Terjadi eror pada koneksi database");
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

		if (cbGroupLevel.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(null, "Group Level Belum Terpilih");
			return false;
		}

		return true;

	}

	private void showSelectUsernameDialog(){
		selectedUsername =  (String)JOptionPane.showInputDialog(this, "Pilih Username", "Pilihan Username", JOptionPane.QUESTION_MESSAGE, null, usernameData, "");
		if(selectedUsername != null){
			try {
				Connection con = DbCommand.getConnection();
				BpaUserTableDao dao = BpaUserTableDao.getInstance();
				BpaUserSrcCond cond = new BpaUserSrcCond();
				cond.setUsername(selectedUsername);
				List list = dao.executeQuery(con, cond);
				BpaUserTableRecord rec = (BpaUserTableRecord) list.get(0);

				tfUserName.setText(rec.getUsername());
				String groupLevel = userGroupMap.get(rec.getGroupId());
				cbGroupLevel.setSelectedItem(groupLevel);
			} catch (SQLException e) {

			}

		}
	}

	private void clearInput(){
		tfUserName.setText("");
		pfPassword1.setText("");
		pfPassword2.setText("");
		cbGroupLevel.setSelectedIndex(-1);
	}

	private HashMap<String, String> getUserGroupMap(ArrayList<BpaUserGroupTableRecord> userGroupList){
		HashMap<String, String> result = new HashMap<String, String>();
		if(userGroupList == null || userGroupList.isEmpty()){
			return result;
		}

		for(BpaUserGroupTableRecord rec:userGroupList){
			result.put(rec.getId(), rec.getGroupName());
		}
		return result;
	}

	private String[] getUserGroupId(ArrayList<BpaUserGroupTableRecord> userGroupList){
		if(userGroupList == null || userGroupList.isEmpty()){
			return null;
		}
		String[] result = new String[userGroupList.size()];
		for(int i=0; i< userGroupList.size(); i++){
			BpaUserGroupTableRecord rec = userGroupList.get(i);
			result[i] = rec.getId();
		}
		return result;
	}

	private String[] getUserGroupName(ArrayList<BpaUserGroupTableRecord> userGroupList){
		if(userGroupList == null || userGroupList.isEmpty()){
			return null;
		}
		String[] result = new String[userGroupList.size()];
		for(int i=0; i< userGroupList.size(); i++){
			BpaUserGroupTableRecord rec = userGroupList.get(i);
			result[i] = rec.getGroupName();
		}
		return result;
	}
}
