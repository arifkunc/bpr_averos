package net.plaut.bprtab.komp.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import net.plaut.bprtab.komp.model.TambahNasabahModel;

public class HapusNasabahView extends JInternalFrame {
	private JTextField tfNomorID;
	private JTextField tfNama;
	private JTextField tfTelepon;
	private JTextField tfNamaOrangtua;
	private TambahNasabahModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HapusNasabahView frame = new HapusNasabahView();
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
	public HapusNasabahView() {
		setFrameIcon(new ImageIcon(HapusNasabahView.class.getResource("/net/plaut/bprtab/resources/HapusNasabah.png")));
		getContentPane().setBackground(new Color(255, 250, 205));
		setBackground(SystemColor.activeCaption);
		getContentPane().setFont(new Font("Arial", Font.PLAIN, 15));
		setTitle("Hapus Nasabah");
		setBounds(100, 100, 450, 411);
		setClosable(true);
		setIconifiable(true);
		getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(255, 250, 240));
		panel.setBounds(10, 332, 414, 37);
		getContentPane().add(panel);
		
				JButton btnSimpan = new JButton("Hapus");
				btnSimpan.setIcon(new ImageIcon(HapusNasabahView.class.getResource("/net/plaut/bprtab/resources/Simpan.png")));
				btnSimpan.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				panel.add(btnSimpan);
				btnSimpan.setFont(new Font("Arial", Font.BOLD, 15));
				
						JButton btnBatal = new JButton("Batal");
						btnBatal.setIcon(new ImageIcon(HapusNasabahView.class.getResource("/net/plaut/bprtab/resources/Batal.png")));
						panel.add(btnBatal);
						btnBatal.setFont(new Font("Arial", Font.BOLD, 15));
								
								Panel panel_1 = new Panel();
								panel_1.setBackground(new Color(255, 250, 240));
								panel_1.setBounds(10, 11, 414, 315);
								getContentPane().add(panel_1);
								panel_1.setLayout(null);
								
								JLabel label = new JLabel("Nomor ID");
								label.setBounds(10, 8, 62, 18);
								label.setFont(new Font("Arial", Font.PLAIN, 15));
								panel_1.add(label);
								
								JLabel label_2 = new JLabel("Kelas");
								label_2.setBounds(10, 72, 37, 18);
								label_2.setFont(new Font("Arial", Font.PLAIN, 15));
								panel_1.add(label_2);
								
								JLabel label_3 = new JLabel("Gender");
								label_3.setBounds(10, 104, 48, 18);
								label_3.setFont(new Font("Arial", Font.PLAIN, 15));
								panel_1.add(label_3);
								
								JLabel label_4 = new JLabel("Alamat");
								label_4.setBounds(10, 136, 45, 18);
								label_4.setFont(new Font("Arial", Font.PLAIN, 15));
								panel_1.add(label_4);
								
								JLabel label_5 = new JLabel("Telepon");
								label_5.setBounds(10, 214, 52, 18);
								label_5.setFont(new Font("Arial", Font.PLAIN, 15));
								panel_1.add(label_5);
								
								JLabel label_1 = new JLabel("Nama Lengkap");
								label_1.setBounds(10, 40, 98, 18);
								label_1.setFont(new Font("Arial", Font.PLAIN, 15));
								panel_1.add(label_1);
								
								JLabel label_6 = new JLabel("Keterangan");
								label_6.setBounds(10, 246, 75, 18);
								label_6.setFont(new Font("Arial", Font.PLAIN, 15));
								panel_1.add(label_6);
								
								JLabel label_7 = new JLabel("Nama Orang tua");
								label_7.setBounds(10, 183, 108, 18);
								label_7.setFont(new Font("Arial", Font.PLAIN, 15));
								panel_1.add(label_7);
								
										tfNomorID = new JTextField();
										tfNomorID.setEditable(false);
										tfNomorID.setBounds(142, 8, 177, 25);
										panel_1.add(tfNomorID);
										tfNomorID.setFont(new Font("Arial", Font.BOLD, 15));
										tfNomorID.setColumns(10);
										
												JTextArea taAlamat = new JTextArea();
												taAlamat.setEditable(false);
												taAlamat.setEnabled(false);
												taAlamat.setBounds(142, 136, 260, 40);
												panel_1.add(taAlamat);
												taAlamat.setLineWrap(true);
												taAlamat.setFont(new Font("Arial", Font.BOLD, 15));
												
														tfNamaOrangtua = new JTextField();
														tfNamaOrangtua.setEnabled(false);
														tfNamaOrangtua.setEditable(false);
														tfNamaOrangtua.setBounds(142, 183, 260, 25);
														panel_1.add(tfNamaOrangtua);
														tfNamaOrangtua.setFont(new Font("Arial", Font.BOLD, 15));
														tfNamaOrangtua.setColumns(10);
														
																tfTelepon = new JTextField();
																tfTelepon.setEnabled(false);
																tfTelepon.setEditable(false);
																tfTelepon.setBounds(142, 214, 260, 25);
																panel_1.add(tfTelepon);
																tfTelepon.setFont(new Font("Arial", Font.BOLD, 15));
																tfTelepon.setColumns(10);
																
																		JTextArea taKeterangan = new JTextArea();
																		taKeterangan.setEditable(false);
																		taKeterangan.setEnabled(false);
																		taKeterangan.setBounds(142, 246, 260, 60);
																		panel_1.add(taKeterangan);
																		taKeterangan.setLineWrap(true);
																		taKeterangan.setFont(new Font("Arial", Font.BOLD, 15));
																		
																				JRadioButton rdbtnLakilaki = new JRadioButton("Laki-laki");
																				rdbtnLakilaki.setEnabled(false);
																				rdbtnLakilaki.setBackground(new Color(255, 250, 240));
																				rdbtnLakilaki.setBounds(142, 104, 100, 23);
																				panel_1.add(rdbtnLakilaki);
																				rdbtnLakilaki.setFont(new Font("Arial", Font.PLAIN, 15));
																				
																						tfNama = new JTextField();
																						tfNama.setEnabled(false);
																						tfNama.setBounds(142, 40, 260, 25);
																						panel_1.add(tfNama);
																						tfNama.setFont(new Font("Arial", Font.BOLD, 15));
																						tfNama.setColumns(10);
																								
																										JComboBox cbKelas = new JComboBox();
																										cbKelas.setEnabled(false);
																										cbKelas.setBounds(142, 72, 100, 25);
																										panel_1.add(cbKelas);
																										cbKelas.setFont(new Font("Arial", Font.BOLD, 15));
																										
																												JRadioButton rdbtnPerempuan = new JRadioButton("Perempuan");
																												rdbtnPerempuan.setEnabled(false);
																												rdbtnPerempuan.setBackground(new Color(255, 250, 240));
																												rdbtnPerempuan.setBounds(244, 104, 120, 23);
																												panel_1.add(rdbtnPerempuan);
																												rdbtnPerempuan.setFont(new Font("Arial", Font.PLAIN, 15));
																												
																												JTextPane txtpnSaldo = new JTextPane();
																												txtpnSaldo.setText("Saldo Saat Ini");
																												txtpnSaldo.setFont(new Font("Arial", Font.BOLD, 15));
																												txtpnSaldo.setEditable(false);
																												txtpnSaldo.setBounds(287, 72, 115, 25);
																												panel_1.add(txtpnSaldo);
																												
																												JButton button = new JButton("Cari");
																												button.setIcon(new ImageIcon(HapusNasabahView.class.getResource("/net/plaut/bprtab/resources/Cari.png")));
																												button.setFont(new Font("Arial", Font.BOLD, 15));
																												button.setBounds(322, 8, 80, 26);
																												panel_1.add(button);

	}
}
