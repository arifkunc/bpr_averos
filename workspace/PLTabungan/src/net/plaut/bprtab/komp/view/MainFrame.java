package net.plaut.bprtab.komp.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import net.miginfocom.swing.MigLayout;
import net.plaut.bprtab.constant.DbConstant;
import net.plaut.bprtab.util.LoginInformation;
import net.plaut.common.util.PropertiesReader;
import net.plaut.component.IconTextButton;
import net.plaut.component.MDIDesktopPane;

public class MainFrame extends JFrame {
	
	//only one instance
	private static MainFrame instance;
	
	private JPanel contentPane;
	private MDIDesktopPane mainDesktopPane;
	private JTabbedPane tabbedPaneNoUser;
	private JTabbedPane tabbedPaneSuperAdmin;
	private JTabbedPane tabbedPaneTeller;
	private JPanel panelHomeNoUser;
	private JPanel panelHomeSuperAdmin;
	private JPanel panelNasabahSuperAdmin;
	private JPanel panelUserSuperAdmin;
	private JPanel panelHomeTeller;
	private JPanel panelTransaksiTeller;
	private JScrollPane scrollPaneforDesktopPane;
	private JPanel panelCard;
	private CardLayout cardLayout;
	private JLabel lbBottom;
	
	// button attribute
	// button for tabbedPaneNoUser
	private IconTextButton btLoginNoUser;
	private IconTextButton btLogoutNoUser;
	
	//button for tabbedPaneSuperAdmin
	private IconTextButton btLoginSuperAdmin;
	private IconTextButton btLogoutSuperAdmin;
	private IconTextButton btTambahNasabah;
	private IconTextButton btUbahNasabah;
	private IconTextButton btHapusNasabah;
	private IconTextButton btTambahUser;
	private IconTextButton btUbahUser;
	private IconTextButton btHapusUser;
	
	//button for tabbedPaneTeller
	private IconTextButton btLoginTeller;
	private IconTextButton btLogoutTeller;
	private IconTextButton btPenarikan;
	private IconTextButton btPenyetoran;
	private IconTextButton btBatalTarik;
	private IconTextButton btBatalSetor;
	private IconTextButton btBunga;
	private IconTextButton btAdministrasi;
	
	private String resourcesPath;

	public static MainFrame getInstance() {
		if(instance == null)
			instance = new MainFrame();
		return instance;
	}

	/**
	 * Create the frame.
	 */
	private MainFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/net/plaut/bprtab/resources/averos_desktoppane.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(new Dimension(1296, 795));
        setLocation(0, 0);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("APLIKASI BANK SEKOLAH SMA AVEROS - Sorong");
        
        PropertiesReader propertiesReader = new PropertiesReader("prop/config.properties");
        resourcesPath = propertiesReader.getProperty("resources.path");
        
        initComponent();
        addListener();
        
        setVisible(true);
	}
	
	private void initComponent(){
		//instantiate all component
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		panelCard = new JPanel();
		scrollPaneforDesktopPane = new JScrollPane();
		mainDesktopPane = new MDIDesktopPane();
		tabbedPaneNoUser = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneNoUser.setBackground(new Color(240, 240, 240));
		tabbedPaneNoUser.setFont(new Font("Arial", Font.BOLD, 15));
		panelHomeNoUser = new JPanel();
		panelHomeNoUser.setBackground(new Color(240, 240, 240));
		
		tabbedPaneSuperAdmin = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneSuperAdmin.setFont(new Font("Arial", Font.BOLD, 15));
		panelNasabahSuperAdmin = new JPanel();
		panelUserSuperAdmin = new JPanel();
		
		tabbedPaneTeller = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneTeller.setFont(new Font("Arial", Font.BOLD, 15));
		panelHomeTeller = new JPanel();
		panelTransaksiTeller = new JPanel();
		
		lbBottom = new JLabel("Papeda Laut \u00A9 2013");
		lbBottom.setFont(new Font("Tahoma", Font.BOLD, 11));
		cardLayout = new CardLayout();
		
		// instantiate button for tabbedPaneNoUser
		btLoginNoUser = new IconTextButton("Login", resourcesPath + "icon48.png");
		btLoginNoUser.setIcon(new ImageIcon(MainFrame.class.getResource("/net/plaut/bprtab/resources/Login.png")));
		btLoginNoUser.setFont(new Font("Arial", Font.BOLD, 15));
		btLogoutNoUser = new IconTextButton("Logout", resourcesPath + "icon48.png");
		btLogoutNoUser.setIcon(new ImageIcon(MainFrame.class.getResource("/net/plaut/bprtab/resources/Logout.png")));
		btLogoutNoUser.setFont(new Font("Arial", Font.BOLD, 15));
		btTambahNasabah = new IconTextButton("Buat Nasabah", resourcesPath + "icon48.png");
		btTambahNasabah.setText("Tambah Nasabah");
		btTambahNasabah.setIcon(new ImageIcon(MainFrame.class.getResource("/net/plaut/bprtab/resources/TambahNasabah.png")));
		btTambahNasabah.setFont(new Font("Arial", Font.BOLD, 15));
		btUbahNasabah = new IconTextButton("Edit Nasabah", resourcesPath + "icon48.png");
		btUbahNasabah.setText("Ubah Nasabah");
		btUbahNasabah.setIcon(new ImageIcon(MainFrame.class.getResource("/net/plaut/bprtab/resources/EditNasabah.png")));
		btUbahNasabah.setFont(new Font("Arial", Font.BOLD, 15));
		btHapusNasabah = new IconTextButton("Hapus Nasabah", resourcesPath + "icon48.png");
		btHapusNasabah.setIcon(new ImageIcon(MainFrame.class.getResource("/net/plaut/bprtab/resources/HapusNasabah.png")));
		btHapusNasabah.setFont(new Font("Arial", Font.BOLD, 15));
		btTambahUser = new IconTextButton("Buat User", resourcesPath + "icon48.png");
		btTambahUser.setText("Tambah User");
		btTambahUser.setIcon(new ImageIcon(MainFrame.class.getResource("/net/plaut/bprtab/resources/TambahUser.png")));
		btTambahUser.setFont(new Font("Arial", Font.BOLD, 15));
		btUbahUser = new IconTextButton("Edit User", resourcesPath + "icon48.png");
		btUbahUser.setIcon(new ImageIcon(MainFrame.class.getResource("/net/plaut/bprtab/resources/UbahUser.png")));
		btUbahUser.setText("Ubah User");
		btUbahUser.setFont(new Font("Arial", Font.BOLD, 15));
		btHapusUser = new IconTextButton("Hapus User", resourcesPath + "icon48.png");
		btHapusUser.setIcon(new ImageIcon(MainFrame.class.getResource("/net/plaut/bprtab/resources/HapusUser.png")));
		btHapusUser.setFont(new Font("Arial", Font.BOLD, 15));
		
		// instantiate button for tabbedPaneTeller
		btLoginTeller = new IconTextButton("Login", resourcesPath + "icon48.png");
		btLoginTeller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btLoginTeller.setIcon(new ImageIcon(MainFrame.class.getResource("/net/plaut/bprtab/resources/Login.png")));
		btLoginTeller.setFont(new Font("Arial", Font.BOLD, 15));
		btLogoutTeller = new IconTextButton("Logout", resourcesPath + "icon48.png");
		btLogoutTeller.setIcon(new ImageIcon(MainFrame.class.getResource("/net/plaut/bprtab/resources/Logout.png")));
		btLogoutTeller.setFont(new Font("Arial", Font.BOLD, 15));
		btPenarikan = new IconTextButton("Penarikan", resourcesPath + "icon48.png");
		btPenarikan.setIcon(new ImageIcon(MainFrame.class.getResource("/net/plaut/bprtab/resources/Tarik.png")));
		btPenarikan.setFont(new Font("Arial", Font.BOLD, 15));
		btBatalTarik = new IconTextButton("Batal Tarik", resourcesPath + "icon48.png");
		btBatalTarik.setIcon(new ImageIcon(MainFrame.class.getResource("/net/plaut/bprtab/resources/BatalTarik.png")));
		btBatalTarik.setFont(new Font("Arial", Font.BOLD, 15));
		btBunga = new IconTextButton("Bunga", resourcesPath + "icon48.png");
		btBunga.setText("Suku Bunga");
		btBunga.setIcon(new ImageIcon(MainFrame.class.getResource("/net/plaut/bprtab/resources/Bunga.png")));
		btBunga.setFont(new Font("Arial", Font.BOLD, 15));
		btAdministrasi = new IconTextButton("Administrasi", resourcesPath + "icon48.png");
		btAdministrasi.setIcon(new ImageIcon(MainFrame.class.getResource("/net/plaut/bprtab/resources/Admin.png")));
		btAdministrasi.setFont(new Font("Arial", Font.BOLD, 15));
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[70][grow][20]"));
		
		
		contentPane.add(panelCard, "cell 0 0,grow");
		contentPane.add(scrollPaneforDesktopPane, "cell 0 1,grow");
		contentPane.add(lbBottom, "cell 0 2");
		
		panelCard.setLayout(cardLayout);
		panelCard.add(tabbedPaneNoUser, "nouser");
		panelCard.add(tabbedPaneSuperAdmin, "superadmin");
		panelCard.add(tabbedPaneTeller, "teller");
		
		//add tab
		tabbedPaneNoUser.addTab("HOME", new ImageIcon(MainFrame.class.getResource("/net/plaut/bprtab/resources/Home.png")), panelHomeNoUser, null);
		panelHomeSuperAdmin = new JPanel();
		
		// instantiate button for tabbedPaneSuperAdmin
		btLoginSuperAdmin = new IconTextButton("Login", resourcesPath + "icon48.png");
		btLoginSuperAdmin.setIcon(new ImageIcon(MainFrame.class.getResource("/net/plaut/bprtab/resources/Login.png")));
		btLoginSuperAdmin.setFont(new Font("Arial", Font.BOLD, 15));
		btLogoutSuperAdmin = new IconTextButton("Logout", resourcesPath + "icon48.png");
		btLogoutSuperAdmin.setIcon(new ImageIcon(MainFrame.class.getResource("/net/plaut/bprtab/resources/Logout.png")));
		btLogoutSuperAdmin.setFont(new Font("Arial", Font.BOLD, 15));
		
		tabbedPaneSuperAdmin.addTab("HOME", new ImageIcon(MainFrame.class.getResource("/net/plaut/bprtab/resources/Home.png")), panelHomeSuperAdmin, null);
		
		// Add button into panelHomeSuperAdmin
		panelHomeSuperAdmin.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panelHomeSuperAdmin.add(btLoginSuperAdmin);
		panelHomeSuperAdmin.add(btLogoutSuperAdmin);
		tabbedPaneSuperAdmin.addTab("NASABAH", new ImageIcon(MainFrame.class.getResource("/net/plaut/bprtab/resources/Nasabah.png")), panelNasabahSuperAdmin, null);
		tabbedPaneSuperAdmin.addTab("USER", new ImageIcon(MainFrame.class.getResource("/net/plaut/bprtab/resources/User.png")), panelUserSuperAdmin, null);
		
		tabbedPaneTeller.addTab("HOME", new ImageIcon(MainFrame.class.getResource("/net/plaut/bprtab/resources/Home.png")), panelHomeTeller, null);
		tabbedPaneTeller.addTab("TRANSAKSI", new ImageIcon(MainFrame.class.getResource("/net/plaut/bprtab/resources/Transaksi.png")), panelTransaksiTeller, null);
		scrollPaneforDesktopPane.setViewportView(mainDesktopPane);
		
		// Add button into panelHomeNoUser
		panelHomeNoUser.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panelHomeNoUser.add(btLoginNoUser);
		panelHomeNoUser.add(btLogoutNoUser);
		
		// Add button into panelNasabahSuperAdmin
		panelNasabahSuperAdmin.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panelNasabahSuperAdmin.add(btTambahNasabah);
		panelNasabahSuperAdmin.add(btUbahNasabah);
		panelNasabahSuperAdmin.add(btHapusNasabah);
		
		// Add button into panelUserSuperAdmin
		panelUserSuperAdmin.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panelUserSuperAdmin.add(btTambahUser);
		panelUserSuperAdmin.add(btUbahUser);
		panelUserSuperAdmin.add(btHapusUser);
		
		// Add button into panelHomeTeller
		panelHomeTeller.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panelHomeTeller.add(btLoginTeller);
		panelHomeTeller.add(btLogoutTeller);
		
		// Add button into panelTransaksiTeller
		panelTransaksiTeller.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		btPenyetoran = new IconTextButton("Penyetoran", resourcesPath + "icon48.png");
		btPenyetoran.setIcon(new ImageIcon(MainFrame.class.getResource("/net/plaut/bprtab/resources/Setor.png")));
		btPenyetoran.setFont(new Font("Arial", Font.BOLD, 15));
		panelTransaksiTeller.add(btPenyetoran);
		panelTransaksiTeller.add(btPenarikan);
		btBatalSetor = new IconTextButton("Batal Setor", resourcesPath + "icon48.png");
		btBatalSetor.setIcon(new ImageIcon(MainFrame.class.getResource("/net/plaut/bprtab/resources/BatalSetor.png")));
		btBatalSetor.setFont(new Font("Arial", Font.BOLD, 15));
		panelTransaksiTeller.add(btBatalSetor);
		panelTransaksiTeller.add(btBatalTarik);
		panelTransaksiTeller.add(btBunga);
		panelTransaksiTeller.add(btAdministrasi);
		
		cardLayout.show(panelCard, "nouser");
		
		activateButton(DbConstant.USER_GROUP_NO_USER);
		
	}
	
	private void addListener(){
		btLoginNoUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showLoginView(e);
			}
		});
		
		btLogoutNoUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				logout();
				showLogoutView(e);
			}
		});
		
		btLogoutSuperAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				logout();
				showLogoutView(e);
			}
		});
		
		btLogoutTeller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				logout();
				showLogoutView(e);
			}
		});
		
		btTambahNasabah.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showAddNasabahForm(e);
			}
		});
		
		btUbahNasabah.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showEditNasabahForm(e);
			}
		});
		
		btHapusNasabah.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showHapusNasabahForm(e);
			}
		});
		
		btTambahUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showAddUserForm(e);
			}
		});
		
		btUbahUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showEditUserForm(e);
			}
		});
		
		btHapusUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showHapusUserForm(e);
			}
		});
		
		btPenyetoran.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showSetorTabunganView(e);
			}
		});
		
		btBatalSetor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showBatalSetorTabunganView(e);
			}
		});
		
		btPenarikan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTarikTabunganView(e);
			}
		});
		
		btBatalTarik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showBatalTarikTabunganView(e);
			}
		});
	}
	
	public void activateButton(String userGroup){
		if(userGroup.equals(DbConstant.USER_GROUP_NO_USER)){
			btLoginNoUser.setEnabled(true);
			btLogoutNoUser.setEnabled(false);
			
			btLoginSuperAdmin.setEnabled(false);
			btLogoutSuperAdmin.setEnabled(false);
			btTambahNasabah.setEnabled(false);
			btUbahNasabah.setEnabled(false);
			btHapusNasabah.setEnabled(false);
			btTambahUser.setEnabled(false);
			btUbahUser.setEnabled(false);
			btHapusUser.setEnabled(false);
			
			btLoginTeller.setEnabled(false);
			btLogoutTeller.setEnabled(false);
			btPenarikan.setEnabled(false);
			btPenyetoran.setEnabled(false);
			btBatalTarik.setEnabled(false);
			btBatalSetor.setEnabled(false);
			btBunga.setEnabled(false);
			btAdministrasi.setEnabled(false);
		}
		
		if(userGroup.equals(DbConstant.USER_GROUP_SUPER_ADMIN)){
			btLoginNoUser.setEnabled(false);
			btLogoutNoUser.setEnabled(false);
			
			btLoginSuperAdmin.setEnabled(false);
			btLogoutSuperAdmin.setEnabled(true);
			btTambahNasabah.setEnabled(true);
			btUbahNasabah.setEnabled(true);
			btHapusNasabah.setEnabled(true);
			btTambahUser.setEnabled(true);
			btUbahUser.setEnabled(true);
			btHapusUser.setEnabled(true);
			
			btLoginTeller.setEnabled(false);
			btLogoutTeller.setEnabled(false);
			btPenarikan.setEnabled(false);
			btPenyetoran.setEnabled(false);
			btBatalTarik.setEnabled(false);
			btBatalSetor.setEnabled(false);
			btBunga.setEnabled(false);
			btAdministrasi.setEnabled(false);
		}
		
		if(userGroup.equals(DbConstant.USER_GROUP_TELLER)){
			btLoginNoUser.setEnabled(false);
			btLogoutNoUser.setEnabled(false);
			
			btLoginSuperAdmin.setEnabled(false);
			btLogoutSuperAdmin.setEnabled(false);
			btTambahNasabah.setEnabled(false);
			btUbahNasabah.setEnabled(false);
			btHapusNasabah.setEnabled(false);
			btTambahUser.setEnabled(false);
			btUbahUser.setEnabled(false);
			btHapusUser.setEnabled(false);
			
			btLoginTeller.setEnabled(false);
			btLogoutTeller.setEnabled(true);
			btPenarikan.setEnabled(true);
			btPenyetoran.setEnabled(true);
			btBatalTarik.setEnabled(true);
			btBatalSetor.setEnabled(true);
			btBunga.setEnabled(true);
			btAdministrasi.setEnabled(true);
		}
	}
	
	public void switchPanelCard(String userGroup){
		if(userGroup.equals(DbConstant.USER_GROUP_NO_USER))
			cardLayout.show(panelCard, "nouser");
		
		if(userGroup.equals(DbConstant.USER_GROUP_SUPER_ADMIN))
			cardLayout.show(panelCard, "superadmin");
		
		if(userGroup.equals(DbConstant.USER_GROUP_TELLER))
			cardLayout.show(panelCard, "teller");
	}
	
	//Listener Method
	private void logout(){
		LoginInformation lInfo = LoginInformation.getInstance();
		lInfo.resetLoginInformation();
		JOptionPane.showMessageDialog(this, "Terima kasih. \n Anda Telah Logout.", "Logout", JOptionPane.INFORMATION_MESSAGE);
		activateButton(lInfo.getUserGroup());
		switchPanelCard(lInfo.getUserGroup());
	}
	
	private void showAddNasabahForm(ActionEvent e){
		TambahNasabahView tambahNasabah = new TambahNasabahView();
		mainDesktopPane.add(tambahNasabah);
		Dimension desktopSize = mainDesktopPane.getSize();
        Dimension childSize = tambahNasabah.getSize();
        tambahNasabah.setLocation((desktopSize.width - childSize.width)/2, (desktopSize.height - childSize.height)/2);
	}
	
	private void showEditNasabahForm(ActionEvent e){
		UbahNasabahView ubahNasabah = new UbahNasabahView();
		mainDesktopPane.add(ubahNasabah);
		Dimension desktopSize = mainDesktopPane.getSize();
        Dimension childSize = ubahNasabah.getSize();
        ubahNasabah.setLocation((desktopSize.width - childSize.width)/2, (desktopSize.height - childSize.height)/2);
	}
	
	private void showHapusNasabahForm(ActionEvent e){
		HapusNasabahView hapusNasabah = new HapusNasabahView();
		mainDesktopPane.add(hapusNasabah);
		Dimension desktopSize = mainDesktopPane.getSize();
        Dimension childSize = hapusNasabah.getSize();
        hapusNasabah.setLocation((desktopSize.width - childSize.width)/2, (desktopSize.height - childSize.height)/2);
	}
	
	private void showAddUserForm(ActionEvent e){
		TambahUserView tambahUser = new TambahUserView();
		mainDesktopPane.add(tambahUser);
		Dimension desktopSize = mainDesktopPane.getSize();
        Dimension childSize = tambahUser.getSize();
        tambahUser.setLocation((desktopSize.width - childSize.width)/2, (desktopSize.height - childSize.height)/2);
	}
	
	private void showEditUserForm(ActionEvent e){
		UbahUserView ubahUser = new UbahUserView();
		mainDesktopPane.add(ubahUser);
		Dimension desktopSize = mainDesktopPane.getSize();
        Dimension childSize = ubahUser.getSize();
        ubahUser.setLocation((desktopSize.width - childSize.width)/2, (desktopSize.height - childSize.height)/2);
	}
	
	private void showHapusUserForm(ActionEvent e){
		HapusUserView hapusUser = new HapusUserView();
		mainDesktopPane.add(hapusUser);
		Dimension desktopSize = mainDesktopPane.getSize();
        Dimension childSize = hapusUser.getSize();
        hapusUser.setLocation((desktopSize.width - childSize.width)/2, (desktopSize.height - childSize.height)/2);
	}
	
	private void showSetorTabunganView(ActionEvent e){
		SetorTabunganView setorTabungan = new SetorTabunganView();
		mainDesktopPane.add(setorTabungan);
		Dimension desktopSize = mainDesktopPane.getSize();
        Dimension childSize = setorTabungan.getSize();
        setorTabungan.setLocation((desktopSize.width - childSize.width)/2, (desktopSize.height - childSize.height)/2);
	}
	
	private void showBatalSetorTabunganView(ActionEvent e){
		BatalSetorTabunganView batalsetorTabungan = new BatalSetorTabunganView();
		mainDesktopPane.add(batalsetorTabungan);
		Dimension desktopSize = mainDesktopPane.getSize();
        Dimension childSize = batalsetorTabungan.getSize();
        batalsetorTabungan.setLocation((desktopSize.width - childSize.width)/2, (desktopSize.height - childSize.height)/2);
	}
	
	private void showTarikTabunganView(ActionEvent e){
		TarikTabunganView tarikTabungan = new TarikTabunganView();
		mainDesktopPane.add(tarikTabungan);
		Dimension desktopSize = mainDesktopPane.getSize();
        Dimension childSize = tarikTabungan.getSize();
        tarikTabungan.setLocation((desktopSize.width - childSize.width)/2, (desktopSize.height - childSize.height)/2);
	}
	
	private void showBatalTarikTabunganView(ActionEvent e){
		BatalTarikTabunganView bataltarikTabungan = new BatalTarikTabunganView();
		mainDesktopPane.add(bataltarikTabungan);
		Dimension desktopSize = mainDesktopPane.getSize();
        Dimension childSize = bataltarikTabungan.getSize();
        bataltarikTabungan.setLocation((desktopSize.width - childSize.width)/2, (desktopSize.height - childSize.height)/2);
	}
	
	private void showLoginView(ActionEvent e){
		LoginView loginView = new LoginView();
		mainDesktopPane.add(loginView);
		Dimension desktopSize = mainDesktopPane.getSize();
        Dimension childSize = loginView.getSize();
        loginView.setLocation((desktopSize.width - childSize.width)/2, (desktopSize.height - childSize.height)/2);
	}
	
	private void showLogoutView(ActionEvent e) {
		LoginInformation lInfo = LoginInformation.getInstance();
		lInfo.resetLoginInformation();
		JOptionPane.showMessageDialog(this, "Terima kasih. \n Anda Telah Logout.", "Logout", JOptionPane.INFORMATION_MESSAGE);
		activateButton(lInfo.getUserGroup());
		switchPanelCard(lInfo.getUserGroup());
		
		// LogoutView logoutView = new LogoutView();
		// mainDesktopPane.add(logoutView);
		// Dimension desktopSize = mainDesktopPane.getSize();
        // Dimension childSize = logoutView.getSize();
        // logoutView.setLocation((desktopSize.width - childSize.width)/2, (desktopSize.height - childSize.height)/2);
		

		
	}

}
