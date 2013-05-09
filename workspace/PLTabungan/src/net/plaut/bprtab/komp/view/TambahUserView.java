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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.plaut.bprtab.dao.BpaUserGroupTableDao;
import net.plaut.bprtab.dao.BpaUserGroupTableRecord;
import net.plaut.bprtab.dao.condition.BpaUserGroupSrcCond;
import net.plaut.bprtab.logic.UserFacade;
import net.plaut.bprtab.logic.UserLogic;
import net.plaut.bprtab.object.AddUserDto;
import net.plaut.bprtab.util.DbCommand;
import net.plaut.bprtab.util.SystemInformation;
import net.plaut.common.util.StringUtil;
import net.plaut.component.PComboBoxLoad;
import net.plaut.dbutil.db.DbConnection;

public class TambahUserView extends JInternalFrame {
	private JTextField tfUserName;
	private JPasswordField pfPassword1;
	private JPasswordField pfPassword2;
	private PComboBoxLoad cbGroupLevel;
	private JButton btSave;
	private JButton btCancel;
	private Panel panelA;
	private Panel panelB;
	
	private HashMap<String, String> userGroupMap;
	private String[] userGroupId;
	private String[] userGroupName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TambahUserView frame = new TambahUserView();
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
	public TambahUserView() {
		setFrameIcon(new ImageIcon(TambahUserView.class.getResource("/net/plaut/bprtab/resources/TambahUser.png")));
		getContentPane().setBackground(new Color(255, 250, 205));
		getContentPane().setFont(new Font("Arial", Font.PLAIN, 15));
		setTitle("Tambah User Baru");
		//setBounds(100, 100, 399, 229);
		setBounds(100, 100, 399, 250);
		setClosable(true);
		setIconifiable(true);

		BpaUserGroupTableDao guDao = BpaUserGroupTableDao.getInstance();
		Connection con;
		ArrayList<BpaUserGroupTableRecord> userGroupList;
		try {
			con = DbCommand.getConnection();
			BpaUserGroupSrcCond cond = new BpaUserGroupSrcCond();
			userGroupList = guDao.executeQuery(con, cond);
		} catch (SQLException e) {
			userGroupList = new ArrayList<BpaUserGroupTableRecord>();
		}
		userGroupMap = getUserGroupMap(userGroupList);
		userGroupId = getUserGroupId(userGroupList);
		userGroupName = getUserGroupName(userGroupList);
		
		getContentPane().setLayout(null);
		
		panelA = new Panel();
		panelA.setBackground(new Color(255, 250, 240));
		
		panelA.setBounds(10, 10, 363, 171);
		panelA.setLayout(null);
		cbGroupLevel = new PComboBoxLoad(userGroupId, userGroupName);
		panelA.add(cbGroupLevel);
		cbGroupLevel.setBounds(171, 104, 180, 25);
		cbGroupLevel.setFont(new Font("Arial", Font.BOLD, 15));
		cbGroupLevel.setSelectedIndex(-1);
		cbGroupLevel.repaint();
		getContentPane().add(panelA);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 11, 68, 18);
		panelA.add(lblUsername);
		lblUsername.setFont(new Font("Arial", Font.PLAIN, 15));

		tfUserName = new JTextField();
		tfUserName.setBounds(171, 8, 180, 25);
		panelA.add(tfUserName);
		tfUserName.setFont(new Font("Arial", Font.BOLD, 15));
		tfUserName.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 40, 76, 24);
		panelA.add(lblPassword);
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 15));

		pfPassword1 = new JPasswordField();
		pfPassword1.setBounds(171, 40, 180, 25);
		panelA.add(pfPassword1);
		pfPassword1.setFont(new Font("Arial", Font.BOLD, 15));
		pfPassword1.setColumns(10);

		JLabel lblPassword_1 = new JLabel("Ketik Ulang Password");
		lblPassword_1.setBounds(10, 72, 151, 24);
		panelA.add(lblPassword_1);
		lblPassword_1.setFont(new Font("Arial", Font.PLAIN, 15));

		pfPassword2 = new JPasswordField();
		pfPassword2.setBounds(171, 72, 180, 25);
		panelA.add(pfPassword2);
		pfPassword2.setFont(new Font("Arial", Font.BOLD, 15));
		pfPassword2.setColumns(10);

		JLabel lblLevel = new JLabel("Group Level");
		lblLevel.setBounds(10, 104, 99, 24);
		panelA.add(lblLevel);
		lblLevel.setFont(new Font("Arial", Font.PLAIN, 15));

		panelB = new Panel();
		panelB.setBackground(new Color(255, 250, 240));
		panelB.setBounds(10, 187, 363, 37);
		getContentPane().add(panelB);

		btSave = new JButton("Simpan");
		btSave.setIcon(new ImageIcon(TambahUserView.class.getResource("/net/plaut/bprtab/resources/Simpan.png")));
		panelB.add(btSave);
		btSave.setFont(new Font("Arial", Font.BOLD, 15));

		btCancel = new JButton("Batal");
		btCancel.setIcon(new ImageIcon(TambahUserView.class.getResource("/net/plaut/bprtab/resources/Batal.png")));
		panelB.add(btCancel);
		btCancel.setFont(new Font("Arial", Font.BOLD, 15));

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
	}

	private void saveAction(ActionEvent e) {
		if (!isInputValid()){
			return;
		}
			
		try {
			Connection con = DbCommand.getConnection();
			UserFacade facade = UserFacade.getInstance();
			AddUserDto dto = new AddUserDto();
			dto.setUsername(tfUserName.getText());
			dto.setPassword(new String(pfPassword1.getPassword()));
			dto.setGroupLevelId((String) cbGroupLevel.getSelectedValue());
			facade.createNewUser(con, dto);
			JOptionPane.showMessageDialog(null, "User baru berhasil ditambahkan");
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

		if (pfPassword1.getPassword() == null || pfPassword1.getPassword().length == 0) {
			JOptionPane.showMessageDialog(null, "Password Masih Kosong");
			return false;
		}

		if (pfPassword2.getPassword() == null || pfPassword2.getPassword().length == 0) {
			JOptionPane.showMessageDialog(null, "Konfirmasi Password Masih Kosong");
			return false;
		}

		String password1 = new String(pfPassword1.getPassword());
		String password2 = new String(pfPassword2.getPassword());
		if (!password1.equals(password2)) {
			JOptionPane.showMessageDialog(null, "Konfirmasi Password Tidak Sama");
			return false;
		}

		if (cbGroupLevel.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(null, "Group Level Belum Terpilih");
			return false;
		}
		
		// check for username exists or not
		String username = tfUserName.getText();
		UserLogic logic = UserLogic.getInstance();
		try {
			Connection con = DbCommand.getConnection();
			if(logic.checkUserExist(con, username)){
				JOptionPane.showMessageDialog(null, "Username telah ada sebelumnya");
				return false;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Terjadi eror pada koneksi database");
			return false;
		}
		
		return true;
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
