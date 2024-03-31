package br.com.vainaweb.backendt2.biblioteca.model;

public class Membro extends Pessoa {
	int codigo;
	
	public Membro() {
		
	}
	
	public Membro(String nome, String cpf, int codigo) {
		super(nome, cpf);		
		this.codigo=codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}	
}
