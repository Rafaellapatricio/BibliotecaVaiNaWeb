package br.com.vainaweb.backendt2.biblioteca.model;

public class Pessoa {

	private String nome;
	private String cpf;
	//private String rg;
	private String email;
	private String telefone;
	//private Endereco endereco = new Endereco();
	
	public Pessoa() {

	}
	public Pessoa(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;		
		//this.setEndereco(endereco);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone=telefone;
	}

}