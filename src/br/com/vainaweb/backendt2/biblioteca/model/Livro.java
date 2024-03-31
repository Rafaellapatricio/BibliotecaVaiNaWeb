package br.com.vainaweb.backendt2.biblioteca.model;

import java.util.Date;

public class Livro extends FichaCatalografica {
	
	private String dataEntrada;// data que o livro deu entrada na biblioteca;
	private int codigo; // combinação de 8 dígitos
	private boolean alugado=false; 	

	public Livro() {
		super();
	}
	
	public Livro(String titulo, String autor, String localPublic, Date dataPublic, 
				String genero, int numEdicao,String dataEntrada, int codigo, boolean alugado) {
		
		super(titulo,autor,localPublic,dataPublic,genero,numEdicao);
		this.dataEntrada=dataEntrada;
		this.codigo=codigo;
		this.alugado=alugado;
	}	

	public String getDataEntrada() {
		return dataEntrada;		
	}

	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo=codigo;
	}
	
	public boolean getAlugado() {
		return alugado;
	}

	public void setAlugado(boolean alugado) {
		this.alugado = alugado;
	}
	
}



