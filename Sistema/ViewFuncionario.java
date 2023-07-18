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

public class ViewFuncionario extends JFrame {

	private JPanel func;
	private JTable table;
	private JLabel lblNome;
	private JTextField nome;
	private JLabel lblSalrio;
	private JTextField salario;
	private JLabel lblSetor;
	private JTextField setor;
	private JButton btnCadastrar;
	private JButton btnExcluir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewFuncionario frame = new ViewFuncionario();
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
	public ViewFuncionario() {
		setTitle("Gerenciamento de funcionários");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 367);
		func = new JPanel();
		func.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(func);
		func.setLayout(null);
		
		JLabel lblCadastroDeFuncionrio = new JLabel("Cadastro de funcionário");
		lblCadastroDeFuncionrio.setBounds(25, 12, 185, 15);
		func.add(lblCadastroDeFuncionrio);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 39, 398, 113);
		func.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Salário", "Setor"
			}
		));
		scrollPane.setViewportView(table);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(25, 164, 70, 15);
		func.add(lblNome);
		
		nome = new JTextField();
		nome.setBounds(102, 160, 320, 19);
		func.add(nome);
		nome.setColumns(10);
		
		lblSalrio = new JLabel("Salário");
		lblSalrio.setBounds(25, 194, 70, 15);
		func.add(lblSalrio);
		
		salario = new JTextField();
		salario.setBounds(102, 192, 320, 19);
		func.add(salario);
		salario.setColumns(10);
		
		lblSetor = new JLabel("Setor");
		lblSetor.setBounds(25, 221, 70, 15);
		func.add(lblSetor);
		
		setor = new JTextField();
		setor.setColumns(10);
		setor.setBounds(102, 219, 320, 19);
		func.add(setor);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeid = nome.getText();
				String salid = salario.getText();
				String setorid = setor.getText();
				
				//adicionar os dados ao cadastro
				DefaultTableModel tabela = (DefaultTableModel)table.getModel();
				tabela.addRow(new String[]{nomeid,salid,setorid});
				
				//limpar campo
				nome.setText(" ");
				salario.setText(" ");
				setor.setText(" ");
				
				nome.requestFocus();
			}
		});
		btnCadastrar.setBounds(90, 267, 117, 25);
		func.add(btnCadastrar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel)table.getModel()).removeRow(table.getSelectedRow());
			}
		});
		btnExcluir.setBounds(242, 267, 117, 25);
		func.add(btnExcluir);
	}

}
