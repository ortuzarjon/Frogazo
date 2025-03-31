package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Models.Libro;

public class LibroConnect {

	private Connection conexion() {
		
		String url = "jdbc:mysql://localhost:3306/libros";

		String username = "root";


		String password = "";
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error conectando a la base de datos");
			e.printStackTrace();
		}
		
		return con;
	}
	
	public ArrayList<Libro> cargarLibros() throws SQLException{
		
		Connection con = conexion();
		Statement st = con.createStatement();
		
		String consulta = "SELECT * FROM libros";
		
		ResultSet rs = st.executeQuery(consulta);
		

		ArrayList<Libro> libros = new ArrayList<>();
		
		try {
			while(rs.next()) {
				
				Libro li = new Libro();
				li.setId(rs.getInt("id"));
				li.setTipo(rs.getString("tipo"));
				li.setTitulo(rs.getString("nombre"));
				li.setAutor(rs.getString("autor"));
				li.setiSBN(rs.getString("isbn"));
				li.setPrecio(rs.getDouble("precio"));
				li.setPesoGR(rs.getDouble("pesoGr"));
				
				libros.add(li);
			}
		} catch (SQLException e) {
		System.out.println("ERROR AÑADIENDO LIBROS AL ARRAYLIST");
			e.printStackTrace();
		}
		
		
		
		return libros;
	}
	
	
	public void crearLibro(Libro li) throws SQLException {
		
		Connection con = conexion();
		
		Statement st = con.createStatement();
	
		String consulta = "INSERT INTO libros (id,tipo,nombre,autor,isbn,precio,pesoGr) VALUES "
				+"("+li.getId()+",'"+li.getTipo()+"','"+li.getTitulo()+"','"+li.getAutor()+"','"+li.getiSBN()+"',"+li.getPrecio()+","+li.getPesoGR()+");";
				
		int filas = st.executeUpdate(consulta);
		
		if(filas>0) {
			System.out.println("Libro creado correctamente");
		}else {
			System.out.println("Error creando libro");
		}
		
	}
		
		public void modLibro(Libro li, String isbn) throws SQLException {
			
			Connection con = conexion();
			
			Statement st = con.createStatement();
		
			String consulta = "UPDATE libros SET id ="+li.getId()+", tipo = '"+li.getTipo()+"' , nombre = '"+li.getTitulo()+"' ,  autor = '"
					+li.getAutor()+"', precio = "+li.getPrecio()+" , pesoGr = "+li.getPesoGR()+ "   WHERE isbn LIKE '"+isbn+"';";	
			int filas = st.executeUpdate(consulta);
			
			if(filas>0) {
				System.out.println("Libro modificado correctamente");
			}else {
				System.out.println("Error modificando libro");
			}
		
		
	}
		
		
		public Libro buscarLibroIsbn(Libro li) throws SQLException {

			
			Connection con = conexion();
			Statement st = con.createStatement();
		
			String consulta = "SELECT * FROM libros WHERE isbn LIKE '"+li.getiSBN()+"';";
			
			ResultSet rs = st.executeQuery(consulta);
			
			while(rs.next()) {
				
				li.setId(rs.getInt("id"));
				li.setTipo(rs.getString("tipo"));
				li.setTitulo(rs.getString("nombre"));
				li.setAutor(rs.getString("autor"));
				li.setiSBN(rs.getString("isbn"));
				li.setPrecio(rs.getDouble("precio"));
				li.setPesoGR(rs.getDouble("pesoGr"));
				
			}
			
			return li;
			
		}
	
		public void eliminarLibro(Libro li) throws SQLException {
			
			Connection con = conexion();
			Statement st = con.createStatement();
		
			String consulta = "DELETE FROM libros WHERE isbn LIKE '"+ li.getiSBN()+"' ;";	
			
			int filas = st.executeUpdate(consulta);
			
			if(filas>0) {
				System.out.println("Libro eliminado correctamente");
			}else {
				System.out.println("Error eliminando libro");
			}
			
		}
	
}
