package br.com.vainaweb.backendt2.biblioteca;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Scanner;

import br.com.vainaweb.backendt2.biblioteca.controller.Operacoes;
import br.com.vainaweb.backendt2.biblioteca.controller.OperacoesMembro;
import br.com.vainaweb.backendt2.biblioteca.model.Livro;
import br.com.vainaweb.backendt2.biblioteca.model.Membro;


public class Application {

	public static void main(String[] args) throws ParseException {
		Operacoes op = new Operacoes();
		OperacoesMembro om= new OperacoesMembro();		
		Scanner sc = new Scanner(System.in);		
		boolean menuAtivo = true;
		
		while (menuAtivo) {
			exibirMenu();
			int opcao = sc.nextInt();
			
			switch (opcao) {
			case 1:
				listarLivro(op);
				break;
			case 2:
				adicionarLivro(op, sc);
				break;
			case 3:				
				editarLivro(op, sc);
			case 4:
				removerLivro(op,sc);				
				break;
			case 5:
				menuMembro(sc, om, op);
				break;
			case 0:
				System.out.println("\n> Tchau, tchau!! ");
				menuAtivo = false;
				break;
			default:
				System.out.println("\n> Opção inválida. Tente novamente.");
				break;
			}
		}
		
	}// FINAL DA MAIN

	
	//COMEÇO DOS METODOS
	static void exibirMenu() {			
		System.out.println("\n Biblioteca Moon - Área do Funcionário -");
		System.out.println("-----------------------------------------");
		System.out.println("1. Listar Livros");
		System.out.println("\n2. Adicionar Livro");
		System.out.println("3. Editar Livros");
		System.out.println("4. Remover Livro");
		System.out.println("--------------------------");
		System.out.println("5. Área do Membro");
		System.out.println("--------------------------");
		System.out.println("0. Sair");
		System.out.print("\nDigite a opção: ");
	}
	
	//SEGUNDA MENU
	static void exibirMenuMembro() {
		System.out.println("\n Biblioteca - AREA DO MEMBRO");
		System.out.println("----------------------------------\n");
		System.out.println("1. Listar Membros");
		System.out.println("2. Adicionar Membros");
		System.out.println("3. Editar dados Membro");
		System.out.println("4. Remover Livro");
		System.out.println("5. Alugar Livro");
		System.out.println("0. Sair");		
		System.out.print("\nDigite a opção: ");
	}
	
	static void menuMembro(Scanner sc, OperacoesMembro om, Operacoes op) {	
		
		exibirMenuMembro();
		int opcao=sc.nextInt();			
		switch (opcao) {
			case 1:
				listarMembros(om);
				break;
			case 2:
				cadastrarMembro(om,sc);
				break;
			case 3:
				editarMembro(om, sc);
				break;
			case 4:
				removerMembro(om, sc);	
				break;
			case 5:
				verificarSituacao(op, sc, om);		
				break;
			default:
				System.out.println("Opção inválida.");
				break;
		}
	}//fim do segundo menu
	
	//LIVROS	
	static void adicionarLivro(Operacoes op, Scanner sc) throws ParseException {
		
		System.out.println("\n** CADASTRAR LIVRO **\n");
		sc.nextLine();
		
		System.out.print("Título do livro: ");
		String setTitulo = sc.nextLine();
		
		System.out.print("\nNome do autor(a): ");
		String setAutor = sc.nextLine();		
		
		System.out.print("\nGênero: ");
		String setGenero = sc.nextLine();
		
		System.out.print("\nLocal de publicação: ");
		String setPaisOrigem = sc.nextLine();
		
		System.out.print("\nData de publicação: ");
		String setDataPublic= sc.nextLine();
		SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
		Date datap = formatar.parse(setDataPublic);
		
		System.out.print("\nEdição: ");
		int setNumEdicao = sc.nextInt();
		sc.nextLine();
		
		System.out.print("\nCódigo ISBN: ");		
		int setCodigo = sc.nextInt();
		
		boolean setAlugado=false;
		
		//pegar data automaticamente
		Date data = new Date();
		DateFormat formataData = DateFormat.getDateInstance();
		String setDataEntrada = formataData.format(data);
		
		op.adicionarLivro(setTitulo, setAutor, setPaisOrigem, datap, setGenero, setNumEdicao, setDataEntrada, setCodigo, setAlugado);
	}
	
	static void verificarSituacao(Operacoes op, Scanner sc, OperacoesMembro om) {
		
		System.out.println("\n  LOCALIZAR LIVRO");
		System.out.println("Código do livro: ");
		int setCodigo= sc.nextInt();
		Livro codigoSelecioado= op.selecionarLivro(setCodigo);
		if(codigoSelecioado!=null) {
			System.out.println("Titulo: "+codigoSelecioado.getTitulo()+"| Situação: "
					+codigoSelecioado.getAlugado());
			
			if(codigoSelecioado.getAlugado()==false) {
				alugarLivro(op, om, sc);
			}else {
				System.out.println("\n  Livro indisponível para aluguel no momento.");
			}			
		}
		else {
			System.out.println("\nLivro do código não encontrado.");
		}		

	}
	static void alugarLivro(Operacoes op, OperacoesMembro om, Scanner sc){
		
		System.out.println("\n  Digite seu código de membro: ");
		int setCodigo=sc.nextInt();	
		Membro selecionarMembro= om.selecionarMembro(setCodigo);
		Livro codigoSelecioado= op.selecionarLivro(setCodigo);
		
		if(selecionarMembro!=null) {			
			System.out.println("Membro: "+selecionarMembro.getNome());
			System.out.println("ALUGANDO LIVRO....  Data de devolução: ");
			boolean alugar = true;
			codigoSelecioado.setAlugado(alugar);
			verificarDataLimite(op);
		}		
		else {			
			System.out.println("\nMembro do código " + setCodigo+ " não encontrado.");
		}
	}
	
	static void removerLivro(Operacoes op, Scanner sc) {
		
		System.out.print("\nDigite o código do livro: ");
		int setCodigo = sc.nextInt();
		sc.nextLine();
		Livro selecionarLivro = op.selecionarLivro(setCodigo);
		
		if (selecionarLivro != null) {
			op.removerLivro(selecionarLivro);
			System.out.println("Conta:  " + setCodigo + " removida com sucesso.");
		} else {
			System.out.println("Conta com o número " + setCodigo + " não encontrada.");
		}
	}
	
	static void editarLivro(Operacoes op, Scanner sc) throws ParseException {		

		System.out.println("**Editar Livro**/n");
		System.out.print("**Digite o código do livro: **");
		int setCodigo= sc.nextInt();
		sc.nextLine();
		Livro localizarLivro= op.selecionarLivro(setCodigo);
		if(localizarLivro!=null) {
			System.out.println("\n***Alterar dados do livro***\n");
			
			System.out.println("Título: ");
			String novoTitulo= sc.nextLine();
			localizarLivro.setTitulo(novoTitulo);
			
			System.out.println("Autor(a): ");
			String novoAutor= sc.nextLine();
			localizarLivro.setAutor(novoAutor);
			
			System.out.println("Gênero: ");
			String novoGenero=sc.nextLine();
			localizarLivro.setGenero(novoGenero);
			
			System.out.println("Data Publicação: ");
			String novaData=sc.nextLine();
			SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
			Date data = formatar.parse(novaData);
			localizarLivro.setDataPublic(data);
			
			System.out.println("Pais de Origem: ");
			String novaOrigem=sc.nextLine();
			localizarLivro.setPaisOrigem(novaOrigem);
			
			System.out.println("Número da Edição: ");
			int novaEdicao = sc.nextInt();
			sc.nextLine();
			localizarLivro.setNumEdicao(novaEdicao);
			
		}else {
			System.out.println("Livro não localizado!!!");
		}
		/* 
		setNumEdicao,setDataEntrada,setCodigo, setAlugado*/
	}
	
	static void listarLivro(Operacoes op) {
		op.listarLivro();		
	}	
	
	//MEMBROS
	static void cadastrarMembro(OperacoesMembro om, Scanner sc) {
		
		System.out.println("\n** CADASTRAR NOVO MEMBRO **\n");		
		//codigo,nome,cpf - adicionar outros dados se quiser 
		System.out.print("NOME: ");
		String setNome =sc.next();
		System.out.print("CPF: ");	
		String setCpf= sc.next();
		//gerar codigo do membro
		int setCodigo=om.gerarCodigo(0);
		
		om.cadastrarMembro(setNome, setCpf, setCodigo);		
	}
	
	static void listarMembros(OperacoesMembro om) {
		om.listarMembro();
	}
	
	static void removerMembro(OperacoesMembro om, Scanner sc) {
		
		System.out.print("\nDigite o código do Membro: ");
		int setCodigo = sc.nextInt();
		sc.nextLine();
		Membro selecionarMembro = om.selecionarMembro(setCodigo);
		
		if (selecionarMembro != null) {
			om.removerMembro(selecionarMembro);
			System.out.println("Membro:  " + setCodigo + " removido com sucesso.");
		} else {
			System.out.println("Membro com o número " + setCodigo + " não encontrada.");
		}		
	}
	static void verificarDataLimite(Operacoes op) {
		op.verificarDataLimite();
	}
	
	static void editarMembro(OperacoesMembro om, Scanner sc) {
		System.out.println("**Editar Livro**/n");
		System.out.print("**Digite o código do livro: **");
		int setCodigo= sc.nextInt();
		sc.nextLine();
		Membro localizarMembro= om.selecionarMembro(setCodigo);
		if(localizarMembro!=null) {
			System.out.println("\n***Alterar dados Membro***\n");
			
			System.out.println("Nome: ");
			String novoNome= sc.nextLine();
			localizarMembro.setNome(novoNome);
		}else {
			System.out.println("Membro não localizado.");
		}
	}
}

