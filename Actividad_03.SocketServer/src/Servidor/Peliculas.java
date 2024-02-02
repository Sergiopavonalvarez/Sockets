package Servidor;

public class Peliculas {
	
	String id;
	String titulo;
	String director;
	
	
	
	
	
	
	
	public Peliculas(String id, String titulo, String director) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.director = director;
	}
	
	
	@Override
	public String toString() {
		return "Peliculas [id=" + id + ", titulo=" + titulo + ", director=" + director + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	
	


}
