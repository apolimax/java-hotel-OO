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

public class ViewCliente extends JFrame {

	private JPanel checkin;
	private JTable table;
	private JLabel lblNome;
	private JTextField nome;
	private JLabel lblCheckinckecout;
	private JTextField check;
	private JLabel lblData;
	private JTextField data;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCliente frame = new ViewCliente();
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
	public ViewCliente() {
		setTitle("Gerenciamento de cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 394);
		checkin = new JPanel();
		checkin.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(checkin);
		checkin.setLayout(null);
		
		JLabel lblCadastroCliente = new JLabel("Cadastro Cliente");
		lblCadastroCliente.setBounds(12, 12, 140, 15);
		checkin.add(lblCadastroCliente);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 39, 412, 103);
		checkin.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "checkin/checkout", "data"
			}
		));
		scrollPane.setViewportView(table);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(22, 154, 70, 15);
		checkin.add(lblNome);
		
		nome = new JTextField();
		nome.setBounds(166, 152, 258, 19);
		checkin.add(nome);
		nome.setColumns(10);
		
		lblCheckinckecout = new JLabel("checkin/ckecout");
		lblCheckinckecout.setBounds(22, 190, 130, 19);
		checkin.add(lblCheckinckecout);
		
		check = new JTextField();
		check.setBounds(165, 190, 258, 19);
		checkin.add(check);
		check.setColumns(10);
		
		lblData = new JLabel("data");
		lblData.setBounds(22, 231, 92, 15);
		checkin.add(lblData);
		
		data = new JTextField();
		data.setBounds(166, 229, 258, 19);
		checkin.add(data);
		data.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeid = nome.getText();
				String checkid = check.getText();
				String dataid = data.getText();
				
				//adicionar os dados ao cadastro
				DefaultTableModel tabela = (DefaultTableModel)table.getModel();
				tabela.addRow(new String[]{nomeid,checkid,dataid});
				
				//limpar campo
				nome.setText(" ");
				check.setText(" ");
				data.setText(" ");
				
				nome.requestFocus();
				
			}
		});
		btnCadastrar.setBounds(97, 279, 117, 25);
		checkin.add(btnCadastrar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel)table.getModel()).removeRow(table.getSelectedRow());
			}
		});
		btnExcluir.setBounds(237, 279, 117, 25);
		checkin.add(btnExcluir);
	}
}
