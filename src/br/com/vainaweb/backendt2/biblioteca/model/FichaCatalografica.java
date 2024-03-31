package br.com.vainaweb.backendt2.biblioteca.model;

import java.util.Date;

public class FichaCatalografica {
	
	private String titulo,autor, paisOrigem,genero;
	private Date dataPublic;
	private int numEdicao;
	
	
	public FichaCatalografica() {
		
	}
	
	public FichaCatalografica(String titulo, String autor, String paisOrigem,
			Date dataPublic, String genero, int numEdicao){
		
		this.titulo= titulo;
		this.autor= autor;
		this.paisOrigem= paisOrigem;
		this.dataPublic= dataPublic;
		this.genero= genero;
		this.numEdicao=numEdicao;
		
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo=titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor=autor;
	}
	
	public String getPaisOrigem() {
		return paisOrigem;
	}
	
	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem=paisOrigem;
	}
	
	public Date getDataPublic() {
		return dataPublic;
	}
	
	public void setDataPublic(Date data) {
		this.dataPublic=data;
	}
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero=genero;
	}
	
	public int getNumEdicao() {
		return numEdicao;
	}
	
	public void setNumEdicao(int numEdicao) {
		this.numEdicao=numEdicao;
	}
	
}
