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

public class crearLibro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldID;
	private JTextField textFieldTipo;
	private JTextField textFieldNombre;
	private JTextField textFieldAutor;
	private JTextField textFieldISBN;
	private JTextField textFieldPrecio;
	private JTextField textFieldGramos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					crearLibro frame = new crearLibro();
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
	public crearLibro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID =");
		lblNewLabel.setBounds(10, 10, 82, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblTipo = new JLabel("Tipo = ");
		lblTipo.setBounds(10, 33, 93, 13);
		contentPane.add(lblTipo);
		
		JLabel lblNombre = new JLabel("Nombre = ");
		lblNombre.setBounds(10, 56, 82, 13);
		contentPane.add(lblNombre);
		
		JLabel lblAutor = new JLabel("Autor = ");
		lblAutor.setBounds(10, 79, 45, 13);
		contentPane.add(lblAutor);
		
		JLabel lblIsbn = new JLabel("ISBN =");
		lblIsbn.setBounds(10, 102, 45, 13);
		contentPane.add(lblIsbn);
		
		JLabel lblPrecio = new JLabel("Precio = ");
		lblPrecio.setBounds(10, 128, 82, 13);
		contentPane.add(lblPrecio);
		
		JLabel lblNewLabel_6 = new JLabel("Peso Gramos =");
		lblNewLabel_6.setBounds(10, 151, 76, 13);
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
		textFieldID.setBounds(84, 7, 96, 19);
		contentPane.add(textFieldID);
		textFieldID.setColumns(10);
		
		textFieldTipo = new JTextField();
		textFieldTipo.setColumns(10);
		textFieldTipo.setBounds(84, 30, 96, 19);
		contentPane.add(textFieldTipo);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(84, 53, 96, 19);
		contentPane.add(textFieldNombre);
		
		textFieldAutor = new JTextField();
		textFieldAutor.setColumns(10);
		textFieldAutor.setBounds(84, 76, 96, 19);
		contentPane.add(textFieldAutor);
		
		textFieldISBN = new JTextField();
		textFieldISBN.setColumns(10);
		textFieldISBN.setBounds(84, 99, 96, 19);
		contentPane.add(textFieldISBN);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setColumns(10);
		textFieldPrecio.setBounds(84, 125, 96, 19);
		contentPane.add(textFieldPrecio);
		
		textFieldGramos = new JTextField();
		textFieldGramos.setColumns(10);
		textFieldGramos.setBounds(84, 148, 96, 19);
		contentPane.add(textFieldGramos);
		
		JLabel lblAñadir = new JLabel("");
		lblAñadir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAñadir.setBounds(233, 79, 181, 85);
		contentPane.add(lblAñadir);
		
		JLabel lblNewLabel_1 = new JLabel("CREAR LIBRO");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(227, 10, 187, 36);
		contentPane.add(lblNewLabel_1);
		
		
		JButton btnNewButton = new JButton("AÑADIR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LibroConnect licon = new LibroConnect();
				
				Libro li = new Libro();
				
				li.setId(Integer.parseInt(textFieldID.getText()));
				li.setTipo(textFieldTipo.getText());
				li.setTitulo(textFieldNombre.getText());
				li.setAutor(textFieldAutor.getText());
				li.setiSBN(textFieldISBN.getText());
				li.setPrecio(Double.parseDouble(textFieldPrecio.getText()));
				li.setPesoGR(Double.parseDouble(textFieldGramos.getText()));
				
				try {
					licon.crearLibro(li);
					lblAñadir.setText("OK");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					lblAñadir.setText("No OK");

				}
				
				
			}
		});
		btnNewButton.setBounds(7, 174, 173, 79);
		contentPane.add(btnNewButton);
		
	}
}
