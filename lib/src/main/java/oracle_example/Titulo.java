package oracle_example;

import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo>{
	//@SerializedName("Title")
	private String nombre;
	//@SerializedName("Released")
	private String fechaDeLanzamiento;
	private int anioDeLanzamiento;
	private String duracion;
	
	@Override
	public int compareTo(Titulo o) {
		return this.getNombre().compareTo(o.getNombre());
	}
	
	@Override
	public String toString() {
		return "( Nombre: "+ nombre +
				" Fecha de lanzamiento: "+fechaDeLanzamiento+
				" Duración: "+ duracion+" )";				
	}
	
	public Titulo(TituloOmdb miTituloOmdb) {
		super();
		this.nombre = miTituloOmdb.Title();
		this.anioDeLanzamiento = Integer.parseInt(miTituloOmdb.Year());
		this.duracion = miTituloOmdb.Runtime();
		//this.duracion = Integer.valueOf(miTituloOmdb.Runtime().substring(0,3));
		this.fechaDeLanzamiento = miTituloOmdb.Released();
	}
	
	public Titulo(String nombre, String fechaDeLanzamiento, int anioDeLanzamiento, String duracion) {
		super();
		this.nombre = nombre;
		this.fechaDeLanzamiento = fechaDeLanzamiento;
		this.anioDeLanzamiento = anioDeLanzamiento;
		this.duracion = duracion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaDeLanzamiento() {
		return fechaDeLanzamiento;
	}

	public void setFechaDeLanzamiento(String fechaDeLanzamiento) {
		this.fechaDeLanzamiento = fechaDeLanzamiento;
	}

	public int getAnioDeLanzamiento() {
		return anioDeLanzamiento;
	}

	public void setAnioDeLanzamiento(int anioDeLanzamiento) {
		this.anioDeLanzamiento = anioDeLanzamiento;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	
	
	
}
