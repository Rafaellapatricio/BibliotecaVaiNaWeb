package br.com.vainaweb.backendt2.biblioteca.controller;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.vainaweb.backendt2.biblioteca.model.Livro;

public class Operacoes {
	
	List<Livro>listaLivro = new ArrayList<>(500);
	
	public Operacoes() {
		
	}
	
	public void adicionarLivro(String titulo, String autor, String paisOrigem, Date dataPublic, 
			String genero, int numEdicao, String setDataEntrada, int codigo, boolean alugado) {

		if (listaLivro.size() > 500) {
			System.out.println("A biblioteca está cheia");

		}

		System.out.println("\n=============");
		System.out.println("  ADICIONAR LIVRO A NOSSA BIBLIOTECA ");
		System.out.println("=============\n");

		int adicionar = verificarCodigoLivro(codigo);

		if (adicionar == 0) {
			listaLivro.add(new Livro(titulo, autor, paisOrigem, dataPublic, genero, numEdicao, 
					setDataEntrada, codigo,	alugado));
		} else if(adicionar == 1) {
			System.err.println("CÓDIGO INVÁLIDO");
		} else if(adicionar == 2) {
			System.out.println("Livro já cadastrado!");
		}

	}
	
	public void listarLivro() {
		System.out.println("--------------------------------------");		
		System.out.println(" LIVROS DA NOSSA BIBLIOTECA ");
		System.out.println("--------------------------------------\n");
		
		for(Livro a: listaLivro ) {
			System.out.println(" Titulo: " + a.getTitulo() + " | Autor: " + a.getAutor()+
					"| Gênero: " + a.getGenero()+ "| País:  "+ a.getPaisOrigem()+
					"| Publicação: "+a.getDataPublic()+"\n| Edição: "+a.getNumEdicao()+"ª Edição"+
					"| Data de entrada: "+a.getDataEntrada()+ "| Código ISBN: "+a.getCodigo()
					+"| Situação: "+a.getAlugado());
		System.out.println("--------------------------------------------------------------------");		
		}
		
	}
	public Livro selecionarLivro(int codigo) {
		
		System.out.println("\n  SELECIONAR LIVRO ");		
		for(Livro l: listaLivro) {
			if(l.getCodigo() == codigo) {
				return l;
			}
		}
		
		return null;
	}
	
	public void removerLivro(Livro selecionarLivro) {
		listaLivro.remove(selecionarLivro);
		
	}
	
	public void verificarDataLimite() {	
		
		Date data = new Date();		
		DateFormat retorno = DateFormat.getDateInstance();
		Calendar comparar = Calendar.getInstance();
		
		String entrada= retorno.format(data);
		System.out.println("Data de empréstimo: "+entrada);
		
		comparar.add(Calendar.DATE, 15);		
		System.out.println("Data de retorno: "+retorno.format(comparar.getTime()));	
	}
	
	private int verificarCodigoLivro(int codigo) {
		if (codigo < 10000000 && codigo > 99999999){
			return 1;
		}

		// depois conferimos se o livro já está cadastrado ou não
		for (Livro m : listaLivro) {
			if (codigo == m.getCodigo()) {
				return 2;
			}
		}
		// caso passe por todas as verificações anteriores, o codigo é válido.
		return 0;
	}
}
