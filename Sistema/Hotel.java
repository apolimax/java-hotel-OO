package Sistema;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Hotel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hotel frame = new Hotel();
					frame.setExtendedState(MAXIMIZED_BOTH);
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
	public Hotel() {
		setTitle("Sistema Hotel IMD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);
		
		JMenu mnCliente = new JMenu("Cliente");
		mnCliente.setIcon(new ImageIcon(Hotel.class.getResource("/Sistema/cliente1.jpg")));
		menuBar.add(mnCliente);
		
		JMenuItem mntmCadastroC = new JMenuItem("Cadastro C");
		mntmCadastroC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCliente p = new ViewCliente();
				p.setVisible(true);
			}
		});
		mnCliente.add(mntmCadastroC);
		
		JMenu mnFuncionrio = new JMenu("Funcionário");
		mnFuncionrio.setIcon(new ImageIcon(Hotel.class.getResource("/Sistema/funcionario1.png")));
		menuBar.add(mnFuncionrio);
		
		JMenuItem mntmCadastroFun = new JMenuItem("Cadastro Fun...");
		mntmCadastroFun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewFuncionario f = new ViewFuncionario();
				f.setVisible(true);
			}
		});
		mnFuncionrio.add(mntmCadastroFun);
		
		JMenu mnServios = new JMenu("Serviços");
		mnServios.setIcon(new ImageIcon(Hotel.class.getResource("/Sistema/servicos1.png")));
		menuBar.add(mnServios);
		
		JMenuItem mntmDemandar = new JMenuItem("Demandar");
		mntmDemandar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Servicos s = new Servicos();
				s.setVisible(true);
			}
		});
		mnServios.add(mntmDemandar);
		
		JMenu mnSair = new JMenu("Sair");
		menuBar.add(mnSair);
		
		JMenuItem mntmConfirmar = new JMenuItem("Confirmar");
		mntmConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnSair.add(mntmConfirmar);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

}
