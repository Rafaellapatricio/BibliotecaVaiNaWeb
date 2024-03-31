package br.com.vainaweb.backendt2.biblioteca.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.vainaweb.backendt2.biblioteca.model.Membro;

public class OperacoesMembro {
	
	List<Membro>listaMembro=new ArrayList<>(100);
	
	public OperacoesMembro() {
		
	}

	public void cadastrarMembro(String nome, String cpf, int codigo) {

		if (listaMembro.size() > 100) {
			System.out.println("Limite total de cadastros alcançado.");
		}
		
		int cadastro = verificarCPF(cpf);
		// código:
		// 0 - Cadastrado com sucesso!
		// 1 - CPF inválido
		// 2 - CPF já cadastrado no sistema
		
		if(cadastro == 0) {
			listaMembro.add(new Membro(nome, cpf, codigo));
		} else if(cadastro == 1) {
			System.err.println("CPF INVÁLIDO!");

		} else if(cadastro == 2) {
			System.out.println("Membro já cadastrado!");
		}

	}
	
	public int gerarCodigo(int inteiro) {
		
		Random gerarNumero = new Random();
		inteiro=0;
		
		for (int i = 1; i <= 1; i++) {
			if(gerarNumero.nextInt()>0) {
				inteiro =gerarNumero.nextInt();				
			}
			else {
				int result= gerarNumero.nextInt();
				String regex = "" + result;
				regex = regex.replaceAll("-", "");
				inteiro= Integer.parseInt(regex);	
			}			
		}		
		return inteiro;		
	}
	
	public void listarMembro() {		
		System.out.println("\n  MEMBROS DA NOSSA BIBLIOTECA ");
		System.out.println("------------------------------------\n");		
		for(Membro m: listaMembro ) {
			System.out.println(". Nome: " + m.getNome() + " | CPF: " + m.getCpf()+
					"| Código de cadastro: "+m.getCodigo());
		}		
	}
	
	public Membro selecionarMembro(int codigo) {
		for(Membro m: listaMembro){
			if(m.getCodigo()==codigo) {
				return m;
			}
		}		
		return null;		
	}
	
	public void removerMembro(Membro selecionarMembro){
		listaMembro.remove(selecionarMembro);		
	}
	
	private int verificarCPF(String cpf) {
		
		Pattern testecpf = Pattern.compile("^[0-9]{3}[.][0-9]{3}[.][0-9]{3}[-][0-9]{2}$");	
		Matcher verificando= testecpf.matcher(cpf);
		//verificando.find();
		if(verificando.find()==false) {
			System.out.println("DEU ZEBRA "+verificando.find());
			return 1;
		}
		for(Membro m: listaMembro) {
			if(cpf.equals(m.getCpf())) {
				return 2;
			}
		}
		System.out.println("DEU CERTO "+verificando.find());
		return 0;
	}	

}