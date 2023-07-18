package Sistema;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Servicos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblNome;
	private JTextField nome;
	private JLabel lblServio;
	private JTextField servico;
	private JLabel lblQuarto;
	private JTextField quarto;
	private JButton btnCadastrar;
	private JButton btnExcluir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Servicos frame = new Servicos();
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
	public Servicos() {
		setTitle("Gerenciamento de serviços");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblServios = new JLabel("Serviços");
		lblServios.setBounds(12, 32, 70, 15);
		contentPane.add(lblServios);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 58, 426, 92);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome Cliente", "Tipo Serviço", "Quarto"
			}
		));
		scrollPane.setViewportView(table);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(12, 162, 70, 15);
		contentPane.add(lblNome);
		
		nome = new JTextField();
		nome.setBounds(78, 158, 360, 19);
		contentPane.add(nome);
		nome.setColumns(10);
		
		lblServio = new JLabel("Serviço");
		lblServio.setBounds(12, 194, 70, 15);
		contentPane.add(lblServio);
		
		servico = new JTextField();
		servico.setColumns(10);
		servico.setBounds(78, 192, 360, 19);
		contentPane.add(servico);
		
		lblQuarto = new JLabel("Quarto");
		lblQuarto.setBounds(12, 221, 70, 15);
		contentPane.add(lblQuarto);
		
		quarto = new JTextField();
		quarto.setColumns(10);
		quarto.setBounds(78, 221, 360, 19);
		contentPane.add(quarto);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeid = nome.getText();
				String servicoid = servico.getText();
				String quartoid = quarto.getText();
				
				//adicionar os dados ao cadastro
				DefaultTableModel tabela = (DefaultTableModel)table.getModel();
				tabela.addRow(new String[]{nomeid,servicoid,quartoid});
				
				//limpar campo
				nome.setText(" ");
				servico.setText(" ");
				quarto.setText(" ");
				
				nome.requestFocus();
				
			}
		});
		btnCadastrar.setBounds(78, 278, 117, 25);
		contentPane.add(btnCadastrar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel)table.getModel()).removeRow(table.getSelectedRow());
			}
		});
		btnExcluir.setBounds(242, 278, 117, 25);
		contentPane.add(btnExcluir);
	}

}
