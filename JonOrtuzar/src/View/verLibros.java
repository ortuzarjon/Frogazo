package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BBDD.LibroConnect;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;

public class verLibros extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					verLibros frame = new verLibros();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public verLibros() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 416, 182);
		contentPane.add(scrollPane);
		
		LibroConnect licon = new LibroConnect();
		table = new JTable();
		table.setEnabled(false);
		DefaultTableModel dtm = new DefaultTableModel();
		String[] identifiers = {"Id","Tipo","Nombre","Autor","Isbn","Precio","Peso Gramos"};
		dtm.setColumnIdentifiers(identifiers);
		
		for(int i = 0;i<licon.cargarLibros().size();i++) {
			dtm.addRow(new Object[] {
					
					licon.cargarLibros().get(i).getId(),	
					licon.cargarLibros().get(i).getTipo(),
					licon.cargarLibros().get(i).getTitulo(),
					licon.cargarLibros().get(i).getAutor(),
					licon.cargarLibros().get(i).getiSBN(),
					licon.cargarLibros().get(i).getPrecio(),
					licon.cargarLibros().get(i).getPesoGR()
					
			});
		}
		table.setModel(dtm);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("VOLVER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal vP = new VentanaPrincipal();
				vP.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(319, 232, 107, 31);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("INFORMACION DE TODOS LOS LIBROS= ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 10, 416, 30);
		contentPane.add(lblNewLabel);
	}
}
