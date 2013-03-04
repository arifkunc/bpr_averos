package net.plaut.bprtab.komp.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Panel;

public class BatalTarikTabunganView extends JInternalFrame {
	private JTextField tfNomorID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BatalTarikTabunganView frame = new BatalTarikTabunganView();
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
	public BatalTarikTabunganView() {
		getContentPane().setBackground(new Color(255, 250, 205));
		setFrameIcon(new ImageIcon(BatalTarikTabunganView.class.getResource("/net/plaut/bprtab/resources/BatalTarik.png")));
		getContentPane().setFont(new Font("Arial", Font.PLAIN, 15));
		setTitle("Batal Tarik Tabungan");
		setBounds(100, 100, 450, 422);
		setClosable(true);
		setIconifiable(true);
		getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(255, 250, 240));
		panel.setBounds(10, 10, 414, 160);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNomorId = new JLabel("Nomor ID");
		lblNomorId.setBounds(10, 8, 70, 25);
		panel.add(lblNomorId);
		lblNomorId.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel lblNamaLengkap = new JLabel("Nama Lengkap");
		lblNamaLengkap.setBounds(10, 40, 105, 25);
		panel.add(lblNamaLengkap);
		lblNamaLengkap.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel lblKelas = new JLabel("Kelas");
		lblKelas.setBounds(10, 72, 37, 25);
		panel.add(lblKelas);
		lblKelas.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel lblSaldoSaatIni = new JLabel("Saldo");
		lblSaldoSaatIni.setBounds(10, 104, 110, 25);
		panel.add(lblSaldoSaatIni);
		lblSaldoSaatIni.setFont(new Font("Arial", Font.PLAIN, 15));
		
		tfNomorID = new JTextField();
		tfNomorID.setEnabled(false);
		tfNomorID.setBounds(146, 8, 180, 25);
		panel.add(tfNomorID);
		tfNomorID.setToolTipText("Mencari Nasabah");
		tfNomorID.setFont(new Font("Arial", Font.PLAIN, 15));
		tfNomorID.setColumns(10);
		
		JLabel lblnama = new JLabel("-nama lengkap-");
		lblnama.setEnabled(false);
		lblnama.setBounds(146, 40, 260, 25);
		panel.add(lblnama);
		lblnama.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel lblkelas = new JLabel("-kelas-");
		lblkelas.setEnabled(false);
		lblkelas.setBounds(146, 72, 260, 25);
		panel.add(lblkelas);
		lblkelas.setFont(new Font("Arial", Font.BOLD, 15));
		
		JTextPane txtpnsaldo = new JTextPane();
		txtpnsaldo.setEnabled(false);
		txtpnsaldo.setEditable(false);
		txtpnsaldo.setBounds(146, 104, 260, 30);
		panel.add(txtpnsaldo);
		txtpnsaldo.setFont(new Font("Arial", Font.BOLD, 15));
		txtpnsaldo.setText("-saldo-");
		
		JButton btnCari = new JButton("Cari");
		btnCari.setIcon(new ImageIcon(BatalTarikTabunganView.class.getResource("/net/plaut/bprtab/resources/Cari.png")));
		btnCari.setBounds(330, 8, 80, 26);
		panel.add(btnCari);
		btnCari.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel lblNewLabel = new JLabel("Sekian rupiah");
		lblNewLabel.setBounds(155, 136, 200, 15);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.BLUE);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(255, 250, 240));
		panel_1.setBounds(10, 176, 414, 160);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblSandiTransaksi = new JLabel("Kode Transaksi");
		lblSandiTransaksi.setBounds(10, 8, 120, 25);
		panel_1.add(lblSandiTransaksi);
		lblSandiTransaksi.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel lblJenisTransaksi = new JLabel("Jenis Transaksi");
		lblJenisTransaksi.setBounds(10, 40, 120, 25);
		panel_1.add(lblJenisTransaksi);
		lblJenisTransaksi.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel lblNominal = new JLabel("Nominal");
		lblNominal.setBounds(10, 72, 120, 25);
		panel_1.add(lblNominal);
		lblNominal.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel lblsandi = new JLabel("-sandi-");
		lblsandi.setEnabled(false);
		lblsandi.setBounds(146, 8, 260, 25);
		panel_1.add(lblsandi);
		lblsandi.setFont(new Font("Arial", Font.BOLD, 15));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEnabled(false);
		comboBox.setBounds(146, 40, 260, 25);
		panel_1.add(comboBox);
		comboBox.setFont(new Font("Arial", Font.BOLD, 15));
		
		JTextPane txtpnnominal = new JTextPane();
		txtpnnominal.setEnabled(false);
		txtpnnominal.setBounds(146, 72, 260, 25);
		panel_1.add(txtpnnominal);
		txtpnnominal.setFont(new Font("Arial", Font.BOLD, 15));
		txtpnnominal.setText("-nominal-");
		
		JTextPane txtpnsaldoSaatIni = new JTextPane();
		txtpnsaldoSaatIni.setEnabled(false);
		txtpnsaldoSaatIni.setBounds(146, 104, 260, 25);
		panel_1.add(txtpnsaldoSaatIni);
		txtpnsaldoSaatIni.setFont(new Font("Arial", Font.BOLD, 15));
		txtpnsaldoSaatIni.setText("-saldo saat ini-");
		
		JLabel lblSaldoSaatIni_1 = new JLabel("Saldo Saat Ini ");
		lblSaldoSaatIni_1.setBounds(10, 104, 120, 25);
		panel_1.add(lblSaldoSaatIni_1);
		lblSaldoSaatIni_1.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel label = new JLabel("Sekian rupiah");
		label.setBounds(155, 136, 200, 14);
		panel_1.add(label);
		label.setForeground(Color.BLUE);
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(new Color(255, 250, 240));
		panel_2.setBounds(10, 342, 414, 37);
		getContentPane().add(panel_2);
		
		JButton btnSimpan = new JButton("Batal");
		btnSimpan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSimpan.setIcon(new ImageIcon(BatalTarikTabunganView.class.getResource("/net/plaut/bprtab/resources/Simpan.png")));
		panel_2.add(btnSimpan);
		btnSimpan.setFont(new Font("Arial", Font.BOLD, 15));
		
		JButton btnBatal = new JButton("Kembali");
		btnBatal.setIcon(new ImageIcon(BatalTarikTabunganView.class.getResource("/net/plaut/bprtab/resources/Batal.png")));
		panel_2.add(btnBatal);
		btnBatal.setFont(new Font("Arial", Font.BOLD, 15));

	}
}
