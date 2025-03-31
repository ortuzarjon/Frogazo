package Models;

public class Libro {




	private int id;
	private String tipo;
	private String titulo;
	private String autor;
	private String iSBN;
	private double precio;
	private double pesoGR;
	
	public Libro() {
		
	}

	public Libro(int id, String tipo,String titulo, String autor, String iSBN, double precio, double pesoGR) {
		this.id = id;
		this.tipo = tipo;
		this.titulo = titulo;
		this.autor = autor;
		this.iSBN = iSBN;
		this.precio = precio;
		this.pesoGR = pesoGR;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getiSBN() {
		return iSBN;
	}

	public void setiSBN(String iSBN) {
		this.iSBN = iSBN;
	}

	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public double obtenerPrecio() {
		double precio =  this.getPrecio();
		
		return precio;
	}
	
	public double getPesoGR() {
		return pesoGR;
	}

	public void setPesoGR(double pesoGR) {
		this.pesoGR = pesoGR;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", tipo=" + tipo + ", titulo=" + titulo + ", autor=" + autor + ", iSBN=" + iSBN
				+ ", precio=" + precio + ", pesoGR=" + pesoGR + "]";
	}

	

}
