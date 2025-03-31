package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BBDD.LibroConnect;
import Models.Libro;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ModificarLibro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldID;
	private JTextField textFieldTipo;
	private JTextField textFieldNombre;
	private JTextField textFieldAutor;
	private JTextField textFieldPrecio;
	private JTextField textFieldGramos;
	private JTextField textISBN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarLibro frame = new ModificarLibro();
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
	public ModificarLibro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID =");
		lblNewLabel.setBounds(10, 84, 82, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblTipo = new JLabel("Tipo = ");
		lblTipo.setBounds(10, 107, 93, 13);
		contentPane.add(lblTipo);
		
		JLabel lblNombre = new JLabel("Nombre = ");
		lblNombre.setBounds(10, 130, 82, 13);
		contentPane.add(lblNombre);
		
		JLabel lblAutor = new JLabel("Autor = ");
		lblAutor.setBounds(10, 153, 45, 13);
		contentPane.add(lblAutor);
		
		JLabel lblPrecio = new JLabel("Precio = ");
		lblPrecio.setBounds(10, 176, 82, 13);
		contentPane.add(lblPrecio);
		
		JLabel lblNewLabel_6 = new JLabel("Peso Gramos =");
		lblNewLabel_6.setBounds(10, 199, 76, 13);
		contentPane.add(lblNewLabel_6);
		

		JButton btnNewButton_1 = new JButton("VOLVER");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal vP = new VentanaPrincipal();
				vP.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(305, 225, 121, 28);
		contentPane.add(btnNewButton_1);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(84, 78, 96, 19);
		contentPane.add(textFieldID);
		textFieldID.setColumns(10);
		
		textFieldTipo = new JTextField();
		textFieldTipo.setColumns(10);
		textFieldTipo.setBounds(84, 101, 96, 19);
		contentPane.add(textFieldTipo);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(84, 124, 96, 19);
		contentPane.add(textFieldNombre);
		
		textFieldAutor = new JTextField();
		textFieldAutor.setColumns(10);
		textFieldAutor.setBounds(84, 147, 96, 19);
		contentPane.add(textFieldAutor);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setColumns(10);
		textFieldPrecio.setBounds(84, 173, 96, 19);
		contentPane.add(textFieldPrecio);
		
		textFieldGramos = new JTextField();
		textFieldGramos.setColumns(10);
		textFieldGramos.setBounds(84, 196, 96, 19);
		contentPane.add(textFieldGramos);
		
		JLabel lblAñadir = new JLabel("");
		lblAñadir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAñadir.setBounds(233, 79, 181, 85);
		contentPane.add(lblAñadir);
		
		

		JLabel lblNewLabel_1 = new JLabel("ISBN = ");
		lblNewLabel_1.setBounds(10, 10, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		textISBN = new JTextField();
		textISBN.setBounds(84, 7, 96, 19);
		contentPane.add(textISBN);
		textISBN.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("BUSCAR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean encontrado = false;
				LibroConnect licon = new LibroConnect();
				
				Libro li = new Libro();
				
				li.setiSBN(textISBN.getText());
				
				try {
					licon.buscarLibroIsbn(li);
					encontrado = true;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(encontrado) {
					textFieldID.setText(String.valueOf(li.getId()));
					textFieldTipo.setText(li.getTipo());
					textFieldNombre.setText(li.getTitulo());
					textFieldAutor.setText(li.getAutor());
					textFieldPrecio.setText(String.valueOf(li.getPrecio()));
					textFieldGramos.setText(String.valueOf(li.getPesoGR()));

		
				}else {
					
				}
				
				}
		});
		btnNewButton_2.setBounds(138, 225, 109, 28);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("MODIFICAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			LibroConnect licon = new LibroConnect();
				
			Libro li = new Libro();
			li.setId(Integer.parseInt(textFieldID.getText()));
			li.setTipo(textFieldTipo.getText());
			li.setTitulo(textFieldNombre.getText());
			li.setAutor(textFieldAutor.getText());
			li.setPrecio(Double.parseDouble(textFieldPrecio.getText()));
			li.setPesoGR(Double.parseDouble(textFieldGramos.getText()));
			
			try {
				licon.modLibro(li, textISBN.getText());
				
				lblAñadir.setText("OK");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				lblAñadir.setText("NO OK");
			}
				
				
				
			}
		});
		btnNewButton.setBounds(7, 225, 121, 28);
		contentPane.add(btnNewButton);
		
	}
}
